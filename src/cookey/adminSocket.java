
package cookey;

import com.google.gson.Gson;

import cookey.dao.UsuarioDAO;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import cookey.model.Atributo;
import cookey.model.usuario.UsuarioDTO;

public class adminSocket extends Thread {
	private final Socket conector;
	// private String metodoPedido;
	private String httpPedido;
	private final String NEW_LINE = "\r\n";

	adminSocket(Socket insocket) {
		conector = insocket;
	}

	public void procesarSocket() {
		this.start();
	}

	@Override // sobreescribimos el m�todo run() del Thread para procesar el socket, es el
				// proceso principal del server
	public void run() {

		try {
			// Capturo el flujo de entrada
			// Creo un objeto para manipular el pedido. Necesito que tenga acceso al socket
			// Se lo inyecto en el constructor

			InputStream flujoentrada = conector.getInputStream();
			BufferedReader buffer = new BufferedReader(new InputStreamReader(flujoentrada));

			// PrintStream para enviar archivos
			PrintStream ps = new PrintStream(new BufferedOutputStream(conector.getOutputStream()));

			// Proceso el Stream y se lo paso como String a HttpRequest

			String header = buffer.readLine();

			// Si la cabecera es nula salgo
			if (header == null) {
				return;
			}

			StringTokenizer tokenizer = new StringTokenizer(header);

			// metodoPedido = tokenizer.nextToken(); // metodoPedido nunca lo uso
			httpPedido = tokenizer.nextToken(); // Esta l�nea no est� de m�s?
			httpPedido = header + NEW_LINE;

			while (buffer.ready()) {
				// Leeo todo el pedido HTTP hasta el final
				httpPedido += buffer.readLine() + NEW_LINE;
			}

			System.out.println(httpPedido);

			/*
			 * System.out.println("HTTP-METHOD: " + metodoPedido);
			 * System.out.println(httpPedido);
			 */

			HttpRequest req = new HttpRequest(httpPedido);
			HttpResponse resp = new HttpResponse(conector);

			// AHORA PARA VER SI TODO ESTA OK VAMOS A GENERAR UN ECHO AL WEB BROWSER
			// ANTES QUE NADA SE ENVIA UN ENCABEZADO DE ESTADO Y AUTORIZACION PARA CORS SINO
			// NO FUNCIONA
			// DESDE OTROS SITIOS EXTERNOS, POR EJEMPLO ALGO QUE HAGAMOS CON ANGULARJS Y
			// QUERRAMOS CONSUMIR EXTERNAMENTE
			// capturamos los parametros enviados

			String PaginaInicio;
			System.out.println("Accion: " + req.getAccion2());
			System.out.println("Metodo: " + req.getMetodo());

			if (req.getMetodo().contains("GET")) {

				if (req.getAccion2() != null) {
					String hacer = req.getAccion2();

					if (hacer.contains("Ingresar")) {

						UsuarioDTO user = new UsuarioDTO();
						UsuarioDAO userD = new UsuarioDAO();
						ArrayList<Atributo> atr = req.getAtributos();
						String criterio1 = null;
						String criterio2 = null;

						for (int i = 0; i < atr.size(); i++) {
							if (atr.get(i).getAtrib().equals("user")) {
								criterio1 = atr.get(i).getValor();
							}
							if (atr.get(i).getAtrib().equals("passw")) {
								criterio2 = atr.get(i).getValor();
							}
						}

						user = userD.readU(criterio1, criterio2);

						Gson gson = new Gson();
						String listadoJSON = "[";

						listadoJSON += gson.toJson(user) + "]";
						resp.imprimirSalida(resp.getHeader());
						resp.imprimirSalida(listadoJSON);

					} else if (hacer.contains("RegistrarU")) {

						UsuarioDTO user = new UsuarioDTO();
						UsuarioDAO userD = new UsuarioDAO();
						ArrayList<Atributo> atr = req.getAtributos();

						for (int i = 0; i < atr.size(); i++) {
							if (atr.get(i).getAtrib().equals("newUserName")) {
								user.setNombreUsuario(atr.get(i).getValor());
							}
							if (atr.get(i).getAtrib().equals("newPassw")) {
								user.setContrase�a(atr.get(i).getValor());
							}
						}
						
						if (userD.createU(user)) {
							System.out.println("Cree el usuario correctamente");
							
							Gson gson = new Gson();
							String listadoJSON = "[";
							listadoJSON += gson.toJson(user) + "]";
							
							resp.imprimirSalida(resp.getHeader());
							resp.imprimirSalida(listadoJSON);
							
						} else {
							System.out.println("No se pudo crear");
						}

					}

				} else { // no piden ninguna accion enviamos un archivo, por defecto es index.html
					if (req.getAccion2().equals(" ")) { // no pidieron nada enviamos pagina principal

						PaginaInicio = resp.getHeader();
						PaginaInicio += resp.getInitPage("hola desde el servidor IW2");
						resp.imprimirSalida(PaginaInicio);

					} else { // pidieron un archivo, lo enviamos
						req.enviarArchivo("", ps);
					}
				}
			}

			resp.cerrar();
			conector.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}
}
