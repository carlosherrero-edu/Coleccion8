package pendientes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {
	
	final static String RUTA = "RUTA/AL/FICHERO";

	public static void main(String[] args) {

			FileReader miArchivo = new FileReader(RUTA);
			char unCar = (char) miArchivo.read();
			System.out.println("Primer carácter del archivo  :" + unCar);
			
			miArchivo.close();
		
	}

}
