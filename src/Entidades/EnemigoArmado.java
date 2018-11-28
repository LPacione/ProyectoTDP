package Entidades;

import java.util.Random;


import javax.swing.Icon;
import javax.swing.ImageIcon;

import Animation.Pictures;
import Colisionador.CEnemigoArmado;
import Colisionador.CEnemigoKami;
import Colisionador.Colisionador;
import Datos.GameData;
import Datos.IconsManager;
import Entrada.Discreta;
import IA.ArmadoIA;
import IA.DummyIA;
import IA.FollowIA;
import IA.KamiIA2;
import Level.AbsNivel;
import Level.LevelDirector;
import TiposDeDatos.Coords;
import Entidades.PowerUp;

public class EnemigoArmado extends Enemigo{
//Visitable

public static Icon armadoIcon = new ImageIcon(Pictures.naveArmada);
	
	private float velocidad = 2f;
	private boolean cambieDeIA = false;
	protected int dano;
	protected int danoBala;
	protected CEnemigoArmado col;

	
	public EnemigoArmado(Icon icon) {
		super(icon);
		ia= new ArmadoIA();
		valor=15;
		dano=1000;
		danoBala=10;
		vida = 200;
		col = new CEnemigoArmado(dano);
	}

	
	public void onRefresh() {
		cuerpo.mover(ia.ADondeVoy(this).multK(velocidad)); 
		if(getVida()<=50 && !cambieDeIA) {
			cambieDeIA = true;
			ia = new FollowIA();
		}
	}
	
	public int getDano() {
		return dano;
	}
	
	public void aceptar(Colisionador c) {
		c.afectarEnemigoArmado(this);
	}

	public void disparar() {
		Balazo b = new BalazoEnemigo(IconsManager.balazoEnemigo,danoBala);
		b.cuerpo.setPosicion(cuerpo.getPosicion().sumar(new Coords(armadoIcon.getIconWidth()/2- b.getMostrable().getIcon().getIconWidth()/2,40)));
		AbsNivel n = LevelDirector.instancia().currentLevel();
		n.addEntity(b);
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
	
	public void setSuperMisil() {
		danoBala=50;
	}
	
	public String getName() {
		return "Armado";
	}
	
	public void comprobarVida() {
		if(vida<=0) {
			AbsNivel n= LevelDirector.instancia().currentLevel();
			PowerUp powerUp=null;
			int nro= new Random().nextInt(2)+1;
				if(nro==1)
					powerUp= new SuperMisil(IconsManager.superMisil);
				if(nro==2)
					powerUp= new BombaTemporal(IconsManager.bombaTemporal);
				if(nro==3)
					powerUp= new TiroTriple(IconsManager.tiroTriple);
				if(nro==4)
					powerUp= new DetenerTiempo(IconsManager.detenerTiempo);
				if(nro==5)
					powerUp=  new SumaVida(IconsManager.sumaVida);
				if(nro==6)
					powerUp= new CampoDeProteccion(IconsManager.campoDeProteccion);
			if(powerUp!=null) {
				powerUp.cuerpo.setPosicion(cuerpo.getPosicion());
				n.addEntity(powerUp);
				
			}
		}
	}

}

	

