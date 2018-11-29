package Entidades;

import Colisionador.CPowerUp;
import Colisionador.Colisionador;
import Datos.IconsManager;
import InterfazGrafica.Mostrador;
import Refactoring.IANula;
import TiposDeDatos.CuerpoRigido;
import TiposDeDatos.Grafico;

public class SumaVida extends PowerUp{


	protected float velocidad = 1f;
	protected CPowerUp col;

	
	protected SumaVida()  {
		super();
	}
	

	protected void iniciarGraficamente() {
		
		grafico = new Grafico(IconsManager.sumaVida);
		
		mostrador = new Mostrador(grafico.getIcon());
	}
	public void activar() {
		// TODO Auto-generated method stub
		
	}
	
	public void actualizarEntidad() {
		mover();
	}
	

}
