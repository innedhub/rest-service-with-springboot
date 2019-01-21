package com.backend.tasks.utils;

import com.backend.tasks.ApplicationTest;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles(value = "production")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfileTest {
    @Autowired
    private Environment environment;

    @Value("${server.address}")
    private String serverAddress;

    @Test
    public void testProfile() {
        Assertions.assertThat(environment.getActiveProfiles()).isEqualTo(new String[] {"production"} );
        Assertions.assertThat(serverAddress).isEqualTo("192.168.1.120");
    }

}
