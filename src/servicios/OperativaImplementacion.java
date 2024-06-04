package servicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import controladores.Inicio;
import dtos.AlumnoDto;

public class OperativaImplementacion implements OperativaInterfaz {

	public void darAlta(Scanner sc) {
		
		AlumnoDto alumno = new AlumnoDto();
		alumno.setIdAlumno(idAutomatico());
		System.out.println("Introduzca su nombre");
		alumno.setNombreAlumno(sc.next());
		System.out.println("Introduzca su primer apellido");
		alumno.setApellido1Alumno(sc.next());
		System.out.println("Introduzca su segundo apellido");
		alumno.setApellido2Alumno(sc.next());
		System.out.println("Introduzca su DNI");
		alumno.setDNI(sc.next());
		System.out.println("Introduzca su direccion");
		alumno.setDireccion(sc.next());
		System.out.println("Introduzca su telefono");
		alumno.setTelefono(sc.next());
		System.out.println("Introduzca su email");
		alumno.setEmail(sc.next());
		String saltoDeLinea = sc.nextLine();
		System.out.println("Introduzca su fecha de nacimiento en formato: dd-MM-yyyy");
		String fecha = sc.next();
		// Definir el formato deseado usando DateTimeFormatter
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		// Parsear la entrada del usuario a LocalDateTime usando el formato especificado
		LocalDate fechaNa = LocalDate.parse(fecha, formatter);
		alumno.setFechaNacimiento(fechaNa);
		

		
		
		Inicio.listaAlumnos.add(alumno);
	}
	
	
	public void mostrarLista() {
		
		for(AlumnoDto alumno : Inicio.listaAlumnos) {
			
			System.out.println(alumno);
		}
		
	}
	
	
	private long idAutomatico() {
		 long nuevoId;
		 int tamanioLista = Inicio.listaAlumnos.size();
		 
		 if(tamanioLista > 0) {
			 
			 nuevoId = Inicio.listaAlumnos.get(tamanioLista -1).getIdAlumno() +1;
		 }
		 else {
			 nuevoId = 1;
		 }
		 return nuevoId;
	}
	
}
