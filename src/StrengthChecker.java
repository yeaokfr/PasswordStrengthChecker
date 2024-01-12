import java.util.Scanner;


public class StrengthChecker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        do {
            // Checks each individual condition
            boolean testLength = false;
            boolean testUppercase = false;
            boolean testLowercase = false;
            boolean testNumber = false;
            boolean testSpecial = false;

            int points = 0;

            String password = Helper.getNonZeroLenString(scan, "What is your password?");
            String checker;

            // Checks to see if the string length is >= 12
            if (password.length() >= 12) {
                testLength = true;
                points++;
            }

            // Checks for an uppercase letter
            for (int i = 0; i < password.length(); i++) {
                checker = password.substring(i, i + 1);
                if (checker.matches("[ABCDEFGHIJKLMNOPQRSTUVWXYZ]")) {
                    testUppercase = true;
                    points++;
                    break;
                }
            }

            // Checks for a lowercase letter
            for (int i = 0; i < password.length(); i++) {
                checker = password.substring(i, i + 1);
                if (checker.matches("[abcdefghijklmnopqrstuvwxyz]")) {
                    testLowercase = true;
                    points++;
                    break;
                }
            }

            // Checks for a number
            for (int i = 0; i < password.length(); i++) {
                checker = password.substring(i, i + 1);
                if (checker.matches("[1234567890]")) {
                    testNumber = true;
                    points++;
                    break;
                }
            }

            // Checks for a special character
            for (int i = 0; i < password.length(); i++) {
                checker = password.substring(i, i + 1);
                if (checker.matches("[!@#$%^&*`~'.,/?;:=+<>]")) {
                    testSpecial = true;
                    points++;
                    break;
                }
            }

            System.out.println(" ");
            System.out.println("You earned " + points + "/5 points");

            // Checks how many points the user received and outputs a message based on that scale (X/5)
            if (points <= 2) {
                System.out.println("Your password is straight hot garbage. You might wanna fix that before I find your Social Security and bank details");
            } else if (points == 3) {
                System.out.println("Your password is okay. I'll only be able to get your mom's facebook");
            } else {
                System.out.println("Wowwy zowwy your password is splendid! I can't even find your G-mail");
            }

            System.out.println(" ");

            // Tells the user what they are missing to get a 5/5 password
            if (!testLength) {
                System.out.println("Your password is not long enough");
            }

            if (!testUppercase) {
                System.out.println("Your password does not contain an uppercase letter");
            }

            if (!testLowercase) {
                System.out.println("Your password does not contain a lowercase letter");
            }

            if (!testNumber) {
                System.out.println("Your password does not contain a number");
            }

            if (!testSpecial) {
                System.out.println("Your password does not contain a special character");
            }

            System.out.println(" ");

            // Asks the user if they want to check another password
            boolean again = Helper.getYNConfirm(scan, "Do you wish to try out another password? [Y/N]");

            if (!again) {
                break;
            }

            System.out.println(" ");
        } while(true);
    }
}