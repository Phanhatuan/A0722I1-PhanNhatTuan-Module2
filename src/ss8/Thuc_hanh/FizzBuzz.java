package ss8.Thuc_hanh;

public class FizzBuzz {
    public static String fizzBuzz(int number) {
        final boolean isFizz = number % 3 == 0;
        boolean isBuzz = number % 5 == 0;
        if (isFizz &&   isBuzz)
            return "FizzBuzz";

        if (isFizz)
            return "Fizz";

        if (isBuzz)
            return "Buzz";

        return number + "";
    }
}
