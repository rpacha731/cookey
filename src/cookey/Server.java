
package cookey;

import java.net.ServerSocket;

public class Server {

	public void IniciarServidor(int Puerto) {

		try {
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(Puerto);
			System.out.println("Servidor IW2 funcionado en el Puerto: " + Puerto);

			while (true) {
				new adminSocket(server.accept()).procesarSocket();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
