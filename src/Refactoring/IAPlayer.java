package Refactoring;

import Datos.GameData;
import Entidades.Entidad;
import Entrada.Teclado;

public class IAPlayer extends IA{

	public void mover(Entidad e) {
		int x = (int) e.getGrafico().getPosicion().getX();
		if (Teclado.getInstancia().derecha() && x<GameData.WindowSize.getWidth()-e.getGrafico().getAncho()) {
			x=x+3;
		}
		else {
			if (Teclado.getInstancia().izquierda()  && x>=0) {
				x=x-3;
			}
		}
	
		e.getGrafico().setPosicion(x, e.getGrafico().getPosicion().getY());
	}

}
