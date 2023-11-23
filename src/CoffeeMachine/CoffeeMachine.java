package CoffeeMachine;
import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;
    private String state;

    public CoffeeMachine(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.money = money;
        this.state = "chooseAction";
    }

    public void processInput(String input) {
        switch (state) {
            case "chooseAction":
                handleChooseAction(input);
                break;
            case "buy":
                handleBuy(input);
                break;
            case "fillWater":
                fillWater(input);
                break;
            case "fillMilk":
                fillMilk(input);
                break;
            case "fillCoffeeBeans":
                fillCoffeeBeans(input);
                break;
            case "fillDisposableCups":
                fillDisposableCups(input);
                break;
            default:
                break;
        }
    }

    private void handleChooseAction(String input) {
        switch (input) {
            case "buy":
                state = "buy";
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                break;
            case "fill":
                state = "fillWater";
                System.out.println("Write how many ml of water do you want to add:");
                break;
            case "take":
                takeMoney();
                break;
            case "remaining":
                printStatus();
                break;
            case "exit":
                break;
            default:
                break;
        }
    }

    private void handleBuy(String input) {
        switch (input) {
            case "1":
                makeCoffee(250, 0, 16, 4);
                break;
            case "2":
                makeCoffee(350, 75, 20, 7);
                break;
            case "3":
                makeCoffee(200, 100, 12, 6);
                break;
            case "back":
                state = "chooseAction";
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                break;
            default:
                break;
        }
    }

    private void makeCoffee(int waterNeeded, int milkNeeded, int beansNeeded, int cost) {
        if (water >= waterNeeded && milk >= milkNeeded && coffeeBeans >= beansNeeded && disposableCups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= waterNeeded;
            milk -= milkNeeded;
            coffeeBeans -= beansNeeded;
            disposableCups--;
            money += cost;
        } else {
            String msg = "Sorry, not enough ";
            if (water < waterNeeded) msg += "water ";
            if (milk < milkNeeded) msg += "milk ";
            if (coffeeBeans < beansNeeded) msg += "coffee beans ";
            if (disposableCups < 1) msg += "disposable cups ";
            msg += "to make coffee.";
            System.out.println(msg);
        }
        state = "chooseAction";
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }

    private void fillWater(String input) {
        water += Integer.parseInt(input);
        state = "fillMilk";
        System.out.println("Write how many ml of milk do you want to add:");
    }

    private void fillMilk(String input) {
        milk += Integer.parseInt(input);
        state = "fillCoffeeBeans";
        System.out.println("Write how many grams of coffee beans do you want to add:");
    }

    private void fillCoffeeBeans(String input) {
        coffeeBeans += Integer.parseInt(input);
        state = "fillDisposableCups";
        System.out.println("Write how many disposable cups of coffee do you want to add:");
    }

    private void fillDisposableCups(String input) {
        disposableCups += Integer.parseInt(input);
        state = "chooseAction";
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }

    private void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
        state = "chooseAction";
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }

    private void printStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
        state = "chooseAction";
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);

        while (true) {
            String input = scanner.next();
            if (input.equals("exit")) {
                break;
            }
            machine.processInput(input);
        }
        scanner.close();
    }
}