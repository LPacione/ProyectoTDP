package InterfazGrafica;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyListener;

import Datos.*;
import Entrada.Discreta;
import Entrada.Teclado;
import Level.LevelDirector;

import javax.swing.*;
import javax.swing.JLabel;

public class PantallaL extends Pantalla{
	private static PantallaL instancia;
	public static PantallaL getInstance() {
		instancia = instancia == null ? new PantallaL() : instancia;
		return instancia;
	}


	private PantallaL() {	
		inicializar();
	}

	protected void inicializar() {
		frame = new JFrame(GameData.NombreDelJuego);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(GameData.WindowSize);
		frame.setContentPane(new JLabel(IconsManager.fondoL));
		container = frame.getContentPane();
		container.setLayout(null);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);		
	}

	public void addMostrable(Mostrador mostrable){
		container.add(mostrable);
	}
	
	public void removeMostrable(Mostrador mostrable) {
		container.remove(mostrable);
	}
	
	public void addTeclado(KeyListener kl) {
		frame.addKeyListener(kl);
	}

	public void refresh() {
		frame.repaint();	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}

	@Override
	public void borrarPantalla() {
		frame.removeAll();
		container.removeAll();
	}


}
