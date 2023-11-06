//Author: Adrian Joel Jaspa
//Subject: CMSC 22
//Activity: This activity is about printing the inputted dates by the user as well as printing a Calender correlating to the inputted information.
//          the activity also uses a built-in java function that allows the programmer to get the necessary way of printing the Date using Date Time Formatter
//          aswell as the calendar with correct positions, spacings, alignments, and amount of dates, using LocalDate.

import java.time.format.DateTimeFormatter;                                              //Importing DateTimeFormatter for the Format (MMMM, yyyy)
import java.time.LocalDate;                                                             //Importing the LocalDate for the information about the date
import java.util.Scanner;                                                               //Importing Scanner for the imports

public class lab4{                                                                      //Class Name
    public static void main(String[] args){                                             //Main
        Scanner scanner = new Scanner(System.in);                                        
        boolean input = true;
        System.out.println(" ");
        System.out.print("Please Enter month: ");                                     //Printing the message request for Month
        int month = scanner.nextInt();
        System.out.print("Please Enter year (1 - 10000): ");                          //Printing the message request for Year
        int year = scanner.nextInt();
        
        while(input){
            if(month > 12 || month < 1 || year > 10000 || year < 1){  
                System.out.println("Your inputs is out of bounds please try again.");
                System.out.println(" ");                                              //If one of the numbers is OUT OF BOUNDS
                System.out.print("Please Enter month: ");                             //Printing the message request for Month
                month = scanner.nextInt();
                System.out.print("Please Enter year (1 - 10000): ");                  //Printing the message request for Year
                year = scanner.nextInt();
            }else{                                                                      //If it is not out of bounds     
                LocalDate date = LocalDate.of(year, month, 1);               //Initialize date with the LocalDate.of year and month, day is only 1 since
                                                                                        //          the only time we use the day is to determine the first day of the month
                Calendar(date);
                input = false;                                                          //Run the method with the parameter date
            }
        }

        scanner.close();                                                         
    }

    public static void Calendar(LocalDate date){                                        //Method Calendar: create a calendar, parameters is the date
        int lengthMonth = date.lengthOfMonth();                                         //We use length month to know whether or not the day starts at 29, 30 or 31
        int spaces = date.getDayOfWeek().getValue();                                    //Determines which day the first day of the month starts,(Sunday, Monday, Tuesday, etc.)

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM, yyyy");      //Formats the exact way of printing that was shown in the example i.e. "December, 2022"
        System.out.println(date.format(dtf));                                           //Prints the format
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");                            //Prints the days of the Week

        if(spaces < 7){                                                                 //If Spaces is 7 then there is no point to add a whole line of empty space
            spaces = spaces + 1;                                                        //Adds 1 to space since space
            for (int i = 0; i < spaces-1; i++) {                                        //Loop statement to determine the amount of spaces needed to print at the start
                System.out.printf("    ");                                       //Prints the spaces     
            }
        }else{                                                                          //If the first day of the months starts at Sunday
            spaces = 1;                                                                 //Spaces will be 1 and no need to print any blanks
        }                                                                               //Space will be used for the next Loop statement below
    
        for (int i = 1 ; i <= lengthMonth; i++){                                        //Print looping for each day of the month
            System.out.printf("%3d ", i);                                        //Format the aligns the days of the month properly and prints i

            if(spaces == 7){                                                            //If spaces has reached the last day of the week
                System.out.println();                                                   //Prints the next line
                spaces = 0;                                                             //We start with 0 since we are about to increment at the end of the line of this method
            }
        
        spaces++;                                                                       //Spaces increments
        }

        System.out.println();                                                           //Line print for visibilty

    }
}