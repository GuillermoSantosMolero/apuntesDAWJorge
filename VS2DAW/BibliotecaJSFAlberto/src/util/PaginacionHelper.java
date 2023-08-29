package util;

public abstract class PaginacionHelper {
	
	private int nrpag;
	private int pagina;
	
	public PaginacionHelper(int registrosporpagina,int pag) {
		this.nrpag=registrosporpagina;
		this.pagina=pag;
	}
	// Método abstracto que cuenta los elementos a mostrar
	// será implementada cuando instanciemos un objeto PaginacionHelper
	
	public abstract long getItemsCount();
	
	public int getPrimerElementoPagina(){
		return(this.pagina*this.nrpag)+1;
	}
	
	public long getUltimoElementoPagina(){
		long i = getPrimerElementoPagina() + this.nrpag-1;
		long count=getItemsCount();
		if(i>count)
			i=count;
		if(i<1)
			i=1;
		return i;
	}
	
	public boolean isHayPaginaSiguiente() {
		return(((this.pagina+ 1) * this.nrpag) + 1) <= getItemsCount();
	}
	
	public boolean isHayPaginaAnterior() {
		return this.pagina > 0;
	}
	
	public void getPaginaSiguiente() {
		if(isHayPaginaSiguiente())
			this.pagina++;
	}
	
	public void getPaginaAnterior() {
		if(isHayPaginaAnterior())
			this.pagina--;
	}

	public int getNrpag() {
		return nrpag;
	}

	public void setNrpag(int nrpag) {
		this.nrpag = nrpag;
	}

	public int getPagina() {
		return pagina;
	}

	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
}