package ru.mirea.task7.decorator;

public class MessageSenderImpl implements MessageSender{
    @Override
    public String send(String data) {
        return "> " + data;
    }
}
