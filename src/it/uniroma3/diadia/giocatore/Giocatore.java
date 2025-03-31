package it.uniroma3.diadia.giocatore;

public class Giocatore {
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa bag;

	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.bag = new Borsa(20);
	}

	public int getCFU() {
		return this.cfu;
	}

	public void setCFU(int CFU) {
		this.cfu = CFU;
	}

	public Borsa getBorsa(){
		return this.bag;
	}
}
