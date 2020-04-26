package pl.sda.parser;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        Parser parser = new Parser();
        List<RealEstate> realEstateList = parser.readFile();

        for(Map.Entry<String,Integer> entry :  parser.countByCity(realEstateList).entrySet())
            System.out.println(entry.getKey() + "->" + entry.getValue());

        for(Map.Entry<String,List<RealEstate>> entry : parser.groupByCity(realEstateList).entrySet())
        {
            System.out.println(entry.getKey());// + " -> " + entry.getValue());
            for (RealEstate re:entry.getValue() ) {
                System.out.println("        Cena: " + re.getPrice());
            }
            System.out.println();
        }
    }
}
