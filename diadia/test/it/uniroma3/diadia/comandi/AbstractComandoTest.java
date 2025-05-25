package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class AbstractComandoTest {
	AbstractComando comando;
	Partita partita;
	IO io;
	
	@BeforeEach
	public void setUp() throws Exception{
		this.comando = new FintoComando();
		this.partita = new Partita();
		this.io = new IOConsole();
	}
	
	@Test
	public void testEsegui() {
		comando.esegui(partita, io);
		assertTrue(partita.isFinita());
	}
	
    @Test
    public void testSetParametro() {
        comando.setParametro("chiave");
        assertEquals("chiave", comando.getParametro());
    }
}
