package coffeemachine.enums;

import coffeemachine.CoffeeMachine;

public enum State {
    CHOOSE_ACTION {
        @Override
        public State executeState(final CoffeeMachine coffeeMachine) {
            coffeeMachine.chooseState();
            return coffeeMachine.getState();
        }
    },
    BUY {
        @Override
        public State executeState(final CoffeeMachine coffeeMachine) {
            try {
                coffeeMachine.buyAction();
            } catch (NumberFormatException e) {
                System.out.println("Wrong input!");
                System.out.println();
            }
            return CHOOSE_ACTION;
        }
    },
    FILL {
        @Override
        public State executeState(final CoffeeMachine coffeeMachine) {
            coffeeMachine.fillAction();
            return CHOOSE_ACTION;
        }
    },
    TAKE {
        @Override
        public State executeState(final CoffeeMachine coffeeMachine) {
            coffeeMachine.takeAction();
            return CHOOSE_ACTION;
        }

    },
    REMAINING {
        @Override
        public State executeState(final CoffeeMachine coffeeMachine) {
            coffeeMachine.displayResources();
            return CHOOSE_ACTION;
        }
    },
    EXIT {
        @Override
        public State executeState(final CoffeeMachine coffeeMachine) {
            return EXIT;
        }
    },
    ERROR {
        @Override
        public State executeState(final CoffeeMachine coffeeMachine) {
            coffeeMachine.errorAction();
            return CHOOSE_ACTION;
        }

    };

    public abstract State executeState(CoffeeMachine coffeeMachine);
}
