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
        int numOfRafter = length / Conf.ROOFWIDTHUNIT;

        return numOfRafter;
    }

    public double getMaterialPrice(double pricePrUnit, int length, int numberOfItems) {
        double price = ((length / 100.0) * numberOfItems * pricePrUnit);

        return price;
    }

}
