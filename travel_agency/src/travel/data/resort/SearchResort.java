package travel.data.resort;

import travel.essense.Order;
import travel.essense.Resort;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResort {
    public static void findByName(List<Resort> resorts, String name){
        resorts.stream().filter(resort -> name.equals(resort.getName())).forEach((resort) -> System.out.println(resort.print()));
    }
}
