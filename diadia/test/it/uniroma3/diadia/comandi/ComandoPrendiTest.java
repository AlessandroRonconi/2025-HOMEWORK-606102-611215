package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {
	private Partita partita;
	private Attrezzo attrezzo;
	private Attrezzo attrezzoPesante;
	private IO io;
	private AbstractComando comando;

	@BeforeEach
	void setUp() throws Exception{
		partita = new Partita(Labirinto.newBuilder("labirinto2.txt").getLabirinto());
		attrezzo = new Attrezzo("martello", 2);
		attrezzoPesante = new Attrezzo("incudine", 15);
		comando = new ComandoPrendi();
		io = new IOConsole(new Scanner(System.in));
		comando.setIO(io);
	}


	@Test
	public void testAttrezzoPreso() {
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
		comando.setParametro("martello");
		comando.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("martello"));
	}

	@Test
	public void testAttrezzoDaPrendereNonPresente() {
		comando.setParametro("forbici");
		comando.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("forbici"));
	}
	
	@Test
	public void testAttrezzoTroppoPesante() {
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzoPesante);
		comando.setParametro("martello");
		comando.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("incudine"));
	}
	
	@Test
	public void testPartitaConComandoPrendi() throws Exception{
		List<String> daLeggere = new ArrayList<>();
		daLeggere.add("prendi osso");
		daLeggere.add("fine");
		IOSimulator io = new IOSimulator(daLeggere);
		Labirinto labirinto = Labirinto.newBuilder("labirinto1.txt").getLabirinto();
		DiaDia gioco = new DiaDia(labirinto,io);
		gioco.gioca();
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.getNextOutput());
		assertEquals("Hai preso osso", io.getNextOutput());
		assertEquals("Grazie di aver giocato!", io.getNextOutput());
	}
}
