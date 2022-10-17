package ss1.Bai_tap;
import java.util.Scanner;

public class ReadNumber {
    public static void main(String[] args) {
        System.out.println("Enter a number less than 4 digits");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        String result ="";
        if(number/100>0){
            int numbers = number/100;
            switch (numbers){
                case 9: result+="nine hundred ";break;
                case 8: result+="eight hundred ";break;
                case 7: result+="seven hundred ";break;
                case 6: result+="six hundred ";break;
                case 5: result+="five hundred ";break;
                case 4: result+="four hundred ";break;
                case 3: result+="three hundred ";break;
                case 2: result+="two hundred ";break;
                case 1: result+="one hundred ";break;

            }
        }
        if(number/10>0){
            int numbers = number/10;
            int num  = numbers%10;
            switch (num){
                case 9: result+="and ninety ";break;
                case 8: result+="and eighty ";break;
                case 7: result+="and seventy ";break;
                case 6: result+="and sixty ";break;
                case 5: result+="and fifty ";break;
                case 4: result+="and fourty ";break;
                case 3: result+="and thirdty ";break;
                case 2: result+="and twenty ";break;

            }
        }
        if(number/10>0){
            int numbers = number%100;
            switch (numbers){
                case 10: result+="and ten ";break;
                case 11: result+="and eleven ";break;
                case 12: result+="and twelve ";break;
                case 13: result+="and thirteen ";break;
                case 14: result+="and fourteen ";break;
                case 15: result+="and fifteen ";break;
                case 16: result+="and sixteen ";break;
                case 17: result+="and seventeen ";break;
                case 18: result+="and eighteen ";break;
                case 19: result+="and nineteen ";break;

            }
        }
        if(number%100>19){
            int numbers = number%10;
            switch (numbers){
                case 9: result+="nine";break;
                case 8: result+="eight";break;
                case 7: result+="seven";break;
                case 6: result+="six ";break;
                case 5: result+="five";break;
                case 4: result+="four ";break;
                case 3: result+="three";break;
                case 2: result+="two";break;
                case 1: result+="one";break;

            }
        }
        if(number<10){
            switch (number){
                case 9: result+="nine";break;
                case 8: result+="eight";break;
                case 7: result+="seven";break;
                case 6: result+="six ";break;
                case 5: result+="five";break;
                case 4: result+="four ";break;
                case 3: result+="three";break;
                case 2: result+="two";break;
                case 1: result+="one";break;

            }
        }
        System.out.println(result);
    }

}
