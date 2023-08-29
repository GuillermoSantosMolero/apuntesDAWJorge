package mimath;

/**
 * @author Guillermo Santos Molero
 *
 */
public class Areas {//Inicio de la clase
	//Área del triángulo
	float area_triangulo(float base,float altura) {
		return (base*altura)/2;
	}
	//Área del rectángulo
	float area_rectangulo(float ladouno, float ladodos) {
		return (ladouno*ladodos);
	}
	//Área del círculo
	float area_circulo(float radio) {
		final float PI = 3.141592f;
		return (PI*(radio*radio));
	}
}//Fin de la clase


