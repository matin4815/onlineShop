package users;


import inventory.Inventory;
import inventory.Products;
import shopingcart.UserSalesRecord;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Manager {
    private Map<String, Manager> managerMap = new HashMap<>();
    private String managerUsername;
    private String managerPassword;
    Inventory inventory = new Inventory();
    UserSalesRecord userSalesRecord = new UserSalesRecord();

    public Manager() {
    }

    public Manager(String managerUsername, String managerPassword) {
        this.managerUsername = managerUsername;
        this.managerPassword = managerPassword;
    }



    public String getManagerUsername() {
        return managerUsername;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public boolean addManager(Manager manager){
        boolean isManager = true;
        if(managerMap.containsKey(manager.managerUsername)){
            System.out.println("this manager is already an admin");
            isManager = false;
        }else{
            managerMap.put(manager.getManagerUsername(), manager);
        }
        return isManager;
    }

    public boolean signIn(String userName, String password){
        boolean isManager = false;
        if(managerMap.containsKey(userName)){
            Manager manager = managerMap.get(userName);
            if(manager.managerPassword.equals(password)){
                System.out.println("You are signed in");
                isManager = true;
            }
        }
        return isManager;
    }


    Scanner scanner = new Scanner(System.in);

    public void addProduct(){
        System.out.println("pls enter the product name: ");
        String name = scanner.nextLine();
        System.out.println("pls enter the product price: ");
        String price = scanner.nextLine();
        System.out.println("what type of product are you trying to add: ");
        String type = scanner.nextLine();
        System.out.println("pls enter the product id: ");
        String id = scanner.nextLine();
        System.out.println("pls enter the quantity of the product: ");
        String qty = scanner.nextLine();
        Products product = new Products(name, price, type, id, qty);
        inventory.add(product);
        System.out.println("product added");
    }

    public void removeProduct() {
        System.out.println("pls enter the id of the product you want to remove: ");
        String id = scanner.nextLine();
        inventory.removeProduct(id);
    }

    public void getUserSalesRecord(){
        userSalesRecord.printSalesRecordForManager();
    }
}
