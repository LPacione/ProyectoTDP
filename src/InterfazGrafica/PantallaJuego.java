package InterfazGrafica;

import java.awt.Container;
import java.awt.event.KeyListener;
import Datos.*;
import Entrada.*;
import Level.LevelDirector;

import javax.swing.*;
import javax.swing.JLabel;

public class PantallaJuego extends Pantalla{
	
	private static PantallaJuego instancia;
	public static PantallaJuego getInstance() {
		instancia = instancia == null ? new PantallaJuego() : instancia;
		return instancia;
	}


	private JFrame frame;
	private Container container;

	private PantallaJuego() {	
		run();
	}

	protected void inicializar() {
		frame = new JFrame(GameData.NombreDelJuego);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(GameData.WindowSize);
		frame.setContentPane(new JLabel(IconsManager.fondo));
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

	public void run() {
		inicializar();
	}


}
