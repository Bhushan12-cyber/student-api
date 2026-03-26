package com.example.studentapi.service;

import com.example.studentapi.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {

    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentService();  // Fresh instance before each test
    }

    @Test
    void testGetAllStudents_returnsThreeStudents() {
        List<Student> students = studentService.getAllStudents();
        assertEquals(3, students.size());
    }

    @Test
    void testGetStudentById_found() {
        assertTrue(studentService.getStudentById(1).isPresent());
    }

    @Test
    void testGetStudentById_notFound() {
        assertFalse(studentService.getStudentById(999).isPresent());
    }

    @Test
    void testAddStudent() {
        Student newStudent = new Student(0, "Amit", "Cloud", 85.0);
        studentService.addStudent(newStudent);
        assertEquals(4, studentService.getAllStudents().size());
    }

    @Test
    void testDeleteStudent_success() {
        boolean result = studentService.deleteStudent(1);
        assertTrue(result);
        assertEquals(2, studentService.getAllStudents().size());
    }

    @Test
    void testAverageGrade() {
        double avg = studentService.getAverageGrade();
        assertTrue(avg > 0);
    }
}