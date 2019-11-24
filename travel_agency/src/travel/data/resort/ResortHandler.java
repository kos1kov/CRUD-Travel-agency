package travel.data.resort;

import travel.data.FileSerializer;
import travel.essense.Resort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResortHandler {
    public static FileSerializer fileSerializer = new FileSerializer<Resort>();
    private static List<Resort> resorts = new ArrayList<Resort>();
    public static void addResort(Resort resort) throws IOException {
        if (resorts.size() == 0) {
            resort.setId(0);
        }else {
            resort.setId(resorts.get(resorts.size() - 1).getId() + 1);
        }
        resorts.add(resort);
        fileSerializer.saveFile(resorts, "resorts.xml");
    }

    public static void deleteResort(int id) throws IOException {
        resorts.remove(id);
        fileSerializer.saveFile(resorts, "resorts.xml");
    }

    public static void printAllresorts(){
        for (var resort : resorts) {
            System.out.println(resort.toString());
        }
    }

    public static void getAllResort() throws IOException, ClassNotFoundException {
        resorts = (List<Resort>) fileSerializer.loadFromFile("resorts.xml");
    }
    public static void findByName(String name){
        resorts.stream().filter(resort -> name.equals(resort.getName())).forEach((resort) -> System.out.println(resort.toString()));
    }
}
