package resueltos;

public class Reloj {
	
	final String expRegHora="^([01]\\d|2[0-3])$";
	final String expRegMiniSeg="^[0-5]\\d$";

//propiedades de la clase	
	
	private int horas;
	private int minutos;
	private int segundos;
	
	
	
//constructores
	
	public Reloj(){
		
		this.horas=0;
		this.minutos=0;
		this.segundos=0;
	}
	
	public Reloj(int horas, int minutos, int segundos){
		
		setHoras(horas);
		setMinutos(minutos);
		setSegundos(segundos);
		
	}

// metodos get & set	
	
	public int getHoras() {
		return horas;
	}

	

	public int getMinutos() {
		return minutos;
	}

	

	public int getSegundos() {
		return segundos;
	}
	
	

	
	
//metodo mostrar hora
	
	private void setHoras(int horas) {
		if (Integer.toString(horas).matches(expRegHora)) {
			this.horas = horas;
		} else {
			throw new IllegalArgumentException("La hora debe estar entre 00-23");
		}

	}

	private void setMinutos(int minutos) {
		if(Integer.toString(minutos).matches(expRegMiniSeg)){
			this.minutos=minutos;
		} else {
			throw new IllegalArgumentException("Los minutos deben estar entre 00-59");
		}
	}

	private void setSegundos(int segundos) {
		if(Integer.toString(segundos).matches(expRegMiniSeg)){
			this.segundos = segundos;
		}else {
			throw new IllegalArgumentException("Los segundos deben estar entre 00-59");
		}

	}
	

	public String mostrarHora(){
		
		return String.format("Son las %2d horas %2d minutos y %2d segundos", 
				this.getHoras(),this.getMinutos(), this.getSegundos());
		
	}
	
	public void ponerHora(int horas, int minutos){
		
		this.ponerHora2(horas, minutos, 0);
	}
	
	public void ponerHora2(int horas, int minutos, int segundos){
		
		setHoras(horas);
		setMinutos(minutos);
		setSegundos(segundos);
	}
	
	/* 
	 * Método main para prueba rápida
	 */
	
	public static void main(String[] args) {
		Reloj miReloj= new Reloj();
		miReloj.ponerHora2(12, 30, 30);
		System.out.println(miReloj.mostrarHora());
		//las siguientes instrucciones generarán excepción
		try {
			miReloj.ponerHora2(24, 30, 30);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			miReloj.ponerHora2(12, 60, 30);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		

		try {
			miReloj.ponerHora2(12, 30, -20);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
