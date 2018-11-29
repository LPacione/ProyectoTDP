package Colisionador;

import Entidades.BalazoEnemigo;
import Entidades.BalazoPlayer;
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
	
	public void afectarDisparoPlayer(BalazoPlayer balazo) {
		balazo.eliminar();
	}
	
	public void afectarBalazoEnemigo(BalazoEnemigo b) {
		b.eliminar();
	}
	
	public void afectarObstaculo(Obstaculo o) {
		o.eliminar();
	}
}