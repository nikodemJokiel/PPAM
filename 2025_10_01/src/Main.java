import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int RollTheDice(){
        return (int) ((Math.random() * 6 ) + 1);
    }

    public static int CountScore(List<Integer> scores){

        int score = 0;
        for(int i = 1; i <= 6; i++){
            int counter = 0;
            for(int j = 0; j < scores.size(); j++){
                if(i == scores.get(j)) {
                    counter++;
                }
            }
            if(counter >= 2) {
                score = score + (i * counter);
            }
        }
        return score;
    }
    public static void main(String[] args) {
        boolean exit = false;
        Scanner input = new Scanner(System.in);
        int choice;

        while(!exit){
            List<Integer> scores = new ArrayList<>();
            do{
                System.out.print("Ile kostek chcesz rzucić?(3-10)\n");
                choice = input.nextInt();
            }while(choice < 3 || choice > 10);
            for(int i = 0; i < choice; i++){
                int diceRoll = RollTheDice();
                System.out.println("Kostka " + (int)(i+1) + ": " + diceRoll);
                scores.add(diceRoll);
            }
            System.out.println("Liczba uzyskanych punktów: " + CountScore(scores));
            String answer;
            do{
                System.out.println("Jeszcze raz? (t/n)");
                answer = input.next();

            }while(!answer.equals("t") && !answer.equals("n"));
            if(answer.equals("n")){
                exit = true;
            }
        }
    }
}