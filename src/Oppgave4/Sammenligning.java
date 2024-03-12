package Oppgave4;

import java.util.HashSet;
import java.util.Random;
import java.util.Arrays;

public class Sammenligning {

    private static HashSet<Integer> hash = new HashSet<>(100000);
    private Integer[] integerArray = new Integer[100000];
    
    
    public void leggTilNummer(HashSet<Integer> h, Integer[] I) {
        int tall = 376;
        
        for (int i = 0; i < 100000; i++) {
            h.add(tall);
            I[i] = tall;
            tall = (tall + 45713) % 1000000;
        }
    }
    
    public Integer[] genererTall() {
        Integer[] randomNumbers = new Integer[10000];
        Random random = new Random();

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(1000000); 
        }
        
        return randomNumbers;
    }
    
    public static int countOccurrences(Integer[] array, Integer target) {
        int firstIndex = Arrays.binarySearch(array, target); 
        if (firstIndex < 0) {
           
            return 0;
        }

        int lastIndex = firstIndex + 1;
        int count = 1;

        // Count occurrences to the left of the first index
        while (firstIndex >= 0) {
        	if (array[firstIndex] == target) {
            count++;
        	}
            firstIndex--;
        }

        // Count occurrences to the right of the last index
        while (lastIndex < array.length) {
        	if (array[lastIndex] == target) {
            count++;
        	}
            lastIndex++;
        }

        return count;
    }


    
    public int[] sokTabell(Integer[] randomTall) {
    	long startTime = System.currentTimeMillis();
    	
        int[] funnetTall = new int[10000];
        for (int i = 0; i < randomTall.length; i++) {
        	if (Arrays.binarySearch(integerArray, randomTall[i]) >= 0) {
            funnetTall[i] = countOccurrences(integerArray, randomTall[i]);
        	}
        }
        
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Tabellsok ferdig! " + elapsedTime + " ms");
        System.out.println();
        return funnetTall;
    }
    
    public static int[] sokHash(Integer[] randomTall) {
    	long startTime = System.currentTimeMillis();
    	
        int[] funnetTall = new int[10000];
        for (int i = 0; i < randomTall.length; i++) {
        	if (hash.contains(randomTall[i])) {
            funnetTall[i] = countOccurrencesHash(randomTall[i]);
        	}
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Hashsok ferdig! " + elapsedTime + " ms");
        System.out.println();
        return funnetTall;
    }

    public static int countOccurrencesHash(Integer target) {
        int count = 0;
        for (Integer num : hash) {
            if (num.equals(target)) {
                count++;
            }
        }
        return count;
    }

    
    public static void main(String[] args) {
        Sammenligning sammenligning = new Sammenligning();
        sammenligning.leggTilNummer(hash, sammenligning.integerArray);
        Arrays.sort(sammenligning.integerArray);
        Integer[] randomtall = sammenligning.genererTall();
        int[] funnetHash = sokHash(randomtall);
        int[] funnetTabell = sammenligning.sokTabell(randomtall);
        
      
        boolean erLik = Arrays.equals(funnetTabell, funnetHash);
        if (erLik) {
            System.out.println("Begge er like!");
        } else {
            System.out.println("Noko er feil!");
            for (int i = 0; i<funnetHash.length; i++) {
            System.out.print(funnetHash[i] + " ");
            }
            
            System.out.println();
            
            for (int i = 0; i<funnetHash.length; i++) {
            System.out.print(funnetTabell[i] + " ");
            }
        }
    }
}
