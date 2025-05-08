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

public class ComandoPosaTest {
	private Partita partita;
	private Attrezzo attrezzo;
	private IO io;
	private Comando comando;
	
	@BeforeEach
	void setUp() throws Exception{
		partita = new Partita();
		attrezzo = new Attrezzo("martello", 2);
		comando = new ComandoPosa();
		io = new IOConsole();
	}
	
	
	@Test
	public void testAttrezzoPosato() {
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro("martello");
		comando.esegui(partita,io);
		assertTrue(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("martello"));
	}

	@Test
	public void testAttrezzoDaPosareNonPresente() {
		comando.setParametro("martello");
		comando.esegui(partita,io);
		assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("martello"));
	}


	public void riempiStanza() {
		for(int i= 0; i<10;i++) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(new Attrezzo("attrezzo"+i, 1));
		}
	}
	
	@Test
	public void testStanzaPiena() {
		this.riempiStanza();
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro("martello");
		comando.esegui(partita,io);
		assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("martello"));
	}
	
	@Test
	public void testPartitaConComandoPosa(){
		String[] daLeggere = {"prendi osso", "posa osso", "fine"};
		IOSimulator io = new IOSimulator(daLeggere);
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.getNextOutput());
		assertEquals("Hai preso osso", io.getNextOutput());
		assertEquals("Hai posato osso", io.getNextOutput());
		assertEquals("Grazie di aver giocato!", io.getNextOutput());
	}

}
