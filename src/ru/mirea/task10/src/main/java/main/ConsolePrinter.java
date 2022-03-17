package main;

import org.springframework.stereotype.Component;

@Component
public class ConsolePrinter implements Printer {

    ConsolePrinter() {}

    @Override
    public void doPrint() {
        System.out.println("This message is printed by ConsolePrinter");
    }
}
