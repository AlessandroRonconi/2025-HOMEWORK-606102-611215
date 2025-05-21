package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;

class ComandoNonValidoTest {
	
	@BeforeEach
	void setUp() throws Exception {}
	
	@Test
	public void testPartitaConComandoNonValido(){
		List<String> daLeggere = new ArrayList<>();
		daLeggere.add(" ");
		daLeggere.add("fine");
		IOSimulator io = new IOSimulator(daLeggere);
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.getNextOutput());
		assertEquals(io.getNextOutput(), "Comando non valido");
		assertEquals("Grazie di aver giocato!", io.getNextOutput());
	}

}
