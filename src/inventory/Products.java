package inventory;

public class Products {
    private String name;
    private String price;
    private String type;
    private String qty;
    private String id;

    public Products(String name, String price, String type, String id, String qty) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.id = id;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getQty() {
        return qty;
    }


}
