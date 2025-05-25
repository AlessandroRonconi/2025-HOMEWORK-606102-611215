package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {
	private Borsa bag;
	private Attrezzo spada;
	private Attrezzo martello;
	private Attrezzo ascia;
	private Attrezzo piuma;
	private Attrezzo martelletto;
	private Attrezzo incudine;
	
	@BeforeEach
	void setUp() throws Exception{
		this.bag = new Borsa();
		this.spada = new Attrezzo("spada",9);
		this.ascia = new Attrezzo("ascia",12);
		this.piuma = new Attrezzo("piuma",1);
		this.martello = new Attrezzo("martello", 10);
		this.martelletto = new Attrezzo("martello", 2);
		this.incudine = new Attrezzo("incudine", 10);
	}
	
	@Test
	void testBorsaVuota() {
		assertEquals(0, this.bag.getPeso());
	}
	
	@Test
	void testAggiungo1Attrezzo() {
		this.bag.addAttrezzo(spada);
		assertTrue(this.bag.hasAttrezzo("spada"));
		assertFalse(this.bag.isEmpty());
		assertEquals(this.bag.getAttrezzo("spada").getPeso(), 9);
	}
	
	@Test
	void testAggiungo1AttrezzoELoRimuovo() {
		this.bag.addAttrezzo(spada);
		assertTrue(this.bag.hasAttrezzo("spada"));
		this.bag.removeAttrezzo("spada");
		assertTrue(this.bag.isEmpty());
		assertEquals(this.bag.getPeso(), 0);
	}
	
	@Test
	void testAggiungo1AttrezzoCheSfora() {
		this.bag.addAttrezzo(ascia);
		assertEquals(this.bag.getPeso(), 0);
		assertTrue(this.bag.isEmpty());
	}
	
	@Test
	void testAggiungo2Attrezzi() {
		this.bag.addAttrezzo(piuma);
		this.bag.addAttrezzo(spada);
		assertEquals(10, this.bag.getPeso());
	}
	
	@Test
	void testAggiungo2AttrezziCheSforano() {
		this.bag.addAttrezzo(spada);
		this.bag.addAttrezzo(martello);
		assertEquals(this.bag.getPeso(), 9);
		assertFalse(this.bag.hasAttrezzo("martello"));
	}
	
	@Test
	void testGetContenutoOrdinatoPerPeso() {
		Borsa borsa = new Borsa(30);
		borsa.addAttrezzo(incudine);
		borsa.addAttrezzo(piuma);
		borsa.addAttrezzo(martello);
		
		List<Attrezzo> ordinati = Arrays.asList(piuma, incudine, martello);
		assertEquals(ordinati, borsa.getContenutoOrdinatoPerPeso());
		
	}
	
	@Test
	void testGetContenutoOrdinatoPerNome(){
		Borsa borsa = new Borsa(30);
		
		borsa.addAttrezzo(martello);
		assertEquals(1,borsa.getNumeroAttrezzi());
		assertEquals(1,borsa.getContenutoOrdinatoPerNome().size());
		
		borsa.addAttrezzo(martelletto);
		assertEquals(2,borsa.getNumeroAttrezzi());
		assertEquals(2,borsa.getContenutoOrdinatoPerNome().size());
		
		borsa.addAttrezzo(spada);
		assertEquals(3,borsa.getNumeroAttrezzi());
		assertEquals(3,borsa.getContenutoOrdinatoPerNome().size());

		List<Attrezzo> attesi = Arrays.asList(martelletto, martello, spada);  // [martelletto, martello, spada]
		assertEquals(attesi, new ArrayList<>(borsa.getContenutoOrdinatoPerNome()));
	}
	
	@Test
	void testGetContenutoRaggruppatoPerPeso() {
		Borsa borsa = new Borsa(30);
		borsa.addAttrezzo(incudine);
		borsa.addAttrezzo(piuma);
		borsa.addAttrezzo(spada);
		borsa.addAttrezzo(martello);
		

		Map<Integer, Set<Attrezzo>> mappa = borsa.getContenutoRaggruppatoPerPeso();


		assertEquals(3, mappa.size());		// verifica che ci siano 3 gruppi di peso: 1, 9, 10

		
		assertTrue(mappa.containsKey(10));  // Verifica presenza attrezzi nel gruppo di peso 5
		assertTrue(mappa.get(10).contains(martello));
		assertTrue(mappa.get(10).contains(incudine));
		assertEquals(2, mappa.get(10).size());

		// Verifica altri gruppi
		assertEquals(new HashSet<>(Arrays.asList(spada)), mappa.get(9));
		assertEquals(new HashSet<>(Arrays.asList(piuma)), mappa.get(1));
		
	}
	
	@Test
	void testGetSortedSetOrdinatoPerPeso() {
		Borsa borsa = new Borsa(30);
		borsa.addAttrezzo(incudine);
		borsa.addAttrezzo(piuma);
		borsa.addAttrezzo(martello);
		
		List<Attrezzo> ordinati = Arrays.asList(piuma, incudine, martello);
		assertEquals(ordinati, new ArrayList<>(borsa.getSortedSetOrdinatoPerPeso()));
		
	}
}
