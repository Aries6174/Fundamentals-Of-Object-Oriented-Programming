/* Author: Adrian Joel Jaspa
 * Lab 6: Tamagotchi activity.
 * 
 * File name: Tamagotchi.java
 * Contains all the necessary attributes, commands, and instances for Tamagotchi.java
 */

package lab6package;

public class Pet {

    // Setting up the instance and declaring the properties
    private static Pet instance = null; // Setting it to null
    protected int hunger;
    protected int happiness;
    protected int train;

    private Pet() { // Setting up the attributes
        this.hunger = 50;
        this.happiness = 25;
        this.train = 10;
    }

    // Thread-safe Singleton instance
    public static Pet getInstance() {
        if (instance == null) {
            synchronized (Pet.class) {

                if (instance == null) {
                    instance = new Pet();
                }
            }
        }
        return instance;
    }

    // Moves the location of the Pet
    public static Pet movePet(String location) {
        switch (location) {
            case "lobby":
                return new Lobby();
            case "kitchen":
                return new Kitchen();
            case "playground":
                return new Playground();
            case "training room":
                return new TrainingRoom();
            default:
                return null;
        }
    }

    // Placeholders for eat, play, and train
    void eat() {
        System.out.println("You cant eat here!");
    }

    void play() {
        System.out.println("You can't play here!");
    }

    void train() {
        System.out.println("You can't train here!");
    }

    // Getters for getting the hunger, happiness, and train of the pet
    public int getHunger() {
        Pet pet = Pet.getInstance();
        return pet.hunger;
    }

    public int getHappiness() {
        Pet pet = Pet.getInstance();
        return pet.happiness;
    }

    public int getTrain() {
        Pet pet = Pet.getInstance();
        return pet.train;
    }

    // Location: LOBBY.
    // All 3 commands are allowed.
    public static class Lobby extends Pet {
        Pet pet = Pet.getInstance();

        @Override
        public void eat() {
            if (pet.hunger >= 15 || pet.train >= 1) {
                System.out.println("Your pet is being fed <3.");
                pet.hunger -= 15;
                pet.happiness += 5;
                pet.train -= 10;
            } else {
                System.out.println("Your pet is not hungry or too fat for now. -_-");
            }
        }

        @Override
        public void play() {
            if (pet.hunger <= 100) {
                System.out.println("Your pet is playing <3.");
                pet.hunger += 10;
                pet.happiness += 15;
            } else {
                System.out.println("Your pet does not have the energy to play D:");
            }
        }

        @Override
        public void train() {
            if (pet.hunger <= 100 || pet.happiness > 10) {
                System.out.println("Your pet is training <3.");
                pet.happiness -= 10;
                pet.hunger += 20;
                pet.train += 10;
            } else {
                System.out.println("Your pet does not have the energy or is too sad to Train ;-;");
            }
        }
    }

    // Location: KITCHEN
    // Only eating is allowed
    public static class Kitchen extends Pet {
        Pet pet = Pet.getInstance();

        @Override
        public void eat() {
            if (pet.hunger >= 15 && pet.train >= 1) {
                System.out.println("Your pet is being fed <3.");
                pet.train -= 10;
                pet.hunger = 0;
                pet.happiness += 5;
            } else {
                System.out.println("Your pet is not hungry or too fat for now.");
            }
        }
    }

    // Location: Playground
    // Only playing is allowed
    public static class Playground extends Pet {
        Pet pet = Pet.getInstance();

        @Override
        public void play() {
            if (pet.hunger <= 100) {
                System.out.println("Your pet is playing <3.");
                pet.hunger += 10;
                pet.happiness += 25;
            } else {
                System.out.println("Your pet does not have the energy to play D:");
            }
        }
    }

    // Location: Training Room
    // Only training is allowed
    public static class TrainingRoom extends Pet {
        Pet pet = Pet.getInstance();

        @Override
        public void train() {
            if (pet.hunger <= 100 || pet.happiness >= 5) {
                System.out.println("Your pet is training <3.");
                pet.happiness -= 10;
                pet.hunger += 20;
                pet.train += 20;
            } else {
                System.out.println("Your pet does not have the energy or is too sad to Train ;-;");
            }
        }
    }
}