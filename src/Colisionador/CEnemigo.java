package Colisionador;

import Entidades.Balazo;
import Entidades.BalazoEnemigo;
import Entidades.Enemigo;
import Entidades.Player;

public class CEnemigo extends Colisionador{
	
	private float damage;
	private Enemigo e;
	
	public CEnemigo(float dam, Enemigo e) {
		damage = dam;
		this.e=e;
	}
	
	public void afectarJugador(Player p) {
		if(p.getEstado().toString() == "CampoDeProteccion") {
			p.getEstado().proteger(e);
		}else {
			p.setVida(p.getVida()-damage);
		}
		
	}
	
	public void afectarDisparoPlayer(Balazo balazo) {
		balazo.eliminar();
	}
	
	public void afectarBalazoEnemigo(BalazoEnemigo b) {
		b.eliminar();
	}
}
