package com.studentmanagement.student.management.repository;

import com.studentmanagement.student.management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByGuardianName(String guardianName);

    // JPQL
    @Query("SELECT student FROM Student student WHERE student.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    // Native
    @Query(
            value = "SELECT * FROM tbl_student WHERE email_id = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

}
