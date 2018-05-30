package juego;

import entorno.Entorno;
import entorno.Herramientas;

public class Linea {
	private double x;
	private double y;
	
	Linea(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	void restarY(double y){
		this.y = this.y - y;
	}
	
	void sumarY(double y){
		this.y = this.y + y;
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

	void dibujar(Entorno e){
		e.dibujarImagen(Herramientas.cargarImagen("linea.png"), this.x, this.y, 0);
	}
}
