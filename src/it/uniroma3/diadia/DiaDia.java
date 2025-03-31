package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "prendi", "posa", "aiuto", "fine"};

	private Partita partita;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca(IOConsole console) {
		String istruzione;

		console.mostraMessaggio(MESSAGGIO_BENVENUTO);	
		do		
			istruzione = console.leggiRiga();
		while (!processaIstruzione(istruzione, console));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione, IOConsole console) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if(comandoDaEseguire.getNome() == null)
			return false;
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(console); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro(),console);
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto(console);
		else if(comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro(),console);
		else if(comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro(),console);
		else
			console.mostraMessaggio("Comando sconosciuto");
		if(this.partita.isFinita()) {
			if (this.partita.vinta())
				console.mostraMessaggio("Hai vinto!");
			else
				console.mostraMessaggio("Hai perso!");
			return true;
		}
		return false;
	}   

	// implementazioni dei comandi dell'utente:

	private void prendi(String nomeAttrezzo, IOConsole console) {
		if(nomeAttrezzo==null)
			console.mostraMessaggio("Quale attrezzo vuoi prendere?");
		Attrezzo nuovoAttrezzo = null;
		nuovoAttrezzo = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(nuovoAttrezzo == null) {
			console.mostraMessaggio("Attrezzo inesistente");
			return;
		}
		this.partita.getGiocatore().getBorsa().addAttrezzo(nuovoAttrezzo);
		this.partita.getStanzaCorrente().removeAttrezzo(nuovoAttrezzo);
		console.mostraMessaggio("Hai preso " + nomeAttrezzo);
		console.mostraMessaggio(String.valueOf(partita));
	}
	
	private void posa(String nomeAttrezzo, IOConsole console) {
		if(nomeAttrezzo==null) {
			console.mostraMessaggio("Quale attrezzo vuoi posare?");
			return;
		}
		Attrezzo vecchioAttrezzo = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if(vecchioAttrezzo==null) {
			console.mostraMessaggio("Attrezzo inesistente");
			return;
		}
		this.partita.getStanzaCorrente().addAttrezzo(vecchioAttrezzo);
		this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		console.mostraMessaggio("Hai posato " + nomeAttrezzo);
		console.mostraMessaggio(String.valueOf(partita));
	}
	
	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto(IOConsole console) {
		for(int i=0; i< elencoComandi.length; i++) 
			console.mostraMessaggio(elencoComandi[i]+" ");
		console.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione, IOConsole console) {
		if(direzione==null)
			console.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			console.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCFU();
			this.partita.setCfu(cfu - 1);
		}
		console.mostraMessaggio(String.valueOf(partita));
	}

	/**
	 * Comando "Fine".
	 */
	private void fine(IOConsole console) {
		console.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}


	public static void main(String[] argc) {
		IOConsole console = new IOConsole();
		DiaDia gioco = new DiaDia();
		gioco.gioca(console);
	}
}// =^.^=