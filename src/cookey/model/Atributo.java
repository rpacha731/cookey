package model;

public class Atributo {
	private String atrib;
	private String valor;
	
	public Atributo(String atrib, String valor) {
		super();
		this.atrib = atrib;
		this.valor = valor;
	}
	
	public String getAtrib() {
		return atrib;
	}
	public void setAtrib(String atrib) {
		this.atrib = atrib;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Atributo [atrib=" + atrib + ", valor=" + valor + "]";
	}
	
	
}
