package it.uniroma3.diadia;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.StringReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class CaricatoreLabirintoTest {

	private final String monolocale = 
			"Stanze:biblioteca\n"+
			"Magica:\n"+
			"Buia:\n"+
			"Bloccata:\n"+
			"Inizio:biblioteca\n"+
			"Vincente:biblioteca\n"+
			"Mago:\n"+
			"Cane:\n"+
			"Strega:\n"+
			"Attrezzi:\n"+
			"Uscite:\n";

	private final String bilocale = 
			"Stanze:N12,N11\n"+
			"Magica:\n"+
			"Buia:\n"+
			"Bloccata:\n"+
			"Inizio:N12\n"+
			"Vincente:N11\n"+
			"Mago:\n"+
			"Cane:\n"+
			"Strega:\n"+
			"Attrezzi:martello 3 N12\n"+
			"Uscite:\n";
	
	private CaricatoreLabirinto loader;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMonolocale() throws FormatoFileNonValidoException, FileNotFoundException {
		loader = new CaricatoreLabirinto(new StringReader(monolocale));
		loader.carica();
		assertEquals("biblioteca", this.loader.getStanzaIniziale().getNome());
		assertEquals("biblioteca", this.loader.getStanzaVincente().getNome());
		}
	
	@Test
	public void testBilocale() throws FormatoFileNonValidoException, FileNotFoundException {
		loader = new CaricatoreLabirinto(new StringReader(bilocale));
		loader.carica();
		assertEquals("N12", this.loader.getStanzaIniziale().getNome());
		assertEquals("N11", this.loader.getStanzaVincente().getNome());
		}
	
	
	@Test
	public void testBilocaleAttrezzo() throws FormatoFileNonValidoException, FileNotFoundException {
		loader = new CaricatoreLabirinto(new StringReader(bilocale));
		loader.carica();
		Attrezzo martello = new Attrezzo("martello", 3);
		assertEquals(martello, this.loader.getStanzaIniziale().getAttrezzo("martello"));
		}
}
