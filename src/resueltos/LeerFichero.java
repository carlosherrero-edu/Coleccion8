package resueltos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {
	
	final static String RUTA = "/home/zeus/pseint/pseint";

	public static void main(String[] args) {

		

		try {
			//esta orden puede lanzar FileNotFoundException si no existe el fichero
			FileReader miArchivo = new FileReader(RUTA);
			//esta orden puede lanzar IOException si ,por ejemplo no es un fichero de caracteres
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
