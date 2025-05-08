package it.uniroma3.diadia.ambienti;

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
}
