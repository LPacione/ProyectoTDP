package EstadosJugador;

import Entidades.Player;

public class EstadoComun extends State{

	public EstadoComun(Player p) {
		super(p);
	}

	public void disparar() {
		p.disparar();
	}
}
