package Colisionador;

import Entidades.BalazoPlayer;

public class CObstaculo extends Colisionador{

	public void afectarDisparoPlayer(BalazoPlayer balazo) {
		balazo.eliminar();
	}
	
}
