package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;


class StanzaTest {
	private Stanza stanza;
	private Attrezzo spada;
	
	@BeforeEach
	void setUp() throws Exception {
		this.stanza = new Stanza("n11");
		this.spada = new Attrezzo("spada",10);
	}

	@Test
	void testHasAttrezzoStanzaVuota() {
		assertFalse(this.stanza.hasAttrezzo("spada"));
	}
	
	@Test
	void testHasAttrezzoStanzaVuota1() {
		assertFalse(this.stanza.hasAttrezzo("spada"));
		this.stanza.addAttrezzo(spada);
		assertTrue(this.stanza.hasAttrezzo("spada"));
	}
	
	@Test
	void testHasAttrezzoStanzaPiena() {
		this.stanza.addAttrezzo(spada);
		assertTrue(this.stanza.hasAttrezzo("spada"));
	}
	
	@Test
	void getAttrezzo1CheNonStaInStanza() {
		assertNull(this.stanza.getAttrezzo("spada"));
	}
	
	@Test
	void getAttrezzo2CheStaInStanza() {
		this.stanza.addAttrezzo(spada);
		assertTrue(this.stanza.getAttrezzo("spada")==spada);
	}
	
	@Test
	void getAttrezzo3CheStaInStanzaMaRitornaNull() {
		this.stanza.addAttrezzo(spada);
		assertFalse(this.stanza.getAttrezzo("spada")==null);
	}
	
	@Test
	void testRemoveAttrezzoStanzaVuota() {
		assertFalse(this.stanza.removeAttrezzo(spada));
	}
	
	@Test
	void testRemoveAttrezzoStanzaPiena() {
		this.stanza.addAttrezzo(spada);
		assertTrue(this.stanza.hasAttrezzo("spada"));
		this.stanza.removeAttrezzo(spada);
		assertFalse(this.stanza.hasAttrezzo("spada"));
	}

}
