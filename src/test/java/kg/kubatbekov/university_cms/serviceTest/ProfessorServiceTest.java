package kg.kubatbekov.university_cms.serviceTest;

import kg.kubatbekov.university_cms.service.ProfessorService;
import kg.kubatbekov.university_cms.model.Professor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProfessorServiceTest {
    @Autowired
    private ProfessorService professorService;

    @Test
    void getAll_testGetAllValues_whenThereIsValues() {
        int actual = professorService.findAll().size();
        Assertions.assertEquals(5, actual);
    }

    @Test
    void findById_testFindById_whenThereIsValues() {
        Optional<Professor> actual = professorService.findById(1);
        Assertions.assertNotNull(actual);
    }

}
