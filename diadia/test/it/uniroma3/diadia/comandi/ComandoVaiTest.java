package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoVaiTest {
	private Partita partita;
	private Stanza stanza1;
	private Stanza stanza2;
	private IO io;
	private Comando comando;

	@BeforeEach
	void setUp() throws Exception{
		partita = new Partita();
		stanza1 = new Stanza("stanza1");
		stanza2 = new Stanza("stanza2");
		comando = new ComandoVai();
		io = new IOConsole();
	}
	
	@Test
	public void testParametroNull() {
		partita.getLabirinto().setStanzaCorrente(stanza1);
		comando.setParametro(null);
		comando.esegui(partita, io);
		assertTrue(partita.getLabirinto().getStanzaCorrente().equals(stanza1));
	}
	
	@Test
	public void testDirezioneInesistente() {
		partita.getLabirinto().setStanzaCorrente(stanza1);
		comando.setParametro("nord");
		comando.esegui(partita, io);
		assertTrue(partita.getLabirinto().getStanzaCorrente().equals(stanza1));
	}
	
	@Test
	public void testVaiAStanza2() {
		stanza1.impostaStanzaAdiacente("nord", stanza2);
		partita.getLabirinto().setStanzaCorrente(stanza1);
		comando.setParametro("nord");
		comando.esegui(partita, io);
		assertTrue(partita.getLabirinto().getStanzaCorrente().equals(stanza2));
	}
	
	@Test
	public void testPartitaConComandoVai(){
		String[] daLeggere = {"vai nord"};
		IOSimulator io = new IOSimulator(daLeggere);
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.getNextOutput());
		assertTrue(io.getNextOutput().contains("Biblioteca"));
		assertEquals("Hai vinto!", io.getNextOutput());
	}
}
