package Oppgave1;

import java.util.Arrays;
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
	    for (T element : set) {
	        if (!annenMengde.inneholder(element)) {
	            return false;
	        }
	    }
	    return true;
	}


	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {

		T[] mengde = annenMengde.tilTabell();

		if (set.size() != mengde.length) {
			return false;
		}

		for (int i = 0; i < set.size(); i++) {
			if (!set.contains(mengde[i])) {
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {

		T[] mengde = annenMengde.tilTabell();

		for (int i = 0; i < mengde.length; i++) {
			if (set.contains(mengde[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {

		T[] mengde = annenMengde.tilTabell();
		MengdeADT<T> temp = new TabellMengde<>();

		for (int i = 0; i < mengde.length; i++) {
			if (set.contains(mengde[i])) {
				temp.leggTil(mengde[i]);
			}
		}
		return temp;

	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {

		T[] mengde = annenMengde.tilTabell();
		MengdeADT<T> temp = new TabellMengde<>(set.size() + mengde.length);

		for (T x : mengde) {
			temp.leggTil(x);
		}

		for (T tab : set) {
			temp.leggTil(tab);
		}

		return temp;

	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		
		T[] mengde = annenMengde.tilTabell();
		MengdeADT<T> temp = new TabellMengde<>();
		
	
		for(T element : set) {
			if(!annenMengde.inneholder(element)) {
				temp.leggTil(element);
			}
		}
		return temp;
		
	}

	@Override
	public void leggTil(T element) {

		set.add(element);

	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		
		T[] mengde = annenMengde.tilTabell();

		
		for(T temp : mengde) {
			if(!set.contains(temp)) {
				set.add(temp);
			}
		}
		
		

	}

	@Override
	public T fjern(T element) {
		
	if(set.contains(element)) {
		set.remove(element);
		return element;
	}
		
		return null;
		
	}

	@Override
	public T[] tilTabell() {

		T[] tab = (T[]) new Object[set.size()];

		return set.toArray(tab);

	}

	@Override
	public int antallElementer() {
		
		return set.size();
	}

}
