package Colisionador;

import Entidades.*;

public abstract class Colisionador 
{
//Interface Visitor
	
	
	
	//Metodos abstractos vacios para que no molesten en las clases hijas
	public void afectarJugador(Player p) {}
	public void afectarEnemigo(Enemigo e) {}
	public void afectarObstaculo(Obstaculo o) {}
	public void afectarEnemigoKami(EnemigoKami ek) {}
	public void afectarEnemigoArmado(EnemigoArmado ea) {}
	public void afectarDisparoEnemigo(BalazoEnemigo b) {}
	public void afectarDisparoPlayer(BalazoPlayer b) {}
	public void afectarPowerUp(PowerUp p) {}
	public void afectarEnemigoKami2(EnemigoKami2 enemigoKami2) {}
	public void afectarEnemigoArmadoEspecial(EnemigoArmadoEspecial enemigoArmadoEspecial) {}
	public void afectarBarricada(Barricada bar) {}

	
}
