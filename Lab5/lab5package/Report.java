package lab5package;

public class Report {
    private int water;
    private int milk;
    private int coffee;
    private double money;

    // Encapsulation of water, milk, coffee, and money
    public Report(int water, int milk, int coffee, double money) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.money = money;
    }

    // will check if there is enough resources
    public boolean Reporting(Menu order) {
        int waterRequired = order.getWater();
        int milkRequired = order.getMilk();
        int coffeeRequired = order.getCoffee();

        return (water >= waterRequired &&
                milk >= milkRequired &&
                coffee >= coffeeRequired);
    }

    // will return the current water inside the machine
    public int waterStatus(Menu order) {
        return water;
    }

    // will return the current milk inside the machine
    public int milkStatus(Menu order) {
        return milk;
    }

    // will return the current coffee inside the machine
    public int coffeeStatus(Menu order) {
        return coffee;
    }

    // Refills the water
    public void waterRefill() {
        water = 1500;
    }

    // Refills the Milk
    public void milkRefill() {
        milk = 1500;
    }

    // Refills the coffee
    public void coffeeRefill() {
        coffee = 500;
    }

    // Adds and updates the earning everytime the machine has run
    public void earnings(double amount) {
        money += amount;
    }

    // Subtracts water milk and coffee from the chosen order and will increase the
    // price
    public void makeCoffee(Menu order) {
        water -= order.getWater();
        milk -= order.getMilk();
        coffee -= order.getCoffee();
        money += order.getPrice();
    }

    // Prints the current status
    public void printReport() {
        System.out.println("Water: " + water + "ml");
        System.out.println("Milk: " + milk + "ml");
        System.out.println("Coffee: " + coffee + "g");
        System.out.printf("Money: $%.2f", money);
        System.out.println(" ");
    }
}
