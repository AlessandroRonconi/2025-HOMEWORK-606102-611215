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

import it.uniroma3.diadia.Configuratore;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePerNomeEPeso;


public class Borsa{
	private static final int PESO_MASSIMO_DEFAULT = Configuratore.getProprieta("pesoMax");
	private Map<String, List<Attrezzo>> attrezzi;
	private int pesoMax;

	public Borsa() {
		this(PESO_MASSIMO_DEFAULT);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>();
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public int getPeso() {
		int pesoTotale = 0;
        for (List<Attrezzo> lista : attrezzi.values()) {
            for (Attrezzo a : lista)
                pesoTotale += a.getPeso();
        }
        return pesoTotale;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.pesoMax)
            return false;

        List<Attrezzo> lista = this.attrezzi.get(attrezzo.getNome());
        if (lista == null) {
            lista = new ArrayList<>();
            this.attrezzi.put(attrezzo.getNome(), lista);
        }
        lista.add(attrezzo);
        return true;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		List<Attrezzo> lista = this.attrezzi.get(nomeAttrezzo);
        if (lista != null && !lista.isEmpty()) {
            Attrezzo rimosso = lista.remove(0);
            if (lista.isEmpty())
                this.attrezzi.remove(nomeAttrezzo);
            return rimosso;
        }
        return null;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		List<Attrezzo> lista = this.attrezzi.get(nomeAttrezzo);
        if (lista != null && !lista.isEmpty())
            return lista.get(0);
        return null;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> risultato = this.getAttrezzi();
        Collections.sort(risultato, new ComparatorePerNomeEPeso());
        return risultato;
	}

	private List<Attrezzo> getAttrezzi() {
		List<Attrezzo> tutti = new ArrayList<>();
        for (List<Attrezzo> lista : this.attrezzi.values()) {
            tutti.addAll(lista);
        }
        return tutti;
	}

	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
	    SortedSet<Attrezzo> ordinati = new TreeSet<>();
	    for (List<Attrezzo> lista : this.attrezzi.values()) {
	        ordinati.addAll(lista);
	    }
	    return ordinati;
	}

	public int getNumeroAttrezzi() {
	    int count = 0;
	    for(List<Attrezzo> lista : attrezzi.values()) {
	        count += lista.size();
	    }
	    return count;
	}

	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		final Map<Integer, Set<Attrezzo>> peso2attrezzi = new HashMap<>();
		for(Attrezzo attrezzo : this.getAttrezzi()) {
			final int peso = attrezzo.getPeso();
			Set<Attrezzo> attrezziStessoPeso = peso2attrezzi.get(peso);
			if(attrezziStessoPeso != null)
				attrezziStessoPeso.add(attrezzo);
			else { 
				attrezziStessoPeso = new HashSet<>();
				attrezziStessoPeso.add(attrezzo);
				peso2attrezzi.put(peso, attrezziStessoPeso);
			}
			attrezziStessoPeso.add(attrezzo);
		}
		return peso2attrezzi;
	}

	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
        SortedSet<Attrezzo> risultato = new TreeSet<>(new ComparatorePerNomeEPeso());
        risultato.addAll(this.getAttrezzi());
        return risultato;
	}

	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+
					this.getPeso()+"kg/"+
					this.getPesoMax()+"kg): ");
			for (Attrezzo attrezzo : this.getAttrezzi())
				s.append(attrezzo.toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}
