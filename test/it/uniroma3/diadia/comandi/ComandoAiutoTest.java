package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;

class ComandoAiutoTest {

	@BeforeEach
	void setUp() throws Exception {}
	
	@Test
	public void testPartitaConComandoAiuto(){
		String[] daLeggere = {"aiuto", "fine"};
		IOSimulator io = new IOSimulator(daLeggere);
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.getNextOutput());
		for(int i=0; i < ComandoAiuto.ELENCO_COMANDI.length; i++) {
			assertEquals(ComandoAiuto.ELENCO_COMANDI[i]+" ", io.getNextOutput());
		}
		io.getNextOutput();
		assertEquals("Grazie di aver giocato!", io.getNextOutput());
	}

}
