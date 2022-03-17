package com.example.task23;

import com.example.task23.services.EmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@ExtendWith(MockitoExtension.class)
class EmailServiceTest {

    @Mock
    private JavaMailSenderImpl javaMailSenderImpl;
    private EmailService underTest;

    @BeforeEach
    void setUp() {
        underTest = new EmailService(javaMailSenderImpl);
    }

    @Test
    void sendNotification() {

        // given
        Phone phone = new Phone();
        phone.setName("IPhone");
        phone.setCreationYear("2007");
        Mockito.doNothing().when(javaMailSenderImpl).send(Mockito.any(SimpleMailMessage.class));

        // when
        underTest.sendNotification(phone);

        // then
        Mockito.verify(javaMailSenderImpl).send(Mockito.any(SimpleMailMessage.class));



    }
}