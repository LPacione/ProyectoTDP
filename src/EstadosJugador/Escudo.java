package EstadosJugador;

import Entidades.Enemigo;
import Entidades.Player;

public class Escudo extends State{

	public Escudo(Player p) {
		super(p);
	}
	
	public void disparar() {
		p.disparar();
	}
	
	public void proteger(Enemigo e) {
		e.setVida(0);
		p.setEstado(new EstadoComun(p));
	}

}
