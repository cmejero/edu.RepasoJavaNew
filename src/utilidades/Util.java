package utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Util {

	public static final String rutaFecha() {
		
		LocalDate fecha = LocalDate.now();		
		 DateTimeFormatter formateador = DateTimeFormatter.ofPattern("ddMMyyyy");
		String log = "log-";
		String fechaA= fecha.format(formateador);
		String txt = ".txt";
		String fechaActual = log.concat(fechaA).concat(txt);
		
		return fechaActual;
	}
}
