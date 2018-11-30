package EstadosJugador;

import Entidades.Player;

public class EstadoSuperMisil extends State{
	protected int disparos;
	public EstadoSuperMisil(Player p) {
		super(p);
		disparos=100;
	}
	
	public void disparar() {
		p.disparoSuperMisil();
		if(disparos>0) {
			disparos--;
		}
		else {
			p.setEstado(new EstadoComun(p));
		}
		
	}

}
