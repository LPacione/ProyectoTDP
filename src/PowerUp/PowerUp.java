package PowerUp;

import Colisionador.CPowerUp;
import Colisionador.Colisionador;
import Entidades.Entidad;
import Entidades.Player;
import IA.IAMareado;
import IA.IANula;
import Level.Nivel;

public abstract class PowerUp extends Entidad{

	public abstract void activar();

	//Concrete Element

	protected float damage;
	protected Player p;
	private boolean cambieDeIA = false;

	public PowerUp() {
		super();
		ia = new IANula();
		vida=1;
		col = new CPowerUp(this);
		p = Nivel.getInstancia().getPlayer();
	}

	protected void mover() {
		ia.mover(this);
		if(getVida()<=50 && !cambieDeIA) {
			cambieDeIA = true;
			ia = new IAMareado();
		}
	}

	public void aceptar(Colisionador c) {
		c.afectarPowerUp(this);
	}

	public void colisionasteCon(Entidad another) {
		another.aceptar(col);
	}

	public String getName() {
		return "PowerUp";
	}

	public void actualizarEntidad() {
		mover();
	}

	public void resetearEntidad() {
		ia = new IANula();
	}
	
}
