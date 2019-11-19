package travel.data.resort;

import travel.essense.Client;
import travel.essense.Resort;

import java.util.List;
import java.util.Scanner;

public class UpdateResort {
    public static void Update(List<Resort> resorts, Scanner in){
        System.out.print("Enter id of resort, which want to update: ");
        int index = Integer.parseInt(in.nextLine ());

        System.out.print("");
        System.out.print("List of available action : ");
        String key = "1";

        while(!key.equals("quit")){
            switch (key){
                case "1":
                    fields();
                    break;
                case "2":
                    System.out.print("Enter name: ");
                    resorts.get(index - 1).setName(in.nextLine());
                    break;
                case "3":
                    System.out.print("Enter hotel name: ");
                    resorts.get(index - 1).setHotelName(in.nextLine());
                    break;
                case "4":
                    System.out.print("Enter number of stars: ");
                    resorts.get(index - 1).setStars(Integer.parseInt(in.nextLine()));
                    break;
                default:
                    System.out.println(key);
            }
            key = in.nextLine ();
        }
    }

    private static void fields(){
        System.out.println("1 - list of fields");
        System.out.println("2 - change name");
        System.out.println("3 - change hotel name");
        System.out.println("4 - change stars");
        System.out.println("quit - to exit");
    }
}
