package business.entities;

public class SimpleOrder {
    int id;
    int kundeId;
    int length;
    int width;

    public SimpleOrder(int id, int kundeId, int length, int width) {
        this.id = id;
        this.kundeId = kundeId;
        this.length = length;
        this.width = width;
    }

    public int getId() {
        return id;
    }

    public int getKundeId() {
        return kundeId;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
}
