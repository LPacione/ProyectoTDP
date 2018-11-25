package Level;

import Datos.GameData;
import Datos.IconsManager;
import Entidades.ElConocedor;
import Entidades.Enemigo;
import Entidades.EnemigoArmado;
import Entidades.EnemigoKami;
import Entidades.Entidad;
import Entidades.Obstaculo;
import Entrada.Discreta;
import InterfazGrafica.*;
import TiposDeDatos.Coords;

public class CrearNivel extends AbsNivel {

	private int cantEnems;
	private int cantEnemsK;
	private int cantObs;
	private int cantEnemsA;
	private int numeroNivel;

	public CrearNivel(int i) {
		if(i<=5) {
			numeroNivel=i;
			cantEnems = 3*i;
			cantEnemsK=3*i;
			cantObs = 2*i;
			cantEnemsA= 2*i;
			controlarVida();
		}	
		else {
			gane();
		}
	}

	public void crear() {
		int ancho = GameData.WindowSize.width;
		//ENEMIGOS 1
		int cantXNivel= cantEnems/3;
		int n=0;
		int nivelAltura=1;
		for(int i=1; i<=cantEnems ; i++) {
			Enemigo enem = new Enemigo(Enemigo.ic1);
			demasEntidades.add(enem);
			Coords c = new Coords(ancho*i/(cantEnems+1),100*nivelAltura);
			enem.getCuerpo().setPosicion(c);
			ElConocedor.instancia().add(enem);
			n++;
			if(n==cantXNivel) {
				n=0;
				nivelAltura++;
			}
		}
		//ENEMIGOS KAMI
		for(int i=1; i<=cantEnemsK;i++) {
			EnemigoKami enemK = new EnemigoKami(EnemigoKami.ic2);
			demasEntidades.add(enemK);
			Coords c = new Coords(ancho*i/(cantEnemsK+1),350);
			enemK.getCuerpo().setPosicion(c);
			ElConocedor.instancia().add(enemK);
		}
		//ENEMIGOS ARMADOS
		for(int i=1; i<=cantEnemsA; i++) {
			EnemigoArmado enemA= new EnemigoArmado(EnemigoArmado.armadoIcon);
			demasEntidades.add(enemA);
			Coords c= new Coords(ancho*i*2/(cantEnems+1),50);
			enemA.getCuerpo().setPosicion(c);
			ElConocedor.instancia().add(enemA);
		}
		//OBSTACULOS
		for(int i=1; i<=cantObs; i++) {
			Obstaculo obs = new Obstaculo(Obstaculo.obs);
			demasEntidades.add(obs);
			Coords c = new Coords(ancho*i/(cantObs+1),200);
			obs.getCuerpo().setPosicion(c);
		}

		player.getCuerpo().setPosicion(new Coords(400,500));	
		controlarVida();
	}

	public int getNumeroNivel() {
		return numeroNivel;
	}


	public void iniciar() {
	//	pantalla = PantallaInicio.getInstance();
	}
	public boolean limpiar() {
		return false;
	}

	public boolean gane() {
		boolean gane=false;
		if(numeroNivel==5 && demasEntidades.isEmpty()) {
			pantalla.borrarPantalla();
			pantalla= PantallaW.getInstance();
			gane=true;
		}
		return gane;
	}

	public boolean perdi() {
		boolean perdi=false;
		if(player.getVida()<=0) {
			pantalla.borrarPantalla();
			pantalla= PantallaL.getInstance();
			perdi=true;
		}
		return true;
	}

	

	protected void controlarVida() {
		if(player.getVida() >83.4) {
			vida.setIcon(IconsManager.v1);
			PantallaJuego.getInstance().addMostrable(vida);
		}
		else 
			if(player.getVida() > 66.8) {
				vida.setIcon(IconsManager.v2);
				PantallaJuego.getInstance().addMostrable(vida);
			}
			else 
				if(player.getVida() >50.2){
					vida.setIcon(IconsManager.v3);
					PantallaJuego.getInstance().addMostrable(vida);
				}
				else
					if(player.getVida() > 33.6){
						vida.setIcon(IconsManager.v4);
						PantallaJuego.getInstance().addMostrable(vida);
					}
					else
						if(player.getVida() > 17){
							vida.setIcon(IconsManager.v5);
							PantallaJuego.getInstance().addMostrable(vida);
						}
						else {
							vida.setIcon(IconsManager.v6);
							PantallaJuego.getInstance().addMostrable(vida);
						}
	}
	

	public void refrescarTodo() {
		controlarVida();
		gane();
		perdi();
		super.refrescarTodo();
	}


}
