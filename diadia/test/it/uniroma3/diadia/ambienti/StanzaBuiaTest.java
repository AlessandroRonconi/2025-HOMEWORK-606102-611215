package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	private StanzaBuia stanza;
	private Attrezzo lanterna;

	@BeforeEach
	void setUp() throws Exception {
		this.stanza = new StanzaBuia("n11", "lanterna");
		this.lanterna = new Attrezzo("lanterna",3);
	}
	
	@Test
	void testBuioPesto() {
		assertFalse(this.stanza.hasAttrezzo("lanterna"));
		assertTrue(this.stanza.getDescrizione().equals("qui c'è un buio pesto"));
	}
	
	@Test
	void testIlluminata() {
		this.stanza.addAttrezzo(lanterna);
		assertTrue(this.stanza.hasAttrezzo("lanterna"));
		assertFalse(this.stanza.getDescrizione().equals("qui c'è un buio pesto"));
	}

}
