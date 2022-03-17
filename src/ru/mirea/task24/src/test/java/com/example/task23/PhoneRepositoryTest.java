package com.example.task23;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class PhoneRepositoryTest {

    @Autowired
    private PhoneRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void findAllByCreationYear() {
        // given
        Phone phone = new Phone();
        phone.setName("IPhone");
        phone.setCreationYear("2007");
        underTest.save(phone);

        // when
        List<Phone> existed = underTest.findAllByCreationYear(phone.getCreationYear());

        // then
        Assertions.assertThat(existed).isNotNull();
        Assertions.assertThat(existed.size()).isEqualTo(1);
        Assertions.assertThat(existed.get(0).getName()).isEqualTo(phone.getName());
        Assertions.assertThat(existed.get(0).getCreationYear()).isEqualTo(phone.getCreationYear());
    }

    @Test
    void findAllByName() {
        // given
        Phone phone = new Phone();
        phone.setName("IPhone");
        phone.setCreationYear("2007");
        underTest.save(phone);

        // when
        List<Phone> existed = underTest.findAllByName(phone.getName());

        // then
        Assertions.assertThat(existed).isNotNull();
        Assertions.assertThat(existed.size()).isEqualTo(1);
        Assertions.assertThat(existed.get(0).getName()).isEqualTo(phone.getName());
        Assertions.assertThat(existed.get(0).getCreationYear()).isEqualTo(phone.getCreationYear());
    }
}