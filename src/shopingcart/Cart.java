package shopingcart;

import inventory.Products;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Products> cart = new ArrayList<>();
    UserSalesRecord userSalesRecord = new UserSalesRecord();

    public void addProduct(Products product){
        if(cart.size() < 6){
            this.cart.add(product);
        }else{
            System.out.println("your cart is full, either remove an item to add new item or pay for items to empty cart");
        }

    }

    public void removeProductFromCart(String id){
        for(Products product: cart){
            if(product.getId().equals(id)){
                cart.remove(product);
            }else{
                System.out.println("this product is not in cart");
            }
        }
    }

    private int totalPrice(){
        int totalPrice = 0;
        for(Products product: cart) {
            totalPrice += Integer.parseInt(product.getPrice());
        }
        return totalPrice;

    }

    public void printItemsInCart(){
        System.out.println("Items in your cart are: ");
        for(Products product: cart){
            System.out.println("id = " + product.getId() + " and product name is " + product.getName() + "with the type of " + product.getType());
        }
    }

    public void buyProducts(String id){
        int totalPrice = totalPrice();
        System.out.println("the price for you to pay is " + totalPrice);
        ArrayList<Products> salesRecord = new ArrayList<>();
        for(Products product: cart){
            salesRecord.add(product);
        }
        cart.clear();
        userSalesRecord.addSalesRecord(id, salesRecord);
        System.out.println("Happy Shopping!");
    }
}
