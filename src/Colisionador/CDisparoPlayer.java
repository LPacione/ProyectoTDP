package Colisionador;

import Entidades.BalazoEnemigo;
import Entidades.Barricada;
import Entidades.Enemigo;
import Entidades.EnemigoArmado;
import Entidades.EnemigoArmadoEspecial;
import Entidades.EnemigoKami;
import Entidades.EnemigoKami2;
import Entidades.Obstaculo;
import PowerUp.PowerUp;

public class CDisparoPlayer extends Colisionador {
	
	
	private float damage;
	
	public CDisparoPlayer(float damage) {
		this.damage = damage;
	}

	public void afectarEnemigo(Enemigo e) {
		e.setVida(e.getVida()-damage);	
	}
	public void afectarEnemigoKami(EnemigoKami ek) {
		ek.setVida(ek.getVida()-damage);
	}
	public void afectarEnemigoKami2(EnemigoKami2 ek2) {
		ek2.setVida(ek2.getVida()-damage);
	}
	public void afectarEnemigoArmado(EnemigoArmado ea) {
		ea.setVida(ea.getVida()-damage);
	}
	public void afectarEnemigoArmadoEspecial(EnemigoArmadoEspecial eae) {
		eae.setVida(eae.getVida()-damage);
	}
	public void afectarObstaculo(Obstaculo o) {
		o.setVida(o.getVida()-damage);
	}
	public void afectarBarricada(Barricada bar) {
		bar.setVida(bar.getVida()-damage);
	}
	public void afectarPowerUp(PowerUp p) {
		p.activar();
		p.eliminar();
	}
	
	public void afectarBalazoEnemigo(BalazoEnemigo b) {
		b.eliminar();
	}
	
}
