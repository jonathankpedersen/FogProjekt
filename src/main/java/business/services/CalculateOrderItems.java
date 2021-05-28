package business.services;

public class CalculateOrderItems {
    int carportLength;
    int pricePrItem;

    public CalculateOrderItems(int carportLength, int pricePrItem) {
        this.carportLength = carportLength;
        this.pricePrItem = pricePrItem;
    }

    public int calculatePrice(){
        int price = ((carportLength/55)*2)*pricePrItem;

        return price;
    }

}
