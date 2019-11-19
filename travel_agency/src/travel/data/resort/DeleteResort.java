package travel.data.resort;

import travel.essense.Resort;

import java.util.List;
import java.util.Scanner;

public class DeleteResort {
    public static void deleteResort(List<Resort> resorts, Scanner in){
        System.out.print("Input id: ");
        int id = Integer.parseInt(in.nextLine());
        resorts.remove(id - 1);
    }
}
