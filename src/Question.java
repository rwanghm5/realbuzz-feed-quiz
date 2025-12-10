/* Irene Feng 10/12/2022
A question class with Answers.
*/ 
import java.util.Scanner;

public class Question {
    // Fields
    String label;
    Answer[] possibleAnswers = new Answer[3];

    Question(String label) {
        this.label = label;
    }

    // ask a question, and return the category that corresponds to the answer
    Category ask(Scanner sc) {
        System.out.println(this.label);
        // prints out all the answer choices
        for (int i = 0; i < this.possibleAnswers.length; i++) {
            String choice = Integer.toString(i + 1);
            System.out.println("[" + choice + "]:" +
                    this.possibleAnswers[i].label);
        }
        int ans;
        while(true){
            boolean checker=sc.hasNextInt();
            ans = sc.nextInt();
            if(ans<=3&&checker==true)
                break;
            else
                System.out.println("Please enter an integer between 1-3");}
        return possibleAnswers[ans - 1].cat;
    }

}
