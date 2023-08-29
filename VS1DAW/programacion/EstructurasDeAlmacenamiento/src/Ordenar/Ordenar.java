package Ordenar;
/**
 * @author Guillermo Santos Molero
 *
 */
public class Ordenar {
	private int[] arrayNumerosAleatorios; 
	private int longitudArray;
	public Ordenar() {
		this.longitudArray=99;
		this.arrayNumerosAleatorios = new int[this.longitudArray];
		rellenarArray();
	}
	public void jugar() {
		System.out.println("Este es el array sin ordenar");
		verArray();
		System.out.println("Este es el mismo array ordenado");
		ordenarArray();
		verArray();
	}
	private int generarNumeroAleatorio() {
		int numeroRandom;
		numeroRandom = (int) (Math.random()*1000);
		return numeroRandom;
	}
	
	private void rellenarArray() {
		 int numero;
		for(int i=0;i<this.arrayNumerosAleatorios.length-1;i++) {
			numero=generarNumeroAleatorio();
			if(comprobarNumero(numero)==false) {
				--i;
			}else {
				this.arrayNumerosAleatorios[i]=numero;
			}
		}
	}
	private void verArray() {
		for(int i=0;i<this.arrayNumerosAleatorios.length-1;i++) {
			System.out.print(this.arrayNumerosAleatorios[i]+", ");
		}
		System.out.println();
	}
	private void ordenarArray() {
		int ayuda;
		for(int i=2;i<this.arrayNumerosAleatorios.length-1;i++) {
			for(int j=0;j<this.arrayNumerosAleatorios.length-i;j++) {
				if(this.arrayNumerosAleatorios[j]>=this.arrayNumerosAleatorios[j+1]) {
					ayuda=this.arrayNumerosAleatorios[j];
					this.arrayNumerosAleatorios[j]=this.arrayNumerosAleatorios[j+1];
					this.arrayNumerosAleatorios[j+1]=ayuda;
				}
			}
		}
	}
	private boolean comprobarNumero(int num) {
		boolean correcto=true;
		for(int i=0;i<this.arrayNumerosAleatorios.length-1;i++) {
			if (this.arrayNumerosAleatorios[i]==num) {
				correcto=false;
			}
		}
		return correcto;
	}

}