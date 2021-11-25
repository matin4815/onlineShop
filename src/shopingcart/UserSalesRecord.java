package shopingcart;

import inventory.Products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserSalesRecord {
    private Map<String, ArrayList<Products>> salesRecord = new HashMap<>();

    public void addSalesRecord(String id,ArrayList<Products> userSales){
        salesRecord.put(id, userSales);
    }

    public void printSalesRecordForManager(){
        for(String id:salesRecord.keySet()){
            System.out.println(salesRecord.get(id));
        }
    }

    public void printCostumerSalesRecord(String customerId){
        for(String id:salesRecord.keySet()){
            if(id.equals(customerId)){
                System.out.println(salesRecord.get(id));
            }
        }
    }


}
