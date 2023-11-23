package CoffeeMachine;
import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;

    public CoffeeMachine(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.money = money;
    }

    public void printStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public void buyCoffee(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back – to main menu:");
        String choice = scanner.next();
        if (!choice.equals("back")) {
            int type = Integer.parseInt(choice);
            switch (type) {
                case 1:
                    makeCoffee(250, 0, 16, 4);
                    break;
                case 2:
                    makeCoffee(350, 75, 20, 7);
                    break;
                case 3:
                    makeCoffee(200, 100, 12, 6);
                    break;
                default:
                    break;
            }
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
    }

    public void fillIngredients(Scanner scanner) {
        System.out.println("Write how many ml of water do you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        disposableCups += scanner.nextInt();
    }

    public void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();

            switch (action) {
                case "buy":
                    machine.buyCoffee(scanner);
                    break;
                case "fill":
                    machine.fillIngredients(scanner);
                    break;
                case "take":
                    machine.takeMoney();
                    break;
                case "remaining":
                    machine.printStatus();
                    break;
                case "exit":
                    scanner.close();
                    return;
                default:
                    break;
            }
        }
    }
}