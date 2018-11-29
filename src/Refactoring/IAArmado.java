package Refactoring;

import Entidades.Entidad;

public class IAArmado extends IA{
	
	private boolean derecha = true;
	
	public void mover(Entidad e) {
		int x = (int) e.getGrafico().getPosicion().getX();
		
		if (derecha) {
			x++;
		}
		else {
			x--;
		}
		if (x==0) {
			derecha = true;
		}
		if (x==600) {
			derecha = false;
		}
		
		e.getGrafico().setPosicion(x, e.getGrafico().getPosicion().getY());
		
	}

}
