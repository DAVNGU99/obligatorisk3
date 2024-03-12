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
		
		for (int i = 0; i < tab.length; i++) {
			if(tab[i].equals(element)) {
				return true;
			}
		}
		return false;
		
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
	
	for (int i = 0; i < tab.length; i++) {
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
		
	
		for (int i = 0; i < tab.length; i++) {
			if(!annenMengde.inneholder(tab[i])) {
				return false;
			}
		}
		
		return true;
		
		
		
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		
		for (int i = 0; i < tab.length; i++) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void leggTil(T element) {
		
		if(antall == tab.length) {
			tab = Arrays.copyOf(tab, tab.length*2);
		}
		
		
		tab[antall] = element;
		antall++;
		
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		
		T[] temp = annenMengde.tilTabell();
		
		
		for (int i = 0; i < temp.length; i++) {
			
			if(!inneholder(tab[i])) {
				leggTil(temp[i]);
			}
			
		}
		
	}

	@Override
	public T fjern(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T[] tilTabell() {
		return Arrays.copyOf(tab, antall);
	}

	@Override
	public int antallElementer() {
		// TODO Auto-generated method stub
		return 0;
	}

}
