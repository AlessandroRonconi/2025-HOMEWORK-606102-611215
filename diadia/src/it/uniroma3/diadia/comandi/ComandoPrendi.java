package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	private String nomeAttrezzo; 
	@Override
	public void esegui(Partita partita, IO io) {
		
		if(nomeAttrezzo==null)
			io.mostraMessaggio("Quale attrezzo vuoi prendere?");
		Attrezzo nuovoAttrezzo = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(nuovoAttrezzo == null) {
			io.mostraMessaggio("Attrezzo inesistente");
			return;
		}
		partita.getGiocatore().getBorsa().addAttrezzo(nuovoAttrezzo);
		partita.getLabirinto().getStanzaCorrente().removeAttrezzo(nuovoAttrezzo);
		io.mostraMessaggio("Hai preso " + nomeAttrezzo);	
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

}
