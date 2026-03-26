package com.example.studentapi.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;  // Simulates HTTP requests without a real server

    @Test
    void testGetAllStudents_returns200() throws Exception {
        mockMvc.perform(get("/api/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }

    @Test
    void testGetStudentById_found() throws Exception {
        mockMvc.perform(get("/api/students/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Bhushan"));
    }

    @Test
    void testGetStudentById_notFound() throws Exception {
        mockMvc.perform(get("/api/students/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetAverageGrade() throws Exception {
        mockMvc.perform(get("/api/students/average"))
                .andExpect(status().isOk());
    }
}