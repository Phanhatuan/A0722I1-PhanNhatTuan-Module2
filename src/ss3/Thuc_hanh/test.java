package ss3.Thuc_hanh;

import java.util.ArrayList;
import java.util.List;

public class test {
        int rollno;
        String name;
        static String college = "Bưu Chính Viễn Thông";

        static void change() {
            // Thay đổi thuộc tính static (thuộc tính chung của tất cả các đối tượng)
            college = "Đại Học Công Nghệ";
        }

        test(int r, String n) {
            rollno = r;
            name = n;
        }

        void display() {
            System.out.println(rollno + " - " + name + " - " + college);
        }

        public static void main(String args[]) {
            List<Integer> arr = new ArrayList<>();
            arr.add(1);
            String a = "asd";
            String b = new String();
            StringBuilder d = new StringBuilder("a");
            d.delete(1,1);
            System.out.println(d);
            StringBuffer e = new StringBuffer("asddd");

            /*Object[]arr1 = new Object[10];
            System.out.println(arr1);
            arr1[1]=1;
            arr1[2]="ad";
            System.out.println(arr1[0]);
            System.out.println(arr1[2]);*/
            test s1 = new test(111, "Thông");
            test.change();
            s1.display();

            test s2 = new test(222, "Minh");
            s2.display();


    }
}
