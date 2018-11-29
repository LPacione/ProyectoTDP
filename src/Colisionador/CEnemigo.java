package Colisionador;

import Entidades.BalazoEnemigo;
import Entidades.BalazoPlayer;
import Entidades.Player;

public class CEnemigo extends Colisionador{
	
	private float damage;
	
	public CEnemigo(float dam) {
		damage = dam;
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
}
