package ss3.Bai_tap;

public class FindBiggestNumber2dArray extends Array2dTemplate {
    public int find_max(){
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j]>max){
                    max= arr[i][j];
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        FindBiggestNumber2dArray a = new FindBiggestNumber2dArray();
        a.input();
        a.creat_2dArray();
        a.display();
        int max = a.find_max();
        System.out.println("Max la: " + max);
    }
}
