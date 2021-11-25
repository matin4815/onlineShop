package inventory;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Products> shopInventory = new HashMap<>();

    public void add(Products product){
        if(shopInventory.containsKey(product.getId())){
            System.out.println("this product id is already in inventory");
        }else{
            this.shopInventory.put(product.getId(), product);
            System.out.println(shopInventory.size());
        }
    }

    public Products getProduct(String id){
        if(shopInventory.containsKey(id)){
            return shopInventory.get(id);

        }else{
            return null;
        }
    }

    public boolean removeProduct(String id){
        if(shopInventory.containsKey(id)){
            shopInventory.remove(id);
            return true;
        }else{
            return false;
        }
    }

    public void printProducts(){
        System.out.println(shopInventory.size());
        for(String id: shopInventory.keySet()){
            System.out.println("id: " + id + " = " + shopInventory.get(id).getName());
        }
    }

    public void printProductFiltered(String type){
        for(String id: shopInventory.keySet()) {
            if(shopInventory.get(id).getType().equals(type)){
                System.out.println("id: " + id + " = " + shopInventory.get(id).getName());
            }else{
                continue;
            }
        }

    }


}
