package resueltos;

public class Reloj {

//propiedades de la clase	
	
	private int horas;
	private int minutos;
	private int segundos;
	
	final String PATRON1="^(([01]\\d)|(2[0-3])):[0-5]\\d:[0-5]\\d$";
	final String PATRON2="^(([01]\\d)|(2[0-3])):[0-5]\\d$";
	
//constructores
	
	public Reloj(){
		
		this.horas=0;
		this.minutos=0;
		this.segundos=0;
	}
	
	public Reloj(String hora){
		
		ponerHora2 ( hora);
		
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
	
	public void ponerHora(String nuevaHora){
		
		if (nuevaHora.matches(PATRON2)){
			ponerHora(nuevaHora.concat(":00"));
	}
	else {
		throw new IllegalArgumentException("La nueva hora no se ajusta al patrón hh:mm");
	}
	}
	
	public void ponerHora2(String nuevaHora){
		
		if (nuevaHora.matches(PATRON1)){
			
			String[] tokens=nuevaHora.split(":");
		
		    this.horas = Integer.parseInt(tokens[0]);
			this.minutos = Integer.parseInt(tokens[1]);;
			this.segundos = Integer.parseInt(tokens[2]);
		} else {
			throw new IllegalArgumentException("La nueva hora no se ajusta al patrón hh:mm:ss");
		}
	}
}
