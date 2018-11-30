package Colisionador;

import Entidades.Balazo;
import PowerUp.PowerUp;

public class CPowerUp extends Colisionador {
	private PowerUp p;
	public CPowerUp(PowerUp p) {
		this.p=p;
	}
	public void afectarDisparoPlayer(Balazo b) {
		b.eliminar();
	}
	
}
