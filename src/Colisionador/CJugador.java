package Colisionador;

import Entidades.*;

public class CJugador extends Colisionador{
	
	
	public void afectarDisparo(Balazo balazo) {
		balazo.setVida(-2);
		System.out.println("Balazo vs Player");
	}
	public void afectarEnemigoKami(EnemigoKami ek) {
		ek.setVida(-50);
		System.out.println("Kami vs Player");
	}
	public void afectarJugador(Player p) {}
	public void afectarEnemigo(Enemigo e) {
		e.setVida(-50);
		System.out.println("Dummy vs Player");
	}
	public void afectarObstaculo(Obstaculo o) {}
	public void afectarEnemigoArmado(EnemigoArmado ea) {
		ea.setVida(-50);
		System.out.println("Armado vs Player");
	}
}
