package com.neomacro.codechallengeev.account.controller;

import com.fasterxml.jackson.databind.*;
import com.neomacro.codechallengeev.account.dto.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.http.*;
import org.springframework.test.context.web.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.result.*;
import org.springframework.test.web.servlet.setup.*;
import org.springframework.web.context.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@ExtendWith(MockitoExtension.class)
@WebAppConfiguration()
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@WebMvcTest(AccountController.class)
public class TestAccountController {

    @Mock
    private WebApplicationContext wac;

    @InjectMocks
    private AccountController accountController;

    private MockMvc mockMvc;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeEach // For Junit5
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
    }

    @Test
    public void getWithdraw() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/withdraw")
                        .content(asJsonString(new AccountDto()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.customerDto.email").exists());
    }
}
