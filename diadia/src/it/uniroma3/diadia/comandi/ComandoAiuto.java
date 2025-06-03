package it.uniroma3.diadia.comandi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {

	private static List<String> elencoComandi = new ArrayList<>(Arrays.asList("vai", "aiuto", "fine","prendi", "posa", "guarda","saluta","interagisci","regala"));
	
	@Override
	public void esegui(Partita partita) {
		for(String s : elencoComandi) 
			getIO().mostraMessaggio(s+" ");
		getIO().mostraMessaggio("");
	}
	
	public static List<String> getElencoComandi(){
		return elencoComandi;
	}
}