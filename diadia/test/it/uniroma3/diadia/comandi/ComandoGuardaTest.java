package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.ambienti.Labirinto;

class ComandoGuardaTest {

	@BeforeEach
	void setUp() throws Exception {}
	
	@Test
	public void testPartitaConComandoGuarda() throws Exception{
		List<String> daLeggere = new ArrayList<>();
		daLeggere.add("guarda");
		daLeggere.add("fine");
		IOSimulator io = new IOSimulator(daLeggere);
		Labirinto labirinto = Labirinto.newBuilder("labirinto1.txt").getLabirinto();
		DiaDia gioco = new DiaDia(labirinto,io);
		gioco.gioca();
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.getNextOutput());
		assertTrue(io.getNextOutput().contains("biblioteca"));
		assertEquals("Grazie di aver giocato!", io.getNextOutput());
	}


}
