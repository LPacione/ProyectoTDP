package Entidades;

import Colisionador.CEnemigoKami;
import Colisionador.Colisionador;
import Datos.IconsManager;
import IA.IAMareado;
import InterfazGrafica.Mostrador;
import TiposDeDatos.Grafico;

public class EnemigoKami extends Enemigo{
//Visitable
	
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
	
	
	public void aceptar(Colisionador c) {
		c.afectarEnemigoKami(this);
	}
	
	public void colisionasteCon(Entidad another) {
		another.aceptar(col);		
	}
	
	public String getName() {
		return "Kami";
	}
	
	public void resetearEntidad() {
		ia = new IAMareado();
	}
	
}