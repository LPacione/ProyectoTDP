package Colisionador;

import Entidades.Balazo;
import Entidades.Obstaculo;
import Entidades.Player;

public class CEnemigoArmadoEspecial extends Colisionador{

	private float damage;

	public CEnemigoArmadoEspecial(float damage) {
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
