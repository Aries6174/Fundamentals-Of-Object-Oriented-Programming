// Author: Adrian Joel Jaspa   
// Subject: CMSC 22

import java.util.Scanner;

public class lab3{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);           //Scanner
        String randomWord = WordGenerator.generateWord();   //Generates a random word in the given class
        boolean gameStart = true;                           //Will determine whether or not the 
        int lives = 5;                                      //Number of lives
        int wordLength = randomWord.length();               //Counts the number of letters that exist in the word (For printing blanks and For-Loops)
        int correctGuess = 0;                               //If correctGuess is equal to word length the game would end (only if the player manages to guess all)
        char [] letter = randomWord.toCharArray();          //Stores each letter inside the array called letter (For comparing the input and each letter)
        char [] guess = new char[wordLength + 5];           //Stores the guesses of the player (Also will records the previously corrected guesses)

        //Printing of the Title of the Lab Activity
        System.out.println("\n");
        System.out.println("=*=*=*=*=*=*=*=*=*=*=");
        System.out.println("=  H A N G - M A N  =");
        System.out.println("=*=*=*=*=*=*=*=*=*=*=");
        System.out.println("\n");


        //THE GAME
        while (gameStart) {                                   // Will run the game, if false, then it means the game ends and the program stops
            boolean guessedCorrectly = false;                 // Flag to track if a correct guess was made, its put in here instead outside of the loop because we have to check each inputted letter by the player is correct and will affect the lives

            //For Loops that prints the Right and hidden letters every turn.
            for (int i = 0; i < wordLength; i++) {            // Will run based on how many letters exist in Generated Word(Example: reference = will run 9 times)
                if (guess[i] == letter[i]) {                  // if the guessed number is the same as one of the letters
                    System.out.print(letter[i] + " ");        // will print that letter
                } else {
                    System.out.print("_ ");                 // if not will print a blank space instead
                }
            }

            //Printing of inputs
            System.out.println("\n");
            System.out.println("Lives left: " + lives);        // Printing the current lives of the player
            System.out.println("Enter a letter: ");          // Asking for the letter
            String userInput = scanner.next();                 // storing the answer as a string since scanner cant use char
            char input = userInput.toLowerCase().charAt(0);            // converting the first letter of that string as a char and storing it in a variable
            System.out.println("\n");           

            //Determining if the letter is the same with at least 1 letter or not
            for (int i = 0; i < wordLength; i++) {              // Will run based on the amount of Letters that Exist in the Generated Words
                if (input == letter[i] && guess[i] != input) {  // To determine if the input is the same the as one of the letters, but also isnt a duplicated guess
                    guess[i] = input;                           // Will change that part of the array(guesses) as the same letter as the array of the right letters
                    correctGuess++;                             // Increases correctGuesses for future use
                    guessedCorrectly = true;                    // will check if the guess of the player is true and will determine the lives
                }
            }

            if (!guessedCorrectly) {                            // If a players answer is wrong
                lives--;                                        // Minus a life
            }

            //Finale
            if(wordLength == correctGuess){                     //if the Correct Guesses are the same with the Word Length
                for (int i = 0; i < wordLength; i++) {          //will run based on the number of letters in the generated word
                    if (guess[i] == letter[i]) {                //if the guess is the same as the letter
                        System.out.print(letter[i] + " ");      //will print the letter
                }
                }

                //Since the wordLength is Equal to the correct guess that means the whole word is revealed without losing any Lives 
                //Will Print out the Celebratory Congraturations
                System.out.println("\n");
                System.out.println("=*=*=*=*=*=*=*=*=*=*="); 
                System.out.println("= CONGRATURATIONS!! =");
                System.out.println("=*=*=*=*=*=*=*=*=*=*="); 
                System.out.println("\n");
                gameStart = false;                              //Stops the while loop and ends the game

            }else if(lives == 0){                               // if lives ran out, will give a YOU LOSE message
                System.out.println("=*=*=*=*=*=*=*=*=*=*=");
                System.out.println("=  Y O U   L O S E  =");
                System.out.println("=*=*=*=*=*=*=*=*=*=*="); 
                System.out.println("\n");
                gameStart = false;                              //Stops the while loop and ends the game


                // if none of these if statements get triggered the while loop will run again
            }
                

            
        }

    }





}

