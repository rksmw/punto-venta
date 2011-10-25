package puntoventa.util;

import java.util.ArrayList;

public class MensajesError {
	private ArrayList<String> mensajes=new ArrayList<String>();
	private boolean errores;
	public ArrayList<String> getMensajes() {
		return mensajes;
	}
	public void setMensajes(ArrayList<String> mensajes) {
		this.mensajes = mensajes;
	}
	public boolean isErrores() {
		return errores;
	}
	public void setErrores(boolean errores) {
		this.errores = errores;
	}

}
