package juego;

import entorno.Entorno;

import java.awt.Color;
import java.util.Random;

import entorno.Herramientas;

public class Pelotita {
	private double x;
	private double y;
	private double angulo;
	private double velocidad;
	private double Rx=1;
	private double Ry=1;
	private double diametro;
	
	Pelotita(double x, double y,  double v, double a, double d){
		this.x=x;
		this.y=y;
		this.velocidad = v;
		this.angulo = a;
		this.diametro = d;
	}
	
	public double getRx() {
		return Rx;
	}

	public void setRx(double rx) {
		Rx = rx;
	}

	public double getRy() {
		return Ry;
	}

	public void setRy(double ry) {
		Ry = ry;
	}

	public double getDiametro() {
		return diametro;
	}

	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}
	
	public void mover(){
		if (this.velocidad>=0){
			this.x += Rx * (this.velocidad * Math.cos(this.angulo));
			this.y += Ry * (this.velocidad * Math.sin(this.angulo));
		}
		
			if (this.x <= 5){
				this.x=5;
				Rx=Rx*(-1);
		}
		
			if (this.x >= 790){
				this.x=790;
				Rx=Rx*(-1);
		}
		
			if (this.y <= 5){
				this.y = 5;
				Ry=Ry*(-1);
		}
		
			if (this.y >= 590){
				this.y = 590;
				Ry = Ry *(-1);
		}
			
		
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

	public void setAngulo(double angulo) {
		this.angulo = angulo;
	}
	

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad){
		this.velocidad = velocidad;
	}
	
	public void restarVelocidad(double a){
		this.velocidad = this.velocidad - a;
	}
	
	void dibujar(Entorno e){
		e.dibujarCirculo(x, y, diametro, Color.BLACK);
	}
}