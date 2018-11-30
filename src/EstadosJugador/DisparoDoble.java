package EstadosJugador;

import Entidades.Player;

public class DisparoDoble extends State{
	protected int disparos;
	public DisparoDoble(Player p) {
		super(p);
		disparos=100;
	}
	
	public void disparar() {
	p.crearDisparoDoble();
		if(disparos>0) {
			disparos--;
		}
		else {
			p.setEstado(new EstadoComun(p));
		}	
	}

}
