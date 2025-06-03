package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando{
	private String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo == null) getIO().mostraMessaggio("Cosa vuoi regalare?");
		Attrezzo regalo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if(regalo == null) {
			getIO().mostraMessaggio("Attrezzo inesistente");
			return;
		}
		
		partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		partita.getLabirinto().getStanzaCorrente().getPersonaggio().riceviRegalo(regalo, partita);
		getIO().mostraMessaggio("Hai regalato "+ this.nomeAttrezzo);
		
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

}
