package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoVaiTest {
	private Partita partita;
	private Stanza stanza1;
	private Stanza stanza2;
	private IO io;
	private AbstractComando comando;

	@BeforeEach
	void setUp() throws Exception{
		partita = new Partita(Labirinto.newBuilder("labirinto3.txt").getLabirinto());
		stanza1 = new Stanza("stanza1");
		stanza2 = new Stanza("stanza2");
		comando = new ComandoVai();
		io = new IOConsole(new Scanner(System.in));
		comando.setIO(io);
	}
	
	@Test
	public void testParametroNull() {
		partita.getLabirinto().setStanzaCorrente(stanza1);
		comando.setParametro(null);
		comando.esegui(partita);
		assertTrue(partita.getLabirinto().getStanzaCorrente().equals(stanza1));
	}
	
	@Test
	public void testDirezioneInesistente() {
		partita.getLabirinto().setStanzaCorrente(stanza1);
		comando.setParametro("nord");
		comando.esegui(partita);
		assertTrue(partita.getLabirinto().getStanzaCorrente().equals(stanza1));
	}
	
	@Test
	public void testVaiAStanza2() {
		stanza1.impostaStanzaAdiacente(Direzione.nord, stanza2);
		partita.getLabirinto().setStanzaCorrente(stanza1);
		comando.setParametro("nord");
		comando.esegui(partita);
		assertTrue(partita.getLabirinto().getStanzaCorrente().equals(stanza2));
	}
	
	@Test
	public void testPartitaConComandoVai()throws Exception{
		List<String> daLeggere = new ArrayList<>();
		daLeggere.add("vai sud");
		IOSimulator io = new IOSimulator(daLeggere);
		Labirinto labirinto = Labirinto.newBuilder("labirinto1.txt").getLabirinto();
		DiaDia gioco = new DiaDia(labirinto,io);
		gioco.gioca();
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.getNextOutput());
		assertTrue(io.getNextOutput().contains("N11"));
		assertEquals("\n"+"Hai vinto!", io.getNextOutput());
	}
}
