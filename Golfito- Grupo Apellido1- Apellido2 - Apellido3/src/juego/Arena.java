package juego;

import java.awt.Color;



import entorno.Entorno;
import entorno.Herramientas;

public class Arena {
	private double x;
	private double y;
	private double ancho;
	private double alto;
	
	Arena(double x, double y,double ancho, double alto){
		this.x=x;
		this.y=y;
		this.alto=alto;
		this.ancho=ancho;
	}

	
	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}


	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}


	public double getAncho() {
		return ancho;
	}


	public void setAncho(double ancho) {
		this.ancho = ancho;
	}


	public double getAlto() {
		return alto;
	}


	public void setAlto(double alto) {
		this.alto = alto;
	}
	
	boolean colisionArena(Pelotita pelotita){
		return pelotita.getX() > (this.x - (this.ancho /2)) && pelotita.getX() < (this.x + (this.ancho /2)) && pelotita.getY() > (this.y - (this.alto/2)) && pelotita.getY() < (this.y + (this.alto /2));
	}

	
	void dibujar(Entorno e){
		e.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.BLACK);
	}
	
}
