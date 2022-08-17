package com.studentmanagement.student.management.repository;

import com.studentmanagement.student.management.entity.Guardian;
import com.studentmanagement.student.management.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("sonthuol@gmail.com")
                .firstName("Son")
                .lastName("Thuol")
//                .guardianName("Son Thuong")
//                .guardianEmail("sonthuong@gmail.com")
//                .guardianMobile("0377087266")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Son Thuong")
                .email("sonthuong@gmail.com")
                .mobile("0377087266")
                .build();

        Student student = Student.builder()
                .emailId("sonthe@gmail.com")
                .firstName("Son")
                .lastName("The")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> studentList = studentRepository.findByFirstName("Son");

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> studentList = studentRepository.findByFirstNameContaining("So");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentBasedOnGuardienName(){
        List<Student> studentList = studentRepository.findByGuardianName("Son Thuong");

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printGetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("sonthe@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void getStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddress("sonthe@gmail.com");

        System.out.println("student = " + student);
    }
}