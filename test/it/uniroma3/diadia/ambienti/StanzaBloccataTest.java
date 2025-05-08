package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {

	private StanzaBloccata stanza;
	private Stanza stanzaNord;
	private String direzioneBloccata = "nord";
	private String nomeAttrezzoSblocco = "piedediporco";

	@BeforeEach
	void setUp() throws Exception{
		stanza = new StanzaBloccata("Laboratorio", direzioneBloccata, nomeAttrezzoSblocco);
		stanzaNord = new Stanza("Stanza Nord");
		stanza.impostaStanzaAdiacente(direzioneBloccata, stanzaNord);
	}

	@Test
	void testSenzaAttrezzo() {
		Stanza adiacente = stanza.getStanzaAdiacente(direzioneBloccata);
		assertTrue(stanza.equals(adiacente));
	}

	@Test
	void testConAttrezzo() {
		stanza.addAttrezzo(new Attrezzo(nomeAttrezzoSblocco, 5));
		Stanza adiacente = stanza.getStanzaAdiacente(direzioneBloccata);
		assertFalse(stanza.equals(adiacente));
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
