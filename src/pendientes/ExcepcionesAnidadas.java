package pendientes;

public class ExcepcionesAnidadas {

	public static void main(String[] args) {
		try {
			metodo1();
		} catch (Exception ex) {
			System.err.printf("%s%n%n", ex.getMessage());
			ex.printStackTrace();

			StackTraceElement[] trazas = ex.getStackTrace();

			System.out.println("Información obtenida por la pila de trazas");
			System.out.println("Clase \t\t\t\t\t Fichero \t\t\tLínea \tMétodo");
			for (StackTraceElement ele : trazas) {
				System.out.printf("%s\t", ele.getClassName());
				System.out.printf("%s\t", ele.getFileName());
				System.out.printf("%s\t", ele.getLineNumber());
				System.out.printf("%s\n", ele.getMethodName());

			}
		} // fin try-catch

	} // fin main

	static void metodo1() throws Exception {
		metodo2();
	}

	static void metodo2() throws Exception {
		metodo3();
	}

	static void metodo3() throws Exception {
		throw new Exception("Excepción generada desde metodo3");
	}

}
