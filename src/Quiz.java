
/*
 * Irene Feng Nov 2022
 * This is the class where we create the Quiz and run it. It has the main method.  
 */
import java.util.Scanner;

public class Quiz {
        static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) throws Exception {
                // Create Categories
                Category Vanilla = new Category("Vanilla",
                                "You have fast hands and no patience. You enjoy high risk, high reward and you speed through everything.");
                Category NetheriteOP = new Category("Netherite OP", 
                                "You are a patient person, preferring to take it slow and steady and take a duel of attrition; boring but reliable.");
                Category SMP = new Category("SMP (Survival multiplayer)",
                                "You are a strategic mastermind. You strive under un-optimal conditions when the odds are against you. You don’t have a set strategy; you adapt to what is around you.");
                // Create Questions
                Question q1 = new Question("Which one of these colors resonates with you the most?");
                // Attach Answers to Questions
                q1.possibleAnswers[0] = new Answer("Red", Vanilla);
                q1.possibleAnswers[1] = new Answer("Gold", SMP);
                q1.possibleAnswers[2] = new Answer("Grey", NetheriteOP);

                Question q2 = new Question("The movie theater is empty; you can choose to sit wherever you like. Where do you go?");
                q2.possibleAnswers[0] = new Answer("Wherever’s open, you’re already walking", Vanilla);
                q2.possibleAnswers[1] = new Answer("Middle row, middle seat, perfect balance", NetheriteOP);
                q2.possibleAnswers[2] = new Answer("A spot with a good view and a quick exit route", SMP);

                Question q3 = new Question("You’re at a party with a bunch of executives, what are you doing?");
                q3.possibleAnswers[0] = new Answer("You're talking with the executives, that's the most strategic use of your time, you think", SMP);
                q3.possibleAnswers[1] = new Answer("You're playing on the basketball court; full energy", Vanilla);
                q3.possibleAnswers[2] = new Answer("You're lying on the sofa, scrolling and taking life slow", NetheriteOP);

                // ... more questions here

                // For each question, ask, read input, store answer.
                gameIntro();
                Question[] qList = { q1, q2 };
                for (Question q : qList) {
                        Category c = q.ask(sc);
                        c.points++;
                }
                // Get most common category from the questions asked
                // Return Category
                Category[] cList = { monopoly, catan, ers, hanabi };
                // these need to be in the same order or the points will be incorrect!
                int index = getMostPopularCatIndex(cList);
                System.out.println("If you were a board game, you would be " + cList[index].label + ". ");
                System.out.println(cList[index].description);

        }

        public static void gameIntro() {
                // requires 1 to keep going
                System.out.println("Which Board Game Are You?");
                System.out.println("You get to choose numbers 1-4 for every question. Enter '1' to play!");
                int play = sc.nextInt();
                if (play != 1) {
                        System.out.println("Unidentifiable input. Please enter '1' to play");
                        gameIntro();
                }
        }

        // returns the index that is the max
        // the tie breaker is the first Category that has the count is the "max" :/ 
        public static int getMostPopularCatIndex(Category[] counts) {
                int maxCount = 0;
                int maxIndex = 0;
                for (int i = 0; i < counts.length; i++) {
                        if (counts[i].points > maxCount) {
                                maxCount = counts[i].points;
                                maxIndex = i;
                        }
                }
                return maxIndex;
        }
}
