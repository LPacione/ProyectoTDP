package InterfazGrafica;

import java.awt.Container;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import Datos.GameData;
import Datos.IconsManager;

public class PantallaInicio extends Pantalla {

	private static PantallaInicio instancia;
	public static PantallaInicio getInstance() {
		instancia = instancia == null ? new PantallaInicio() : instancia;
		return instancia;
	}

	private JFrame frame;
	private Container container;
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
		play.setBounds(350, 250, 80, 25);
		play.setVisible(true);
		play.setText("PLAY");
		play.addMouseListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent e) {
				 if (e.getButton() == MouseEvent.BUTTON1) {
					 play.setVisible(false);
					 play.setEnabled(false);
				 }
			 }
		});
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
	
	
	
}
