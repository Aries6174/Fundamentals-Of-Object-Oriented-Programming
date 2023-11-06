//Author: Adrian Joel Jaspa
//Subject CMSC 22


import java.util.Scanner;                           //Scanner for inputs

public class lab2{
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);       //Scanner
        System.out.println("Enter a Number: ");       //Printing a the request
        long input1 = scanner.nextLong();               //insert the given to a variable, using long for bigger values
        boolean pryme = true;                           //Boolean for future use

        if (input1 < 2){                                //if statement determining if its not 0, 1, and a negative number
            pryme = false;                              //if it is, then it is false
        }else{                                          //if greater than zero
            for(long i = 2; i * i <= input1; i++){      //for loop that starts from 2, limits to the input1, and increments
                if (input1 % i == 0){                   //if the remainder is 0
                    pryme = false;                      //it is not Prime
                    break;                              //ends the loop
                }
            }
        }

        if(pryme == true){                                                              //if True it is Prime
            System.out.println(input1 + " is indeed a Prime number. Shiny!");
        }else{                                                                          //if False it is not Prime
            System.out.println(input1+ " is not a Prime number. :(");
        }
            
        scanner.close();                                //Scanner close
    }
}
    