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
			Node ny = forste;

			while (ny != null) {
				if (!annenMengde.inneholder(ny.data)) {
					return false;
				}
				ny = ny.neste; // Oppdater ny til neste node
			}
			return true;

		}

		@Override
		public boolean erLik(MengdeADT<T> annenMengde) {

			Node ny = forste;

			while (ny != null) {
				// Sjekk om annenMengde ikke inneholder elementet
				if (!annenMengde.inneholder(ny.data) || antall != annenMengde.antallElementer()) {
					return false;
				}
				ny = ny.neste; // Oppdater ny til neste node
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

			if (this.erLik(annenMengde)) {
				return temp;
			}

			Node ny = forste;

			while (ny != null) {

				if (annenMengde.inneholder(ny.data)) {
					temp.leggTil(ny.data);
				}
			}
			return temp;
		}

		@Override
		public void leggTil(T element) {

		}

		@Override
		public void leggTilAlleFra(MengdeADT<T> annenMengde) {
			

		}

		@Override
		public T fjern(T element) {
			// TODO Auto-generated method stub
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

}
