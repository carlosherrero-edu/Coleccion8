package pendientes;


public class Utilidades {
	
	/**
	 * Funci�n para calcular la letra de verificaci�n correspondiente a un DNI espa�ol
	 * @param dni entero con el valor del DNI, que suponemos comprendido entre 0 y 99999999
	 * @return car�cter con la letra de verificaci�n que corresponde al resultado del resto entre 23
	 * Corresponde al ejercicio 11 de la Colecci�n 6
	 */
	public static char letraNIF (int dni) {
		
		//aunque se puede plantear con un array de caracteres, es m�s sencillo tomar la posici�n de un String
		
		final String LETRAS="TRWAGMYFPDXBNJZSQVHCKE";  //letras que corresponden a cada valor del resto
		
		return LETRAS.charAt(dni%23);
	}
	
	/**
	 *  Funci�n para calcular la letra de verificaci�n correspondiente a un NIE de residente extranjero
	 * @param nie cadena con el valor del NIE, que suponemos sigue el patr�n A9999999 (1 letra + 7 d�gitos)
	 * @return car�cter con la letra de verificaci�n del NIE, o el car�cter '\u0000' si es un NIE no v�lido
	 * Corresponde al ejercicio 12 de la Colecci�n 6
	 * @see letraNIF
	 */
	public static char letraNIE (String nie) {
		
		
		int dni;
		
		// convertimos la letra inicial del NIE en el d�gito establecido por la autoridad que dise�� el sistema
		switch (nie.charAt(0)){
			case 'X' -> {
				dni= Integer.parseInt("0"+ nie.substring(1));
				}
			case 'Y' -> {
				dni= Integer.parseInt("1"+ nie.substring(1));
			}
			case 'Z' -> {
				dni= Integer.parseInt("2"+ nie.substring(1));
			}case 'A' -> {
				dni= Integer.parseInt("3"+ nie.substring(1));
			}
			default ->{
				//si no es un valor v�lido, devolvemos el car�cter unicode "nulo"
				return '\u0000';
			}
			
		}
		
		return letraNIF(dni);
		
	}

}
