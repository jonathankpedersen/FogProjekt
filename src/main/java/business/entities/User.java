package business.entities;

public class User
{

    public User(String name, String email,String address, String tele_number, String password, String role)
    {
        this.email = email;
        this.password = password;
        this.role = role;
        this.name = name;
        this.address = address;
        this.tele_number = tele_number;
    }

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private String password; // Should be hashed and secured
    private String role;
    private String name;
    private String address;
    private String tele_number;

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName() { return name;}

    public void setName() {this.name = name;}

    public String getAddress() { return address;}

    public void setAddress() {this.address = address;}

    public String getTele_number() { return tele_number;}

    public void setTele_number() {this.tele_number = tele_number;}
}
