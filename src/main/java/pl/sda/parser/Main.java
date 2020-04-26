package pl.sda.parser;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        Parser parser = new Parser();
        List<RealEstate> realEstateList = parser.readFile();
        parser.countByCity(realEstateList);
        parser.groupByCity(realEstateList);

    }
}
