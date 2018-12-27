package projects.coffeemachine.com.damirel;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CoffeeMachine {

    private int water = 400;
    private int milk = 540;
    private int coffeeBeans = 120;
    private int cups = 9;
    private int money = 550;

    private State state;
    private final MachineInputHandler inputHandler;

    private final Map<Integer, Drink> drinks = new HashMap<>();

    CoffeeMachine() {
        inputHandler = new MachineInputHandler();
        state = State.CHOOSE_ACTION;
        drinks.put(1, Drink.ESPRESSO);
        drinks.put(2, Drink.LATTE);
        drinks.put(3, Drink.CAPPUCCINO);
    }

    public void chooseState() {
        state = inputHandler.getState();
    }

    public State getState() {
        return state;
    }

    public void processState() {
        state = state.executeState(this);
    }

    public void setWater(int water) {
        this.water += water;
    }

    public void setMilk(int milk) {
        this.milk += milk;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans += coffeeBeans;
    }

    public void setCups(int cups) {
        this.cups += cups;
    }

    public void displayResources() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(String.format("%d of water", water));
        System.out.println(String.format("%d of milk", milk));
        System.out.println(String.format("%d of coffee beans", coffeeBeans));
        System.out.println(String.format("%d of disposable cups", cups));
        System.out.println(String.format("%d of money", money));
        System.out.println();
    }

    public void buyAction() throws NumberFormatException {
        final String chosenDrink = inputHandler.chooseDrink();
        if ("back".equals(chosenDrink)) {
            System.out.println();
            return;
        }
        final Optional<Drink> drinkOptional = Optional
                .ofNullable(drinks.get(Integer.valueOf(chosenDrink)));
        if (drinkOptional.isPresent()) {
            final Drink drink = drinkOptional.get();
            if (drink.isAvailable(water, milk, coffeeBeans, cups)) {
                System.out.println("I have enough resources, making you a coffee!");
                cookCoffee(drink);
            }
        } else {
            System.out.println("Chosen drink don't exist!");
        }
        System.out.println();
    }

    private void cookCoffee(final Drink drink) {
        money += drink.getPrice();
        cups -= 1;
        water -= drink.getWater();
        milk -= drink.getMilk();
        coffeeBeans -= drink.getBeans();
    }

    public void takeAction() {
        System.out.println();
        System.out.println(String.format("I gave you $%d", money));
        money = 0;
        System.out.println();
    }

    public void errorAction() {
        System.out.println();
        System.out.println("Action don't exist!");
        System.out.println();
    }

    public void fillAction() {
        inputHandler.fillAction(this);
    }
}