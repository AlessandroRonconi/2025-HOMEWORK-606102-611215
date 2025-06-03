package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;

public class LabirintoTest {
	Labirinto labirinto;
	Stanza biblioteca;
	Stanza mensa;

	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		labirinto = Labirinto.newBuilder("labirinto2.txt").getLabirinto();

		biblioteca = new Stanza("Biblioteca");
		mensa = new Stanza("mensa");

	}


	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
	}


	@Test
	public void testSetStanzaCorrente() {
		labirinto.setStanzaCorrente(mensa);
		assertEquals(mensa, labirinto.getStanzaCorrente());
	}
	
	@Test
	public void testGetStanzaCorrente() {
		assertEquals("Atrio", labirinto.getStanzaCorrente().getNome());
	}

}
