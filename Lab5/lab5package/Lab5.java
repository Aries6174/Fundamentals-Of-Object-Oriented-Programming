//Author: Adrian Joel Jaspa
/* Lab 5: This code contains a system of what a basic coffee machine is, 

*/

package lab5package;

import java.util.Scanner;

public class Lab5 {
    private Report report; // Calling report
    private Menu menu; // Calling menu

    public Lab5() {
        int water = 1500; // Setting the limit of water
        int milk = 1500; // Setting the limit of milk
        int coffee = 500; // Setting the limit of coffee
        double money = 0; // Setting the earnings as 0 since its starting
        report = new Report(water, milk, coffee, money); // Creating an instance of report which passes 4 values.
    }

    private double insert() {
        Scanner scanner = new Scanner(System.in);
        double exact = 0; // Will store the return value

        System.out.println("Insert the Following Coins.");

        while (true) {
            try { // Try Catch will catch the error if the input was either a string or an
                  // non-integer symbol
                System.out.println("Quarters:");
                int quarter = scanner.nextInt(); // Input of Quarters
                System.out.println("Dimes:");
                int dime = scanner.nextInt(); // Input of Dime
                System.out.println("Nickels:");
                int nickel = scanner.nextInt(); // Input of Nickels
                System.out.println("Pennies:");
                int penny = scanner.nextInt(); // Input of Pennies

                double totalValue = 0.0; // Initiating total Value

                // Multiplies the value of each coin to the number of coins that was inputted by
                // the user.
                totalValue += quarter * Money.getQuarter();
                totalValue += dime * Money.getDime();
                totalValue += nickel * Money.getNickel();
                totalValue += penny * Money.getPenny();

                exact += totalValue; // adding it inside exact

                System.out.printf("Total value: $%.2f", exact); // Printing the total value with the exact, aswell as
                                                                // making sure its only 2 decimal places
                System.out.println(" ");
            } catch (java.util.InputMismatchException e) { // If string or non-integer symbol is inputted
                System.out.println("Invalid input. Please enter a valid number."); // Will run the code again until it
                                                                                   // get the right input
                scanner.nextLine(); // Consume the invalid input
            }

            System.out.println("Insert more coins? (Y/N)"); // If the user wants to insert more coins
            String contInser = scanner.next().toLowerCase(); // Lowercase the input

            if (!contInser.equals("y")) { // If the user want to input more, it will run the code again and will add up
                                          // the new value of coin inside exact.
                break;
            }
        }
        return exact;// will return exact.
    }

    private void makeDrink(String input) {
        Menu order = null; // everytime the a drink is made clearing the order making sure.

        if ("latte".equals(input)) {
            order = new Latte(); // order is set to latte
        } else if ("espresso".equals(input)) {
            order = new Espresso(); // order is set to espresso
        } else if ("cappuccino".equals(input)) {
            order = new Cappuccino(); // order is set to cappuccino
        } else if ("empty".equals(input)) {
            order = new EmptyOut(); // clearing the ingridients
        } else {
            return; // if nothing happens return
        }

        while (true) {
            if (report.Reporting(order)) { // if there is an order
                double price = order.getPrice(); // initialize price to be order.getPrice();
                double insert = insert(); // initializing insert to be insert()
                // Perform the rest of the drink-making logic here

                if (insert < price) { // If there is not enough money return the prints and run main again
                    System.out.println(" ");
                    System.out.println("Sorry not enough money. Money refunded");
                    break;
                } else if (insert >= price) { // if the insert is greater than the price
                    double change = insert - price; // subtract to get the change
                    if (change > 0) { // The printing for the change
                        System.out.printf("Your change is $%.2f.", change);
                    } else if (change == 0) { // if there is no change
                        System.out.println("We recieve exact amount. Therefore No change. ");
                    }
                    // Printing the order
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("Preparing your Order, Please wait...");
                    try {
                        Thread.sleep(3000); // delaying 3 seconds
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    report.makeCoffee(order); // makes the coffee
                    System.out.println(" ");
                    System.out.println(
                            "Your Order is done. Please take your " + order.getName() + ". Thank you and enjoy <3. "); // Thanking
                                                                                                                       // for
                                                                                                                       // the
                                                                                                                       // order
                    try {
                        Thread.sleep(1500); // delaying 1.5 seconds
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                }
            } else if (report.waterStatus(order) < order.getWater()) { // If the water is not enough It will refill
                                                                       // automatically
                report.waterRefill();
                System.out.println(" ");
                System.out.println("Not Enought Water. Now Refilling Water");
                try {
                    Thread.sleep(3000); // delays 3 seconds
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Water is now refilled");
            } else if (report.milkStatus(order) < order.getMilk()) { // if the milk is not enough it will refill
                                                                     // automatically
                report.milkRefill();
                System.out.println(" ");
                System.out.println("Not Enough Milk. Refilling Milk");
                try {
                    Thread.sleep(3000); // delays 3 seconds
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Milk is now refilled");
            } else if (report.coffeeStatus(order) < order.getCoffee()) { // if the coffee is not enough it will refill
                                                                         // automatically
                report.coffeeRefill();
                System.out.println(" ");
                System.out.println("Not Enough Coffee. Restocking Coffee");
                try {
                    Thread.sleep(3000); // delay 3 seconds
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Coffee is now in stock");
                System.out.println(" ");
            }
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean run = true; // boolean for the while statement

        // introduction
        while (run) {
            System.out.println("""

                    ╔╦╦╦═╦╗╔═╦═╦══╦═╗ ╔══╦═╗ .╔╦═╦══╦═╦═╦══╗ ╔═╦═╦═╦═╗
                    ║║║║╦╣╚╣╠╣║║║║║╦╣ ╚╗╔╣║║ ╔╝║╩╠╗╚╣╔╣╩╠╗╚╣ ║╠╣╩║╔╣╦╣
                    ╚══╩═╩═╩═╩═╩╩╩╩═╝ .╚╝╚═╝ ╚═╩╩╩══╩╝╚╩╩══╝ ╚═╩╩╩╝╚═╝
                                    """);

            System.out.println("Here is our Menu, What Would you Like?");
            System.out.println("Coffee          |   Price");
            System.out.println("Latte           |   $3.00");
            System.out.println("Espresso        |   $1.50");
            System.out.println("Cappuccino      |   $4.00");
            System.out.println("---------------------------------------");

            String input = scanner.nextLine().toLowerCase();

            if ("latte".equals(input) || "espresso".equals(input) || "cappuccino".equals(input)
                    || "empty".equals(input)) { // If choosing one of the coffee menu or emptying out the machine
                makeDrink(input); // runs the makeDrink method with the input
            } else if ("report".equals(input)) { // Prints out the report
                System.out.println(" ");
                System.out.println("Here is the Status of the resources: ");
                report.printReport(); // prints the status of each ingridient and the earnings
                try {
                    Thread.sleep(3000); // delay for 3 seconds
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else if ("off".equals(input)) { // turning off the machine
                System.out.println(" ");
                System.out.println("Turning off machine, please wait...");
                System.out.println(" ");
                try {
                    Thread.sleep(3000); // delay for 3 seconds
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Bye Bye!");
                try {
                    Thread.sleep(1000); // delay for 1 second
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print("\033c"); // clears the terminal
                run = false; // the code stops looping

            } else { // if the input is not one of the choices
                System.out.println("Please choose one of the choice given.");
            }
        } // loop ends

    }

    // main
    public static void main(String[] args) {
        Lab5 lab5 = new Lab5();
        lab5.run(); // running run
    }

}
