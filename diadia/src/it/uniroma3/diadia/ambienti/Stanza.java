package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

/*
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	private static final int NUMERO_MASSIMO_DIREZIONI = 4;
	private String nome;

	private Map<String, Attrezzo> attrezzi;
	private Map<Direzione, Stanza> stanzeAdiacenti;
	
	private AbstractPersonaggio personaggio;

	/*
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.attrezzi = new HashMap<>();
		this.stanzeAdiacenti = new HashMap<>();
	}

	/*
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(Direzione direzione, Stanza stanza) {
		if (stanzeAdiacenti.containsKey(direzione)) {
			stanzeAdiacenti.put(direzione, stanza);
		}
		else if (stanzeAdiacenti.size() < NUMERO_MASSIMO_DIREZIONI) {
			stanzeAdiacenti.put(direzione, stanza);
		}
	}

	/*
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}

	/*
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/*
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/*
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public List<Attrezzo> getAttrezzi() {
		return new ArrayList<>(this.attrezzi.values());
	}

	/*
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
	    if(this.attrezzi.containsKey(attrezzo.getNome())) return false;
	    this.attrezzi.put(attrezzo.getNome(), attrezzo);
	    return true;
	}

	/*
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
			risultato.append(this.getDirezioni().toString());
		risultato.append("\nAttrezzi nella stanza: ");
		for (Attrezzo attrezzo : this.attrezzi.values()) {
			if(attrezzo!=null) {
				risultato.append(attrezzo.toString()+" ");
			}
		}
		return risultato.toString();
	}

	/*
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	/*
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		if (this.attrezzi.containsKey(nomeAttrezzo))
			attrezzoCercato = this.attrezzi.get(nomeAttrezzo);
		return attrezzoCercato;		
	}

	/*
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		return this.attrezzi.remove(attrezzo.getNome(), attrezzo);
	}


	public List<String> getDirezioni() {
	    return new ArrayList<>(this.stanzeAdiacenti.keySet());
	}

	public Map<String, Stanza> getMapStanzeAdiacenti() {
		return this.stanzeAdiacenti;
	}
	
	public List<Stanza> getStanzeAdiacenti() {
	    return new ArrayList<>(this.stanzeAdiacenti.values());
	}

	public boolean isMagica() {
		return false;
	}

	public void setPersonaggio(AbstractPersonaggio personaggio) {
		this.personaggio = personaggio;
	}
	public AbstractPersonaggio getPersonaggio() {
		return this.personaggio;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || !(obj instanceof Stanza)) return false;
		Stanza that = (Stanza) obj;
		return this.getNome().equals(that.getNome());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.nome);
	}

}
