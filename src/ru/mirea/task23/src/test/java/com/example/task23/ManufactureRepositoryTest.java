package com.example.task23;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class ManufactureRepositoryTest {

    @Autowired
    private ManufactureRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    public void itShouldfindAllByName() {
        // given
        Manufacture manufacture = new Manufacture();
        manufacture.setName("Fabric");
        manufacture.setAddress("Moscow");
        underTest.save(manufacture);

        // when
        List<Manufacture> existed = underTest.findAllByName(manufacture.getName());

        // then
        Assertions.assertThat(existed).isNotNull();
        Assertions.assertThat(existed.size()).isEqualTo(1);
        Assertions.assertThat(existed.get(0).getName()).isEqualTo(manufacture.getName());
        Assertions.assertThat(existed.get(0).getAddress()).isEqualTo(manufacture.getAddress());
    }

    @Test
   public void itShouldfindAllByAddress() {
        // given
        Manufacture manufacture = new Manufacture();
        manufacture.setName("Fabric");
        manufacture.setAddress("Moscow");
        underTest.save(manufacture);

        // when
        List<Manufacture> existed = underTest.findAllByAddress(manufacture.getAddress());

        // then
        Assertions.assertThat(existed).isNotNull();
        Assertions.assertThat(existed.size()).isEqualTo(1);
        Assertions.assertThat(existed.get(0).getName()).isEqualTo(manufacture.getName());
        Assertions.assertThat(existed.get(0).getAddress()).isEqualTo(manufacture.getAddress());

    }
}