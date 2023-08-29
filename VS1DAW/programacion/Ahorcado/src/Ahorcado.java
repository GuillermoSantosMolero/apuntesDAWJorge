/**
 * @author Guillermo Santos Molero
 *
 */
public class Ahorcado { //Inicio clase
	//Declaración de variables
	String palabras []= {"perro","gato","almohada","sol","azul","rojo","verde","programacion","base","altura","serpiente","javali","natacion",
			"futbol","deporte","salvamento","pelota","teclado","raton", "monitor","altavoces","lampara","cascos","bol","vaso","encimera","alfombrilla",
			"mundo","tablero","cuaderno","soporte","telefono","ahorros","pantalon","camiseta","sudadera","cargador","pijama","botella","cubata","navidad",
			"resaca","recuerdo","silla","puerta","pies","manos","teclas","luna","armario"};
	char[] solucion;
	char[] arrayPalabra;
	int partMaq=0, partHum=0, vidas=6, juego=1;
	String letrasUsadas=" ";
	
	public Ahorcado () { //Método constructor
		
	}
	 
	//Método que eligira una palabra aleatoria del array de palabras
	public void elegirPalabra () {
		String pal;
		int numeroRandom, longitud;
		numeroRandom = (int) (Math.random() * 49) + 1;
		pal= palabras [numeroRandom];
		longitud=pal.length();
		this.arrayPalabra=new char[longitud];
		this.solucion=new char[longitud];
		//Este for rellenara el array solucion con el numero de guiones que será igual a la longitud de la palabra
		for (int i=0;i<longitud;i++) {
			this.arrayPalabra[i]=pal.charAt(i);
			this.solucion[i]='_';
		}
	}
	
	//Método que compara la letra entrante con las letras que componen la palabra elegida
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

	//Método que compara el array que contiene la palabra elegida con el array que va rellenando el usuario
	public boolean compararArrays () {
		boolean coincide=true;
		for (int i=0;i<this.arrayPalabra.length;i++) {
			if ('_'==this.solucion[i]) {
				coincide=false;
			}
		}
		return coincide;
	}
	
	//Método que nos mostrará el array solucion
	public void verSolucion() {
		for (char c:this.solucion) {
			System.out.print(c+" ");
		}
		System.out.println();
	}
	
	//Método que devolverá las partidas ganadas por la máquina
	public int verPartMaq() {
		return partMaq;
	}

	//Método que sumará una partida a la máquina
	public void sumarPartMaq() {
		this.partMaq = partMaq+1;
	}

	//Método que devolverá las partidas ganadas por el humano
	public int verPartHum() {
		return partHum;
	}

	//Método que sumará una partida al humano
	public void sumarPartHum() {
		this.partHum = partHum+1;
	}

	//Método que devolverá el número de vidas
	public int verVidas() {
		return vidas;
	}
	
	//Método que reinicia las vidas a 6
	public void reiniciarVidas() {
		this.vidas=6;
	}

	//Método que almacena las letras usadas por el usuario
	public void meterEnLetrasUsadas (char letra) {
		this.letrasUsadas=letrasUsadas+letra+", ";
	}
	
	//Método que devuelve las letras usadas
	public String verLetrasUsadas() {
		return letrasUsadas;
	}
	
	//Método que sustituye el valor de letras usadas por un espacio en blanco
	public void reiniciarLetrasUsadas() {
		this.letrasUsadas=" ";
	}
	
	//Método que sumará una partida
	public void incrementarJuego () {
		this.juego=juego+1;
	}
	
	//Método que nos devolverá la partida en la que estamos
	public int verJuego () {
		return juego;
	}
	}
	

	

