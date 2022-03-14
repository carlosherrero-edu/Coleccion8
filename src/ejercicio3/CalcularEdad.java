package ejercicio3;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class CalcularEdad {
	
	/**
	 * MÃ©todo para calcular la edad de una persona en una fecha determinada
	 * 
	 * @param fechaNac fecha de nacimiento ,en formato "dd-mm-aaaa"
	 * @param fechaRef fecha de referencia en la que se calcula su edad, en formato
	 *                 "dd-mm-aaaa"
	 * @return edad de la persona en aÃ±os en la fecha de referencia
	 * @throws Exception si alguna de las fechas pasadas no es vÃ¡lida, o bien la
	 *                   fecha de referencia es anterior a la de nacimiento //
	 */

	static int dimeEdad(String fechaNac, String fechaRef)
			throws FechaNacimientoException, NumberFormatException, DateTimeException {

		String anioNac, diaNac, mesNac;
		String anioRef, diaRef, mesRef;
		int edad;

		// Paso 1: Tomar subcadenas de las fechas
		diaNac = fechaNac.substring(0, 2);
		mesNac = fechaNac.substring(3, 5);
		anioNac = fechaNac.substring(6);
		diaRef = fechaRef.substring(0, 2);
		mesRef = fechaRef.substring(3, 5);
		anioRef = fechaRef.substring(6);

		// convertir las cadenas en números
		int diaNacEnt = Integer.parseInt(diaNac);
		int mesNacEnt = Integer.parseInt(mesNac);
		int anioNacEnt = Integer.parseInt(anioNac);

		int diaRefEnt = Integer.parseInt(diaRef);
		int mesRefEnt = Integer.parseInt(mesRef);
		int anioRefEnt = Integer.parseInt(anioRef);

		// Paso 2: Convertirlas a números

		LocalDate fechaNacimiento = LocalDate.of(anioNacEnt, mesNacEnt, diaNacEnt);

		LocalDate fechaReferencia = LocalDate.of(anioRefEnt, mesRefEnt, diaRefEnt);

		if (fechaReferencia.isAfter(fechaNacimiento)) {

			 edad = anioRefEnt - anioNacEnt;

			if (mesRefEnt < mesNacEnt) {
				edad--;
			} else if (mesRefEnt == mesNacEnt && diaRefEnt < diaNacEnt) {
				edad--;
			}

		} else {
			throw new FechaNacimientoException("La fecha de nacimiento no puede ser anterior a la fecha de referencia");
		}

		

		return edad;
	}
	

	
//	

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String fechaNac, fechaRef;

		boolean fechasValidas=false; 
		
		while (!fechasValidas) {
			
			try {
				System.out.print("\nDime la fecha de nacimiento (dd-mm-aaaa) >>>");
				fechaNac = teclado.nextLine();
		
				System.out.print("\nDime la fecha de referencia (dd-mm-aaaa) >>>");
				fechaRef = teclado.nextLine();
		
				int edad = dimeEdad(fechaNac, fechaRef);
		
				System.out.format("%n Tu edad a la fecha del %s es de  %d años ", fechaRef, edad);
				
				fechasValidas=true;
				
			} catch (FechaNacimientoException e) {
				
				System.out.println("LO siento, pero aún no habías nacido en esa fecha");
				
			} catch (NumberFormatException e) {
				
				System.out.println("Has introducido algún valor no numérico dentro de la fecha");
				
			} catch (DateTimeException e) {
				System.out.println("LA fecha que has introducido no existe");
			}
			
		}//fin del while
		

	}

}
