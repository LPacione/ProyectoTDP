package Entidades.PowerUp;

import Colisionador.CPowerUp;
import Colisionador.Colisionador;
import Entidades.Entidad;
import Entidades.Player;
import IA.IANula;

public abstract class PowerUp extends Entidad{

	protected int vida;
	protected Player p;
	
	protected PowerUp() {
		super();	
		col = new CPowerUp();
		ia = new IANula();
		vida=1;
	}
	
	public abstract void activar();
	
	public void aceptar(Colisionador c) {
		c.afectarPowerUp(this);
	}

	public void colisionasteCon(Entidad another) {
		another.aceptar(col);
	}

	public abstract String getName();
}
