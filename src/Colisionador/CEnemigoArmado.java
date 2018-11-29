package Colisionador;

import Entidades.BalazoEnemigo;
import Entidades.BalazoPlayer;
import Entidades.Obstaculo;
import Entidades.Player;

public class CEnemigoArmado extends Colisionador{

	private float damage;

	public CEnemigoArmado(float damage) {
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
