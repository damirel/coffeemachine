package projects.coffeemachine.com.damirel;

public enum Drink {
    ESPRESSO(4, 250, 0, 16, 1),
    LATTE(7, 350, 75, 20, 1),
    CAPPUCCINO(6, 200, 100, 12, 1);

    private final int price;
    private final int water;
    private final int milk;
    private final int beans;
    private final int cups;

    Drink(int price, int water, int milk, int beans, int cups) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.price = price;
        this.cups = cups;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public int getPrice() {
        return price;
    }

    public boolean isAvailable(int water, int milk, int beans, int cups) {
        if (water < this.water) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (milk < this.milk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (beans < this.beans) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else if (cups < this.cups) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }
        return true;
    }
}
