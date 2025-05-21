package it.uniroma3.diadia.personaggi;

import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio{
	private static final String MESSAGGIO_DONO = "ihihihihihihih";
	private Attrezzo attrezzo;
	public Strega(String nome, String presentaz, Attrezzo attrezzo) {
		super(nome, presentaz);
		this.attrezzo = attrezzo;
	}
	@Override
	public String agisci(Partita partita) {
		if(haSalutato() == false) {
			List<Stanza> adiacenti = partita.getLabirinto().getStanzaCorrente().getStanzeAdiacenti();
			if(adiacenti == null || adiacenti.isEmpty()) {
				return null;
			}
			else {
				Stanza stanzaConMenoAttrezzi = null;
				int numAttrezzi;
				int minAttrezzi = Integer.MAX_VALUE;
				for(Stanza s : adiacenti) {
					if(s.getAttrezzi() == null) {
						numAttrezzi = 0;
					}
					else {
						numAttrezzi = s.getAttrezzi().size();
					}
					if(stanzaConMenoAttrezzi == null || numAttrezzi < minAttrezzi) {
						minAttrezzi = numAttrezzi;
						stanzaConMenoAttrezzi = s;
					}
				}
				if(stanzaConMenoAttrezzi != null) {
					partita.getLabirinto().setStanzaCorrente(stanzaConMenoAttrezzi);
					return "ti sei spostato in"+stanzaConMenoAttrezzi.getNome();
				}
			}
		
		}
		else {
			List<Stanza> adiacenti = partita.getLabirinto().getStanzaCorrente().getStanzeAdiacenti();
			if(adiacenti == null || adiacenti.isEmpty()) {
				return null;
			}
			else {
				Stanza stanzaConPiuAttrezzi = null;
				int numAttrezzi;
				int maxAttrezzi = 0;
				for(Stanza s : adiacenti) {
					if(s.getAttrezzi() == null) {
						numAttrezzi = 0;
					}
					else {
						numAttrezzi = s.getAttrezzi().size();
					}
					if(stanzaConPiuAttrezzi == null || numAttrezzi > maxAttrezzi) {
						maxAttrezzi = numAttrezzi;
						stanzaConPiuAttrezzi = s;
					}
				}
				if(stanzaConPiuAttrezzi != null) {
					partita.getLabirinto().setStanzaCorrente(stanzaConPiuAttrezzi);
					return "ti sei spostato in"+stanzaConPiuAttrezzi.getNome();
				}
			}
		}
		return null;
	}
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if(attrezzo == null) return null;
		else {
			partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
			String msg = MESSAGGIO_DONO;
			return msg;
		}
	}
}