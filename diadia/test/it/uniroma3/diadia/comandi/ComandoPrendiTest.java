package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {
	private Partita partita;
	private Attrezzo attrezzo;
	private Attrezzo attrezzoPesante;
	private IO io;
	private Comando comando;

	@BeforeEach
	void setUp() throws Exception{
		partita = new Partita();
		attrezzo = new Attrezzo("martello", 2);
		attrezzoPesante = new Attrezzo("incudine", 15);
		comando = new ComandoPrendi();
		io = new IOConsole();
	}


	@Test
	public void testAttrezzoPreso() {
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
		comando.setParametro("martello");
		comando.esegui(partita,io);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("martello"));
	}

	@Test
	public void testAttrezzoDaPrendereNonPresente() {
		comando.setParametro("martello");
		comando.esegui(partita,io);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("martello"));
	}


	public void riempiBorsa() {
		for(int i= 0; i<10;i++) {
			partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("attrezzo"+i, 1));
		}
	}

	@Test
	public void testBorsaPiena() {
		this.riempiBorsa();
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
		comando.setParametro("martello");
		comando.esegui(partita,io);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("martello"));
	}
	
	@Test
	public void testAttrezzoTroppoPesante() {
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzoPesante);
		comando.setParametro("martello");
		comando.esegui(partita,io);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("incudine"));
	}
	
	@Test
	public void testPartitaConComandoPrendi(){
		String[] daLeggere = {"prendi osso", "fine"};
		IOSimulator io = new IOSimulator(daLeggere);
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.getNextOutput());
		assertEquals("Hai preso osso", io.getNextOutput());
		assertEquals("Grazie di aver giocato!", io.getNextOutput());
	}
}
