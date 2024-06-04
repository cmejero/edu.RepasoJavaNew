package servicios;

import java.util.Scanner;

public class menuImplementacion implements menuInterfaz {


	public int menuYSeleccionPrincipal(Scanner sc) {
		
		int opcionUsuario;
		
		System.out.println("#######################");
		System.out.println("0. Cerrar aplicacion");
		System.out.println("1. Dar alta objeto");
		System.out.println("2. Mostrar lista1");
		System.out.println("#######################");
		
		opcionUsuario = sc.nextInt();
		
		
		return opcionUsuario;
	}
}
