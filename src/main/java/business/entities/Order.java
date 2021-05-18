package business.entities;

public class Order {
    double prisTotal;
    int Kunde_kunde_Id;
    int Carport_carport_Id;
    String status;


    public Order(double prisTotal, int kunde_kunde_Id, int carport_carport_Id, String status) {
        this.prisTotal = prisTotal;
        Kunde_kunde_Id = kunde_kunde_Id;
        Carport_carport_Id = carport_carport_Id;
        this.status = status;
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

    public int getCarport_carport_Id() {
        return Carport_carport_Id;
    }

    public void setCarport_carport_Id(int carport_carport_Id) {
        Carport_carport_Id = carport_carport_Id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
