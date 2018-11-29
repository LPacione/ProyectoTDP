package Entidades;

import Colisionador.CEnemigoKami;
import Colisionador.Colisionador;
import Datos.IconsManager;
import IA.IABuscador;
import InterfazGrafica.Mostrador;
import TiposDeDatos.Grafico;

public class EnemigoKami2 extends Enemigo{
//Visitable
	

	//private float velocidad = 2f;
	private boolean cambieDeIA = false;
	protected int dano;
	int i = 0;
	
	public EnemigoKami2() {
		super();
		ia = new IABuscador();
		valor=15;
		dano=50;
		vida = 200;
		col = new CEnemigoKami(dano);
	}
	
	protected void iniciarGraficamente() {
		
		grafico = new Grafico(IconsManager.enemigoKami2);
		
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
		c.afectarEnemigoKami2(this);
	}
	
	public void colisionasteCon(Entidad another) {
		if (another instanceof Player) 
			System.out.println("acaasd");
		another.aceptar(col);		
	}
	
	public String getName() {
		return "Kami2";
	}
}