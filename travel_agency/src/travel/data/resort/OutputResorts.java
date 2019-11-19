package travel.data.resort;

import travel.essense.Resort;

import java.util.List;

public class OutputResorts {
    public static void printAllResorts(List<Resort> resorts){
        for (var resort : resorts) {
            System.out.println(resort.print());
        }
    }
}
