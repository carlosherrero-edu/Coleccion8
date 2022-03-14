package pendientes;

/**
 * Clase ExpedienteAlumno que resuelve los Ejercicios 8 y 9 de Colección 7
 * @author Carlos Herrero
 *
 */
public class ExpedienteAlumno {

	private int nia;
	private String nombreApe;
	private int num_asig;   //esta propiedad se utiliza únicamente en el ejercicio 8
	private double[] calificaciones;
	private double[] creditos;

	public ExpedienteAlumno(int nia, String nombreApe, int num_asig, double[] creditos)
			throws IllegalArgumentException {

		//realizamos las validaciones pedidas antes de crear un nuevo objeto
		if (nia > 0 && num_asig > 0 ) {
			if (num_asig == creditos.length){
				//comprobamos si el número de créditos de todas las asignaturas está entre 0 y 100
				for (int i = 0; i < creditos.length; i++) {
					if (creditos[i] < 0 || creditos[i] > 100) {
						throw new IllegalArgumentException("Los creditos deben estar comprendidos entre 0-100");
					
					} 
				} //fin del recorrido de creditos
				//si llegamos hasta aquÃ­, los parÃ¡metros son vÃ¡lidos
				
				this.nia = nia;
				this.nombreApe = nombreApe;
				this.num_asig = num_asig;
				this.creditos = creditos;
				
			} else {
				throw new IllegalArgumentException("no se ha especificado la duración en créditos de todas las asignaturas");
			} 
		} else {
			throw new IllegalArgumentException("el nia y número de asignaturas deben ser positivos");
		}
			
			
		
	}

	public String obtenerDatosAlumno() {

		return this.nia + "  " + this.nombreApe;
	}
	

	public void asignarCalificaciones(double[] calificaciones) {
		//comprobamos primero que cada asignatura tiene asignada una calificación
		boolean validacion = (creditos.length == calificaciones.length) ;

		if (validacion) {
			this.calificaciones = calificaciones;
		} else {
			System.out.println("NO se asignan las calificaciones porque no coincide con el número de asignaturas");
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

}
