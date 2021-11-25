package inventory;

public class Shoes extends Products{
    private String style;

    public Shoes(String name, String price, String info,String id, String qty, String style) {
        super(name, price, info, id, qty);
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
