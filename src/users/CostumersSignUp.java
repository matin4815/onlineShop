package users;


public class CostumersSignUp {
    private String userName;
    private String password;
    private String id;
    private String name;
    private String phone;
    private String address;

    public CostumersSignUp() {
    }

    public CostumersSignUp(String userName, String password, String id, String name, String phone, String address) {
        this.userName = userName;
        this.password = password;
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

}
