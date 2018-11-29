package IA;

import java.util.Random;

import Entidades.Entidad;
import TiposDeDatos.Posicion;

public class IAMareado extends IA{

	private int movimiento;
	private int cont;
	private int cantPasos;
	private Random rnd = new Random();
	
	public IAMareado() {
		movimiento = rnd.nextInt(2)+1;
		cont = 0;
		cantPasos = rnd.nextInt(151);
	}
	
	public void mover(Entidad e) {
		Posicion pos = e.getGrafico().getPosicion();
		float y = pos.getY();
		float x = pos.getX();
		if (movimiento == 1) {
			y++;
			cont++;
		}
		else {
			if (movimiento == 2) {
				y--;
				cont++;
			}
			else {
				cont++;
			}
		}
		
		if (x == 0) {
			x = 600;
		}
		
		if (cont == cantPasos) {
			cambiarPos();
		}
		
		if(y<=0) {
			y++;
		}
		if(y>600) {
			y=0;
		}
		pos.setPos(x, y);
		e.getGrafico().setPosicion(pos.getX(), pos.getY());
	}
	
	private void cambiarPos() {
		cont = 0;
		movimiento = rnd.nextInt(2)+1;
		cantPasos = rnd.nextInt(151);
	}

}
