package ss11.Bai_tap;

import java.sql.SQLOutput;
import java.util.Map;
import java.util.TreeMap;

public class CountWordUseTreeMap {
    public static void main(String[] args) {
        String str = "my name my name tuan dep trai trai trai hi hi";
        String[] words = str.split(" ");
        /*for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }*/
        TreeMap<String, Integer> map1 = new TreeMap<>();
        for (int i = 0; i < words.length; i++) {
            if(map1.containsKey(words[i])){
                int index = map1.get(words[i]);
                index++;
                map1.replace(words[i],index);
            }
            else
                map1.put(words[i], 1);
        }
        for(Map.Entry<String, Integer> entry:map1.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
