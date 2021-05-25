package business.entities;

public class OrderItems {
    Material material;
    int amount;
    int matId;
    int ordreItemId;
    String description;
    double price;
    int length;
    int ordreId;


    //OrderItems klassen skal matche orderitem tabellen, check
    public OrderItems(Material material, int amount) {
        this.material = material;
        this.amount = amount;
    }

    public OrderItems(int amount, int matId, int ordreItemId, String description, double price, int length, int ordreId) {
        this.amount = amount;
        this.matId = matId;
        this.ordreItemId = ordreItemId;
        this.description = description;
        this.price = price;
        this.length = length;
        this.ordreId = ordreId;
    }

    public OrderItems(int amount, int matId, String description, double price, int length) {
        this.amount = amount;
        this.matId = matId;
        this.description = description;
        this.price = price;
        this.length = length;
    }

    public OrderItems(int matId, String description, double price, int length) {
        this.matId = matId;
        this.description = description;
        this.price = price;
        this.length = length;
    }

    public Material getMaterial() {
        return material;
    }

    public int getAmount() {
        return amount;
    }

    public int getMatId() {
        return matId;
    }

    public int getOrdreItemId() {
        return ordreItemId;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getLength() {
        return length;
    }

    public int getOrdreId() {
        return ordreId;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setMatId(int matId) {
        this.matId = matId;
    }

    public void setOrdreItemId(int ordreItemId) {
        this.ordreItemId = ordreItemId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setOrdreId(int ordreId) {
        this.ordreId = ordreId;
    }
}
