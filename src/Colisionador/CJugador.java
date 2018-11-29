package Colisionador;

import Entidades.BalazoEnemigo;
import Entidades.Enemigo;
import Entidades.EnemigoArmado;
import Entidades.EnemigoKami;

public class CJugador extends Colisionador{
	
	
	public void afectarDisparoEnemigo(BalazoEnemigo balazo) {
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
