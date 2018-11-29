package Entidades;

import Colisionador.CPowerUp;
import Colisionador.Colisionador;
import IA.IANula;

public abstract class PowerUp extends Entidad{

	protected int vida;
	protected Player p;
	
	protected PowerUp() {
		super();	
		col = new CPowerUp();
		ia = new IANula();
	}
	
	public abstract void activar();
		
	public void aceptar(Colisionador c) {
		c.afectarPowerUp(this);
	}

	public void colisionasteCon(Entidad another) {
		another.aceptar(col);
	}

	public String getName() {
		return "PowerUp";
	}
}
