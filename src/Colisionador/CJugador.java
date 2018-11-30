package Colisionador;

import Entidades.Balazo;
import Entidades.Enemigo;
import Entidades.EnemigoArmado;
import Entidades.EnemigoKami;

public class CJugador extends Colisionador{
	
	

	public void afectarDisparoEnemigo(Balazo balazo) {
		balazo.eliminar();
	}
	public void afectarEnemigoKami(EnemigoKami ek) {
		ek.eliminar();
	}
	public void afectarEnemigo(Enemigo e) {
		e.eliminar();
	}
	public void afectarEnemigoArmado(EnemigoArmado ea) {
		ea.eliminar();
	}
}
