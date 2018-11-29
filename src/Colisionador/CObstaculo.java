package Colisionador;

import Entidades.BalazoEnemigo;
import Entidades.BalazoPlayer;
import Entidades.Enemigo;
import Entidades.EnemigoArmado;
import Entidades.EnemigoKami;
import Entidades.Obstaculo;
import Entidades.Player;
import Entidades.PowerUp.PowerUp;

public class CObstaculo extends Colisionador{

	public void afectarDisparoPlayer(BalazoPlayer balazo) {
		balazo.eliminar();
	}
	public void afectarEnemigoKami(EnemigoKami ek) {
		ek.eliminar();
	}
	public void afectarDisparoEnemigo(BalazoEnemigo b) {
		b.eliminar();
	}
	
	public void afectarJugador(Player p) {}
	public void afectarEnemigo(Enemigo e) {}
	public void afectarObstaculo(Obstaculo o) {}
	public void afectarEnemigoArmado(EnemigoArmado ea) {}
	public void afectarPowerUp(PowerUp p) {}
}
