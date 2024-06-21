package array;

// Reverse integer
// Input - (-1234)
// Output - (-4321)

// Input - 1234
// Output - 4321

public class ReverseInteger {
    public static int reverseInteger(int number) {
        boolean isNegative = number < 0;
        if (isNegative) {
            number = number * (-1);
        }
        int reverse = 0;
        int lastDigit;
        while (number > 0) {
            lastDigit = number % 10;
            reverse = reverse * 10 + lastDigit;
            number = number / 10;
        }
        return isNegative ? reverse * (-1) : reverse;
    }

    public static void main(String[] args) {
        int number = 123456;
        int result = reverseInteger(number);
        System.out.println("The reverse number of integer " + number + " is: " + result);
    }
}
