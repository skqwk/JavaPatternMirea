package main;

import org.springframework.stereotype.Component;

@Component
public class FilePrinter implements Printer {

    FilePrinter() {}

    @Override
    public void doPrint() {
        System.out.println("This message is printed by FilePrinter");

    }
}
