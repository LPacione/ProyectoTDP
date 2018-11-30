package Colisionador;

import Entidades.Balazo;
import Entidades.Player;

public class CDisparoEnemigo extends Colisionador{

	private float damage;
	
	public CDisparoEnemigo(float damage) {
		this.damage = damage;
	}

	public void afectarJugador(Player p) {
		p.setVida(p.getVida()-damage);
	}
	
	public void afectarDisparoPlayer(Balazo b) {
		b.eliminar();
	}
	
}
