// Author: Adrian Joel Jaspa
/* Lab 6: Tamagotchi activity.
 *
 * File name: Tamagotchi.java
 * Creating a Tamagotchi Pet wherein it implements Sigleton Instance as well as using a Factory Design Pattern.
 */

package lab6package;

import java.util.Scanner;

public class Tamagotchi {

    private Pet pet; // Setting pet

    public void run() { // Main
        Scanner scanner = new Scanner(System.in); // Scanner
        boolean play = true; // For the Looping

        System.out.println("""

                                               ▄   ▄
                                               █▀█▀█
                                               █▄█▄█
                                                ███  ▄▄
                                                ████▐█ █
                                                ████   █
                                                ▀▀▀▀▀▀▀
                ╔╦╦╦╦═╦╦╦═╦══╦══╦═╦══╦══╦══╦══╦═╦═╦═╦═╦═╦╦╦╦═╦══╦═╦═╦══╦══╦═╦══╦══╦══╦═╦╗
                ║║║║║═╣║║╔╣╔╗║║║║═╣  ╚╣╠╣╔╗║  ╚╗║║║╚╣░║║║╚╝║╚╣  ║░║═╬╣╠╝  ║╚╬╣╠╣╔╗║░░║═╣║
                ║║║║║═╣╚╣╚╣╚╝║║║║═╣   ║║║╚╝║  ╔╣║╩╠╗║╔╣╩║  ╠╗║  ║╔╣═╣║║   ╠╗║║║║╚╝║╔╗╣═╣║
                ║╚══╩═╩═╩═╩══╩╩╩╩═╝   ╚╝╚══╝  ╚═╩╩╩═╩╝╚╩╝  ╚═╝  ╚╝╚═╝╚╝   ╚═╝╚╝╚══╩╝╚╩═╝║
                ╚═══════════════════════════════════════════════════════════════════════╝
                    """); // Logo

        // Asking What kind of Animal
        Delay(2000);
        System.out.println("What kind of Pet did you get? ");
        System.out.print("Kind: ");
        String petKind = scanner.next();
        scanner.nextLine();

        // Asking what the name of the Animal
        System.out.println("What's the name of your pet?  ");
        System.out.print("Name: ");
        String petName = scanner.next();
        scanner.nextLine();

        // Adopting that animal
        System.out.println("Thank you for adopting " + petName + ". Please take care <3");

        // Going to the Main Location
        pet = Pet.getInstance();
        String current = "lobby";
        pet = Pet.movePet(current);
        Delay(1500);

        // Loop Begins
        while (play) {
            // Prompting the user the options
            System.out.println("\n");
            System.out.println("What do you want " + petName + " to do? ");
            System.out.print("""
                    1.) Eat
                    2.) Play
                    3.) Train
                    4.) Go somewhere
                    5.) Check your Pet
                    Choice:  """);
            String choice = scanner.next().toLowerCase();

            // Switch case of all the options
            switch (choice) {
                case "eat": // If user wants to feed their pet
                    pet.eat();
                    Delay(1500);
                    break;
                case "play": // If user wants their pet to play
                    pet.play();
                    Delay(1500);
                    break;
                case "train": // If user wants their pet to train
                    pet.train();
                    Delay(1500);
                    break;
                case "go": // If user wants to change location
                    scanner.nextLine();
                    System.out.println("Where do you want " + petName + " to go? ");
                    String location = scanner.nextLine().toLowerCase();
                    // If they're already in that current area
                    if (location.equals(current)) {
                        System.out.println("You are already in " + location + ". No need to transfer!");
                        Delay(1500);
                        break;
                    }

                    // Changes the location of the pet
                    pet = Pet.movePet(location);

                    // Testing if there are chances where Instance becomes null
                    if (pet == null) {
                        System.out.println("Whatever you printed. It ain't here Yo.");
                        break;
                    }

                    // If none of the if statements are triggered, move to the location mentioned
                    System.out.println("Heading to " + location + "...");
                    Delay(1500);
                    current = location;
                    break;

                case "display": // displaying the pet's Current Status, Name, Kind, and Current Location
                    if (pet != null) {
                        displayStatus(pet, petName, current, petKind);
                        Delay(1500);
                        break;
                    } else { // Else statement if the Pet was not Intiallized. Being tested...
                        System.out.println("Pet is not initialized. Please go somewhere first");
                        break;
                    }

                case "exit": // Exit, also allowed in every locations
                    play = false;
                    System.out.print("\033c");
                    scanner.close();
                    break;

                default:
                    System.out.println("Your choice is not one of the choices above. ");
            }
        }
    }

    // Displaying the status of the Pet
    public void displayStatus(Pet pet, String petName, String location, String petKind) {
        System.out.println("\n");
        System.out.println("=========" + petName.toUpperCase() + "========");
        System.out.println("Current Location: " + location);
        System.out.println("Animal: " + petKind);
        System.out.println("\n");
        System.out.println("Hunger: " + pet.getHunger());
        System.out.println("Happiness: " + pet.getHappiness());
        System.out.println("Train: " + pet.getTrain());
        System.out.println("=========" + petName.toUpperCase() + "========");
        System.out.println("\n");
    }

    // main
    public static void main(String[] args) {
        Tamagotchi gotchi = new Tamagotchi();
        gotchi.run();
    }

    // Delay Thread
    public static void Delay(int x) {
        try {
            Thread.sleep(x);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
