package Oppgave1;


public class LenketMengde<T> implements MengdeADT<T> {

		private class Node {
			private T data;
			private Node neste;

			private Node(T data) {
				this.data = data;
				this.neste = null;
			}
		}

		private Node forste;
		private int antall;

		public LenketMengde() {
			forste = null;
			antall = 0;
		}

		@Override
		public boolean erTom() {
			return antall == 0;
		}

		@Override
		public boolean inneholder(T element) {
			Node ny = forste;

			while (ny != null) {
				if (ny.data.equals(element)) {
					return true; 
				}
				ny = ny.neste;
			}

			return false; 
		}

		@Override
	    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {

	        int antFelles = 0;

	        Node ny = forste;

	        while (ny != null) {
	            if (annenMengde.inneholder(ny.data)) {
	                antFelles++;
	            }
	            ny = ny.neste;
	        }

	        return antFelles == antall;

	    }

		@Override
	    public boolean erLik(MengdeADT<T> annenMengde) {

	        if (annenMengde == null || this == null || antall != annenMengde.antallElementer()) {
	            return false;
	        }

	        Node ny = forste;
	        while (ny != null) {
	            if (!annenMengde.inneholder(ny.data)) {
	                return false;
	            }
	            ny = ny.neste;
	        }

	        return true;

	    }

		@Override
		public boolean erDisjunkt(MengdeADT<T> annenMengde) {
			Node ny = forste;

			while (ny != null) {

				if (annenMengde.inneholder(ny.data)) {
					return false;
				}
				ny = ny.neste;
			}

			return true;
		}

		@Override
		public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
			MengdeADT<T> temp = new TabellMengde<>();
			Node ny = forste;

			while (ny != null) {

				if (annenMengde.inneholder(ny.data)) {
					temp.leggTil(ny.data);
				}
				ny = ny.neste;
			}

			return temp;

		}

		@Override
		public MengdeADT<T> union(MengdeADT<T> annenMengde) {
			TabellMengde<T> temp = new TabellMengde<>();

			temp.leggTilAlleFra(annenMengde);
			temp.leggTilAlleFra(this);
			return temp;
		}

		@Override
	    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {

	        TabellMengde<T> temp = new TabellMengde<>();

	        Node ny = forste;

	        while (ny != null) {

	            if (!annenMengde.inneholder(ny.data)) {
	                temp.leggTil(ny.data);
	            }
	            ny = ny.neste;
	        }
	        return temp;
	    }

		@Override
		public void leggTil(T element) {
			
			Node ny = new Node(element);
			ny.neste = forste;
			forste = ny;
			antall++;

		}

		@Override
	    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
	        if (annenMengde.erTom()) {
	            return;
	        }

	        Node ny = ((LenketMengde<T>) annenMengde).forste;

	        while (ny != null) {
	            if (!this.inneholder(ny.data)) {
	                this.leggTil(ny.data);
	            }
	            ny = ny.neste;
	        }

	    }

		@Override
	    public T fjern(T element) {
	        T temp;
	        if (forste == null)
	            return null;
	        else if (forste.data.equals(element)) {
	            temp = forste.data;
	            forste = forste.neste;
	            antall--;
	            return temp;
	        }
	        Node ny = forste;
	        while (ny.neste != null) {
	            if (ny.neste.data.equals(element)) {
	                temp = ny.neste.data;
	                ny.neste = ny.neste.neste;
	                antall--;
	                return temp;
	            }
	            ny = ny.neste;
	        }

	        return null;
	    }

		@Override
		public T[] tilTabell() {

			@SuppressWarnings("unchecked")
			T[] resultat = (T[]) new Object[antall];

			return resultat;
		}

		@Override
		public int antallElementer() {
			return antall;
		}

		public void skrivUt() {
			Node denne = forste;
			while (denne != null) {
				System.out.println(denne.data);
				denne = denne.neste;
			}

		}
	}


