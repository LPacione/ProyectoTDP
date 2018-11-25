package InterfazGrafica;

import java.awt.Container;
import java.awt.event.KeyListener;
import javax.swing.*;

import Datos.GameData;
import Datos.IconsManager;

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
	
	protected void inicializar() {
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
	
	private void playButton() {
		play = new JButton();
		frame.add(play);
		play.setBounds(200, 200, 80, 25);
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
	}

	
}
