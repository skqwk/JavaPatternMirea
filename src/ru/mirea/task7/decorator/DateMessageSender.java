package ru.mirea.task7.decorator;

import java.time.LocalDateTime;

public class DateMessageSender implements MessageSender{
    private MessageSender sender = new MessageSenderImpl();

    @Override
    public String send(String data) {
        return sender.send(data) + " [" + LocalDateTime.now() + "]";
    }
}

