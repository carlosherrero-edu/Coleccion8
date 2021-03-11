package resueltos.agendacontactos;

public class Contacto {

	private String nombre;
	private String apellidos;
	private String telefono;

	/**
	 * @param nombre
	 * @param apellidos
	 * @param telefono
	 */
	public static boolean validaNom(String texto) {
        return texto.matches("^[A-Z][\\w\\-&]{2,50}");
    }
    public static boolean validaAp(String texto) {
        return texto.matches("^[A-Z][\\w\\-&]{2,100}");
    }
    public static boolean validaTlfnoES(String texto) {
        return texto.matches("^[679][0-9]{8}");
    }
    public static boolean validaTlfnoEX(String texto) {
        return texto.matches("^\\+[0-9\\-]{,20}");
    }
    
    public Contacto(String nombre, String apellido, String telefono){
        
        if (validaNom(nombre)){
            this.nombre=nombre;
        } else {
        	throw new IllegalArgumentException("El nombre no es correcto.");
        }
        
        if (validaAp(apellido)) {
            this.apellidos=apellido;
        }else {
        	throw new IllegalArgumentException("El apellido no es correcto.");
        } 
        
        if (validaTlfnoES(telefono) ||validaTlfnoEX(telefono)  ) {
            this.telefono=telefono;
      
        } else {
        	throw new IllegalArgumentException("El teléfono no es correcto.");
        }
        
    
    }

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	@Override
	public String toString() {
		return "Contacto: [Nombre: " + getNombre() + "\t Apellidos: " + getApellidos() + "\t Telefono: " + getTelefono() + "]";
	}

}