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

/* 
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
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
	
	public int getPesoMax() {
		return pesoMax;
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
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;

		for(Attrezzo attrezzo : this.attrezzi) {
			if(attrezzo.getNome().equals(nomeAttrezzo)) {
				this.attrezzi.remove(attrezzo);
				a = attrezzo;
			}
		}
		return a;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (Attrezzo attrezzo : this.attrezzi)
			if (attrezzo.getNome().equals(nomeAttrezzo))
				a = attrezzo;

		return a;
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
	
	public boolean isEmpty() {
		int numeroAttrezzi = 0;
		for(Attrezzo attrezzo : this.attrezzi) {
			numeroAttrezzi++;
		}
		return numeroAttrezzi==0;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (Attrezzo attrezzo : this.attrezzi)
				s.append(attrezzo.toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}
