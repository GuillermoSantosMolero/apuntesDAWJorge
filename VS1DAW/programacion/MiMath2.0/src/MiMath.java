/**
 * @author Guillermo Santos Molero
 *
 */
public class MiMath {	
	
	public String  esPar (int numero) {
		String resultado;
		int resto = numero%2;
		resultado=(resto==0)?"es par":"es impar";
		return resultado;
	}
	
	public void tablaMultiplicar (int numero) {
		for (int i=1;i<=10;i++) {
			System.out.println(numero +" x "+i +" = "+(numero*i));
		}
	}
	
	public int numDias (int mes, int año) {
		int dias=0;
		switch (mes) {
			case 1:
				dias = 31;
				break;
			case 2:
				int resto = año%4;
				if (resto==0) {
					dias = 29;
				}else {
					dias = 28;
				}
				break;
			case 3:
				dias = 31;
				break;
			case 4:
				dias=30;
				break;
			case 5:
				dias = 31;
				break;
			case 6:
				dias=30;
				break;
			case 7:
				dias = 31;
				break;
			case 8:
				dias = 31;
				break;
			case 9:
				dias=30;
				break;
			case 10:
				dias = 31;
				break;
			case 11:
				dias=30;
				break;
			case 12:
				dias = 31;
				break;
		}
	return dias;
	
	}
	public void factoresPrimos (int num) {
		int resto;
		System.out.print("Los factores primos del número "+num+" son ");
		for (int factor=1;factor<=num;factor++) { 
			resto=num%factor;
			if (resto==0) {
				System.out.print(factor+" ");
			}
		}
	}
	
	public void numerosPares ()throws ArrayIndexOutOfBoundsException {
		int numero =0;
		int[] numerosPares= new int[10];
		for (int i=1; i<=20;i++) {
			if(i%2==0) {
				numerosPares[numero]=i;
				numero++;
			}
		}
		System.out.print("Los números pares entre 1 y 20 son ");
		for (int par: numerosPares){
				System.out.print(par+" "
						+ "");
			}
			
	}
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
}
