package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando{
	private static final String MESSAGGIO_CHI_SALUTARE =

			"Chi dovrei salutare?...";
	
	private String messaggio;

	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
		if (personaggio!=null) {
			this.messaggio = personaggio.saluta();
			getIO().mostraMessaggio(this.messaggio);

		} else getIO().mostraMessaggio(MESSAGGIO_CHI_SALUTARE);
	}

}
