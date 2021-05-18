package business.entities;

public class OrderItems {
    Material material;
    int quantity;

    public OrderItems(Material material, int quantity) {
        this.material = material;
        this.quantity = quantity;
    }

    public Material getMaterial() {
        return material;
    }

    public int getQuantity() {
        return quantity;
    }
}
