package TiposDeDatos;

public class CajaDeColisiones {
	
	private Coords supizq;
	private Coords diagonal;
	
	public CajaDeColisiones(Coords diagonal) {
		this.diagonal = diagonal;
	}
	
	public void setSupIzq(Coords c){
		supizq = c;
	}
	
	public Coords infDer() {
		return supizq.sumar(diagonal);
	}
	
	public Coords supIzq() {
		return supizq;
	}
	
	public boolean checkInside(Coords point) {
		return infDer().abajo(point) && point.aLaIzquierda(infDer()) && supizq.aLaIzquierda(point) && point.abajo(supizq);
	}
	
	public boolean Solapa(CajaDeColisiones otra) {
		return supizq.sqrdistancia(otra.supizq) < diagonal.sqrdistancia(otra.diagonal)*2; // magic numb (pixeles hasta que desaparece)
	}
}
