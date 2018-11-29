package Refactoring;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Datos.GameData;
import Datos.IconsManager;
import Entidades.Entidad;
import Entidades.Player;
import Entrada.Teclado;
import InterfazGrafica.Mostrador;
import Level.Nivel;

public class PantallaJuego extends Pantalla{

	private Nivel nivel;
	protected Mostrador vida;
	int i;

	public PantallaJuego(ControladorPantallas cp) {	
		super(cp);
		
		nivel = Nivel.getInstancia();
		
		frame.addKeyListener(Teclado.getInstancia());
		
		i = 0;
		
		inicializarContainer();
	}

	
	public void run() {
		refrescarTodo();	
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
		vida= new Mostrador(IconsManager.v1);
		vida.setBounds((int)GameData.WindowSize.getWidth()-vida.getWidth(),(int) GameData.WindowSize.getHeight()-vida.getHeight(), vida.getWidth()-30,vida.getHeight()-30);		
		addMostrable(vida);
		
	}
	
	private void inicializarContainer() {
		for (Entidad e: nivel.getEntidades()) {
			addMostrable(e.getMostrable());
		}
	}
	
	private void refrescarTodo() {
		for (Entidad e: nivel.getEntidades()) {
			e.refresh();
		}
		
		checkColisiones();

		nivel.actualizarColeccion();
		
		controlarVida();
		
		Teclado.getInstancia().actualizarTeclado();
		
		checkNivel();
		
		actualizarContainer();
		
		frame.repaint();
		
	}
	
	private void actualizarContainer() {
		container.removeAll();
		for (Entidad e: nivel.getEntidades()) {
			addMostrable(e.getMostrable());
		}
		container.add(vida);
	}
	
	private void checkNivel() {
		if (nivel.getCantidadEntidades()==1) {
			nivel.subirNivel();
		}
		else {
			if (nivel.getPlayer().getVida()<=0) {
				cambiarPantalla(new PantallaPerder(cp));
			}
			else {
				if (nivel.getUltimoNivel()==nivel.getNumeroNivel()) {
					cambiarPantalla(new PantallaGanar(cp));
				}
			}
		}
	}
	
	protected void checkColisiones() {
		for(Entidad e : nivel.getEntidades()) {
			for(Entidad e1: nivel.getEntidades()) {
				if(e!=e1 && e.colisiona(e1)) {
					e.colisionasteCon(e1);
				}
			}
		}
	}

	protected void controlarVida() {
		Player p= Nivel.getInstancia().getPlayer();
		if(p.getVida() >83.4) {
			vida.setIcon(IconsManager.v1);
			addMostrable(vida);
		}
		else 
			if(p.getVida() > 66.8) {
				vida.setIcon(IconsManager.v2);
				addMostrable(vida);
			}
			else 
				if(p.getVida() >50.2){
					vida.setIcon(IconsManager.v3);
					addMostrable(vida);
				}
				else
					if(p.getVida() > 33.6){
						vida.setIcon(IconsManager.v4);
						addMostrable(vida);
					}
					else
						if(p.getVida() > 17){
							vida.setIcon(IconsManager.v5);
							addMostrable(vida);
						}
						else {
							vida.setIcon(IconsManager.v6);
							addMostrable(vida);
						}
	}
}
