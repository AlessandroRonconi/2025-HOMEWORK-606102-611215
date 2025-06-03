package it.uniroma3.diadia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	private Partita partita;
	private Stanza stanza;
	private Labirinto labirinto;
	
	@BeforeEach
	void setUp() throws FileNotFoundException, FormatoFileNonValidoException{
		labirinto = Labirinto.newBuilder("labirinto2.txt").getLabirinto();
		this.partita = new Partita(labirinto);
		this.stanza = new Stanza("stanza");
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", partita.getLabirinto().getStanzaVincente().getNome());
	}

	@Test
	public void testSetStanzaCorrente() {
		partita.getLabirinto().setStanzaCorrente(stanza);
		assertEquals(stanza, partita.getLabirinto().getStanzaCorrente());
	}

	@Test
	public void testNonFinita() {
		assertFalse(partita.isFinita());
	}
	
	@Test
	public void testFinita() {
		this.partita.setCfu(0);
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testVinta() {
		this.partita.getLabirinto().setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.vinta());
	}
	
	@Test
	public void testPersa() {
		this.partita.setCfu(0);
		assertTrue(this.partita.isFinita());
	}
}