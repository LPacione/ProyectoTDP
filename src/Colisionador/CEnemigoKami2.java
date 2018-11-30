package Colisionador;

import Entidades.Balazo;
import Entidades.Obstaculo;
import Entidades.Player;

public class CEnemigoKami2 extends Colisionador {
//Visitor concrete

	private float damage;

	public CEnemigoKami2(float damage) { 
		this.damage = damage;
	}

	public void afectarJugador(Player p) {
		p.setVida(p.getVida()-damage);
	}
	
	public void afectarDisparoPlayer(Balazo balazo) {
		balazo.eliminar();
	}
	
	public void afectarBalazoEnemigo(Balazo b) {
		b.eliminar();
	}
	
	public void afectarObstaculo(Obstaculo o) {
		o.eliminar();
	}
}
