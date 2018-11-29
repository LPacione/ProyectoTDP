package Entidades;

import java.util.Random;

import Colisionador.CEnemigo;
import Colisionador.Colisionador;
import Datos.IconsManager;
import InterfazGrafica.Mostrador;
import Level.Nivel;
import Refactoring.IAMareado;
import TiposDeDatos.Grafico;


public class Enemigo extends Entidad {
//Concrete Element
	
	protected float damage;

	public Enemigo() {
		super();
		ia = new IAMareado();
		valor = 10;
		damage = 50;
		vida = 100;
		col = new CEnemigo(damage);
	}

	protected void iniciarGraficamente() {
		
		grafico = new Grafico(IconsManager.enemigo);
		
		mostrador = new Mostrador(grafico.getIcon());
	}

	public void aceptar(Colisionador c) {
		c.afectarEnemigo(this);
	}

	public void colisionasteCon(Entidad another) {
		another.aceptar(col);
		
	}
	
	public String getName() {
		return "Dummy";
	}

	public void actualizarEntidad() {
		mover();
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
