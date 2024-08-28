package learn;

import java.time.LocalDate;

/**
 * Clean code - DRY, KISS, YAGNI, Boy scoot rule, SOLID
 */

public class Main {

    public static void main(String[] args) {
        // int myInt = sum(2, 4, 6, 8, 10);
        int sumNumbers = sum(2, 4, 6, 8, 10);
        // String myString = "Hello";
        String greeting = "Hello";
        // User u = new User("Toto", "toto2000");
        User totoUser = new User("Toto", "toto2000");
    }


        // DRY -> Don't repeat Yourself

    public int sumTwo(int a, int b) {
        return a + b;
    }

    public int sumThree(int a, int b, int c) {
        // return a + b + c;
        return a + sumTwo(b, c);
    }

    public static int sum(int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    // KISS -> Keep It Simple Stupid
    public boolean isEven(int n) {
        // if (n % 2 == 0) return true;
        // else return false;
        return n % 2 == 0;
    }

    // YAGNI: You Ain't Gonna Need It
    class User {
        private String username;
        private String password;
        private LocalDate birthday; // Not used

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    // Boy scout rule
    // public boolean x(int x) {
        // if (x > 10)
        //     return true;
        // return false;
    // }
    public boolean isUpperThan10(int x) {
        return x > 10;
    }
}
