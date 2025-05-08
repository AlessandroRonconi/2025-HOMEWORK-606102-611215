package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	private String nomeAttrezzoLuce;

	public StanzaBuia(String nome, String nomeAttrezzo) {
		super(nome);
		this.nomeAttrezzoLuce = nomeAttrezzo;
	}

	@Override
	public String getDescrizione() {
		if (this.hasAttrezzo(nomeAttrezzoLuce)) {
			return super.getDescrizione();
		} else {
			return "qui c'è un buio pesto";
		}
	}
}