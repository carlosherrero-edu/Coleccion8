package resueltos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio5 {
	
	 static String RUTA = "C:/users/Alumno/fichero";


	public static void main(String[] args) {
			
			FileReader miArchivo=null;
			Scanner teclado =new Scanner(System.in);
		
			try {
				
				boolean ficheroExiste=false;
				
				while (!ficheroExiste) {
					try {
						//esta orden puede lanzar FileNotFoundException si no existe el fichero
						 miArchivo = new FileReader(RUTA);
						 //si no se producen errores, salgo del bucle
						 ficheroExiste=true;
					} catch (FileNotFoundException e) {
						System.out.print("El fichero que has escrito en la ruta "+ RUTA+ "  No existe."
								+ " \n Por favor, escribe la ruta correcta>>>>");
						RUTA=teclado.nextLine();
					}
				}
				

				
				//esta orden puede lanzar IOException si ,por ejemplo no es un fichero de caracteres
				char unCar = (char) miArchivo.read();
				System.out.println("Primer carácter del archivo  :" + unCar);
			
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				try {
					miArchivo.close();
					teclado.close();
				}catch (Exception e) {
					System.out.println("Se ha producido este error: " +e.getMessage());
				}
			}
				
		
			
		

	}

}
