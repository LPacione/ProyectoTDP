package Entidades;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Animation.Pictures;
import Colisionador.CBarricada;
import Colisionador.Colisionador;
import Datos.IconsManager;
import InterfazGrafica.Mostrador;
import Refactoring.IANula;
import TiposDeDatos.Grafico;

public class Barricada extends Entidad {
public static Icon bar = new ImageIcon(Pictures.barricada);
	
	public Barricada() {
		super();
		ia = new IANula();
		vida = 50;
		col = new CBarricada(); 
	}
	
	protected void iniciarGraficamente() {
		
		grafico = new Grafico(IconsManager.barricada);
		
		mostrador = new Mostrador(grafico.getIcon());
	}

	public void aceptar(Colisionador c) {
		c.afectarBarricada(this);
	}

	public void colisionasteCon(Entidad another) {
		another.aceptar(col);		
	}
	
	public String getName() {
		return "Barricada";
	}

	public void actualizarEntidad() {}
	
}
