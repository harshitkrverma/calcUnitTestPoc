package com.harsh;

import com.harsh.controller.CalculatorController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAdd() throws Exception {
        mockMvc.perform(get("/add")
                        .param("a", "2")
                        .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }

    @Test
    void testSubtract() throws Exception {
        mockMvc.perform(get("/subtract")
                        .param("a", "5")
                        .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("2.0"));
    }

    @Test
    void testMultiply() throws Exception {
        mockMvc.perform(get("/multiply")
                        .param("a", "2")
                        .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("6.0"));
    }

    @Test
    void testDivide() throws Exception {
        mockMvc.perform(get("/divide")
                        .param("a", "6")
                        .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("2.0"));
    }

    @Test
    void testDivideByZero() throws Exception {
        mockMvc.perform(get("/divide")
                        .param("a", "6")
                        .param("b", "0"))
                .andExpect(status().isInternalServerError());
    }
}
