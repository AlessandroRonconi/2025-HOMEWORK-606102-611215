package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePerNomeEPeso;

/* public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	public int getPesoMax() {
		return pesoMax;
	}
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];

		return a;
	}

	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();

		return peso;
	}
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;

		for(int i = 0; i<this.numeroAttrezzi; i++) {
			if(attrezzi[i].getNome().equals(nomeAttrezzo)) {
				a = attrezzi[i];
				for(int j = i; j<this.numeroAttrezzi-1; j++)
					attrezzi[j] = attrezzi[j+1];
				this.attrezzi[numeroAttrezzi-1] = null;
				this.numeroAttrezzi--;
			}
		}
		return a;
	}
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
} */

public class Borsa{
	private static final int PESO_MASSIMO_DEFAULT = 10;
	private List <Attrezzo> attrezzi;
	private int pesoMax;

	public Borsa() {
		this(PESO_MASSIMO_DEFAULT);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<>();
	}

	public int getPeso() {
		int pesoTotale = 0;
		for(Attrezzo attrezzo: attrezzi) {
			pesoTotale += attrezzo.getPeso();
		}
		return pesoTotale;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		return this.attrezzi.add(attrezzo);
	}

	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		final List<Attrezzo> risultato = new ArrayList<>(this.getAttrezzi());
		Collections.sort(risultato, new ComparatorePerNomeEPeso());
		
		return risultato;
	}

	public List<Attrezzo> getContenutoOrdinatoPerNome(){
		final List<Attrezzo> risultato = new ArrayList<>(this.getAttrezzi());
		Collections.sort(risultato);
		
		return risultato;
	}

	private List<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoNome(){
		return new TreeSet<>(this.getAttrezzi());
	}

	public int getNumeroAttrezzi() {
		return this.attrezzi.size();
	}
	
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		final Map<Integer, Set<Attrezzo>> peso2attrezzi = new HashMap<>();
		for(Attrezzo attrezzo : attrezzi) {
			final int peso = attrezzo.getPeso();
			Set<Attrezzo> attrezziStessoPeso = peso2attrezzi.get(peso);
			if(attrezziStessoPeso != null)
				attrezziStessoPeso.add(attrezzo);
			else { 
				attrezziStessoPeso = new HashSet<>();
				attrezziStessoPeso.add(attrezzo);
				peso2attrezzi.put(peso, attrezziStessoPeso);
			}
				
		}
		return peso2attrezzi;
	}
}
