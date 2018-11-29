package Entidades.PowerUp;

import Colisionador.CPowerUpTemporal;
import Colisionador.Colisionador;
import Entidades.Entidad;
import Entidades.Player;
import IA.IANula;

public abstract class PowerUpTemporal extends Entidad{

	protected int vida;
	protected Player p;
	protected final int tempMax = 300;
	protected int contador;
	
	protected PowerUpTemporal() {
		super();	
		col = new CPowerUpTemporal();
		ia = new IANula();
		vida=1;
	}
	
	public abstract void activar();
	
	public void aceptar(Colisionador c) {
		c.afectarPowerUpTemporal(this);
	}

	public void colisionasteCon(Entidad another) {
		another.aceptar(col);
	}

	public abstract String getName();

}
