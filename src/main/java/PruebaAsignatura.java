import notas.*;
import java.util.StringJoiner;
public class PruebaAsignatura {
	static final String[] als= {"12455666F;Lopez Perez, Pedro;6.7","33678999D;Merlo Gomez, Isabel;5.8","23555875G;Martinez Herrera, Lucia;9.1"};
	public static void main(String[] args) throws EstudianteException{
		Asignatura PA1=new Asignatura("PA1",als);
		try {
			System.out.println(PA1.getMedia());
		}catch(EstudianteException e) {
			System.out.println(e.getMessage());
		}
		StringJoiner Dnis=new StringJoiner(", ");
		for(Estudiante e: PA1.getEstudiantes()) {
			Dnis.add(e.getDni());
		}
		System.out.println("Dnis: "+Dnis.toString());
	}
}
