package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza{
	
	private String direzioneBloccata;
	private String nomeAttrezzoSblocco;
	
	public StanzaBloccata(String nome, String dir, String nomeAttrezzo) {
		super(nome);
		this.direzioneBloccata = dir;
		this.nomeAttrezzoSblocco = nomeAttrezzo;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if (direzione.equals(this.direzioneBloccata) && !this.hasAttrezzo(this.nomeAttrezzoSblocco)) {
			return this; // direzione bloccata e attrezzo mancante
		}
		return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		if (!this.hasAttrezzo(nomeAttrezzoSblocco)) {
			return super.getDescrizione() + "\nLa direzione " + direzioneBloccata +
					" è bloccata. Serve l'attrezzo: " + nomeAttrezzoSblocco;
		}
		return super.getDescrizione();
	}
	
//	@Override
//	public boolean equals(Object obj) {
//	    if (this == obj) return true;
//	    if (obj == null || getClass() != obj.getClass()) return false;
//		StanzaBloccata that = (StanzaBloccata) obj;
//		return this.getNome().equals(that.getNome()) && this.getDirezioneBloccata().equals(that.getDirezioneBloccata()) &&
//				this.getNomeAttrezzoSblocco().equals(that.getNomeAttrezzoSblocco());
//	}

	private String getDirezioneBloccata() {
		return this.direzioneBloccata;
	}
	
	private String getNomeAttrezzoSblocco() {
		return this.nomeAttrezzoSblocco;
	}
}
