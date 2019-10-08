package travel.data;

import travel.essense.Order;

import java.util.Comparator;

public class OrderComparatorByPrice implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
        return o1.price.compareTo(o2.price);
    }
}
