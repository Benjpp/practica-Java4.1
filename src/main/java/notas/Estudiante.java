package notas;

public class Estudiante {
	private String dni;
	private String nombre;
	private double nota;
	public Estudiante(String dni, String nombre) {
		this.dni=dni;
		this.nombre=nombre;
		this.nota=0;
	}
	public Estudiante(String dni, String nombre, double nota) {
		this.dni=dni;
		this.nombre=nombre;
		this.nota=nota;
	}
	public String getNombre() {
		return this.nombre;
	}
	public String getDni() {
		return this.dni;
	}
	public double getCalificacion() {
		return this.nota;
	}
	public boolean equals(Estudiante o) {
		return this.nombre.equals(o.getNombre()) && this.dni.equalsIgnoreCase(o.getNombre());
	}
	public int hashCode() {
		return this.hashCode();
	}
	public String toString() {
		return this.nombre+this.dni;
	}
}
