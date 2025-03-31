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



	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private boolean finita;
	private Labirinto lab; 
	private Giocatore player;

	public Partita(){
		this.lab = new Labirinto();
		this.player = new Giocatore();

		this.stanzaCorrente = lab.getStanzaIniziale(); //si comincia da stanza iniziale
		this.stanzaVincente = lab.getStanzaFinale();  //stanza finale a cui si arriva per vincere

		this.finita = false;
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.getStanzaVincente();
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
		return this.getStanzaCorrente() + "\nCFU = " + this.player.getCFU()
		+ "\n" + this.player.getBorsa().toString();
	}
}
