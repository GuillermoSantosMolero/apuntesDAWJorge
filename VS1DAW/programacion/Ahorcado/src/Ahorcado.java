/**
 * @author Guillermo Santos Molero
 *
 */
public class Ahorcado { //Inicio clase
	//Declaraci�n de variables
	String palabras []= {"perro","gato","almohada","sol","azul","rojo","verde","programacion","base","altura","serpiente","javali","natacion",
			"futbol","deporte","salvamento","pelota","teclado","raton", "monitor","altavoces","lampara","cascos","bol","vaso","encimera","alfombrilla",
			"mundo","tablero","cuaderno","soporte","telefono","ahorros","pantalon","camiseta","sudadera","cargador","pijama","botella","cubata","navidad",
			"resaca","recuerdo","silla","puerta","pies","manos","teclas","luna","armario"};
	char[] solucion;
	char[] arrayPalabra;
	int partMaq=0, partHum=0, vidas=6, juego=1;
	String letrasUsadas=" ";
	
	public Ahorcado () { //M�todo constructor
		
	}
	 
	//M�todo que eligira una palabra aleatoria del array de palabras
	public void elegirPalabra () {
		String pal;
		int numeroRandom, longitud;
		numeroRandom = (int) (Math.random() * 49) + 1;
		pal= palabras [numeroRandom];
		longitud=pal.length();
		this.arrayPalabra=new char[longitud];
		this.solucion=new char[longitud];
		//Este for rellenara el array solucion con el numero de guiones que ser� igual a la longitud de la palabra
		for (int i=0;i<longitud;i++) {
			this.arrayPalabra[i]=pal.charAt(i);
			this.solucion[i]='_';
		}
	}
	
	//M�todo que compara la letra entrante con las letras que componen la palabra elegida
	public void compararletra(char letra) {
		boolean coincide=false;
		for (int i=0;i<this.arrayPalabra.length;i++) {
			if (letra==this.arrayPalabra[i]){
				this.solucion[i]=letra;
				coincide=true;
			}
		}
		if(coincide==false) {
			this.vidas=vidas-1;
		}
	}

	//M�todo que compara el array que contiene la palabra elegida con el array que va rellenando el usuario
	public boolean compararArrays () {
		boolean coincide=true;
		for (int i=0;i<this.arrayPalabra.length;i++) {
			if ('_'==this.solucion[i]) {
				coincide=false;
			}
		}
		return coincide;
	}
	
	//M�todo que nos mostrar� el array solucion
	public void verSolucion() {
		for (char c:this.solucion) {
			System.out.print(c+" ");
		}
		System.out.println();
	}
	
	//M�todo que devolver� las partidas ganadas por la m�quina
	public int verPartMaq() {
		return partMaq;
	}

	//M�todo que sumar� una partida a la m�quina
	public void sumarPartMaq() {
		this.partMaq = partMaq+1;
	}

	//M�todo que devolver� las partidas ganadas por el humano
	public int verPartHum() {
		return partHum;
	}

	//M�todo que sumar� una partida al humano
	public void sumarPartHum() {
		this.partHum = partHum+1;
	}

	//M�todo que devolver� el n�mero de vidas
	public int verVidas() {
		return vidas;
	}
	
	//M�todo que reinicia las vidas a 6
	public void reiniciarVidas() {
		this.vidas=6;
	}

	//M�todo que almacena las letras usadas por el usuario
	public void meterEnLetrasUsadas (char letra) {
		this.letrasUsadas=letrasUsadas+letra+", ";
	}
	
	//M�todo que devuelve las letras usadas
	public String verLetrasUsadas() {
		return letrasUsadas;
	}
	
	//M�todo que sustituye el valor de letras usadas por un espacio en blanco
	public void reiniciarLetrasUsadas() {
		this.letrasUsadas=" ";
	}
	
	//M�todo que sumar� una partida
	public void incrementarJuego () {
		this.juego=juego+1;
	}
	
	//M�todo que nos devolver� la partida en la que estamos
	public int verJuego () {
		return juego;
	}
	}
	

	

