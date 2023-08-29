/**
 * @author Guillermo Santos Molero
 *
 */
public class Fraccion implements InterfazFraccion{
	private int num, dem;
	public Fraccion(int num, int dem) {
		this.num=num;
		this.dem=dem;
		simplificar();
	}
	public int MinimoComunMultiplo(int dem1, int dem2) {
		int divisor=2,resultado=1;
		while (divisor<=dem1 || divisor<=dem2) {
			if(dem1%divisor==0) {
				dem1=dem1/divisor;
				resultado=resultado*divisor;
				if(dem2%divisor==0) {
					dem2=dem2/divisor;
				}
			}else {
				if(dem2%divisor==0) {
					dem2=dem2/divisor;
					resultado=resultado*divisor;
				}else {
					divisor++;
				}
			}
			
		}
		/*Otra forma de hacerlo
		 * public int mcm (int a, int b){
		 * 		int mcm = a>=b?a:b;
		 * 		while (mcm%a!=0 mcm%b!=0){
		 * 			++mcm;
		 * 		}
		 * 		return mcm;
		 * }*/
		return resultado;
	}
	
	public int MaximoComunDivisor() {
		int divisor;
		boolean semaforo=false;
		if (this.num>=this.dem) {
			divisor=this.dem;
		}else {
			divisor=this.num;
		}
		while(divisor>1 && semaforo==false) {
			if(this.num%divisor==0 && this.dem%divisor==0) {
				semaforo=true;
			}else {
				--divisor;
				semaforo=false;
			}
		}
		//System.out.println(divisor);
		return divisor;
	}
	
	public String sumar(int num2, int dem2) {
		int mcm=MinimoComunMultiplo(this.dem,dem2);
		this.num=this.num*(mcm/this.dem);
		num2=num2*(mcm/dem2);
		this.dem=mcm;
		return (this.num+num2)+"/"+mcm;
	}

	public String restar(int num2, int dem2) {
		int mcm=MinimoComunMultiplo(this.dem,dem2);
		this.num=this.num*(mcm/this.dem);
		num2=num2*(mcm/dem2);
		this.dem=mcm;
		return (this.num-num2)+"/"+mcm;
	}
	public void simplificar() {
		int comun=MaximoComunDivisor();
		this.num=this.num/comun;
		this.dem=this.dem/comun;
		//System.out.println(num+"/"+dem);
		
	}
	public int getNum() {
		return this.num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getDem() {
		return this.dem;
	}
	public void setDem(int dem) {
		this.dem = dem;
	}

	

}
