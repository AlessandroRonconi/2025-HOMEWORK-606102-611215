package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;

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

	static final public String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa'!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";



	private Partita partita;
	private IO io;

	public DiaDia(Labirinto labirinto, IO console) {
		this.io = console;
		this.partita = new Partita(labirinto);
	}

	public void gioca() {
		String istruzione;

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);	
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione, io));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione, IO io) {
		FabbricaDiComandi factory = new FabbricaDiComandiRiflessiva();
		AbstractComando comandoDaEseguire = factory.costruisciComando(istruzione, io);
		comandoDaEseguire.esegui(this.partita);

		if (this.partita.vinta())
			io.mostraMessaggio("\n"+"Hai vinto!");
		if (!this.partita.giocatoreIsVivo())
			io.mostraMessaggio("\n"+"Hai esaurito i CFU...");

		return this.partita.isFinita();
	}

	public static void main(String[] argc) throws Exception{
//		try (Scanner scanner = new Scanner(System.in)) {     <---- versione senza livelli
//			IO io = new IOConsole(scanner);
//			Labirinto labirinto = Labirinto.newBuilder("labirinto1.txt").getLabirinto();
//			DiaDia gioco = new DiaDia(labirinto, io);
//			gioco.gioca();
//		}
		try (Scanner scanner = new Scanner(System.in)) {
			IO io = new IOConsole(scanner);
			int livello = 1;

			while (true) {
				String nomeFileLabirinto = "labirinto" + livello + ".txt";
				Labirinto labirinto;

				// Prova a caricare il labirinto per il livello corrente
				try {
					labirinto = Labirinto.newBuilder(nomeFileLabirinto).getLabirinto();
				} catch (Exception e) {
					io.mostraMessaggio("Complimenti! Hai completato tutti i livelli!");
					break;
				}

				io.mostraMessaggio("\n" + "Livello " + livello + "\n");
				DiaDia gioco = new DiaDia(labirinto, io);
				gioco.gioca();

				if (gioco.partita.vinta())
					livello++;
				else if(gioco.partita.giocatoreIsVivo() && gioco.partita.isFinita()) return;
				else livello = 1;
			}
		}
	}
}