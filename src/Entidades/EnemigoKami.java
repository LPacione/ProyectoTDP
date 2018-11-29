package Entidades;

import java.util.Random;

import Colisionador.CEnemigoKami;
import Colisionador.Colisionador;
import Datos.IconsManager;
import IA.IABuscador;
import InterfazGrafica.Mostrador;
import Level.Nivel;
import TiposDeDatos.Grafico;

public class EnemigoKami extends Enemigo{
//Visitable
	

	//private float velocidad = 2f;
	protected int dano;
	int i = 0;
	
	public EnemigoKami() {
		super();
		ia = new IABuscador();
		valor=15;
		dano=50;
		vida = 200;
		col = new CEnemigoKami(dano);
	}
	
	protected void iniciarGraficamente() {
		
		grafico = new Grafico(IconsManager.enemigoKami);
		
		mostrador = new Mostrador(grafico.getIcon());
	}
	
	
	public void aceptar(Colisionador c) {
		c.afectarEnemigoKami(this);
	}
	
	public void colisionasteCon(Entidad another) {
		another.aceptar(col);		
	}
	
	public String getName() {
		return "Kami";
	}
	
	protected void dropearPowerUp() {
		Nivel n= Nivel.getInstancia();
		PowerUp powerUp=null;
		int nro= new Random().nextInt(10)+1;
			if(nro==1)
				powerUp= new SuperMisil();
			if(nro==2)
				powerUp= new BombaTemporal();
			if(nro==3)
				powerUp= new TiroTriple();
			if(nro==4)
				powerUp= new DetenerTiempo();
			if(nro==5)
				powerUp=  new SumaVida();
			if(nro==6)
				powerUp= new CampoDeProteccion();
		if(powerUp!=null) {
			powerUp.cuerpo.setPosicion(cuerpo.getPosicion());
			n.agregarEntidad(powerUp);
		}
	}
}