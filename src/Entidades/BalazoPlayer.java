package Entidades;


import Colisionador.CDisparoPlayer;
import Colisionador.Colisionador;
import Datos.IconsManager;
import InterfazGrafica.Mostrador;
import Refactoring.IADisparoPlayer;
import TiposDeDatos.Grafico;

public class BalazoPlayer extends Balazo{
//Concrete Element - Visitable


	protected float velocidad = 5f;
	protected CDisparoPlayer col;

	
	public BalazoPlayer(int dano) {
		super(dano);
		ia = new IADisparoPlayer();
		vida = 200;
		col = new CDisparoPlayer(dano);
	}
	
	protected void iniciarGraficamente() {
		
		grafico = new Grafico(IconsManager.balazo);
		
		mostrador = new Mostrador(grafico.getIcon());
	}
	public int getDano() {
		return dano;
	}
		
	public void aceptar(Colisionador c) {
		c.afectarDisparoPlayer(this);
	}

	public void colisionasteCon(Entidad another) {
		another.aceptar(col);	
	}
	
	public String getName() {
		return "Bala player";
	}

	public void actualizarEntidad() {
		mover();
	}

}
