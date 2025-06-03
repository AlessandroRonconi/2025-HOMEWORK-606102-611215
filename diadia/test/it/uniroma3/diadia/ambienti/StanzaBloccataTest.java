package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {

	private StanzaBloccata stanza;
	private Stanza stanzaNord;
	private Attrezzo attrezzo;
	private Direzione direzioneBloccata = Direzione.nord;
	private String nomeAttrezzoSblocco = "piedediporco";

	@BeforeEach
	void setUp() throws Exception{
		stanza = new StanzaBloccata("Laboratorio", direzioneBloccata, nomeAttrezzoSblocco);
		stanzaNord = new Stanza("Stanza Nord");
		attrezzo = new Attrezzo(nomeAttrezzoSblocco, 5);
		stanza.impostaStanzaAdiacente(direzioneBloccata, stanzaNord);
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	void testSenzaAttrezzo() {
		assertTrue(stanza.equals(stanza.getStanzaAdiacente(direzioneBloccata)));
	}

	@Test
	void testConAttrezzo() {
		stanza.addAttrezzo(attrezzo);
		assertFalse(stanza.equals(stanza.getStanzaAdiacente(direzioneBloccata)));
	}

	@Test
	void testDirezioneBloccata() {
		assertTrue(stanza.getDescrizione().contains("bloccata"));
	}

	@Test
	void testDirezioneSbloccata() {
		stanza.addAttrezzo(new Attrezzo(nomeAttrezzoSblocco, 1));
		assertFalse(stanza.getDescrizione().contains("bloccata"));
	}

}
