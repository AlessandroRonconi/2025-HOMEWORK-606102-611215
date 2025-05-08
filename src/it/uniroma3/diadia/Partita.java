package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private boolean finita;
	private Labirinto labirinto; 
	private Giocatore player;

	public Partita(){
		this.labirinto = new Labirinto();
		this.player = new Giocatore();
		this.finita = false;
	}

	public Labirinto getLabirinto() {
		return labirinto;
	}

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.labirinto.getStanzaCorrente()== this.labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (player.getCFU() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public void setCfu(int cfu) {
		player.setCFU(cfu);		
	}

	public Giocatore getGiocatore() {
		return this.player;
	}

	public String toString() {
		return this.getLabirinto().getStanzaCorrente() + "\nCFU = " + this.player.getCFU()
		+ "\n" + this.player.getBorsa().toString();
	}

	public boolean giocatoreIsVivo() {
		if(this.player.getCFU() == 0) return false;
		return true;
	}
}
