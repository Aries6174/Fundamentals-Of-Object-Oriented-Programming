package lab5package;

//Initiating the variables needed
public abstract class Menu {
    protected String name;
    protected int priceWater;
    protected int priceMilk;
    protected int priceCoffee;
    protected double price;

    public String getName() { // returns the name
        return name;
    }

    public int getWater() { // returns the price of water
        return priceWater;
    }

    public int getMilk() { // returns the price of milk
        return priceMilk;
    }

    public int getCoffee() { // returns the price of coffee
        return priceCoffee;
    }

    public double getPrice() { // returns the price of the coffee inputted
        return price;
    }
}

class Latte extends Menu {
    // Information of Latte
    public Latte() {
        name = "Latte";
        priceWater = 90;
        priceMilk = 30;
        priceCoffee = 18;
        price = 3.00;
    }
}

class Espresso extends Menu {
    // Information of Espresso
    public Espresso() {
        name = "Espresso";
        priceWater = 30;
        priceMilk = 0;
        priceCoffee = 10;
        price = 1.50;
    }
}

class Cappuccino extends Menu {
    // Information of Cappuccino
    public Cappuccino() {
        name = "Cappuccino";
        priceWater = 30;
        priceMilk = 30;
        priceCoffee = 9;
        price = 4.00;
    }
}

class EmptyOut extends Menu {
    // Not asked in the instruction, this is only shown for refilling
    public EmptyOut() {
        name = "Empty";
        priceWater = 1500;
        priceMilk = 1500;
        priceCoffee = 500;
        price = 1000.00;
    }

}
