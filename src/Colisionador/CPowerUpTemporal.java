package Colisionador;

import Entidades.BalazoPlayer;

public class CPowerUpTemporal extends Colisionador{

	public void afectarDisparoPlayer(BalazoPlayer b) {
		b.eliminar();
	}
	
}
