package ru.mirea.task7.decorator;

public class DecoratorTest {
    public static void main(String[] args) {
        MessageSender m1 = new MessageSenderImpl();

        MessageSender m2 = new PoliteMessageSender();

        MessageSender m3 = new DateMessageSender();

        System.out.println(m1.send("Close window"));
        System.out.println(m2.send("Close window"));
        System.out.println(m3.send("Close window"));
    }
}
