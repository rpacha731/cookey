package cookey.model.receta;

import java.sql.Time;

public class RecetaDTO {
	private String titulo;
	private String descripcion;
	private String ingredientes; // Pasar a string el array de ingredientes
	private String pasos;
	private Time duracion;
	private String dificultad;
	private String categoria;
	private String img;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getPasos() {
		return pasos;
	}

	public void setPasos(String pasos) {
		this.pasos = pasos;
	}

	public Time getDuracion() {
		return duracion;
	}

	public void setDuracion(Time duracion) {
		this.duracion = duracion;
	}

	public String getDificultad() {
		return dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "RecetaDTO [titulo=" + titulo + ", descripcion=" + descripcion + ", ingredientes=" + ingredientes
				+ ", pasos=" + pasos + ", duracion=" + duracion + ", dificultad=" + dificultad + ", categoria="
				+ categoria + ", img=" + img + "]";
	}

}
