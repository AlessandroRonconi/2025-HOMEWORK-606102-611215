package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {

	@Override
	public AbstractComando costruisciComando(String istruzione, IO io){
		Scanner scannerDiParole = new Scanner(istruzione); // es. ‘vai sud’
		String nomeComando = null; // es. ‘vai’
		String parametro = null; // es. ‘sud’
		AbstractComando comando = null;

		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();//prima parola: nome del comando

		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();//seconda parola: eventuale parametro

		if (nomeComando == null)
			comando = new ComandoNonValido();
		
		else {
			StringBuilder nomeClasse = new StringBuilder("it.uniroma3.diadia.comandi.Comando");
			nomeClasse.append(Character.toUpperCase(nomeComando.charAt(0)));
			nomeClasse.append(nomeComando.substring(1));

			try {
				comando = (AbstractComando) Class.forName(nomeClasse.toString()).newInstance();
				comando.setParametro(parametro);
			} catch (Exception e) {
				comando = new ComandoNonValido();
			}
		}

		comando.setIO(io);
		return comando;
	}
}
