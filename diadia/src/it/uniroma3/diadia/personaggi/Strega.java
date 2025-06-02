package it.uniroma3.diadia.personaggi;

import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio{
	private static final String MESSAGGIO_DONO = "ihihihihihihih";
	
	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
	}
	@Override
	public String agisci(Partita partita) {
		List<Stanza> stanzeAdiacenti = partita.getLabirinto().getStanzaCorrente().getStanzeAdiacenti();
		
		Stanza maxAttrezzi = stanzeAdiacenti.get(0);
		Stanza minAttrezzi = stanzeAdiacenti.get(0);
		
		
		for(Stanza s : stanzeAdiacenti) {
			if(s!=null) {
				if(s.getNumeroAttrezzi() > partita.getLabirinto().getStanzaCorrente().getNumeroAttrezzi()) maxAttrezzi = s;
				if(s.getNumeroAttrezzi() < partita.getLabirinto().getStanzaCorrente().getNumeroAttrezzi()) minAttrezzi = s;
			}
		}
		
		if(haSalutato()) {
			partita.getLabirinto().setStanzaCorrente(maxAttrezzi);
			return "Mi hai salutato, quindi ti mando in " + maxAttrezzi.getNome() + ", la stanza con più attrezzi!";
		}
		partita.getLabirinto().setStanzaCorrente(minAttrezzi);
		return "Che maleducazione! Ti mando in " + minAttrezzi.getNome() + ", la stanza con meno attrezzi!";
		
//		if(haSalutato() == false) {
//			
//			if(stanzeAdiacenti == null || stanzeAdiacenti.isEmpty()) {
//				return null;
//			}
//			else {
//				Stanza stanzaConMenoAttrezzi = null;
//				int numAttrezzi;
//				int minAttrezzi = Integer.MAX_VALUE;
//				for(Stanza s : stanzeAdiacenti) {
//					if(s.getAttrezzi() == null) {
//						numAttrezzi = 0;
//					}
//					else {
//						numAttrezzi = s.getAttrezzi().size();
//					}
//					if(stanzaConMenoAttrezzi == null || numAttrezzi < minAttrezzi) {
//						minAttrezzi = numAttrezzi;
//						stanzaConMenoAttrezzi = s;
//					}
//				}
//				if(stanzaConMenoAttrezzi != null) {
//					partita.getLabirinto().setStanzaCorrente(stanzaConMenoAttrezzi);
//					return "Ora ti mando in "+stanzaConMenoAttrezzi.getNome();
//				}
//			}
//		
//		}
//		else {
//			List<Stanza> adiacenti = partita.getLabirinto().getStanzaCorrente().getStanzeAdiacenti();
//			if(adiacenti == null || adiacenti.isEmpty()) {
//				return null;
//			}
//			else {
//				Stanza stanzaConPiuAttrezzi = null;
//				int numAttrezzi;
//				int maxAttrezzi = 0;
//				for(Stanza s : adiacenti) {
//					if(s.getAttrezzi() == null) {
//						numAttrezzi = 0;
//					}
//					else {
//						numAttrezzi = s.getAttrezzi().size();
//					}
//					if(stanzaConPiuAttrezzi == null || numAttrezzi > maxAttrezzi) {
//						maxAttrezzi = numAttrezzi;
//						stanzaConPiuAttrezzi = s;
//					}
//				}
//				if(stanzaConPiuAttrezzi != null) {
//					partita.getLabirinto().setStanzaCorrente(stanzaConPiuAttrezzi);
//					return "Ora ti mando in "+stanzaConPiuAttrezzi.getNome();
//				}
//			}
//		}
//		return null;
	}
	
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return MESSAGGIO_DONO;
	}
}