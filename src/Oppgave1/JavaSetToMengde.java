package Oppgave1;

import java.util.HashSet;
import java.util.Set;

public class JavaSetToMengde<T> implements MengdeADT<T> {

	
	private Set<T> set = new HashSet<T>();	
	
	
	@Override
	public boolean erTom() {
	
		return set.isEmpty();
		
	}

	@Override
	public boolean inneholder(T element) {
		
		return set.contains(element);
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		
		for (int i = 0; i < set.size(); i++) {
			if(annenMengde.inneholder(set.iterator())) {
				
			}
		}
		
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void leggTil(T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T fjern(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T[] tilTabell() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int antallElementer() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
	
	
	
}
