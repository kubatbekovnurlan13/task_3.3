package kg.kubatbekov.university_cms.serviceTest;

import kg.kubatbekov.university_cms.service.StudentService;
import kg.kubatbekov.university_cms.model.Student;
import kg.kubatbekov.university_cms.ConsoleApp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class StudentServiceTest {
    @MockBean
    private ConsoleApp consoleApp;
    @Autowired
    private StudentService studentService;

    @Test
    void findById_testFindById_whenThereIsValues() {
        Optional<Student> actual = studentService.findById(1);
        Assertions.assertNotNull(actual);
    }

}
