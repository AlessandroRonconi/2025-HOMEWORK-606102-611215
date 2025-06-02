package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{
	private static final String MESSAGGIO_MORSO = "Bau bau, grrrrrr";
	private static final String CIBO_PREFERITO = "osso";
	private Attrezzo attrezzo;
	
	public Cane(String nome, String presentaz, Attrezzo attrezzo) {
		super(nome, presentaz);
		this.attrezzo = attrezzo;
	}
	@Override
	public String agisci(Partita partita) {
		String msg = MESSAGGIO_MORSO;
		partita.getGiocatore().setCFU(partita.getGiocatore().getCFU()-1);
		return msg;		
	}
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String msg;
		if(attrezzo!=null && attrezzo.getNome().equals(CIBO_PREFERITO)) {
			if(this.attrezzo!=null) {
				Attrezzo a = new Attrezzo(this.attrezzo.getNome(),this.attrezzo.getPeso());
				partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
			}
			this.attrezzo = attrezzo;
			msg = "Arf, Arf, Gnam!";
		}
		else {
			msg = MESSAGGIO_MORSO;
			partita.getGiocatore().setCFU(partita.getGiocatore().getCFU()-1);
		}
		return msg;			

	}
}