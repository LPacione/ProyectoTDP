package Colisionador;

import Entidades.BalazoPlayer;

public class CBarricada extends Colisionador {

	
	public void afectarDisparoPlayer(BalazoPlayer balazo) {
		balazo.eliminar();
	}
	
}
