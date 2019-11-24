package travel.service;



import travel.data.resort.ResortHandler;
import travel.essense.Resort;

import java.io.IOException;

public class ResortService {
    public static void addNewResort(Resort resort) throws IOException {
        ResortHandler.addResort(resort);
    };
    public static void findByName(String email) {
        ResortHandler.findByName(email);
    };
    public static void deleteResort(int id) throws IOException {
        ResortHandler.deleteResort(id);
    };

    public static void printAllresorts(){
        ResortHandler.printAllresorts();
    }
}
