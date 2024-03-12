package Oppgave1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TabellMengdeTest {
	
	
	private MengdeADT<Integer> tabellMedToElementer;
	private MengdeADT<Integer> tabellMedFemElementer;
	private MengdeADT<Integer> tomTabell;
	private MengdeADT<Integer> tabellMedIngentingTilFelles;
	
	
	
	
	
	
	
	@BeforeEach
	void setUp() {
		
		tomTabell = new TabellMengde<>();
		tabellMedToElementer = new TabellMengde<>(5); 
		tabellMedFemElementer = new TabellMengde<>(5);
		tabellMedIngentingTilFelles = new TabellMengde<>(5);
	
		tabellMedToElementer.leggTil(3);
		tabellMedToElementer.leggTil(5);

		tabellMedFemElementer.leggTil(1);
		tabellMedFemElementer.leggTil(2);
		tabellMedFemElementer.leggTil(3);
		tabellMedFemElementer.leggTil(4);
		tabellMedFemElementer.leggTil(5);
		
		tabellMedIngentingTilFelles.leggTil(100);
		tabellMedIngentingTilFelles.leggTil(90);
		
		
		
	}
	
	
	
	@Test
	void nyTabellSkalVæreTom() {
		assertTrue(tomTabell.erTom());
		assertFalse(tabellMedToElementer.erTom());
	}
	
	@Test
	void tabellMedFlereElementerSkalIkkeVæreTom() {
		assertFalse(tabellMedToElementer.erTom());
		assertFalse(tabellMedFemElementer.erTom());
	}
	
	@Test
	void skalInneholdeElement() {
		assertTrue(tabellMedFemElementer.inneholder(5));
		assertTrue(tabellMedFemElementer.inneholder(2));
		assertTrue(tabellMedToElementer.inneholder(3));
	}
	
	@Test
	void tabellenInneholderIkkeDetteElementet() {
		assertFalse(tabellMedFemElementer.inneholder(6));
		assertFalse(tabellMedFemElementer.inneholder(8));
	
		
		
	}
	
	
	@Test
	void erDelmengdeAv() {
		assertTrue(tabellMedToElementer.erDelmengdeAv(tabellMedFemElementer));
	}
	
	
	@Test
	void erIkkeEnDelmengdeAv() {
		assertFalse(tabellMedFemElementer.erDelmengdeAv(tabellMedToElementer));
	}
	
	
	@Test
	void erDisjunkt() {
		assertTrue(tabellMedIngentingTilFelles.erDisjunkt(tabellMedToElementer));
	}
	
	@Test
	void ikkeDisjunkt() {
		assertFalse(tabellMedFemElementer.erDisjunkt(tabellMedToElementer));
	}
	
	
	@Test
	void snittAvToTabeller() {
		
		
		MengdeADT<Integer> snittet = tabellMedFemElementer.snitt(tabellMedToElementer);
		
		assertTrue(snittet.inneholder(3));
		assertTrue(snittet.inneholder(5));
		assertFalse(snittet.inneholder(10));
			
	}

	
	@Test
	void unionAvToTabeller() {
		
		MengdeADT<Integer> union = tabellMedFemElementer.union(tabellMedToElementer);
			
		assertTrue(union.inneholder(5));
		assertTrue(union.inneholder(1));
		assertTrue(union.inneholder(3));
		assertFalse(union.inneholder(100));
		assertFalse(union.inneholder(20));
		assertFalse(union.inneholder(7));
		
		
	}
	
	
	@Test
	void minusAvToTabeller() {
		
		MengdeADT<Integer> minus = tabellMedFemElementer.minus(tabellMedToElementer);
		
		assertTrue(minus.inneholder(1));
		assertTrue(minus.inneholder(2));
		assertTrue(minus.inneholder(4));
		assertFalse(minus.inneholder(3));
		assertFalse(minus.inneholder(5));
		
		
		
	}
	
	
	@Test
	void tes
	
	
	
}
