package mimath;

/**
 * @author Guillermo Santos Molero
 *
 */
public class Areas {//Inicio de la clase
	//�rea del tri�ngulo
	float area_triangulo(float base,float altura) {
		return (base*altura)/2;
	}
	//�rea del rect�ngulo
	float area_rectangulo(float ladouno, float ladodos) {
		return (ladouno*ladodos);
	}
	//�rea del c�rculo
	float area_circulo(float radio) {
		final float PI = 3.141592f;
		return (PI*(radio*radio));
	}
}//Fin de la clase


