package com.rafael.EmailApi.integration.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rafael.EmailApi.domain.dtos.EmailDTO;
import com.rafael.EmailApi.domain.services.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmailController.class)
@AutoConfigureMockMvc(addFilters = false)
public class EmailControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmailService emailService;

    @Test
    public void givenValidProductWhenCallPostProductThenSaveProduct() throws Exception {
        EmailDTO emailDTO = EmailDTO.builder()
                .withEmailBody("Test Body")
                .withTo(new String[]{"mail@mail.com"})
                .withFrom("mail@mail.com")
                .withSubject("Test")
                .build();

        mvc.perform(MockMvcRequestBuilders.post("/email").content(new ObjectMapper().writeValueAsString(emailDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
