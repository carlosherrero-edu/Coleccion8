package pendientes;

import java.time.LocalDate;


public class CalcularEdad {
	
	static int dimeEdad( String fechaNac, String fechaRef) throws Exception {
		
		final String PATRON_FECHA="^\\d{2}-\\d{2}-(19|20)\\d{2}$";
		
		//1. Validar las entradas con expresiones regulares
		
		if (!fechaNac.matches(PATRON_FECHA) || !fechaRef.matches(PATRON_FECHA)) {
			throw new Exception ("Alguna de las fechas no cumple el patrón esperado");
			
		}  else {
			//2. Validar que esas fechas realmente existen
			int diaNac= Integer.parseInt(fechaNac.substring(0, 2));
			int mesNac = Integer.parseInt(fechaNac.substring(3, 5));
			int anioNac =   Integer.parseInt(fechaNac.substring(6));
			//valido la fecha de Nacimiento
			LocalDate.of(anioNac, mesNac, diaNac);
			
			int diaRef= Integer.parseInt(fechaRef.substring(0, 2));
			int mesRef = Integer.parseInt(fechaRef.substring(3, 5));
			int anioRef =   Integer.parseInt(fechaRef.substring(6));
			//valido la fecha de Referencia
			LocalDate.of(anioRef, mesRef, diaRef);
			
			if (anioNac> anioRef || (anioNac==anioRef && mesNac>mesRef) || (anioNac== anioRef && mesNac==mesRef && diaNac>diaRef)) {
				throw new Exception ("La fecha de referencia no puede ser posterior a la fecha de nacimiento");
			}
			
		} 
		
	
		
		
		
		//3. Validar que la fecha de referencia es posterior a la fecha de Nacimiento
		
		//4. Si todo OK, calcular la edad
		
		
		
		return 0;
	}

	public static void main(String[] args) {
		try { 
			dimeEdad("01-02-2021", "01-02-2020");
		} catch (Exception e){
			e.printStackTrace();
		}
		

	}

}
