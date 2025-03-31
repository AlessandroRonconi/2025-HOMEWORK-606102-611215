package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LabirintoTest {
    private Labirinto labirinto;

    @BeforeEach
    void setUp() {
        labirinto = new Labirinto();
    }

    @Test
    void testStanzaInizialeAtrio() {
    	assertEquals("Atrio", labirinto.getStanzaIniziale().getNome());
    }

    @Test
    void testStanzaFinaleBiblioteca() {
        assertEquals("Biblioteca", labirinto.getStanzaFinale().getNome());
    }
    @Test
    void testBibliotecaANordDiAtrio() {
        assertEquals(labirinto.getStanzaFinale(), labirinto.getStanzaIniziale().getStanzaAdiacente("nord"));
    }
}
