package business.services;

public class CalculateOrderItems {
    int carportLength;
    int pricePrItem;
    //TODO: Lav en beregner som beregner antallet af spær ud fra den ønskede længde

    public CalculateOrderItems(int carportLength, int pricePrItem) {
        this.carportLength = carportLength;
        this.pricePrItem = pricePrItem;
    }

    public int calculatePrice(){
        int price = ((carportLength/55)*2)*pricePrItem;

        return price;
    }

}
