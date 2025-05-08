package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;

class ComandoFineTest {

	@BeforeEach
	void setUp() throws Exception {}
	
	@Test
	public void testPartitaConComandoFine(){
		String[] daLeggere = {"fine"};
		IOSimulator io = new IOSimulator(daLeggere);
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.getNextOutput());
		assertEquals("Grazie di aver giocato!", io.getNextOutput());
	}

}
