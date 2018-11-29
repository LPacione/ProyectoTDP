package Entidades;

import java.util.Random;

import Colisionador.CEnemigoArmado;
import Colisionador.Colisionador;
import Datos.IconsManager;
import IA.IAArmado;
import IA.IABuscador;
import InterfazGrafica.Mostrador;
import Level.Nivel;
import TiposDeDatos.Grafico;

public class EnemigoArmadoEspecial extends Enemigo{
//Visitable
	
	//private float velocidad = 2f;
	protected int danoBala;
	protected CEnemigoArmado col;
	private boolean cambieDeIA = false;

	
	public EnemigoArmadoEspecial() {
		super();
		ia= new IAArmado();
		valor=15;
		damage=1000;
		danoBala=10;
		vida = 200;
		col = new CEnemigoArmado(damage);
	}
	
	protected void iniciarGraficamente() {
		
		grafico = new Grafico(IconsManager.enemigoArmado);
		
		mostrador = new Mostrador(grafico.getIcon());
	}
	

	protected void mover() {
		ia.mover(this);
		if(getVida()<=50 && !cambieDeIA) {
			cambieDeIA = true;
			ia = new IABuscador();
		}
	}

	
	public void aceptar(Colisionador c) {
		c.afectarEnemigoArmadoEspecial(this);
	}

	protected void disparar() {
		Balazo b = new BalazoEnemigo(danoBala);
		int xBala =(int) grafico.getPosicion().getX();
		int yBala =(int) grafico.getPosicion().getY();
		b.getGrafico().setPosicion(xBala,yBala);
		Nivel n = Nivel.getInstancia();
		n.agregarEntidad(b);
	}
	
	public void actualizarEntidad() {
		mover();

		Random rnd = new Random();
		int numeroAleatorio = rnd.nextInt(100);
		if(numeroAleatorio==5 && !cambieDeIA) {
			disparar();
		}
	}
	
	public void colisionasteCon(Entidad another) {
		another.aceptar(col);	
	}
	
	public void setVida(int v) {
		vida=v;
	}
	
	public void setTiroTriple() {
		disparar();
		disparar();
		disparar();
	}
	
	public void eliminar() {
		Nivel.getInstancia().eliminarEntidad(this);
		dropearPowerUp();
	}
	
	public void setSuperMisil() {
		danoBala=50;
	}
	
	public String getName() {
		return "Armado";
	}
	
	protected void dropearPowerUp() {
		Nivel n= Nivel.getInstancia();
		PowerUp powerUp=null;
		int nro= new Random().nextInt(2)+1;
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

	

