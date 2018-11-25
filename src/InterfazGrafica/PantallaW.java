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

public class PantallaW extends Pantalla{
	private static PantallaW instancia;
	public static PantallaW getInstance() {
		instancia = instancia == null ? new PantallaW() : instancia;
		return instancia;
	}


	//private LevelDirector leverDirector;

	private PantallaW() {	
		inicializar();
	}

	protected void inicializar() {
		frame = new JFrame(GameData.NombreDelJuego);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(GameData.WindowSize);
		frame.setContentPane(new JLabel(IconsManager.fondoW));
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
