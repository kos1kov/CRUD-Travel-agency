package travel.data.resort;

import travel.essense.Client;
import travel.essense.Resort;

import java.util.List;
import java.util.Scanner;

public class AddResort {
    public static void addResort(List<Resort> resorts, Scanner in) {
        Resort resort = new Resort();

        resort.setId(resorts.size() + 1);
        System.out.print("Input resort name: ");
        resort.setName(in.nextLine());
        System.out.print("Input hotel name: ");
        resort.setHotelName(in.nextLine());
        System.out.print("Input numbers of stars: ");
        resort.setStars(Integer.parseInt(in.nextLine()));

        resorts.add(resort);
    }
}
