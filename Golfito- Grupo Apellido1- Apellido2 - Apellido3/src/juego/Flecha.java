package juego;

import java.awt.Color;

import entorno.Entorno;
import entorno.Herramientas;

public class Flecha {
	private double x;
	private double y;
	private double angulo;
	private double alto;
	private double ancho;
	
	Flecha(double x, double y, double angulo){
		this.x=x;
		this.y=y;
		this.angulo=angulo;
		this.alto = 10;
		this.ancho = 90;
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

	public double getAngulo() {
		return angulo;
	}
	
	public void setAngulo(double angulo){
		this.angulo = angulo;
	}

	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	void dibujar(Entorno e){
		e.dibujarImagen(Herramientas.cargarImagen("flecha.png"), this.x, this.y, this.angulo, 1);		
	}
		
	void girar(double modificador){
		this.angulo = this.angulo + modificador;
	}
}
