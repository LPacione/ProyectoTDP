package Refactoring;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Datos.GameData;
import Datos.IconsManager;

public class PantallaInicio extends Pantalla {
	
	
	private JButton play;

	public PantallaInicio(ControladorPantallas cp) {
		super(cp);
	}
	
	
	public void run() {
		refresh();
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
			cambiarPantalla(new PantallaJuego(cp));
		}
	}
	
	private void playButton() {
		play = new JButton();
		frame.add(play);
		play.setBounds(350, 300, 70, 70);
		play.setVisible(true);
		play.setIcon(IconsManager.play);
		play.addActionListener(new OyenteBoton());
	}

	public void refresh() {
		frame.repaint();
	}


}
