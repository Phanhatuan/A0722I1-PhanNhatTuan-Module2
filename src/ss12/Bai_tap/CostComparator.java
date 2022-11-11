package ss12.Bai_tap;

import java.util.Comparator;

public class CostComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1,Product o2) {
            if(o1.getCost() > o2.getCost()){
                return 1;
            }else if(o1.getCost() == o2.getCost()){
                return 0;
            }else{
                return -1;
        }
    }
}
