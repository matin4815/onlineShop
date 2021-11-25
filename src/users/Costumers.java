package users;

import inventory.Inventory;
import inventory.Products;
import shopingcart.Cart;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Costumers {
    private Map<String, CostumersSignUp> costumersMap = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    private Inventory inventory = new Inventory();
    private Cart cart = new Cart();

    public boolean add(CostumersSignUp costumer){
        boolean isSignedUp = true;
        if(costumersMap.containsKey(costumer.getId())){
            isSignedUp = false;
            System.out.println("this costumer id is already SignedUp");
        }else{
            this.costumersMap.put(costumer.getId(), costumer);
            System.out.println(costumersMap);
        }
        return isSignedUp;
    }

    public boolean signIn(String id, String userName, String password){
        boolean isCostumer = false;
        if(costumersMap.containsKey(id)){
            CostumersSignUp costumer = costumersMap.get(id);
            if(costumer.getPassword().equals(password) && costumer.getUserName().equals(userName)){
                System.out.println("You are signed in");
                isCostumer = true;
            }
        }
        return isCostumer;
    }


    public CostumersSignUp getCostumer(String id){
        return costumersMap.get(id);
    }


    public void shop(){
        System.out.println("pls enter the id of the product that you want: ");
        String id = scanner.nextLine();
        Products product = inventory.getProduct(id);
        cart.addProduct(product);
        cart.printItemsInCart();
    }

    public void removeItemFromCart(){
        System.out.println("pls enter the id of the item: ");
        String id = scanner.nextLine();
        cart.removeProductFromCart(id);
        cart.printItemsInCart();
    }


}
