package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Printer printer1 = context.getBean(ConsolePrinter.class);
        Printer printer2 = context.getBean(FilePrinter.class);

        printer1.doPrint();
        printer2.doPrint();
    }
}
