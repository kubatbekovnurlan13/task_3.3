package kg.kubatbekov.university_cms.serviceTest;

import kg.kubatbekov.university_cms.service.StudentService;
import kg.kubatbekov.university_cms.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Test
    void findById_testFindById_whenThereIsValues() {
        Optional<Student> actual = studentService.findById(1);
        Assertions.assertNotNull(actual);
    }

}
