package Entidades.PowerUp;

import Colisionador.CPowerUp;
import Colisionador.Colisionador;
import Entidades.Entidad;
import Entidades.Player;
import IA.IANula;

public abstract class PowerUp extends Entidad{

	protected int vida;
	protected Player p;
	protected final int tiempoMax = 300;
	protected int contador;
	
	protected PowerUp() {
		super();	
		col = new CPowerUp();
		ia = new IANula();
	}
	
	public abstract void activar();
		
	public void actualizar() {
		contador++;
		if (contador == tiempoMax) {
			this.eliminar();
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
}
