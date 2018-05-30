package juego;

import java.awt.Color;

import entorno.Entorno;
import entorno.Herramientas;

public class Hoyo {
	
	private double x;
	private double y;
	private double diametro;
	
	public Hoyo(double x, double y,double diametro){
		this.x=x;
		this.diametro=diametro;
		this.y=y;
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
	
	boolean colisionHoyo(Pelotita pelota,Hoyo hoyo){
		boolean bandera = false;
		double x = Math.max(hoyo.getX(), pelota.getX());
		double xx = x-Math.min(hoyo.getX(), pelota.getX());
		double y = Math.max(hoyo.getY(), pelota.getY());
		double yy = y-Math.min(hoyo.getY(), pelota.getY());
		double distancia = Math.sqrt(xx * xx + yy * yy);
		if ((distancia - 15)<0){
			bandera = true;
		}
		return bandera;
	}	
	
	boolean cercaDeHoyo(Pelotita pelota,Hoyo hoyo){
		boolean bandera = false;
		double x = Math.max(hoyo.getX(), pelota.getX());
		double xx = x-Math.min(hoyo.getX(), pelota.getX());
		double y = Math.max(hoyo.getY(), pelota.getY());
		double yy = y-Math.min(hoyo.getY(), pelota.getY());
		double distancia = Math.sqrt(xx * xx + yy * yy);
		if ((distancia - 40)<0){
			bandera = true;
		}
		return bandera;
	}	
	

	void dibujar(Entorno e){
		e.dibujarCirculo(this.x, this.y, this.diametro, Color.BLACK);
	}
}
