package Colisionador;

import Entidades.BalazoPlayer;
import Entidades.Enemigo;
import Entidades.EnemigoArmado;
import Entidades.EnemigoKami;
import Entidades.Player;

public class CDisparoEnemigo extends Colisionador{

	private float damage;
	
	public CDisparoEnemigo(float damage) {
		this.damage = damage;
	}

	public void afectarJugador(Player p) {
		p.setVida(p.getVida()-damage);
	}
	
	public void afectarDisparoPlayer(BalazoPlayer b) {
		b.eliminar();
	}
	
	public void afectarEnemigo(Enemigo e) {
		e.setVida(e.getVida()-damage);
	}
	
	public void afectarEnemigoKami(EnemigoKami ek) {
		ek.setVida(ek.getVida()-damage);
	}
	
	

	
}
