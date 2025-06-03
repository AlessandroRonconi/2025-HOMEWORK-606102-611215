package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;
/**
 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
 * e ne stampa il nome, altrimenti stampa un messaggio di errore
 */
public class ComandoVai extends AbstractComando {
	private Direzione direzione;

	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(direzione==null) {
			getIO().mostraMessaggio("Dove vuoi andare ?");
			return;
		}

		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if (prossimaStanza == null) {
			getIO().mostraMessaggio("Direzione inesistente");
			return;
		}
		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		getIO().mostraMessaggio(partita.toString());
		partita.getGiocatore().setCFU(partita.getGiocatore().getCFU()-1);
	}
	
	@Override
	public void setParametro(String parametro) {
		if(parametro!=null) this.direzione = Direzione.valueOf(parametro);
	}
}
