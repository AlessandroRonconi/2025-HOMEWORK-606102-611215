package it.uniroma3.diadia.ambienti;
import java.util.HashMap;
import java.util.Map;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder extends Labirinto{
	
	private Map<String, Stanza> listaStanze;
	private Stanza ultimaStanzaAggiunta;
	private Stanza stanzaIniziale;

	public LabirintoBuilder() {
		this.listaStanze = new HashMap<>();
	}
	

	public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
	    Stanza stanzaIniziale = new Stanza(nomeStanza);
	    this.setStanzaCorrente(stanzaIniziale);
	    this.stanzaIniziale = stanzaIniziale;
	    this.ultimaStanzaAggiunta = stanzaIniziale;
	    this.listaStanze.put(nomeStanza, stanzaIniziale);
	    return this;
	}

	public LabirintoBuilder addStanzaVincente(String nomeStanza) {
		Stanza stanzaVincente = new Stanza(nomeStanza);
		ultimaStanzaAggiunta = stanzaVincente;
		this.setStanzaVincente(stanzaVincente);
		this.listaStanze.put(nomeStanza, stanzaVincente);
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String nome, int peso) {
		if(this.ultimaStanzaAggiunta!=null) {
			Attrezzo attrezzo = new Attrezzo(nome,peso);
			this.ultimaStanzaAggiunta.addAttrezzo(attrezzo);
		}
		return this;
	}

	public LabirintoBuilder addAdiacenza(String nomeStanzaPartenza, String nomeStanzaDestinazione, String direzione) {
	    Stanza partenza = this.listaStanze.get(nomeStanzaPartenza);
	    Stanza destinazione = this.listaStanze.get(nomeStanzaDestinazione);
	    if (partenza != null && destinazione != null) {
	        partenza.impostaStanzaAdiacente(direzione, destinazione);
	    }
	    return this;
	}
	
	public LabirintoBuilder addStanza(String nome) {
		Stanza nuova = new Stanza(nome);
		this.listaStanze.put(nome, nuova);
		this.ultimaStanzaAggiunta = nuova;
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String string, String string2, String string3) {
		Stanza nuova = new StanzaBloccata(string, string2, string3);
		this.listaStanze.put(string, nuova);
		this.ultimaStanzaAggiunta = nuova;
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String string, int i) {
		Stanza nuova = new StanzaMagica(string, i);
		this.listaStanze.put(string, nuova);
		this.ultimaStanzaAggiunta = nuova;
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String string, String string2) {
		Stanza nuova = new StanzaBuia(string, string2);
		this.listaStanze.put(string, nuova);
		this.ultimaStanzaAggiunta = nuova;
		return this;
	}
	
	public Map<String,Stanza> getListaStanze() {
		return this.listaStanze;
	}	
}