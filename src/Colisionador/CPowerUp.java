package Colisionador;

import Entidades.*;

public class CPowerUp extends Colisionador {
	
	public void afectarDisparoPlayer(BalazoPlayer b) {
		b.eliminar();
	}
	
}
