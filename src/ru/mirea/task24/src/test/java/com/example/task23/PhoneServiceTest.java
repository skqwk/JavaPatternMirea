package com.example.task23;

import com.example.task23.services.EmailService;
import com.example.task23.services.PhoneService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class PhoneServiceTest {

    @Mock
    private EmailService emailService;
    @Mock
    private PhoneRepository phoneRepository;
    private PhoneService underTest;

    @BeforeEach
    public void setUp() {
        underTest = new PhoneService(phoneRepository, emailService);
    }

    @Test
    void create() {
        // given
        Phone phone = new Phone();
        phone.setName("Iphone");
        phone.setCreationYear("2010");

        // when
        underTest.create(phone);

        // then
        ArgumentCaptor<Phone> phoneArgumentCaptor =
                ArgumentCaptor.forClass(Phone.class);

        Mockito.verify(phoneRepository).save(phoneArgumentCaptor.capture());
        Mockito.verify(emailService).sendNotification(phoneArgumentCaptor.capture());

        Phone capturedPhone = phoneArgumentCaptor.getValue();
        Assertions.assertThat(capturedPhone).isEqualTo(phone);
    }

    @Test
    void readAll() {
        // given
        Phone phone = new Phone();
        phone.setName("Factory");
        phone.setCreationYear("2007");

        Mockito.when(phoneRepository.findAll()).thenReturn(List.of(phone));

        // when
        List<Phone> expected = underTest.readAll();

        // then
        Mockito.verify(phoneRepository).findAll();
        Assertions.assertThat(expected).isNotNull();
        Assertions.assertThat(expected.size()).isEqualTo(1);
        Assertions.assertThat(expected.get(0).getName()).isEqualTo(phone.getName());
        Assertions.assertThat(expected.get(0).getCreationYear()).isEqualTo(phone.getCreationYear());
    }

    @Test
    void read() {
        // given
        Phone phone = new Phone();
        phone.setName("I");
        phone.setCreationYear("2007");
        phone.setId(1L);
        Mockito.when(phoneRepository.findById(phone.getId())).thenReturn(Optional.of(phone));

        // when
        Phone expected = underTest.read(phone.getId());

        // then
        Mockito.verify(phoneRepository).findById(phone.getId());
        Assertions.assertThat(expected).isEqualTo(phone);
    }

    @Test
    void update() {
        // given
        Phone phone = new Phone();
        phone.setName("Factory");
        phone.setCreationYear("2007");
        phone.setId(1L);

        // when
        underTest.update(phone, phone.getId());

        // then
        Mockito.verify(phoneRepository).save(phone);
    }

    @Test
    void delete() {
        // given
        Phone phone = new Phone();
        phone.setName("Factory");
        phone.setCreationYear("2007");
        phone.setId(1L);

        // when
        underTest.delete(phone.getId());

        // then
        Mockito.verify(phoneRepository).deleteById(phone.getId());
    }

    @Test
    void findPhonesByName() {
        // given
        Phone phone = new Phone();
        phone.setName("Fabric");
        phone.setCreationYear("2007");

        Mockito.when(phoneRepository.findAllByName(phone.getName())).thenReturn(List.of(phone));

        // when
        List<Phone> existed = underTest.findPhonesByName(phone.getName());

        // then
        Assertions.assertThat(existed).isNotNull();
        Assertions.assertThat(existed.size()).isEqualTo(1);
        Assertions.assertThat(existed.get(0).getName()).isEqualTo(phone.getName());
        Assertions.assertThat(existed.get(0).getCreationYear()).isEqualTo(phone.getCreationYear());
    }

    @Test
    void findPhonesByYear() {
        // given
        Phone phone = new Phone();
        phone.setName("Fabric");
        phone.setCreationYear("2007");

        Mockito.when(phoneRepository.findAllByName(phone.getName())).thenReturn(List.of(phone));

        // when
        List<Phone> existed = underTest.findPhonesByName(phone.getName());

        // then
        Assertions.assertThat(existed).isNotNull();
        Assertions.assertThat(existed.size()).isEqualTo(1);
        Assertions.assertThat(existed.get(0).getName()).isEqualTo(phone.getName());
        Assertions.assertThat(existed.get(0).getCreationYear()).isEqualTo(phone.getCreationYear());
    }
}