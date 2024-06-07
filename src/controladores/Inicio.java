
package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dtos.AlumnoDto;
import servicios.OperativaImplementacion;
import servicios.OperativaInterfaz;
import servicios.ficherosImplementacion;
import servicios.ficherosInterfaz;
import servicios.menuImplementacion;
import servicios.menuInterfaz;
import utilidades.Util;

public class Inicio {

	public static final String rutaRaizLogs = "C:\\Users\\Carlos\\workspace-recuperacion-java\\logs\\";
	public static final String rutaConFecha = rutaRaizLogs.concat(Util.rutaFecha());
	public static final List<AlumnoDto> listaAlumnos = new ArrayList<AlumnoDto>();
	public static final String rutaDatos = "C:\\Users\\Carlos\\workspace-recuperacion-java\\logs\\datos.txt";

	public static void main(String[] args) {

		System.out.println(rutaConFecha);
		Scanner sc = new Scanner(System.in);
		
		int opcionUsuario;
		boolean cerrarMenu = false;
		menuInterfaz mi = new menuImplementacion();
		ficherosInterfaz fi = new ficherosImplementacion();
		OperativaInterfaz oi = new OperativaImplementacion();
		
		fi.leerFichero();
		
	do {
		try {
			
		opcionUsuario= mi.menuYSeleccionPrincipal(sc);
		
		switch(opcionUsuario) {
		
		case 0:
			System.out.println("Has seleccionado cerrar menu");
			fi.ficheroLog("El usuario ha indicado ha indicado cerrar menú;");
			fi.escribirDatos();
			cerrarMenu= true;
			
			break;
			
		case 1:
			System.out.println("Has seleccionado dar alta objeto");
			oi.darAlta(sc);
			fi.ficheroLog("El usuario ha indicado ha indicado dar alta objeto;");
			break;
		case 2:
			System.out.println("Has seleccionado mostrar lista");
			oi.mostrarLista();
			fi.ficheroLog("El usuario ha indicado ha indicado mostrar lista;");
			break;
		default:
			fi.ficheroLog("El usuario ha indicado ha indicado una opcion incorrecta;");
			System.out.println("La opcion seleccionada no correspònde con ninguna");
			break;
		}
		}catch(Exception e){
			fi.ficheroLog("se ha producido un error:" + e.getMessage());

			System.out.println("Se ha producido un error");
			
	
		}
	}while(!cerrarMenu);

	}

	
}
