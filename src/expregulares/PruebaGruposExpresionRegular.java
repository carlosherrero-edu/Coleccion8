package expregulares;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase para validar una cadena contra una expresión regular y recuperar todos los grupos coincidentes
 * @author Carlos Herrero
 *
 */
public class PruebaGruposExpresionRegular {
	
	static Scanner teclado= new Scanner(System.in);

	public static void main(String[] args) {
		//construimos la expresión regular y el objeto pattern
		/*
		 * ESta expresión extrae la primea y la última palabra de una frase
		 */
		String expRegular="(^\\w+)|(\\w+$)";
		Pattern patron=Pattern.compile(expRegular);
		
		//repetimos mientras no introduzcamos cadena vacía
		while (true) {
			//leemos la cadena a validar
			System.out.print("Escribe la cadena a validar:>>>");
			String validar= teclado.nextLine();
			//si la cadena es vacía, abandonamos el bucle
			if (validar.trim().length()<1) {
				break;
			}
			
			//en caso contrario, la validamos con Matcher
			Matcher m= patron.matcher(validar);
			
			//extraemos los grupos que cumplen la expresión
			System.out.println("Grupos que cumplen la expresión");
			while (m.find()) {
				System.out.println(m.group());
			}
		
		}
		//cerrar Scanner
		System.out.println("Saliste del validador...");
		teclado.close();


	}

}
