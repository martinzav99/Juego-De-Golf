package juego;

import java.awt.Color;
import java.awt.Font;
import javax.sound.sampled.Clip;
import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	
	private Entorno entorno;

	//Variables y métodos propios de cada grupo
	
	
	
	private Pelotita pelotita;
	private Flecha flecha;
	private Linea linea;
	private Agua agua;
	private Agua agua2;
	private Arena arena;
	private Arena arena2;
	private Carga carga;
	private Hoyo hoyo;
	private int golpes;
	private int contador = 15;
	private boolean estadopelota=true;
	private boolean estadoflecha=true;
	private boolean menu=true;
	private boolean creditos=true;
	private boolean gana=true;
	private boolean banderabarra;
	private boolean banderacarga;
	private boolean estadogolpe=true;
	private boolean Finalizo;
	private boolean Empezo;
	private java.awt.Image hoyito;
	private java.awt.Image campo;
	private java.awt.Image bandera;
	private java.awt.Image water;
	private java.awt.Image water2;
	private java.awt.Image pelo;
	private java.awt.Image sand;
	private java.awt.Image sand2;
	private java.awt.Image fondomenu;
	private java.awt.Image credito;
	private java.awt.Image ganaimagen;
	private Clip musicagana;
	
	
	Juego()
	{
		// Inicializa el objeto entorno

		this.entorno = new Entorno(this, "Golfito - Grupo Zavalla - Peralta - Ayala - V0.01", 800, 600);
		
		
		// Inicializar lo que haga falta para el juego
		
		
		this.credito = Herramientas.cargarImagen("creditos.jpg");
		this.ganaimagen = Herramientas.cargarImagen("ganador.jpg");
		this.pelotita = new Pelotita(40,60,0,1.5,26);
		this.flecha = new Flecha(pelotita.getX()+1,pelotita.getY()+1,1.5);
		this.campo = Herramientas.cargarImagen("cesped.png");
		this.bandera = Herramientas.cargarImagen("bandera.png");
		this.agua = new Agua(170,110,150);
		this.agua2 = new Agua(710,450,150);
		this.arena = new Arena(180,470,165,115);
		this.arena2 = new Arena(480,240,165,115);
		this.hoyo = new Hoyo(700,170,27);
		this.carga = new Carga(5,110);
		this.linea = new Linea(35,200);
		this.pelo = Herramientas.cargarImagen("pelotita.png");
		this.hoyito = Herramientas.cargarImagen("hoyo.png");
		this.water = Herramientas.cargarImagen("agua.png");
		this.water2 = Herramientas.cargarImagen("agua.png");
		this.sand = Herramientas.cargarImagen("arena.png");
		this.sand2 = Herramientas.cargarImagen("arena.png");
		this.fondomenu = Herramientas.cargarImagen("menu.jpg");
		this.musicagana = Herramientas.cargarSonido("Marcianito.wav");
		
		// Inicia el juego!
		
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	
	public void tick()
	{
		// Procesamiento de un instante de tiempo
		
		
		
		
		this.entorno.dibujarImagenConCentro(this.campo, 0, 0, 0, 0, 0, 1.1);
		this.entorno.dibujarImagenConCentro(this.bandera, 670, 75, 0, 0, 0, 1);
		this.entorno.dibujarImagenConCentro(this.water, agua.getX()-127, agua.getY()-116, 0, 0, 0, 1);
		this.entorno.dibujarImagenConCentro(this.water2, agua2.getX()-127, agua2.getY()-116, 0, 0, 0, 1);
		this.entorno.dibujarImagen(this.hoyito, hoyo.getX()+12, hoyo.getY()-26, 0);
		this.entorno.dibujarImagenConCentro(this.sand, arena.getX()-190, arena.getY()-160, 0, 0, 0, 1);
		this.entorno.dibujarImagenConCentro(this.sand2, arena2.getX()-190, arena2.getY()-160, 0, 0, 0, 1);
		
		//Flecha Aparece o Desaparece
		
		if(estadoflecha){
			flecha.dibujar(this.entorno);
	        }
		
		
		if(this.pelotita.getVelocidad()>0){
			this.estadoflecha=false;
		}
		
		if(pelotita.getVelocidad()<=0){
			this.flecha.setX(this.pelotita.getX()+1);
			this.flecha.setY(this.pelotita.getY()+1);
			this.estadoflecha=true;
		}
		
		// Pelota Aparece o Desaparece
		
		if(!estadopelota){
			estadoflecha=false;
			pelotita.setVelocidad(0);
		}
		
		if (estadopelota){
			this.entorno.dibujarImagenConCentro(this.pelo, pelotita.getX()-19, pelotita.getY()-19, 0, 0, 0, 1);
		}
		
		//Emboca en el Hoyo
		
		if(hoyo.cercaDeHoyo(pelotita, hoyo)){
			if(pelotita.getVelocidad()>=0){
				pelotita.restarVelocidad(0.5);
			}
			if(this.pelotita.getVelocidad()<4){
				if(hoyo.colisionHoyo(pelotita,hoyo)){
					this.contador--;
					this.pelotita.setVelocidad(0);
					this.pelotita.setX(hoyo.getX());
					this.pelotita.setY(hoyo.getY());
					this.estadoflecha=false;
					if(this.gana){
						if(contador<0){
							this.entorno.dibujarImagenConCentro(this.ganaimagen, 0, 0, 0, 0, 0, 1);
							this.musicagana.start();
							estadogolpe=false;
							this.Finalizo=true;
							entorno.cambiarFont(Font.SANS_SERIF, 40, Color.WHITE);
							entorno.escribirTexto("Cantidad de Golpes : " + this.golpes, 360, 585);
						}
					}
				}
					
			}
		}
		
		//Texto
		
		if (estadogolpe){
			entorno.cambiarFont(Font.DIALOG_INPUT, 40, Color.BLACK);
			entorno.escribirTexto("Golpes: " + this.golpes, 550, 30);
		}
		
		//Colision con la Arena
		
		if(arena.colisionArena(pelotita)){
			if(pelotita.getVelocidad()>0){
				pelotita.restarVelocidad(1);
			}
		}
		
		if(arena2.colisionArena(pelotita)){
			if(pelotita.getVelocidad()>0){
				pelotita.restarVelocidad(1.2);
			}
		}
		
		//Colision con el Agua
		
		if (agua.colisionAgua(pelotita)){
			this.estadopelota=false;
			pelotita.setX(40);
			pelotita.setY(60);
			this.estadopelota=true;
			pelotita.setVelocidad(0);
			}
		
		if (agua2.colisionAgua(pelotita)){
			this.estadopelota=false;
			pelotita.setX(40);
			pelotita.setY(60);
			this.estadopelota=true;
			pelotita.setVelocidad(0);
			}
		

		//Mover Flecha y Apunta la pelota al mismo angulo que flecha.
		
		if (pelotita.getVelocidad()<=0){
			pelotita.setRx(1);
			pelotita.setRy(1);
		}
		
		if(entorno.estaPresionada(entorno.TECLA_DERECHA)){
			if (pelotita.getVelocidad()<=0){
				flecha.girar(0.05);
				pelotita.setAngulo((flecha.getAngulo()));
			}
			}

		if(entorno.estaPresionada(entorno.TECLA_IZQUIERDA)){
			if (pelotita.getVelocidad()<=0){
				flecha.girar(-0.05);
				pelotita.setAngulo((flecha.getAngulo()));
			
			}
		}
		
		//Tiro Con Barra Espaciadora
		
		if(linea.getY()==200){
			this.banderabarra=true;
		}else if(linea.getY()==30){
			this.banderabarra=false;
		}
		
		if(this.Finalizo==false && this.Empezo){
			if(entorno.estaPresionada(entorno.TECLA_ESPACIO) && pelotita.getVelocidad()<=0.0 && (linea.getY()<=200 && linea.getY()>=30) && banderabarra==true ){
				carga.dibujar(this.entorno);
				linea.dibujar(this.entorno);
				linea.restarY(2);
				this.banderacarga=true;
			}else if (entorno.estaPresionada(entorno.TECLA_ESPACIO) && pelotita.getVelocidad()<=0.0 && (linea.getY()<=200 && linea.getY()>=30) && banderabarra==false ){
				carga.dibujar(this.entorno);
				linea.dibujar(this.entorno);
				linea.sumarY(2);
				this.banderacarga=true;
		} 
		}
		
		if(!entorno.estaPresionada(entorno.TECLA_ESPACIO) && pelotita.getVelocidad()<=0.0 && this.banderacarga==true){
			if (linea.getY()<=200 && linea.getY()>134){
				if (pelotita.getVelocidad()<=0.0){
					pelotita.setVelocidad(5);
					this.golpes ++;
					this.banderacarga=false;
				}
			}else if(linea.getY()<=134 && linea.getY()>68){
				if (pelotita.getVelocidad()<=0.0){
					pelotita.setVelocidad(12);
					this.golpes ++;
					this.banderacarga=false;
				}
			}else if(linea.getY()<=68 && linea.getY()>=30){
				if (pelotita.getVelocidad()<=0.0){
					pelotita.setVelocidad(20);
					this.golpes ++;
					this.banderacarga=false;
				}
			}
		}
		
		//Reducir Velocidad
		
		if(pelotita.getVelocidad()>0.0){
			pelotita.restarVelocidad(0.1);
		}
		
		
		
		if(menu==true ){
			this.entorno.dibujarImagenConCentro(this.fondomenu,0,0,0,0,0,1);
			if(entorno.estaPresionada(entorno.TECLA_ENTER)){
				this.menu=false;
				this.Empezo=true;
			}
			if (entorno.estaPresionada(entorno.TECLA_DELETE)){
				System.exit(0);
			}
		}
		if(this.Finalizo==false && this.Empezo==false){
			if(creditos){
				if(entorno.estaPresionada(entorno.TECLA_INSERT)){
					this.entorno.dibujarImagenConCentro(this.credito, 0, 0, 0, 0, 0, 1);
			}
		}
		}
		
		//Mover Pelota
		
		pelotita.mover();

	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
