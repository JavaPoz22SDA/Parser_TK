package pl.sda.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Parser {
    private Path file = Paths.get("file.csv");

    public List<RealEstate> readFile() throws IOException {
        byte[] data = Files.readAllBytes(file);
        String[] dataArray = new String(data).split("\r");
        List<String> dataList= new ArrayList<>(Arrays.asList(dataArray));
        dataList.remove(0);
        List<RealEstate> realEstateList = new ArrayList<>();

        for (String line :dataList){
            String[] lineArray = line.split(",");
            RealEstate realEstate=new RealEstate();
            realEstate.setStreet(lineArray[0]);
            realEstate.setCity(lineArray[1]);
            realEstate.setZip(Integer.parseInt(lineArray[2]));
            realEstate.setState(lineArray[3]);
            realEstate.setBeds(Integer.parseInt(lineArray[4]));
            realEstate.setBaths(Integer.parseInt(lineArray[5]));
            realEstate.setSq_ft(Integer.parseInt(lineArray[6]));
            realEstate.setType(lineArray[7]);
            realEstate.setSale_date(lineArray[8]);
            realEstate.setPrice(Integer.parseInt(lineArray[9]));
            realEstate.setLatitude(Float.parseFloat(lineArray[10]));
            realEstate.setLongitude(Float.parseFloat(lineArray[11]));

            realEstateList.add(realEstate);

        }

        return realEstateList;
    }
    public Map<String, List<RealEstate>> groupByCity(List<RealEstate> realEstates){
        Map<String, List<RealEstate>> listMap = new HashMap<>();

        List<String> cityList = new ArrayList<>();
        for (RealEstate re: realEstates ) {
            if(!cityList.contains(re.getCity()))
                cityList.add(re.getCity());
        }

        for (String city:cityList) {
            List<RealEstate> cityRealEstates = new ArrayList<>();
            for (RealEstate re: realEstates ) {
                cityRealEstates.add(re);
            }
            listMap.put(city,cityRealEstates);
        }

        return listMap;
    }

    public Map<String, Integer> countByCity(List<RealEstate> realEstates){
        Map<String, Integer> listMap = new HashMap<>();
        for (RealEstate re:realEstates ) {
            if(listMap.containsKey(re.getCity())){
                int value = listMap.get(re.getCity())+1;
                listMap.put(re.getCity(),value);
            }else
                listMap.put(re.getCity(),1);
        }
        return listMap;
    }
}
