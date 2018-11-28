package Colisionador;

import Entidades.Enemigo;
import Entidades.EnemigoArmado;
import Entidades.EnemigoKami;
import Entidades.Player;

public class CBombaTemporal extends Colisionador{

	private float damage;

	public CBombaTemporal() {
	}

	public void afectarJugador(Player p) {
		p.setVida(p.getVida()-damage);
	}
	
	public void afectarEnemigo(Enemigo e) {
		e.setVida(e.getVida()-damage);			
	}
	
	public void afectarEnemigoKami(EnemigoKami ek) {
		ek.setVida(ek.getVida()-damage);
	}
	
	public void afectarEnemigoArmado(EnemigoArmado ea) {
		ea.setVida(ea.getVida()-damage);
	}
}
