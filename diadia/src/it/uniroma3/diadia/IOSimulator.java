package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IOSimulator implements IO{

	private List<String> input;
	private List<String> output;
	private int indiceInput;
	private int indiceOutputMostrati;
	private Map<String,List<String>> indiceOutputMap;

	public IOSimulator(List<String> daLeggere) {
//		this.input = daLeggere;
//		this.output = new String[100];
		this.input = new ArrayList<>(daLeggere);
		this.output = new ArrayList<>();
		this.indiceInput = 0;
		this.indiceOutputMostrati = 0;
		this.indiceOutputMap = new HashMap<>();
	}

	public String getNextOutput() {
//		String next = this.output[this.indiceOutputMostrati];
//		this.indiceOutputMostrati++;
//		return next;
		 if (indiceOutputMostrati < output.size()) {
	            return output.get(indiceOutputMostrati++);
	        }
	        return null;
	}


	@Override
	public void mostraMessaggio(String messaggio) {
//		this.output[this.indiceOutput] = messaggio;
//		this.indiceOutput++;
		this.output.add(messaggio);
		if (indiceInput > 0 && indiceInput <= input.size()) {
            String currentInput = input.get(indiceInput - 1);
            indiceOutputMap.computeIfAbsent(currentInput, k -> new ArrayList<>()).add(messaggio);
        }
	}

	@Override
	public String leggiRiga() {
//		if (this.indiceInput < this.input.length) {
//			return this.input[this.indiceInput++];
//		}
//		return null;
//	}
		if(this.indiceInput < this.input.size()) {
			String riga = this.input.get(indiceInput);
			this.indiceInput++;
			return riga;
		}
		return null;
	}

}
