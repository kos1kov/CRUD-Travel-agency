package travel.essense;

import java.io.Serializable;
import java.util.Comparator;

public class Price implements Serializable, Comparator {
    public Price(double bynPrice, double usdPrice) {
        this.usdPrice = usdPrice;
        this.bynPrice = bynPrice;
    }

    private double bynPrice;
    private double usdPrice;

    public double getBynPrice() {
        return bynPrice;
    }

    public void setBynPrice(double bynPrice) {
        this.bynPrice = bynPrice;
    }

    public double getUsdPrice() {
        return usdPrice;
    }

    public void setUsdPrice(double usdPrice) {
        this.usdPrice = usdPrice;
    }

    public String print() {
        return " BYN: " + bynPrice + " USD: " + usdPrice;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
