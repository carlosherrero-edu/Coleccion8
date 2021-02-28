package resueltos;

import java.time.LocalDate;



public class CalcularEdad {
	
	/**
	 * Método para calcular la edad de una persona en una fecha determinada
	 * @param fechaNac fecha de nacimiento ,en formato "dd-mm-aaaa"
	 * @param fechaRef fecha de referencia en la que se calcula su edad, en formato "dd-mm-aaaa"
	 * @return edad de la persona en años en la fecha de referencia
	 * @throws Exception si alguna de las fechas pasadas no es válida, o bien la fecha de referencia es anterior a la de nacimiento
	 */
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
			//valido la fecha de Nacimiento usando el método estático LocalDate.of . Si no existe, se generará una excepción
			LocalDate.of(anioNac, mesNac, diaNac);
			
			int diaRef= Integer.parseInt(fechaRef.substring(0, 2));
			int mesRef = Integer.parseInt(fechaRef.substring(3, 5));
			int anioRef =   Integer.parseInt(fechaRef.substring(6));
			//valido la fecha de Referencia. Si no existe, se generará una excepción
			LocalDate.of(anioRef, mesRef, diaRef);
			
			//3. Validar que la fecha de referencia es posterior a la fecha de Nacimiento
			if ((anioNac> anioRef)|| (anioNac==anioRef && mesNac>mesRef) || (anioNac== anioRef && mesNac==mesRef && diaNac>diaRef)) {
				throw new Exception ("La fecha de referencia no puede ser posterior a la fecha de nacimiento");
			} 
			//4. Si todo OK, calcular la edad
			
			int edad = anioRef - anioNac;
			if (mesRef < mesNac) {
				//si estamos en un mes anterior al de su cumpleaños, hay que restar un año
				edad--;
			} else if (mesRef == mesNac && diaRef < diaNac){
				//si estamos en el mes de su cumpleaños pero en un día anterior, también hay que restar un año
				edad--;
			}
			
			return edad;
			
		} 		
	
	} //fin del método

	public static void main(String[] args) {
		//prueba del método dimeEdad
		String fechaNacimiento="15-05-2000";
		try { 
			// los siguientes casos de prueba habría que pasarlos a JUnit
			//dimeEdad(fechaNacimiento, "hola");      //no cumple el patrón
			//dimeEdad(fechaNacimiento, "14-05-20");  //no cumple el patrón
			//dimeEdad(fechaNacimiento, "31-04-2020"); //fecha no existente
			//dimeEdad(fechaNacimiento, "29-02-2021");//fecha no existente
			//dimeEdad(fechaNacimiento, "14-05-2000");   //fecha anterior
			System.out.println(dimeEdad(fechaNacimiento, "15-05-2000")); //0 años
			System.out.println(dimeEdad(fechaNacimiento, "14-05-2001")); //0 años
			System.out.println(dimeEdad(fechaNacimiento, "15-05-2001")); //1 años
			System.out.println(dimeEdad(fechaNacimiento, "01-05-2020")); //19 años
			System.out.println(dimeEdad(fechaNacimiento, "31-05-2020")); //20 años
		} catch (Exception e){
			e.printStackTrace();
		}
		

	}

}
