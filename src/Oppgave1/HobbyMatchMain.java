package Oppgave1;

public class HobbyMatchMain {

	static double match(Person a, Person b) {
		double antallFelles = 0;
		double antallKunHosA = 0;
		double antallKunHosB = 0;
		double antallTotalt = a.getHobbyer().length + b.getHobbyer().length;
		
		for (int i = 0; i<a.getHobbyer().length; i++) {
			boolean ingenForDen = true;
			for(int j = 0; j<b.getHobbyer().length; j++) {
				if (a.getHobbyer()[i] == b.getHobbyer()[j]) {
					antallFelles++;
					ingenForDen = false;
					break;
				} 
			}
			if (ingenForDen) {
				antallKunHosA++;
			}
		}
		for (int i = 0; i<b.getHobbyer().length; i++) {
			boolean ingenForDen = true;
			for(int j = 0; j<a.getHobbyer().length; j++) {
				if (b.getHobbyer()[i] == a.getHobbyer()[j]) {
					antallFelles++;
					ingenForDen = false;
					break;
				} 
			}
			if (ingenForDen) {
				antallKunHosB++;
			}
		}
		
		double match = antallFelles - (antallKunHosA + antallKunHosB) / antallTotalt;
		if (match >= 0) {
		match = match/antallTotalt * 100;
		} else {
			match = 0;
		}
		return match;
		
	}

	public static void main(String[] args) {
		Person Tommas = new Person("Tommas", "Svømming", "Klatring", "Gaming", "Gåtur");
		Person Grete = new Person("Grete", "Svømming", "Maling", "Skiing", "Gåtur");
		Person Alex = new Person("Alex", "Shopping", "Klatring", "Gaming", "Studering", "Drikking", "Kjøring", "Gåtur");
		
		System.out.println("Match mellom Alex og Alex = " + match(Alex,Alex) + " %");
		System.out.println("Match mellom Alex og Grete = " + match(Alex,Grete) + " %");
		System.out.println("Match mellom Grete og Alex = " + match(Grete,Alex) + " %");
		System.out.println("Match mellom Tommas og Grete = " + match(Tommas,Grete) + " %");
		System.out.println("Match mellom Tommas og Alex = " + match(Tommas,Alex) + " %");
		
	}
}
