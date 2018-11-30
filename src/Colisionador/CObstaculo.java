package Colisionador;

import Entidades.Balazo;
import Entidades.EnemigoKami;

public class CObstaculo extends Colisionador{

	public void afectarDisparoPlayer(Balazo balazo) {
		balazo.eliminar();
	}
	public void afectarEnemigoKami(EnemigoKami ek) {
		ek.eliminar();
	}
	public void afectarDisparoEnemigo(Balazo b) {
		b.eliminar();
	}
	
}
