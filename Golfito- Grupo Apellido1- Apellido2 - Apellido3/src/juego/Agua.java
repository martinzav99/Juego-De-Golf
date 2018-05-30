package juego;

import java.awt.Color;

import entorno.Entorno;
import entorno.Herramientas;

public class Agua {
	double x;
	double y;
	double diametro;
	
	Agua(double x, double y, double diametro){
		this.x=x;
		this.y=y;
		this.diametro=diametro;
	}
	
	public double getDiametro(){
		return this.diametro;
	}
	
	public void setDiametro(double diametro){
		this.diametro=diametro;
	}
	
	public double getX() {
		return this.x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return this.y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	boolean colisionAgua (Pelotita pelota) {
		return pelota.getX() > this.x - this.diametro / 2 && pelota.getX() < this.x + this.diametro / 2  
				&& pelota.getY() > this.y - this.diametro / 2 && pelota.getY() < this.y + this.diametro / 2;
	}
	
	void dibujar(Entorno e){
		e.dibujarCirculo(this.x, this.y, this.diametro, Color.BLACK);
	}
}
