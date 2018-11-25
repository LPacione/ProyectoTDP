package InterfazGrafica;

import java.awt.Container;
import java.awt.event.KeyListener;


import javax.swing.JFrame;
import javax.swing.JLabel;

import Datos.GameData;
import Datos.IconsManager;

public abstract class Pantalla implements Runnable{
	
	protected JFrame frame;
	protected Container container;

	protected abstract void inicializar() ;

	public  abstract void addMostrable(Mostrador mostrable);
	
	public abstract void removeMostrable(Mostrador mostrable) ;
	
	public abstract void addTeclado(KeyListener kl);

	public abstract void refresh();
	
	public abstract void run();
	
	public abstract void borrarPantalla();
	
}
