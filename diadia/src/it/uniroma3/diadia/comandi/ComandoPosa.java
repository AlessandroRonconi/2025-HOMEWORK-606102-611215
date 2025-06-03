package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando {
	private String nomeAttrezzo;

	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo==null) {
			getIO().mostraMessaggio("Quale attrezzo vuoi posare?");
			return;
		}
		Attrezzo vecchioAttrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if(vecchioAttrezzo==null) {
			getIO().mostraMessaggio("Attrezzo inesistente");
			return;
		}
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(vecchioAttrezzo);
		partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		getIO().mostraMessaggio("Hai posato " + nomeAttrezzo);

	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

}
