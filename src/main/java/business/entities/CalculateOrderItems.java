package business.entities;

public class CalculateOrderItems {
    //(Vi antager at vi altid kan få materialer i den længde og bredde som kunden bestiller)
    //Der må kun være 55 cm mellem spærrene
    //TODO: Lav klasse calculateOrderItems (skal minimum kunne beregne antal spær)
    //(length/55)*2*pricePrBeam
    //50kr pr meter 97x97 stolpe
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
