package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GiocatoreTest {
	private Giocatore player;
	@BeforeEach
	void setUp()throws Exception{
		player = new Giocatore();
	}
	@Test
	void testVerificaCfuIniziali() {
		assertTrue(this.player.getCFU()==20);
	}


	@Test
	void testCfuCambiati() {
		this.player.setCFU(2);
		assertFalse(this.player.getCFU()==20);
	}
	@Test
	void testCfuCambiati2() {
		this.player.setCFU(0);
		assertTrue(this.player.getCFU()==0);
		this.player.setCFU(9);
		assertTrue(this.player.getCFU()==9);
	}

}