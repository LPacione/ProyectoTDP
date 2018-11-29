package Entidades;


import Colisionador.CDisparoEnemigo;
import Colisionador.Colisionador;
import Datos.IconsManager;
import InterfazGrafica.Mostrador;
import Refactoring.IADisparoEnem;
import TiposDeDatos.CuerpoRigido;
import TiposDeDatos.Grafico;

public class BalazoEnemigo extends Balazo{
//Concrete Element - Visitable

	protected float velocidad = 5f;
	protected CDisparoEnemigo col;


	public BalazoEnemigo(int dano) {
		super(dano);
		ia = new IADisparoEnem();
		vida = 200;
		col = new CDisparoEnemigo(dano);
	}
	
	protected void iniciarGraficamente() {
		
		grafico = new Grafico(IconsManager.balazoEnemigo);
		
		mostrador = new Mostrador(grafico.getIcon());
	}

	public int getDano() {
		return dano;
	}
	
	public void setDano(int i) {
		dano=i;
	}
		
	public void aceptar(Colisionador c) {
		c.afectarDisparoEnemigo(this);
	}

	public void colisionasteCon(Entidad another) {
		another.aceptar(col);	
	}
	
	public String getName() {
		return "Bala enemigo";
	}

	public void actualizarEntidad() {
		mover();
	}


}
