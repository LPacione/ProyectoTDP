package Colisionador;

import Entidades.Balazo;
import Entidades.Enemigo;
import Entidades.EnemigoKami;
import Entidades.Obstaculo;
import Entidades.Player;

public class CEnemigoKami extends Colisionador {
//Visitor concrete

	private float damage;

	public CEnemigoKami(float damage) { 
		this.damage = damage;
	}

	public void afectarJugador(Player p) {
		p.setVida(p.getVida()-damage);
		System.out.println("Kami vs Player");
		/**
		 * Al colisionar al jugador se le descuenta de la vida que tenga la vida del enemigo
		 * dividido por el puntaje que tenga al morir.
		 */
	}
	public void afectarEnemigo(Enemigo e) {}
	public void afectarObstaculo(Obstaculo o) {}
	public void afectarEnemigoKami(EnemigoKami ek) {}
	public void afectarDisparo(Balazo balazo) {
		balazo.setVida(-2);
	}
}
