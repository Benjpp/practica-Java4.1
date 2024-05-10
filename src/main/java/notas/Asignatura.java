package notas;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Asignatura {
	private String nombre;
	private List<Estudiante> estudiantes=new ArrayList<>();
	private List<String> errores=new ArrayList<>();
	public Asignatura(String nombre, String[] alumnos){
		this.nombre=nombre;
		estudiantes=new ArrayList<>();
		for(int i=0;i<alumnos.length;i++) {
			try(Scanner nuevoAlumnos=new Scanner(alumnos[i].toString())) {
				nuevoAlumnos.useLocale(Locale.ENGLISH);
				nuevoAlumnos.useDelimiter("[;]");
				String dni=nuevoAlumnos.next();
				String nombreApellidos=nuevoAlumnos.next();
				double nota=Double.parseDouble(nuevoAlumnos.next());
				estudiantes.add(new Estudiante(dni,nombreApellidos,nota));
			}catch(EstudianteException e) {
				errores.add("Error. "+e.getMessage()+": "+alumnos[i]);
			}catch(NumberFormatException ne) {
				errores.add("Error. Nota no numerica: "+alumnos[i]);
			}catch(NoSuchElementException nse) {
				errores.add("Error. Faltan datos: "+alumnos[i]);
			}
		}
	}
	public double getCalificacion(Estudiante est) throws EstudianteException{
		int posicionDeEst=this.buscarEstudiante(est);
		if(posicionDeEst==-1) {
			throw new EstudianteException(est.toString()+" no se encuentra");
		}else {
			return this.estudiantes.get(posicionDeEst).getCalificacion();
		}
	}
	public double getMedia() throws EstudianteException{
		if(this.estudiantes.isEmpty()) {
			throw new EstudianteException("No hay estudiantes");
		}else {
			double sumatorio=0;
			for(int i=0;i<this.estudiantes.size();i++) {
				sumatorio=sumatorio+this.estudiantes.get(i).getCalificacion();
			}
			return sumatorio/this.estudiantes.size();
		}
	}
	public String getNombre() {
		return this.nombre;
	}
	public List<Estudiante> getEstudiantes(){
		return this.estudiantes;
	}
	public List<String> getErrores(){
		return this.errores;
	}
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(this.nombre);
		sb.append(": { ");
		sb.append(this.getEstudiantes().toArray());
		sb.append(", ");
		sb.append(this.getErrores().toArray());
		sb.append("}");
		return sb.toString();
	}
	private int buscarEstudiante(Estudiante est) {
		boolean encontrado=false;
		int posicion=0;
		while(!encontrado && posicion<this.estudiantes.size()) {
			if(estudiantes.get(posicion).equals(est)) {
				encontrado=true;
			}
			posicion++;
		}
		return posicion= (encontrado)? posicion-1:-1;
	}
}
