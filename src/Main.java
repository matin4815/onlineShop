import inventory.Inventory;
import shopingcart.Cart;
import shopingcart.UserSalesRecord;
import users.Costumers;
import users.CostumersSignUp;
import users.Manager;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Manager manager = new Manager();
    private static Costumers  costumers = new Costumers();
    private static Inventory inventory = new Inventory();
    private static Cart cart = new Cart();
    private static UserSalesRecord userSalesRecord = new UserSalesRecord();

    public static void main(String[] args) {
        Manager superUser = new Manager("superUser", "superUser");
        manager.addManager(superUser);
        boolean isCostumer = false;
        boolean isManager = false;
        printAtStart();
        String startAction = scanner.nextLine();
        switch (startAction){
            case "0":
                System.out.println("Come back again, goodbye");
                break;
            case "1":
                System.out.println("pls enter your username: ");
                String username = scanner.nextLine();
                System.out.println("pls enter your password");
                String password = scanner.nextLine();
                if(manager.signIn(username, password)){
                    isManager = true;
                }else {
                    System.out.println("someThing was wrong");
                }
                break;
            case "2":
                System.out.println("pls enter your id: ");
                String ID = scanner.nextLine();
                System.out.println("pls enter a username: ");
                String userName1 = scanner.nextLine();
                System.out.println("pls enter a password: ");
                String Password1 = scanner.nextLine();
                if (costumers.signIn(ID, userName1, Password1)){
                    isCostumer = true;
                }else{
                    System.out.println("someThing was wrong");
                }
                break;
            case "3":
                System.out.println("pls enter a username: ");
                String userName = scanner.nextLine();
                System.out.println("pls enter a password: ");
                String Password = scanner.nextLine();
                System.out.println("pls enter a unique id for yourself: ");
                String id = scanner.nextLine();
                System.out.println("pls enter a name: ");
                String name = scanner.nextLine();
                System.out.println("pls enter a phone number: ");
                String phone = scanner.nextLine();
                System.out.println("pls enter an address: ");
                String address = scanner.nextLine();
                CostumersSignUp costumersSignUp = new CostumersSignUp(userName, Password, id, name, phone, address);
                if(costumers.add(costumersSignUp)){
                    System.out.println("Welcome as a new member to our store!!!");
                    isCostumer = true;
                }else{
                    System.out.println("someThing was wrong");
                }
                break;
            case "4":
                printAtStart();
                break;
            default:
                System.out.println("Invalid input");
        }
        while(isManager) {
            printManagerAction();
            String managerAction = scanner.nextLine();
            switch (managerAction) {
                case "0":
                    System.out.println("Come back again, goodbye");
                    isManager = false;
                    break;
                case "1":
                    System.out.println("pls enter a user name: ");
                    String userName = scanner.nextLine();
                    System.out.println("pls enter a password: ");
                    String password = scanner.nextLine();
                    Manager newManager = new Manager(password, userName);
                    if(manager.addManager(newManager)){
                        System.out.println("it happened smoothly");
                    }else{
                        System.out.println("someThing went wrong");
                    }
                    break;
                case "2":
                    manager.addProduct();
                    break;
                case "3":
                    manager.removeProduct();
                    break;
                case "4":
                    manager.getUserSalesRecord();
                    break;
                case "5":
                    printManagerAction();
                    break;
                case "6":
                    isManager = false;
                    isCostumer = true;
                    break;
                case "7":
                    inventory.printProducts();
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }

        while(isCostumer) {
            printCostumerAction();
            String customerAction = scanner.nextLine();
            switch (customerAction) {
                case "0":
                    System.out.println("Come back again, goodbye");
                    isCostumer = false;
                    break;
                case "1":
                    System.out.println("our products are : ");
                    inventory.printProducts();
                    break;
                case "2":
                    costumers.shop();
                    break;
                case "3":
                    costumers.removeItemFromCart();
                    break;
                case "4":
                    System.out.println("pls enter your id(pls do so with cation)");
                    String id = scanner.nextLine();
                    cart.buyProducts(id);
                    break;
                case "5":
                    System.out.println("pls enter your id(pls do so with cation)");
                    String id1 = scanner.nextLine();
                    userSalesRecord.printCostumerSalesRecord(id1);
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }

    }


    private static void printAtStart(){
        System.out.println("Available actions ");
        System.out.println("0 -- to get out of the shop\n" +
                "1 -- to get in as manager\n"+
                "2 -- to get in as a costumer\n"+
                "3 -- to sign up as a costumer\n"+
                "4 -- to print a list of available actions.");
        System.out.println("choose your action: ");

    }


    private static void printManagerAction(){
        System.out.println("Available actions ");
        System.out.println("0 -- to get out of the shop\n" +
                "1 -- to create a new manager\n"+
                "2 -- to add a new product\n"+
                "3 -- to remove an existing product\n"+
                "4 -- to get user sales record\n"+
                "5 -- to print a list of available actions\n"+
                "6 -- to enter as a costumer\n" +
                "7 -- to print the products");
        System.out.println("choose your action: ");

    }

    private static void printCostumerAction(){
        System.out.println("Available actions ");
        System.out.println("0 -- to get out of the shop\n" +
                "1 -- to print products\n"+
                "2 -- to add an item to your cart\n"+
                "3 -- to remove an item from cart\n"+
                "4 -- to buy the items in your cart \n"+
                "5 -- to print your shopping record");
        System.out.println("choose your action: ");

    }
}
