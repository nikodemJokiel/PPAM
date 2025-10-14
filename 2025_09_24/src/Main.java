import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void FirstLastDigit(Scanner sc) {
        int counter = 0;
        boolean writeFirstNum = true;
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.next());
            int lastDigit = n % 10;
            int firstDigit = 0;
            int temp = n;
            while (temp > 0) {
                firstDigit = temp % 10;
                temp = temp / 10;
            }
            if(firstDigit == lastDigit){
                counter++;
                if(writeFirstNum){
                    System.out.println(n);
                    writeFirstNum = false;
                }
            }
        }

        System.out.println(counter);
    }

    public static void PrimeFactors(Scanner sc) {
        int mostFactors = 0;
        int mostDifferentFactors = 0;
        int result1 = 0;
        int result2 = 0;
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.next());
            int temp = n;
            int factorsCount = 0;
            int differentFactorsCount = 0;
            int div = 2;
            while(temp > 1){
                boolean hasFactor = false;
                while(temp % div == 0){
                    factorsCount++;
                    temp = temp / div;
                    if(!hasFactor){
                        differentFactorsCount++;
                    }
                    hasFactor = true;
                }
                div++;

            }
            if(factorsCount > mostFactors){
                mostFactors = factorsCount;
                result1 = n;
            }
            if(differentFactorsCount > mostDifferentFactors){
                mostDifferentFactors = differentFactorsCount;
                result2 = n;
            }
        }
        System.out.println(result1 + " " + mostFactors);
        System.out.println(result2 + " " + mostDifferentFactors);
    }

    public static void Triple(Scanner sc) {
        List<Integer> numbers = new ArrayList<>();
        while(sc.hasNext()) {
            numbers.add(sc.nextInt());
        }
        int size = numbers.size();
        int counter = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(numbers.get(j) % numbers.get(i) == 0 && numbers.get(i) != numbers.get(j)){
                    for(int k = 0; k < size; k++){
                        if(numbers.get(k) % numbers.get(j) == 0 && numbers.get(j) != numbers.get(k)){
                            System.out.println(numbers.get(i) + " " + numbers.get(j) + " " + numbers.get(k));
                            counter++;
                        }
                    }
                }
            }
        }
        System.out.println("number of triples: " + counter);
    }

    public static void Fifths(Scanner sc) {
        List<Integer> numbers = new ArrayList<>();
        while(sc.hasNext()) {
            numbers.add(sc.nextInt());
        }
        int size = numbers.size();
        int counter = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(numbers.get(j) % numbers.get(i) == 0 && numbers.get(i) != numbers.get(j)){
                    for(int k = 0; k < size; k++){
                        if(numbers.get(k) % numbers.get(j) == 0 && numbers.get(j) != numbers.get(k)){
                            for(int l = 0; l < size; l++){
                                if(numbers.get(l) % numbers.get(k) == 0 && numbers.get(k) != numbers.get(l)){
                                    for(int m = 0; m < size; m++){
                                        if(numbers.get(m) % numbers.get(l) == 0 && numbers.get(l) != numbers.get(m)){
                                            System.out.println(numbers.get(i) + " " + numbers.get(j) + " " + numbers.get(k) + " " + numbers.get(l) + " " + numbers.get(m));
                                            counter++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("number of fifths: " + counter);
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Nikodem\\Documents\\GitHub\\PPAM\\2025_09_24\\Dane_2205\\liczby.txt"); //chanage your local path
        Scanner sc = null;
        Scanner sc2 = null;
        Scanner sc3 = null;
        Scanner sc4 = null;
        try {
            sc = new Scanner(file);
            sc2 = new Scanner(file);
            sc3 = new Scanner(file);
            sc4 = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println("zad4.1");
        FirstLastDigit(sc);
        System.out.println("\n");
        System.out.println("zad4.2");
        PrimeFactors(sc2);
        System.out.println("\n");
        System.out.println("zad4.3a");
        Triple(sc3);
        System.out.println("\n");
        System.out.println("zad4.3b");
        Fifths(sc4);

    }
}