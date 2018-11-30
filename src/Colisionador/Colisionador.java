package Colisionador;

import Entidades.Balazo;
import Entidades.BalazoEnemigo;
import Entidades.Barricada;
import Entidades.Enemigo;
import Entidades.EnemigoArmado;
import Entidades.EnemigoArmadoEspecial;
import Entidades.EnemigoKami;
import Entidades.EnemigoKami2;
import Entidades.Obstaculo;
import Entidades.Player;
import PowerUp.PowerUp;
public abstract class Colisionador 
{
//Interface Visitor
	
	//Metodos abstractos vacios para que no molesten en las clases hijas
	public void afectarJugador(Player p) {}
	public void afectarEnemigo(Enemigo e) {}
	public void afectarObstaculo(Obstaculo o) {}
	public void afectarEnemigoKami(EnemigoKami ek) {}
	public void afectarEnemigoArmado(EnemigoArmado ea) {}
	public void afectarDisparoEnemigo(Balazo b) {}
	public void afectarDisparoPlayer(Balazo b) {}
	public void afectarPowerUp(PowerUp p) {}
	public void afectarEnemigoKami2(EnemigoKami2 enemigoKami2) {}
	public void afectarEnemigoArmadoEspecial(EnemigoArmadoEspecial enemigoArmadoEspecial) {}
	public void afectarBarricada(Barricada bar) {}
	
}
