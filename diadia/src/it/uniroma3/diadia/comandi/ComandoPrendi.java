package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando{
	private String nomeAttrezzo; 
	@Override
	public void esegui(Partita partita) {

		if(nomeAttrezzo==null)
			getIO().mostraMessaggio("Quale attrezzo vuoi prendere?");
		Attrezzo nuovoAttrezzo = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(nuovoAttrezzo == null) {
			getIO().mostraMessaggio("Attrezzo inesistente");
			return;
		}

		if(partita.getGiocatore().getBorsa().addAttrezzo(nuovoAttrezzo)) {
			partita.getLabirinto().getStanzaCorrente().removeAttrezzo(nuovoAttrezzo);
			getIO().mostraMessaggio("Hai preso " + nomeAttrezzo);	
		}
		else getIO().mostraMessaggio("La borsa e' troppo piena!");
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

}
