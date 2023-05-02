package kg.kubatbekov.university_cms.serviceTest;

import kg.kubatbekov.university_cms.service.SubjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SubjectServiceTest {
    @Autowired
    private SubjectService subjectService;

    @Test
    void getAll_testGetAllValues_whenThereIsValues() {
        int actual = subjectService.findAll().size();
        Assertions.assertEquals(6, actual);
    }

    @Test
    void groupsSubjectsSize_testGroupsSubjectsSize_whenThereIsValues() {
        int actual = subjectService.subjectsProfessorsSize();
        Assertions.assertEquals(13, actual);
    }

}
