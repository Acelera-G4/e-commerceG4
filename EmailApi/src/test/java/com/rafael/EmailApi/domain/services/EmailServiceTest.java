package com.rafael.EmailApi.domain.services;

import com.rafael.EmailApi.EmailApiApplication;
import com.rafael.EmailApi.domain.dtos.EmailDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = EmailApiApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Test
    public void givenValidEmailDTOWhenCallSendThenDontReturnError() {
        EmailDTO emailDTO = EmailDTO.builder()
                .withEmailBody("Test Body")
                .withTo(new String[]{"mail@mail.com"})
                .withFrom("mail@mail.com")
                .withSubject("Test")
                .build();

        assertDoesNotThrow(() -> emailService.send(emailDTO));
    }


}
