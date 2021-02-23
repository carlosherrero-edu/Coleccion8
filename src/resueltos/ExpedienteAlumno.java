package resueltos;

public class ExpedienteAlumno {
	
	final int CREDITOS_MIN=0;
	final int CREDITOS_MAX=0;
	
	final String PATRON_NOMBRE="[A-Z][\\w\\s\\-&]{1,49}";
	final String PATRON_APE="[A-Z][\\w\\s\\-&]{1,99}";

	private int nia;
	private String nombre;
	private String apellidos;
	private double[] creditos;
	private double[] calificaciones;
	
	
	
	boolean validarCreditos (double [] creditos) {
		
		
		
		boolean validado=true;
		
		//recorro todos los créditos y compruebo si alguno incumple la condición de validación
		for (double valor: creditos) {
			
			if (valor<=CREDITOS_MIN || valor>CREDITOS_MAX) {
				validado=false;
			}
		}
		
		return validado;
	}

	public ExpedienteAlumno(int nia, String nombre, String apellidos, double[] creditos) throws IllegalArgumentException {
	
		
		if ( !String.valueOf(nia).matches("\\d{4,6}")) {
			throw new IllegalArgumentException("El NIA debe constar de entre 4 y 6 dígitos numéricos");
		}
		
		if (!nombre.matches(PATRON_NOMBRE)) {
			throw new IllegalArgumentException("El Nombre no cumple las condiciones de validación");
		}
		

		if (!apellidos.matches(PATRON_APE)) {
			throw new IllegalArgumentException("Los apellidosno cumplen las condiciones de validación");
		}
			
	
		
		if (!validarCreditos(creditos)) {
			throw new IllegalArgumentException("La carga horaria de cada crédito debe estar entre "+ CREDITOS_MIN +" y "+  CREDITOS_MAX);
			
		}
		
		// si llego a este punto, todo es correcto e instancio el objeto
			this.nia=nia;
			this.nombre=nombre;
			this.apellidos = apellidos;
			this.creditos = creditos;
			
		
	}

	public String obtenerDatosAlumno() {

		return this.nia +"  "+ this.nombre + "  "+ this.apellidos;
	}
	
	

	public void asignarCalificaciones(double[] calificaciones) {
		boolean validacion = (this.creditos.length == calificaciones.length);

		if (validacion) {
			this.calificaciones = calificaciones;
		}

	}

	public double obtenerNotaMedia(){
		
			return 0;
		
	}
	
	public boolean pasaCurso() {
		return true;
	}

}
