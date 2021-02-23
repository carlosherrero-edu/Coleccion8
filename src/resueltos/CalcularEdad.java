package resueltos;

public class CalcularEdad {// Inicio Class

	public static int dimeEdad(String fechaNac, String fechaRef) {// Inicio método

		int anioNac, mesNac, diaNac, anioRef, mRef, dRef;

		try {
			// todas las conversiones de números pueden producir una excepción
			// NumberFormatExcepcion
			// Si este error se produce, el programa finaliza y devolvemos -1
			anioNac = Integer.parseInt(fechaNac.substring(6, 10));
			mesNac = Integer.parseInt(fechaNac.substring(3, 5));
			diaNac = Integer.parseInt(fechaNac.substring(0, 2));

			anioRef = Integer.parseInt(fechaRef.substring(6, 10));
			mRef = Integer.parseInt(fechaRef.substring(3, 5));
			dRef = Integer.parseInt(fechaRef.substring(0, 2));
		} catch (NumberFormatException e) {
			System.out.println("En las fechas pasadas hay caracteres no numéricos");
			return -1;
		}

		int edad = anioRef - anioNac;

		if (mRef < mesNac) {
			edad--;
		} else if (mRef == mesNac && dRef < diaNac) {
			edad--;
		}

		// lanzaremos un error si el resultado es negativo
		try {
			if (edad < 0)
				throw new Exception("No puedo calcular tu edad en una fecha en que no habías nacido");
			return edad;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
		
	

	}// Fin método

}// Fin Class
