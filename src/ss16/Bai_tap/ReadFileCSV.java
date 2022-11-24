package ss16.Bai_tap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCSV {

    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(",");
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
            }
        }
        return result;
    }

    private static void printCountry(List<String> country) {
        System.out.println(
                "Country [id= "
                        + country.get(0)
                        + ", code= " + country.get(1)
                        + " , name=" + country.get(2)
                        + "]");
    }

    public static void readFile(){
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader("D:\\CodeGym\\Module_2\\src\\ss16\\Bai_tap\\countries.csv"));

            while ((line = br.readLine()) != null) {
                printCountry(parseCsvLine(line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        readFile();
    }
}
