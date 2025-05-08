package it.uniroma3.diadia;

public class IOSimulator implements IO{

	private String[] input;
	private String[] output;
	private int indiceInput;
	private int indiceOutput;
	private int indiceOutputMostrati;

	public IOSimulator(String[] daLeggere) {
		this.input = daLeggere;
		this.output = new String[100];
		this.indiceInput = 0;
		this.indiceOutput = 0;
		this.indiceOutputMostrati = 0;
	}

	public String getNextOutput() {
		String next = this.output[this.indiceOutputMostrati];
		this.indiceOutputMostrati++;
		return next;
	}


	@Override
	public void mostraMessaggio(String messaggio) {
		this.output[this.indiceOutput] = messaggio;
		this.indiceOutput++;
	}

	@Override
	public String leggiRiga() {
		if (this.indiceInput < this.input.length) {
			return this.input[this.indiceInput++];
		}
		return null;
	}

}
