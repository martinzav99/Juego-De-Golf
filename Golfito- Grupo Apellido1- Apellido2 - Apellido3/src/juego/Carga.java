package juego;

import entorno.Entorno;
import entorno.Herramientas;

public class Carga {
	private double x;
	private double y;
	
	Carga(double x, double y){
		this.x = x;
		this.y = y;
	}

	void dibujar(Entorno e){
		e.dibujarImagen(Herramientas.cargarImagen("carga.png"), this.x, this.y, 0);
	}
}
