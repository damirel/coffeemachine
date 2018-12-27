package projects.coffeemachine.com.damirel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MachineInputHandler {

    private final static Map<String, State> INPUT_STATE = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    static {
        INPUT_STATE.put("exit", State.EXIT);
        INPUT_STATE.put("remaining", State.REMAINING);
        INPUT_STATE.put("buy", State.BUY);
        INPUT_STATE.put("take", State.TAKE);
        INPUT_STATE.put("fill", State.FILL);
    }

    public State getState() {
        System.out.print("Write action (buy, fill, take, remaining, exit): ");
        return INPUT_STATE.getOrDefault(getUserInput(), State.ERROR);
    }

    public String chooseDrink() {
        System.out.println();
        System.out.print(
                "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        return getUserInput();
    }

    private String getUserInput() {
        return scanner.nextLine();
    }

    public void fillAction(CoffeeMachine coffeeMachine) {
        System.out.println();
        System.out.print("Write how many ml of water do you want to add: ");
        coffeeMachine.setWater(Integer.valueOf(scanner.nextLine()));
        System.out.print("Write how many ml of milk do you want to add: ");
        coffeeMachine.setMilk(Integer.valueOf(scanner.nextLine()));
        System.out.print("Write how many grams of coffee beans do you want to add: ");
        coffeeMachine.setCoffeeBeans(Integer.valueOf(scanner.nextLine()));
        System.out.print("Write how many disposable cups of coffee do you want to add: ");
        coffeeMachine.setCups(Integer.valueOf(scanner.nextLine()));
        System.out.println();
    }
}