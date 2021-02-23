package pendientes;

public class Reloj {

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
		
		this.horas = horas;
		this.minutos = minutos;
		this.segundos = segundos;
		
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
	
	public String mostrarHora(){
		
		return String.format("Son las %2d horas %2d minutos y %2d segundos", 
				this.getHoras(),this.getMinutos(), this.getSegundos());
		
	}
	
	public void ponerHora(int horas, int minutos){
		
		this.ponerHora2(horas, minutos, 0);
	}
	
	public void ponerHora2(int horas, int minutos, int segundos){
		
	    	this.horas = horas;
		this.minutos = minutos;
		this.segundos = segundos;
	}
}
