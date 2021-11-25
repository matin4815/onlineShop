package inventory;

public class Reading extends Products{
    private String category;

    public Reading(String name, String price, String info,String id, String qty,  String category) {
        super(name, price, info, id, qty);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
