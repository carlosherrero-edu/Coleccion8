package resueltos;

import java.security.SecureRandom;
import java.util.Scanner;

public class AdivinaNumero {

	public static void main(String[] args) {
		// Objetos que necesitamos para el programa
		Scanner teclado = new Scanner(System.in);
		// utilizamos la clase SecureRandom que genera números más aleatorios
		SecureRandom random = new SecureRandom();
		// obtenemos un número aleatorio entre 1 y 1oo
		int adivinar = random.nextInt(100) + 1;

		/*
		 * Otra forma de generar el numero aleatorio entre 1 y 100 usando la clase
		 * basica Math.random() es la siguiente:
		 * 
		 * int adivinar= (int)(Math.random()*100) +1;
		 */

		boolean hasAcertado = false;
		int intentos = 0, numero = 0;
		System.out.println("  **** ADIVINA EL NUMERO ****");
		System.out.println("       -----------------");
		System.out.println("\n Adivina un número o entre 1 y 100. Tienes 6 intentos");
		do {

			System.out.printf(" Intento  %d : ¿Qué número es ? : ", ++intentos);
		
		boolean esValido=false;
		
		while (!esValido) {	
			try {
				numero = Integer.parseInt(teclado.nextLine());
				
				if (numero<1 || numero>100) {
					throw new Exception ("El número no está comprendido entre 1 y 100");
				}
				// si no se producen excepciones, cambiamos esValido
				esValido=true;
			} catch (NumberFormatException e) {
				System.out.print("\n El número no es válido \n Por favor,escribe otro: >>>");	
				esValido=false;
			} catch (Exception e) {
				System.out.print("\n"+ e.getMessage()+" \n Por favor,escribe otro: >>>");	
				esValido=false;
			}
		} //fin del bucle de validación

			if (numero == adivinar)
				hasAcertado = true;
			else if (numero > adivinar)
				System.out.println(" Has introducido un numero demasiado grande");
			else
				System.out.println(" Has introducido un numero demasiado pequeño");
		} while (!hasAcertado && intentos < 6);

		if (hasAcertado)
			System.out.printf("Felicidades !!! Acertaste en  %d intentos", intentos);
		else
			System.out.println("agotaste tus intentos. Otra vez será!!!");

		teclado.close();

	}
}
