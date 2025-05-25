package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ComandoAiuto extends AbstractComando {
	private List<String> nomiComandi;
	
	
    @Override
    public void esegui(Partita partita, IO io) {
        nomiComandi = getNomiComandi();
        for (String s : nomiComandi) {
            io.mostraMessaggio(s + " ");
        }
        io.mostraMessaggio("");
    }

    public static List<String> getNomiComandi() {
    	List<String> comandi = new ArrayList<>();

        String path = "src/it/uniroma3/diadia/comandi";
        File dir = new File(path);

        if (dir.exists() && dir.isDirectory()) {
            for (String nomeFile : dir.list()) {
                if (nomeFile.startsWith("Comando") && nomeFile.endsWith(".java")) {
                    String nomeComando = nomeFile.substring("Comando".length(), nomeFile.length() - 5); // rimuove "Comando" e ".java"
                    comandi.add(nomeComando.toLowerCase());
                }
            }
        }

        return comandi;
    }
}
