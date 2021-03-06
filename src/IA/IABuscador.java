package IA;

import Entidades.Entidad;
import Level.Nivel;

public class IABuscador extends IA{

	public void mover(Entidad e) {
		int x = (int) e.getGrafico().getPosicion().getX();
		int y = (int) e.getGrafico().getPosicion().getY();
		int xPlayer =(int) Nivel.getInstancia().getPlayer().getGrafico().getPosicion().getX();
		
		if (x < xPlayer) {
			x++;
		}
		else {
			if (x > xPlayer) {
				x--;
			}
		}
		y++;
		
		if(y>600) {
			y=0;
		}
		
		e.getGrafico().setPosicion(x, y);
	}

}
