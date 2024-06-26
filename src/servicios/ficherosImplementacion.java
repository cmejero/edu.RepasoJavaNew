package servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import controladores.Inicio;
import dtos.AlumnoDto;

public class ficherosImplementacion implements ficherosInterfaz {

	public void ficheroLog(String mensaje) {
		try {
			FileWriter escritor = new FileWriter(Inicio.rutaConFecha, true);
			escritor.write(mensaje);

			escritor.close();
		} catch (IOException io) {

			System.out.println("Se ha producido un error");

		}
	}

	public void escribirDatos() {

		AlumnoDto[] arrayAlum = Inicio.listaAlumnos.toArray(new AlumnoDto[0]);

		
		try {
			
			

			for (int i = 0; i < arrayAlum.length - 1; i++) {

				for (int j = 0; j < arrayAlum.length - i - 1; j++) {
					if (arrayAlum[j].getFechaNacimiento().compareTo(arrayAlum[j + 1].getFechaNacimiento()) > 0) {

						AlumnoDto alum = arrayAlum[j];
						arrayAlum[j] = arrayAlum[j + 1];
						arrayAlum[j + 1] = alum;
						
						

					}

				}

				

			}
			
			FileWriter fw = null;
			for(AlumnoDto alumno : Inicio.listaAlumnos) {
			fw = new FileWriter(Inicio.rutaDatos, true);
			
			
			fw.write(alumno.toString().concat("\n"));
			}
			
			fw.close();

		} catch (IOException io) {
			ficheroLog("Se ha producido un error en ficheros" + io.getMessage());
			System.out.println("Se ha producido un error ");

		}
	}

	public void leerFichero() {
		try {
			File archivo = new File(Inicio.rutaDatos);
			BufferedReader bf = new BufferedReader(new FileReader(archivo));
			String lineas = "";

			while ((lineas = bf.readLine()) != null) {

				String[] linea = lineas.split(";");

				AlumnoDto alumno = new AlumnoDto();

				alumno.setIdAlumno(crearId());
				alumno.setNombreAlumno(linea[0]);
				alumno.setApellido1Alumno(linea[1]);
				alumno.setApellido2Alumno(linea[2]);
				alumno.setDNI(linea[3]);
				alumno.setDireccion(linea[4]);
				alumno.setTelefono(linea[5]);
				alumno.setEmail(linea[6]);
				String fechaNa = linea[7];
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

				LocalDate fechaNacimiento = LocalDate.parse(fechaNa, formato);

				alumno.setFechaNacimiento(fechaNacimiento);

			}
			bf.close();

		} catch (IOException io) {

			ficheroLog("Se ha producido un error en el metodo leerFichero(): " + io.getMessage());
			System.out.println("Se ha producido un error, intentelo más tarde");
		}
	}

	private long crearId() {

		long nuevoId;
		int tamanioLista = Inicio.listaAlumnos.size();

		if (tamanioLista > 0) {

			nuevoId = Inicio.listaAlumnos.get(tamanioLista - 1).getIdAlumno() + 1;
		} else {

			nuevoId = 1;
		}
		return nuevoId;
	}

}
