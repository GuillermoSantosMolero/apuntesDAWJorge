/**
 * @author Guillermo
 *
 */
public class Principal {

	public static void main(String[] args) {
		Persona p1 = new Persona();
		System.out.println("El nombre es: "+p1.getNombre());
		System.out.println("Edad de "+p1.getEdad()+" años");
		System.out.println("Altura de "+p1.getAltura()+" metros\n");
		
		Persona p2 = new Persona("Guillermo Santos",18,1.80f);
		System.out.println("El nombre es: "+p2.getNombre());
		System.out.println("Edad de "+p2.getEdad()+" años");
		System.out.println("Altura de "+p2.getAltura()+" metros\n");
		
		Persona p3 = new Persona("Aitana Santos",22,1.60f);
		System.out.println("El nombre es: "+p3.getNombre());
		System.out.println("Edad de "+p3.getEdad()+" años");
		System.out.println("Altura de "+p3.getAltura()+" metros\n");
	}

}
