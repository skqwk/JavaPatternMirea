package com.example.task23;

import com.example.task23.auth.ApplicationUserService;
import com.example.task23.auth.User;
import com.example.task23.auth.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    ApplicationUserService underTest;

    @BeforeEach
    public void setUp() {
        underTest = new ApplicationUserService(new BCryptPasswordEncoder(10), userRepository);
    }

    @Test
    public void getUsers() {
        // given
        User user = new User();
        user.setUsername("user");

        // when
        Mockito.when(userRepository.findUserByUsername(user.getUsername())).thenReturn(user);

        // then
        Assertions.assertEquals(user.getUsername(), underTest.loadUserByUsername(user.getUsername()).getUsername());
    }

    @Test
    public void saveOrUpdate() {

    }
}
