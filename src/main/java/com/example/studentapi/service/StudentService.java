package com.example.studentapi.service;

import com.example.studentapi.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    // In-memory list (no database needed for now)
    private List<Student> students = new ArrayList<>();
    private int nextId = 1;

    public StudentService() {
        // Preload some students
        students.add(new Student(nextId++, "Bhushan", "DevOps", 88.5));
        students.add(new Student(nextId++, "Ravi",    "Java",   92.0));
        students.add(new Student(nextId++, "Sneha",   "Python", 79.0));
    }

    // Get all students
    public List<Student> getAllStudents() {
        return students;
    }

    // Get student by ID
    public Optional<Student> getStudentById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
    }

    // Add new student
    public Student addStudent(Student student) {
        student.setId(nextId++);
        students.add(student);
        return student;
    }

    // Delete student
    public boolean deleteStudent(int id) {
        return students.removeIf(s -> s.getId() == id);
    }

    // Get average grade
    public double getAverageGrade() {
        return students.stream()
                .mapToDouble(Student::getGrade)
                .average()
                .orElse(0.0);
    }
}