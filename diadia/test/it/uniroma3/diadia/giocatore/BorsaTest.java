package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/* class BorsaTest {
	private Borsa bag;
	private Attrezzo spada;
	private Attrezzo martello;
	private Attrezzo ascia;
	private Attrezzo candela;
	@BeforeEach
	void getUp() throws Exception{
		bag = new Borsa(10);
		spada = new Attrezzo("spada",9);
		martello = new Attrezzo("martello",3);
		ascia = new Attrezzo("ascia",12);
		candela = new Attrezzo("candela",1);
	}
	@Test
	void testAggiungo1IsEmpty1() {
		this.bag.addAttrezzo(spada);
		assertFalse(this.bag.hasAttrezzo("spada")==false);
		assertFalse(this.bag.isEmpty());
		assertTrue(this.bag.getAttrezzo("spada").getPeso()==9);

	}
	@Test
	void testAggiungo2IsEmpty2ERemove1() {
		this.bag.addAttrezzo(spada);
		assertTrue(this.bag.hasAttrezzo("spada")==true);
		this.bag.removeAttrezzo("spada");
		assertTrue(this.bag.isEmpty());
		assertTrue(this.bag.getPeso()==0);

	}

	@Test
	void testAggiungo3IsEmpty3Remove2e3() {
		this.bag.addAttrezzo(spada);
		assertTrue(this.bag.hasAttrezzo("spada")==true);
		this.bag.removeAttrezzo("spada");
		assertTrue(this.bag.hasAttrezzo("spada")==false);
		this.bag.addAttrezzo(martello);
		assertTrue(this.bag.getAttrezzo("martello").getPeso()==3);
		this.bag.removeAttrezzo("martello");
		assertTrue(this.bag.isEmpty());

	}
	@Test
	void testMettoOggettoMaPesaTroppo() {
		this.bag.addAttrezzo(ascia);
		assertTrue(this.bag.getPeso()==0);
		assertTrue(this.bag.isEmpty()==true);
	}
	@Test
	void testAggiungiPiuOggettiCheSforano() {
		this.bag.addAttrezzo(spada);
		this.bag.addAttrezzo(martello);
		assertTrue(this.bag.getPeso()==9);
		assertTrue(this.bag.hasAttrezzo("martello")==false);
	}

	@Test
	void testAggiungiPiuOggettiCheNonSforzano() {
		this.bag.addAttrezzo(spada);
		this.bag.addAttrezzo(candela);
		assertTrue(this.bag.getPeso()==10);
		assertTrue(this.bag.hasAttrezzo("candela")==true);
	}




} */

class BorsaTest{
	private Borsa vuota;
	private Attrezzo piuma;
	private Attrezzo martello;
	private Attrezzo martelletto;
	private Borsa borsa;

	@BeforeEach
	void setUp() throws Exception{
		this.vuota = new Borsa();
		this.piuma = new Attrezzo("piuma", 1);
		this.martello = new Attrezzo("martello", 10);
		this.martelletto = new Attrezzo("martello", 2);
		
		this.borsa = new Borsa();
	}

	@Test
	void testBorsaVuota() {
		assertEquals(0, this.vuota.getPeso());
	}

	@Test
	void testBorsa2Attrezzi() {
		vuota.addAttrezzo(piuma);
		vuota.addAttrezzo(martello);
		assertEquals(11, this.vuota.getPeso());
	}
	
	@Test
	void testGetContenutoOrdinatoPerNome(){
		this.borsa.addAttrezzo(this.martello);
		assertEquals(1,borsa.getNumeroAttrezzi());
		assertEquals(1,borsa.getContenutoOrdinatoPerNome().size());
		this.borsa.addAttrezzo(this.martelletto);
		assertEquals(2,borsa.getNumeroAttrezzi());
		assertEquals(2,borsa.getContenutoOrdinatoNome().size());
	}

}
