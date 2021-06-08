package business.services;
import business.Util.Conf;

public class Calculator {
    public int getBeams(int length) {
        return 2;
    }

    public int getPoles(int length) {
        return 4;
    }

    public int getRafter(int length) {
        int numOfRafter = length/Conf.ROOFWIDTHUNIT;

        return numOfRafter;
    }

    //default
    public double getRafterPrice(int pricePrUnit, int length){
        int price = (length/55)*pricePrUnit;

        return price;
    }
}
