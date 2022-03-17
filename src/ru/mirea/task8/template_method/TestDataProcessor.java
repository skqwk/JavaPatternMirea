package ru.mirea.task8.template_method;

import java.util.Scanner;

public class TestDataProcessor {
    public static void main(String[] args)  {
        DataProcessor dataProcessor;

        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();
        switch (type) {
            case "PDF": {
                dataProcessor = new PFDDataProcessor();
                break;
            }
            case "FB2": {
                dataProcessor = new FB2DataProcessor();
                break;
            }
            default: {
                throw new IllegalArgumentException("Incorrect input");
            }
        }

        String path = sc.nextLine();

        System.out.println(dataProcessor.process(path).name());

    }
}
