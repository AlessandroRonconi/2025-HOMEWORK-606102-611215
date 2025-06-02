package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilderTest {
	private LabirintoBuilder labirintoBuilder;

	@Before
	public void setUp() throws Exception {
		labirintoBuilder = new LabirintoBuilder("labirinto1.txt");
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetLabirinto() {
		assertNotNull(labirintoBuilder.getLabirinto());
		assertEquals(Labirinto.class, labirintoBuilder.getLabirinto().getClass());
	}

	@Test
	public void testAddStanza() {
		labirintoBuilder.addStanza("stanzetta");
		Stanza expected = new Stanza("stanzetta");
		assertEquals(expected, labirintoBuilder.getNome2stanza().get("stanzetta"));
	}

	@Test
	public void testAddAttrezzoSenzaStanza(){
		assertEquals(LabirintoBuilder.class, labirintoBuilder.addAttrezzo("cacciavite", 3).getClass());
	}
	
	@Test
	public void testAddAttrezzoConStanza(){
		labirintoBuilder.addStanzaIniziale("stanzetta").addAttrezzo("cacciavite", 3);
		Attrezzo expected = new Attrezzo("cacciavite", 3);
		assertEquals(expected, labirintoBuilder.getLabirinto().getStanzaCorrente().getAttrezzo("cacciavite"));
		assertTrue(labirintoBuilder.getNome2stanza().get("stanzetta").hasAttrezzo("cacciavite"));
	}
}