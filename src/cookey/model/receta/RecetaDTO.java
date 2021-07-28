package cookey.model.receta;

import java.sql.Date;

public class RecetaDTO {
	private String titulo;
	private String descripcion;
	private String ingredientes; // Pasar a string el array de ingredientes
	private String pasos;
	private String duracion;
	private String dificultad;
	private String imagen;
	private String categoria;
	private Integer megustas;
	private Float calificacion;
	private Date fechaPublicacion;
	private String usuarioCreador;

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

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getDificultad() {
		return dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getMegustas() {
		return megustas;
	}

	public void setMegustas(Integer megustas) {
		this.megustas = megustas;
	}

	public Float getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Float calificacion) {
		this.calificacion = calificacion;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getUsuarioCreador() {
		return usuarioCreador;
	}

	public void setUsuarioCreador(String usuarioCreador) {
		this.usuarioCreador = usuarioCreador;
	}

	@Override
	public String toString() {
		return "RecetaDTO [titulo=" + titulo + ", descripcion=" + descripcion + ", ingredientes=" + ingredientes
				+ ", pasos=" + pasos + ", duracion=" + duracion + ", dificultad=" + dificultad + ", imagen=" + imagen
				+ ", categoria=" + categoria + ", megustas=" + megustas + ", calificacion=" + calificacion
				+ ", fechaPublicacion=" + fechaPublicacion + ", usuarioCreador=" + usuarioCreador + "]";
	}

}
