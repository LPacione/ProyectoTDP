package Refactoring;

import java.awt.Container;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import InterfazGrafica.Mostrador;

public abstract class Pantalla{

	protected JFrame frame;
	protected Container container;
	protected ControladorPantallas cp;

	
	protected Pantalla(ControladorPantallas cp) {
		this.cp=cp;
		
		inicializar();
	}
	
	protected abstract void inicializar() ;

	public void addMostrable(Mostrador mostrable) {		
		container.add(mostrable);
	}

	public void removeMostrable(Mostrador mostrable) {
		container.remove(mostrable);
	}
	
	
	public void addTeclado(KeyListener kl) {
		frame.addKeyListener(kl);
	}
	
	public abstract void run();
	
	public void borrarPantalla() {
		frame.removeAll();
		container.removeAll();
		frame.setVisible(false);
		container.setVisible(false);
	}
	
	protected void cambiarPantalla(Pantalla p) {
		borrarPantalla();
		cp.set(p);
	}
	
}
