package Colisionador;

import Entidades.*;

public class CJugador extends Colisionador{
	
	
	public void afectarDisparo(Balazo balazo) {
		balazo.setVida(-2);
	}
	public void afectarEnemigoKami(EnemigoKami ek) {
		ek.setVida(-500);
	}
	public void afectarJugador(Player p) {}
	public void afectarEnemigo(Enemigo e) {}
	public void afectarObstaculo(Obstaculo o) {}
	public void afectarEnemigoArmado(EnemigoArmado ea) {}
}
