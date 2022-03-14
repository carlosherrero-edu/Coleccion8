package expregulares;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase para validar una cadena contra una expresión regular
 *
 */
public class ValidadorExpRegular {
	
	static Scanner teclado= new Scanner(System.in);

	public static void main(String[] args) {
		//construimos la expresión regular y el objeto pattern
		String expRegular="(?u)hola";
		
		
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
			boolean coincide= validar.matches(expRegular);
			
		
			System.out.format("%n La cadena %s  %s a la expresión regular",
							validar, (coincide?"se ajusta":"NO se ajusta"));
		
		}
		//cerrar Scanner
		System.out.println("Saliste del validador...");
		teclado.close();


	}

}
