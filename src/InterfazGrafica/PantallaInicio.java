package InterfazGrafica;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.*;

import Datos.GameData;
import Datos.IconsManager;
import Level.AbsNivel;
import Level.LevelDirector;

public class PantallaInicio extends Pantalla {

	private static PantallaInicio instancia;
	public static PantallaInicio getInstance() {
		instancia = instancia == null ? new PantallaInicio() : instancia;
		return instancia;
	}

	
	private JButton play;

	public PantallaInicio() {
		run();
	}
	
	
	public void run() {
		inicializar();
	}
	
	public void inicializar() {
		frame = new JFrame(GameData.NombreDelJuego);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(GameData.WindowSize);
		frame.setContentPane(new JLabel(IconsManager.fondoInicio));
		container = frame.getContentPane();
		container.setLayout(null);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		playButton();
	}
	
	class OyenteBoton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			frame.removeAll();
			container.removeAll();
			frame.setVisible(false);
			container.setVisible(false);
		AbsNivel n= LevelDirector.instancia().currentLevel();
		n.setPantalla(PantallaJuego.getInstance());
		}
	}
	
	private void playButton() {
		play = new JButton();
		frame.add(play);
		play.setBounds(400, 300, 80, 25);
		play.setVisible(true);
		play.setText("PLAY");
		
	}
	
	public void addMostrable(Mostrador mostrable) {		
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


	public void borrarPantalla() {
		frame.removeAll();
		container.removeAll();
		frame.setVisible(false);
		container.setVisible(false);
	}

	
}
