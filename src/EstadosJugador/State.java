package EstadosJugador;

import Entidades.Enemigo;
import Entidades.Player;

public abstract class State {
	protected Player p;
	public State(Player p) {
		this.p=p;
	}
	public void mover() {}
	public void proteger(Enemigo e) {}
	public void disparar() {}
}
