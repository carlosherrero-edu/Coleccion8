package resueltos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {
	
	final static String RUTA = "C:/users/asus/tnsnames.ora";

	public static void main(String[] args) {

		

		try {
			FileReader miArchivo = new FileReader(RUTA);
			char unCar = (char) miArchivo.read();
			System.out.println("Primer carácter del archivo  :" + unCar);
			
			miArchivo.close();
		} catch (FileNotFoundException e) {
			System.out.println(" No existe el fichero");
		}

		catch (IOException e) {
			System.out.println(" Error en la entrada y salida");
		}

	}

}
