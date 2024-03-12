package Oppgave1;

import java.util.Arrays;

public class TabellMengde<T> implements MengdeADT<T> {
	
	private static final int START_KAPASITET = 20;
	
	private T[] tab;
	private int antall;
	
	
	public TabellMengde() {
	    this(START_KAPASITET); 
	}

	
	
	public TabellMengde( int START_KAPASITET) {
		
		tab = (T[]) new Object[START_KAPASITET];
		this.antall = 0;
		
	}
	


	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public boolean inneholder(T element) {
		
		for (int i = 0; i < antall; i++) {
			if(tab[i].equals(element)) {
				return true;
			}
		}
		return false;
		
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
	
	for (int i = 0; i < antall; i++) {
		if(!annenMengde.inneholder(tab[i])) {
			return false;
		}
		
		
		
		}
	return true;
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		
		if(tab.length != annenMengde.antallElementer()) {
			
			return false;
			
		}
		
	
		for (int i = 0; i < antall; i++) {
			if(!annenMengde.inneholder(tab[i])) {
				return false;
			}
		}
		
		return true;
		
		
		
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		
		for (int i = 0; i < antall; i++) {
			if(annenMengde.inneholder(tab[i])) {
				return false;
			}
		}
		return true;
		
	}

	@Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		
        MengdeADT<T>temp = new TabellMengde<>();
        for (int i = 0; i < antall; i++) {
            if (annenMengde.inneholder(tab[i])) {
                temp.leggTil(tab[i]);
            }
        }
        return temp;

    }

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		
		T[] temp = annenMengde.tilTabell();
		
		MengdeADT<T> union = new TabellMengde<>(tab.length + temp.length);
		
		for (int i = 0; i < tab.length; i++) {
			union.leggTil(tab[i]);
		}
		
		
		for (int i = 0; i < temp.length; i++) {
			if(!union.inneholder(temp[i])) {
				union.leggTil(temp[i]);
			}
		}
		
		
		return union;
			
		
		
		
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
	    MengdeADT<T> result = new TabellMengde<>();

	    for (int i = 0; i < antall; i++) {
	        if (!annenMengde.inneholder(tab[i])) {
	            result.leggTil(tab[i]);
	        }
	    }

	    return result;
	}

	@Override
	public void leggTil(T element) {
		
		if(antall == tab.length) {
			ensureCapcity();
		}
		
		
		tab[antall] = element;
		antall++;
		
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
	    T[] temp = annenMengde.tilTabell();

	    for (int i = 0; i < temp.length; i++) {
	        if (!inneholder(temp[i])) {
	            leggTil(temp[i]);
	        }
	    }
	}

	@Override
	public T fjern(T element) {
		
		for (int i = 0; i < antall; i++) {
			if(tab[i].equals(element)) {
				T temp = tab[i];
				
				
				for (int j = i; j < antall-1; j++) {
					tab[j] = tab[j+1];
				}
				tab[antall-1] = null;
				antall--;
				return temp;
				
			}
		}
		return null;
		
	}

	@Override
	public T[] tilTabell() {
		return Arrays.copyOf(tab, antall);
	}

	@Override
	public int antallElementer() {
		return antall;
	}
	
	
	private void ensureCapcity() {
	    T[] nyTab = (T[]) new Object[tab.length * 2]; // Double the capacity
	    System.arraycopy(tab, 0, nyTab, 0, tab.length); // Copy elements to the new array
	    tab = nyTab; // Update the reference to the new array
	}
	

}
