package Entidades;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Animation.Pictures;
import Colisionador.CObstaculo;
import Colisionador.Colisionador;
import Datos.IconsManager;
import IA.IANula;
import InterfazGrafica.Mostrador;
import TiposDeDatos.Grafico;

public class Obstaculo extends Entidad {

	
	public static Icon obs = new ImageIcon(Pictures.obstaculos);
	
	public Obstaculo() {
		super();
		ia = new IANula();
		vida = 50;
		col = new CObstaculo(); 
	}
	
	protected void iniciarGraficamente() {
		
		grafico = new Grafico(IconsManager.obstaculo);
		
		mostrador = new Mostrador(grafico.getIcon());
	}

	public void aceptar(Colisionador c) {
		c.afectarObstaculo(this);
	}

	public void colisionasteCon(Entidad another) {
		another.aceptar(col);		
	}
	
	public String getName() {
		return "Obstaculo";
	}

	public void actualizarEntidad() {}
	
}
