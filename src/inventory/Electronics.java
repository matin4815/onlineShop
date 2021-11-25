package inventory;

public class Electronics extends Products{
    private String category;

    public Electronics(String name, String price, String info,String id, String qty, String category) {
        super(name, price, info, id, qty);
        this.category = category;
    }


    public String getCategory() {
        return category;
    }
}
