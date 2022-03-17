package ru.mirea.task7.decorator;

public class PoliteMessageSender implements MessageSender{
    private MessageSender sender = new MessageSenderImpl();

    @Override
    public String send(String data) {
        return sender.send( data + ", please");
    }
}
