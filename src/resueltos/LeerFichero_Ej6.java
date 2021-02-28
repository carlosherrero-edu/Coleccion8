package resueltos;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/**
 * Clase de lectura de un fichero para resolver el Ejercicio 6 de la colección 8
 * @author Carlos Herrero
 * @version 1.0
 *
 */
public class LeerFichero_Ej6 {
	
	public static void main(String[] args){
		
		Scanner teclado= new Scanner(System.in);
		FileReader miArchivo = null;
	
	
		try{
					
			boolean existeRuta = false;
			//usamos un do-while para pedir al menos la ruta del fichero 1 vez
			do{
				try{
					System.out.println("Escribe la ruta del fichero a leer...");
					String ruta= teclado.nextLine();
					miArchivo= new FileReader(ruta);
					// si llegamos hasta aquí, el fichero se ha podido abrir
					existeRuta = true;
				}
				catch (FileNotFoundException e){
					System.out.println(" No existe el fichero que has indicado. "
						+ "\n Por favor, comprueba su nombre y ruta");
				}
			} while (!existeRuta);  
			// hasta que no se introduzca un fichero correcto, no salimos de aquí
			
			char unCar = (char)miArchivo.read();
			System.out.println("Primer carácter del archivo  :"+unCar);
		} // aquí se acaba el try principal
		catch (IOException e){
			System.out.println(" Error en la entrada y salida");
			e.printStackTrace();
		}
		finally{
			//ocurra lo que ocurra, tratamos de cerrar el fichero y Scanner
			try{
				miArchivo.close();
				teclado.close();
			} 
			catch (Exception e){
				//no haremos nada. Lo inicializaremos a null
				
				miArchivo = null;
				teclado = null;
				e.printStackTrace();
			}
		}
			
		
		
	}//fin del main

	
}
