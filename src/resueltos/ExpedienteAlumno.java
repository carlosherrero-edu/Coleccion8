package resueltos;

/**
 * Clase ExpedienteAlumno que resuelve los Ejercicios 8 y 9 de Colecci�n 7
 * @author Carlos Herrero
 *
 */
public class ExpedienteAlumno {

	//expresiones regulares
	final String expRegNia="^\\d{4,6}$";
	final String expRegNombre="^\\p{Lu}[\\p{Lu}\\p{Ll}\\s\\-&]{1,49}$";
	final String expRegApellidos="^\\p{Lu}[\\p{Lu}\\p{Ll}\\s\\-&]{1,99}$";
	
	//propiedades
	private int nia;
	private String nombre;
	private String apellidos;
	private int num_asig;   //esta propiedad se utiliza �nicamente en el ejercicio 8
	private double[] calificaciones;
	private double[] creditos;

	public ExpedienteAlumno(int nia, String nombre, String apellidos, int num_asig, double[] creditos)
			throws IllegalArgumentException {

		//realizamos las validaciones pedidas antes de crear un nuevo objeto
		if ( num_asig > 0 ) {
			if (num_asig == creditos.length){
				//comprobamos si el n�mero de cr�ditos de todas las asignaturas est� entre 0 y 100
				for (int i = 0; i < creditos.length; i++) {
					if (creditos[i] < 0 || creditos[i] > 100) {
						throw new IllegalArgumentException("Los creditos deben estar comprendidos entre 0-100");
					
					} 
				} //fin del recorrido de creditos
				//si llegamos hasta aquí, los parámetros son válidos
				
				setNia(nia);
				setNombre(nombre);
				setApellidos(apellidos);
				this.creditos = creditos;
				
			} else {
				throw new IllegalArgumentException("no se ha especificado la duraci�n en cr�ditos de todas las asignaturas");
			} 
		} else {
			throw new IllegalArgumentException("el  n�mero de asignaturas deben ser positivo");
		}
			
			
		
	}
	
	

	private void setNia(int nia) {
		if (!Integer.toString(nia).matches(expRegNia)) {
			throw new IllegalArgumentException("El NIA no cumple el formato esperado");
		} 
		//aquí se llega sólo si no se han lanzado la excepción 
		this.nia=nia;
		
	}



	private void setNombre(String nombre) {
		if (!nombre.matches(expRegNombre)) {
			throw new IllegalArgumentException("El Nombre no cumple el formato esperado");
		}
		this.nombre = nombre;
	}



	private void setApellidos(String apellidos) {
		if (!apellidos.matches(expRegApellidos)) {
			throw new IllegalArgumentException("El campo Apellidos NO cumple el formato esperado");
		}
		this.apellidos = apellidos;
	}



	public String obtenerDatosAlumno() {

		return this.nia + "  " + this.nombre+" "+ this.apellidos;
	}
	

	public void asignarCalificaciones(double[] calificaciones) {
		//comprobamos primero que cada asignatura tiene asignada una calificaci�n
		boolean validacion = (creditos.length == calificaciones.length) ;

		if (validacion) {
			this.calificaciones = calificaciones;
		} else {
			System.out.println("NO se asignan las calificaciones porque no coincide con el n�mero de asignaturas");
		}

	}
	

	public boolean apruebaCurso() throws Exception {
		
		//comprobar previamente que hay calificaciones asignadas
			if (this.calificaciones == null) {
					throw new IllegalArgumentException ("No hay calificaciones asignadas");
			}
				
		
		double cargaTotal = 0;
		final double PORCENTAJE_APROBAR = 30.0;
		final double NOTA_APROBAR = 5.0;
		
		//sumamos el numero total de creditos
		for (double d : creditos) {
			cargaTotal += d;
		}
		
		int creditos_suspensos=0; 
		//sumamos el total de creditos suspensos
		for (int i = 0; i < calificaciones.length; i++) {
			if (calificaciones[i] < NOTA_APROBAR ) {
				creditos_suspensos += creditos[i];		
			} 
		} //fin del recorrido de las calificaciones
		
		
		return  (100.0*(double)creditos_suspensos/(double)cargaTotal <= PORCENTAJE_APROBAR);
	}
	
	
	

	public double obtenerNotaMedia() {
		//comprobar previamente que hay calificaciones asignadas
		
		if (this.calificaciones == null) {
			throw new IllegalArgumentException ("No hay calificaciones asignadas"); 
		}
		
		// tener en cuenta en JUnit que puede generarse un NullPointerException
		double notaMedia = 0;
		double cargaTotal = 0;
		//obtenemos la carga total horaria entre todas las asignaturas
		for (double d : creditos) {
			cargaTotal += d;
		}

		//hacemos la suma ponderada de las calificaciones
		for (int i = 0; i < this.calificaciones.length; i++) {

			notaMedia = (this.calificaciones[i] * this.creditos[i]);
		}

		return notaMedia / cargaTotal;

	}
	
	/*
	 * Método main para prueba rápida
	 */
	public static void main(String[] args) {
		ExpedienteAlumno expe1= new ExpedienteAlumno(123456,"María","Fernández-Cid",3, new double[] {10,20,30});
		System.out.println(expe1.obtenerDatosAlumno());
		/* 
		 * Las siguientes llamadas al constructor provocarán excepciones
		 */
		
		try {
			ExpedienteAlumno expe2= new ExpedienteAlumno(123,"María","Fernández-Cid",3, new double[] {10,20,30});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			ExpedienteAlumno expe2= new ExpedienteAlumno(1234567,"María","Fernández-Cid",3, new double[] {10,20,30});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			ExpedienteAlumno expe2= new ExpedienteAlumno(123456,"maría","Fernández-Cid",3, new double[] {10,20,30});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			ExpedienteAlumno expe2= new ExpedienteAlumno(123456,"María","Fernández-Cid12",3, new double[] {10,20,30});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
