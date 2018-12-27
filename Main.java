package projects.coffeemachine.com.damirel;

public class Main {

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        while (coffeeMachine.getState() != State.EXIT) {
            coffeeMachine.processState();
        }
    }
}
