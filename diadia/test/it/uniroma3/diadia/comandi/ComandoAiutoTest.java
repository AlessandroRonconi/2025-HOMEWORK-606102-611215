package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;

class ComandoAiutoTest {

	@BeforeEach
	void setUp() throws Exception {}
	
	@Test
	public void testPartitaConComandoAiuto(){
		List<String> daLeggere = new ArrayList<>();
		daLeggere.add("aiuto");
		daLeggere.add("fine");
		IOSimulator io = new IOSimulator(daLeggere);
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.getNextOutput());
		for(String s : ComandoAiuto.getElencoComandi()) {
			assertEquals(s+" ", io.getNextOutput());
		}
		io.getNextOutput();
		assertEquals("Grazie di aver giocato!", io.getNextOutput());
	}

}
