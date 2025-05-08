package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	/**
	 * Stampa informazioni di aiuto.
	 */
	static final public String[] ELENCO_COMANDI = {"vai", "prendi", "posa", "guarda", "aiuto", "fine"};
	
	@Override
	public void esegui(Partita partita, IO io) {
		for(int i=0; i< ELENCO_COMANDI.length; i++) 
			io.mostraMessaggio(ELENCO_COMANDI[i]+" ");
		io.mostraMessaggio("");
	}

	@Override
	public void setParametro(String parametro) {}

}
