package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	private String nomeAttrezzo;

	@Override
	public void esegui(Partita partita, IO io) {
		if(nomeAttrezzo==null) {
			io.mostraMessaggio("Quale attrezzo vuoi posare?");
			return;
		}
		Attrezzo vecchioAttrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if(vecchioAttrezzo==null) {
			io.mostraMessaggio("Attrezzo inesistente");
			return;
		}
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(vecchioAttrezzo);
		partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		io.mostraMessaggio("Hai posato " + nomeAttrezzo);

	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

}
