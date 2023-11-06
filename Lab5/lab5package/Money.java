package lab5package;

public enum Money {
    // initialzes the value of each coin to their respective coin
    QUARTER(0.25), DIME(0.1), NICKEL(0.05), PENNY(0.01);

    private double value;

    // each money's value
    Money(double value) {
        this.value = value;
    }

    // returns the value of Quarter
    public static double getQuarter() {
        return QUARTER.value;
    }

    // return the value of Dime
    public static double getDime() {
        return DIME.value;
    }

    // returns the value of nickel
    public static double getNickel() {
        return NICKEL.value;
    }

    // returns the value of penny
    public static double getPenny() {
        return PENNY.value;
    }

    // getting the value of each coin
    public static double getValue(String cash) {
        cash = cash.toLowerCase(); // lowercase the string

        if ("quarters".equals(cash) || "quarter".equals(cash)) {
            return getQuarter();
        } // for quarters
        else if ("dime".equals(cash) || "dimes".equals(cash)) {
            return getDime();
        } // for dimes
        else if ("nickel".equals(cash) || "nickels".equals(cash)) {
            return getNickel();
        } // for nickels
        else if ("penny".equals(cash) || "pennies".equals(cash)) {
            return getPenny();
        } // for pennies
        else {
            throw new IllegalArgumentException("Test");
        } // Apparently need by the get value method
    }

}