package Refactoring;

import Entidades.Entidad;

public class IADisparoPlayer extends IA{

	public void mover(Entidad e) {
		int x = (int) e.getGrafico().getPosicion().getX();
		int y = (int) e.getGrafico().getPosicion().getY();
		e.getGrafico().setPosicion(x,y-5);
	}

}
