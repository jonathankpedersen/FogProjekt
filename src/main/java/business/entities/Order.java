package business.entities;

public class Order {
    int ordreId;
    double prisTotal;
    int Kunde_kunde_Id;
    int length;
    int width;
    boolean shed;
    String status;


    public Order(int kunde_kunde_Id,int length, int width, boolean shed) {
        Kunde_kunde_Id = kunde_kunde_Id;
        this.length = length;
        this.width = width;
        this.shed = shed;
        this.status = "Created";
    }

    public Order(int orderId, int id, int length, int width, boolean shed, double pris, String status) {
        Kunde_kunde_Id = id;
        this.ordreId = orderId;
        this.length = length;
        this.width = width;
        this.shed = shed;
        this.prisTotal = pris;
        this.status = status;
    }

    public void setOrdreId(int ordreId) {
        this.ordreId = ordreId;
    }

    public double getPrisTotal() {
        return prisTotal;
    }

    public void setPrisTotal(double prisTotal) {
        this.prisTotal = prisTotal;
    }

    public int getKunde_kunde_Id() {
        return Kunde_kunde_Id;
    }

    public void setKunde_kunde_Id(int kunde_kunde_Id) {
        Kunde_kunde_Id = kunde_kunde_Id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isShed() {
        return shed;
    }

    public void setShed(boolean shed) {
        this.shed = shed;
    }
}
