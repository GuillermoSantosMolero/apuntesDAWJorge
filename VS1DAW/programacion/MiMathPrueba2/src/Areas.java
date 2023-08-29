/**
 * @author Guillermo Santos Molero
 *
 */
public class Areas {
	final float PI=3.1356f;
	public Areas() {
		
	}
	float area_triangulo(float base,float altura) {
		return (base*altura/2);
	}
	float area_rectangulo(float ladouno, float ladodos) {
		return ladouno*ladodos;
	}
	float area_circulo(float radio) {
		return PI*(radio*radio);
	}
}

