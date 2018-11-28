package Colisionador;

import Entidades.*;/*
import Level.AbsNivel;
import Level.LevelDirector;
import TiposDeDatos.Coords;*/

public class CDisparoPlayer extends Colisionador {
//Visitor Concrete
	
	
	private float damage;
	//private PowerUp powerUp;
	
	public CDisparoPlayer(float damage) {
		this.damage = damage;
	}

	public void afectarJugador(Player p) {
		//El disparo player no afecta al jugador
	}
	public void afectarEnemigo(Enemigo e) {
		e.setVida(e.getVida()-damage);	
	}
	public void afectarEnemigoKami(EnemigoKami ek) {
		ek.setVida(ek.getVida()-damage);
	}
	public void afectarEnemigoArmado(EnemigoArmado ea) {
		ea.setVida(ea.getVida()-damage);
		ea.comprobarVida();
	}
	public void afectarObstaculo(Obstaculo o) {
		o.setVida(o.getVida()-damage);
	}

}
