package resueltos.agendacontactos;

import java.util.ArrayList;

public class AgendaTelefonica {

	private ArrayList<Contacto> listaContactos;

	// constructor
	public AgendaTelefonica() {
		listaContactos = new ArrayList<>();
	}

	public boolean agregarContacto(Contacto c) {
		return this.listaContactos.add(c);
	}

	public boolean agregarContacto(Contacto c, int posicion) {
		boolean resultado; // variable que devolverá el resultado de la operación
		try {
			this.listaContactos.add(posicion, c);
			resultado = true;
		} catch (IndexOutOfBoundsException e) {
			resultado = false;
		}
		return resultado;
	}

	public void listarAgenda() {

		for (Contacto unidadDeContacto : this.listaContactos) {
			System.out.println("\n" + unidadDeContacto.toString());
		}

	}

	public String localizarContacto(String nombre, String apellidos) {
		String lupa = "telefono no encontrado";

		// recorro la lista hasta que encuentre el contacto que busco, o hasta el final
		for (Contacto registro : this.listaContactos) {

			if (registro.getApellidos().equalsIgnoreCase(apellidos) && registro.getNombre().equalsIgnoreCase(nombre)) {

				lupa = registro.getTelefono();
				break;
			}
		}

		return lupa;
	}

	public String localizarContacto(String telefono) {
		String lupa = "Persona no encontrada";

		// recorro la lista hasta que encuentre el contacto que busco, o hasta el final
		for (Contacto registro : this.listaContactos) {

			if (registro.getTelefono().equalsIgnoreCase(telefono)) {

				lupa = registro.getNombre() + " " + registro.getApellidos();
				break;
			}
		}

		return lupa;
	}

	public boolean eliminarContacto(String nombre, String apellidos) {

		boolean halt = false;

		try {
			for (int i = 0; i < this.listaContactos.size(); i++) {
				if (this.listaContactos.get(i).getNombre().equalsIgnoreCase(nombre)
						&& this.listaContactos.get(i).getApellidos().equalsIgnoreCase(apellidos)) {
					this.listaContactos.remove(i);
					halt = true;
					break;
				}
			}
		}

		catch (IndexOutOfBoundsException e) {
			halt = false;

		}

		return halt;

	}

}
