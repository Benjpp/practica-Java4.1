package notas;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Asignatura {
	private String nombre;
	private List<Estudiante> estudiantes;
	private List<String> errores;
	public Asignatura(String nombre, String[] alumnos) throws EstudianteException {
		this.nombre=nombre;
		estudiantes=new ArrayList<>();
		for(int i=0;i<alumnos.length;i++) {
			Scanner nuevoAlumnos=new Scanner(alumnos[i].toString());
			nuevoAlumnos.useLocale(Locale.ENGLISH);
			nuevoAlumnos.useDelimiter(";");
			try {
				String dni=nuevoAlumnos.next();
				String nombreApellidos=nuevoAlumnos.next();
				double nota=Double.parseDouble(nuevoAlumnos.next());
				estudiantes.add(new Estudiante(dni,nombre,nota));
			}catch(EstudianteException e) {
				errores.add("Error. "+e.getMessage()+": "+alumnos[i].toString());
			}catch(NumberFormatException ne) {
				errores.add("Error. Nota no numerica: "+alumnos[i].toString());
			}catch(NoSuchElementException nse) {
				errores.add("Error. Faltan datos: "+alumnos[i].toString());
			}
		}
	}
}
