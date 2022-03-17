package com.example.task23;

import com.example.task23.services.EmailService;
import com.example.task23.services.ManufactureService;
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
public class ManufactureServiceTest {

    @Mock
    private EmailService emailService;
    @Mock
    private ManufactureRepository manufactureRepository;
    private ManufactureService underTest;

    @BeforeEach
    public void setUp() {
        underTest = new ManufactureService(manufactureRepository, emailService);
    }

    @Test
    public void create() {
        // given
        Manufacture manufacture = new Manufacture();
        manufacture.setName("Factory");
        manufacture.setAddress("Moscow");

        // when
        underTest.create(manufacture);

        // then
        ArgumentCaptor<Manufacture> manufactureArgumentCaptor =
                ArgumentCaptor.forClass(Manufacture.class);

        Mockito.verify(manufactureRepository).save(manufactureArgumentCaptor.capture());
        Mockito.verify(emailService).sendNotification(manufactureArgumentCaptor.capture());

        Manufacture capturedManufacture = manufactureArgumentCaptor.getValue();
        Assertions.assertThat(capturedManufacture).isEqualTo(manufacture);
    }

    @Test
    public void readAll() {
        // given
        Manufacture manufacture = new Manufacture();
        manufacture.setName("Factory");
        manufacture.setAddress("Moscow");

        Mockito.when(manufactureRepository.findAll()).thenReturn(List.of(manufacture));

        // when
        List<Manufacture> expected = underTest.readAll();

        // then
        Mockito.verify(manufactureRepository).findAll();
        Assertions.assertThat(expected).isNotNull();
        Assertions.assertThat(expected.size()).isEqualTo(1);
        Assertions.assertThat(expected.get(0).getName()).isEqualTo(manufacture.getName());
        Assertions.assertThat(expected.get(0).getAddress()).isEqualTo(manufacture.getAddress());

    }

    @Test
    public void read() {
        // given
        Manufacture manufacture = new Manufacture();
        manufacture.setName("Factory");
        manufacture.setAddress("Moscow");
        manufacture.setId(1);
        Mockito.when(manufactureRepository.findById(manufacture.getId())).thenReturn(Optional.of(manufacture));

        // when
        Manufacture expected = underTest.read(manufacture.getId());

        // then
        Mockito.verify(manufactureRepository).findById(manufacture.getId());
        Assertions.assertThat(expected).isEqualTo(manufacture);

    }

    @Test
    public void update() {
        // given
        Manufacture manufacture = new Manufacture();
        manufacture.setName("Factory");
        manufacture.setAddress("Moscow");
        manufacture.setId(1);

        // when
        underTest.update(manufacture, manufacture.getId());

        // then
        Mockito.verify(manufactureRepository).save(manufacture);
    }

    @Test
    public void delete() {
        // given
        Manufacture manufacture = new Manufacture();
        manufacture.setName("Factory");
        manufacture.setAddress("Moscow");
        manufacture.setId(1);

        // when
        underTest.delete(manufacture.getId());

        // then
        Mockito.verify(manufactureRepository).deleteById(manufacture.getId());
    }

    @Test
    public void findManufacturesByAddress() {
        // given
        Manufacture manufacture = new Manufacture();
        manufacture.setName("Fabric");
        manufacture.setAddress("Moscow");

        Mockito.when(manufactureRepository.findAllByAddress(manufacture.getAddress())).thenReturn(List.of(manufacture));

        // when
        List<Manufacture> existed = underTest.findManufacturesByAddress(manufacture.getAddress());

        // then
        Assertions.assertThat(existed).isNotNull();
        Assertions.assertThat(existed.size()).isEqualTo(1);
        Assertions.assertThat(existed.get(0).getName()).isEqualTo(manufacture.getName());
        Assertions.assertThat(existed.get(0).getAddress()).isEqualTo(manufacture.getAddress());
    }

    @Test
    public void findManufacturesByName() {
        // given
        Manufacture manufacture = new Manufacture();
        manufacture.setName("Fabric");
        manufacture.setAddress("Moscow");

        Mockito.when(manufactureRepository.findAllByName(manufacture.getName())).thenReturn(List.of(manufacture));

        // when
        List<Manufacture> existed = underTest.findManufacturesByName(manufacture.getName());

        // then
        Assertions.assertThat(existed).isNotNull();
        Assertions.assertThat(existed.size()).isEqualTo(1);
        Assertions.assertThat(existed.get(0).getName()).isEqualTo(manufacture.getName());
        Assertions.assertThat(existed.get(0).getAddress()).isEqualTo(manufacture.getAddress());
    }
}