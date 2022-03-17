package ru.mirea.task1;

import java.util.Scanner;
import java.util.function.Predicate;

public class PINChecker {
    public static void main(String[] args) {

        Predicate<String> pinChecker = str -> (str.length() == 6 || str.length() == 4);

        while (true) {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            if (pinChecker.test(s)) System.out.println(s + " is PIN-code");
            else System.out.println(s + " is not PIN-code");
        }
    }
}
