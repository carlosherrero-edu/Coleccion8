package expregulares;

import java.util.Scanner;


/**
 * Clase para validar una cadena contra una expresión regular
 *
 */
public class ValidadorExpRegular {
	
	static Scanner teclado= new Scanner(System.in);

	public static void main(String[] args) {
		//construimos la expresión regular y el objeto pattern
		//patrón para validar un número de cuenta bancaria (formato IBAN) en España
		String expRegular1="^ES\\d{2}(\\s+\\d{4}){5}$";  
	
		
		
		//repetimos mientras no introduzcamos cadena vacía
		while (true) {
			//leemos la cadena a validar
			System.out.print("\nEscribe la cadena a validar:>>>");
			String validar= teclado.nextLine();
			//si la cadena es vacía, abandonamos el bucle
			if (validar.trim().length()<1) {
				break;
			}
			
			//en caso contrario, comprobamos si la cadena se ajusta a la expresión
			boolean coincide= validar.matches(expRegular1);
			
		
			System.out.format("%n La cadena %s  %s a la expresión regular",
							validar, (coincide?"se ajusta":"NO se ajusta"));
		
		}
		//cerrar Scanner
		System.out.println("Saliste del validador...");
		teclado.close();


	}

}
