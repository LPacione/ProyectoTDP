package EstadosJugador;

import Entidades.Player;

public class DisparoTriple extends State{
	private int disparos;
	public DisparoTriple(Player p) {
		super(p);
		disparos=100;
	}
	
	public void disparar() {
		p.crearDisparoTriple();
		if(disparos>0) {
			disparos--;
		}
		else {
			p.setEstado(new EstadoComun(p));
		}
		
	}
}
