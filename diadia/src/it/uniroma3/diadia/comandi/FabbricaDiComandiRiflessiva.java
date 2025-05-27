package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {
	
	@Override
	public AbstractComando costruisciComando(String istruzione){
		Scanner scannerDiParole = new Scanner(istruzione); // es. ‘vai sud’
		String nomeComando = null; // es. ‘vai’
		String parametro = null; // es. ‘sud’
		AbstractComando comando = null;
		
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();//prima parola: nome del comando
		
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();//seconda parola: eventuale parametro
		
		StringBuilder nomeClasse = new StringBuilder("it.uniroma3.diadia.comandi.Comando");
		
		if (nomeComando == null)
	        return new ComandoNonValido();

	    nomeClasse.append(Character.toUpperCase(nomeComando.charAt(0)));
	    nomeClasse.append(nomeComando.substring(1));

	    try {
	        comando = (AbstractComando) Class.forName(nomeClasse.toString()).newInstance();
	        comando.setParametro(parametro);
	        return comando;
	    } catch (Exception e) {
	        return new ComandoNonValido();
	    }
	}
}
