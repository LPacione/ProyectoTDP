package Entidades;

import Colisionador.CEnemigoKami;
import Colisionador.Colisionador;
import Datos.IconsManager;
import InterfazGrafica.Mostrador;
import Refactoring.IABuscador;
import Refactoring.IAMareado;
import TiposDeDatos.CuerpoRigido;
import TiposDeDatos.Grafico;

public class EnemigoKami extends Enemigo{
//Visitable
	

	private float velocidad = 2f;
	private boolean cambieDeIA = false;
	protected int dano;
	int i = 0;
	
	public EnemigoKami() {
		super();
		ia = new IAMareado();
		valor=15;
		dano=50;
		vida = 200;
		col = new CEnemigoKami(dano);
	}
	
	protected void iniciarGraficamente() {
		
		grafico = new Grafico(IconsManager.enemigoKami);
		
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
		c.afectarEnemigoKami(this);
	}
	
	public void colisionasteCon(Entidad another) {
		if (another instanceof Player) 
			System.out.println("acaasd");
		another.aceptar(col);		
	}
	
	public String getName() {
		return "Kami";
	}
}