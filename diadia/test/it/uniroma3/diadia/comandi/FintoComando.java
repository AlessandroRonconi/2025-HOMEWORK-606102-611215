package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.Partita;

public class FintoComando extends AbstractComando{

	public final static String MESSAGGIO= "Grazie di aver giocato!";
	private String parametro;

	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
	}
	
	@Override
	public void setParametro(String parametro) {
		this.parametro=parametro;
	}
	
	@Override
	public String getParametro() {
		return this.parametro;
	}

}