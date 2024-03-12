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
		
		tomTabell = new TabellMengde<>(2);
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
	void leggTil() {
		
		tomTabell.leggTil(1);
		tomTabell.leggTil(2);
		tomTabell.leggTil(3);
		tomTabell.leggTil(4);
		
		assertEquals(4, tomTabell.antallElementer());
	}

	
	@Test
	void leggTilAlleFra() {
		
		tabellMedToElementer.leggTilAlleFra(tabellMedFemElementer);
		assertEquals(5, tabellMedToElementer.antallElementer());
		tabellMedToElementer.leggTilAlleFra(tomTabell);
		assertEquals(5, tabellMedToElementer.antallElementer());
		
		tabellMedToElementer.leggTilAlleFra(tabellMedIngentingTilFelles);
		assertEquals(7, tabellMedToElementer.antallElementer());
	}

	@Test
	void testFjernElement() {
		
		tabellMedToElementer.fjern(3);
		
		assertEquals(1, tabellMedToElementer.antallElementer());
		assertFalse(tabellMedToElementer.inneholder(3));
		
		tabellMedToElementer.fjern(5);
		
		assertTrue(tabellMedToElementer.erTom());
		
		
		
	}
	
	
	@Test
	void testAntallElementer() {
		
		assertEquals(2, tabellMedToElementer.antallElementer());
		assertEquals(5, tabellMedFemElementer.antallElementer());
		assertEquals(0, tomTabell.antallElementer());
		
		tomTabell.leggTil(3);
		
		assertEquals(1, tomTabell.antallElementer());
	}
	
	
	
}
