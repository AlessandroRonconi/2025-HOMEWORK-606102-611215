package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

	private StanzaMagica magica;
	private Attrezzo pala;
	private Attrezzo martello;
	private Attrezzo vanga;
	private Attrezzo piuma;

	@Before
	public void setUp() throws Exception {
		magica = new StanzaMagica("s1");
		pala = new Attrezzo("pala", 33);
		martello = new Attrezzo("martello", 42);
		vanga = new Attrezzo("vanga", 42);
		piuma = new Attrezzo("piuma", 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddAttrezzo() {
		assertTrue(magica.addAttrezzo(martello));

	}


	@Test
	public void testModificaAttrezzo() {
		assertTrue(magica.addAttrezzo(pala));
		assertTrue(magica.addAttrezzo(vanga));
		assertTrue(magica.addAttrezzo(martello));
		assertTrue(magica.addAttrezzo(piuma));

		assertTrue(magica.hasAttrezzo("amuip"));
	}
}