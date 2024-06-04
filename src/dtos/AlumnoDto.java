package dtos;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AlumnoDto {

	 long idAlumno;
	 String nombreAlumno = "aaaaaaa";
	 String apellido1Alumno = "aaaaa";
	 String apellido2Alumno = "aaaaa";
	 String DNI = "aaaaa";
	 String direccion = "aaaaa";
	 String telefono = "aaaaa";
	 String email = "aaaaa";
	 LocalDate fechaNacimiento;
	 

	 public long getIdAlumno() {
		return idAlumno;
	}






	public void setIdAlumno(long idAlumno) {
		this.idAlumno = idAlumno;
	}






	public String getNombreAlumno() {
		return nombreAlumno;
	}






	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}






	public String getApellido1Alumno() {
		return apellido1Alumno;
	}






	public void setApellido1Alumno(String apellido1Alumno) {
		this.apellido1Alumno = apellido1Alumno;
	}






	public String getApellido2Alumno() {
		return apellido2Alumno;
	}






	public void setApellido2Alumno(String apellido2Alumno) {
		this.apellido2Alumno = apellido2Alumno;
	}






	public String getDNI() {
		return DNI;
	}






	public void setDNI(String dNI) {
		DNI = dNI;
	}






	public String getDireccion() {
		return direccion;
	}






	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}






	public String getTelefono() {
		return telefono;
	}






	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}






	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}






	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}






	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}






		 
	 
	 
	 public AlumnoDto() {
		super();
	}
	
	 
	 



	@Override
	public String toString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String fechaFormateada = fechaNacimiento.format(formato);
		String string = nombreAlumno.concat(";").concat(apellido1Alumno).concat(";").concat(apellido2Alumno).concat(";").concat(DNI).concat(";").concat(direccion).concat(";").concat(telefono).concat(";").concat(email).concat(";").concat(fechaFormateada); 
		return string;
	}
	
	
	
	
	
	
}
