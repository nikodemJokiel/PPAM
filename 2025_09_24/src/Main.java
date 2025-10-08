import java.io.File;
import java.io.FileNotFoundException;
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

    public static void PrimeFactors(Scanner sc) { //jeszcze nie działa
        int mostFactors = 0;
        int result1 = 0;
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.next());

            int factorsCount = 1;
            for (int i = 2; n >= 0; i++) {
                while (n % i == 0) {
                    factorsCount++;
                    n /= i;
                }
            }
            if(factorsCount >= mostFactors){
                mostFactors = factorsCount;
                result1 = n;
            }
        }
        System.out.println(mostFactors);
        System.out.println(result1);
    }
    public static void main(String[] args) {
        File file = new File("C:\\Users\\student\\IdeaProjects\\2025_08_24\\Dane_2205\\liczby.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        FirstLastDigit(sc);
        PrimeFactors(sc);//jeszcze nie działa

    }
}