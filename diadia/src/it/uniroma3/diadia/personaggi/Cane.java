package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{
	private static final String MESSAGGIO_DONO = "bau bau, grrrrrr";
	private Attrezzo attrezzo;
	public Cane(String nome, String presentaz, Attrezzo attrezzo) {
		super(nome, presentaz);
		this.attrezzo = attrezzo;
	}
	@Override
	public String agisci(Partita partita) {
		String msg = MESSAGGIO_DONO;
		int CFUStart = partita.getGiocatore().getCFU();
		int CFUAfter = CFUStart-1;
		partita.getGiocatore().setCFU(CFUAfter);
		return msg;		
	}
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if(attrezzo==null) return null;
		else {
			if(attrezzo.getNome().equals("osso")) {
				Attrezzo a = new Attrezzo(this.attrezzo.getNome(),this.attrezzo.getPeso());
				partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
				partita.getGiocatore().getBorsa().removeAttrezzo("osso");
				this.attrezzo = attrezzo;
			}
			return null;
		}
	}
}