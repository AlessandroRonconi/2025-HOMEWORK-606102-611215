package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {
	private Borsa bag;
	private Attrezzo spada;
	private Attrezzo martello;
	
	@BeforeEach
	void setUp() throws Exception{
		this.bag = new Borsa();
		this.spada = new Attrezzo("spada",9);
		this.martello = new Attrezzo("martello",3);
	}
	
	@Test
	void testAggiungoAttrezzoInBorsaVuota1() {
		this.bag.addAttrezzo(spada);
		assertFalse(this.bag.hasAttrezzo("spada") == false);
		assertFalse(this.bag.isEmpty());
		assertTrue(this.bag.getAttrezzo("spada").getPeso()==9);
	}
	
	@Test
	void testAggiungoAttrezzoInBorsaVuota2() {
		this.bag.addAttrezzo(spada);
		assertTrue(this.bag.hasAttrezzo("spada") == true);
		this.bag.removeAttrezzo("spada");
		assertTrue(this.bag.isEmpty());
		assertTrue(this.bag.getPeso()==0);
	}
	
	@Test
	void testAggiungoAttrezzoInBorsaVuota3() {
		this.bag.addAttrezzo(spada);
		assertTrue(this.bag.hasAttrezzo("spada") == true);
		this.bag.removeAttrezzo("spada");
		assertTrue(this.bag.hasAttrezzo("spada") == false);
		this.bag.addAttrezzo(martello);
		assertTrue(this.bag.getAttrezzo("martello").getPeso()==0);
	}

}
