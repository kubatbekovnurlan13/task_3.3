package kg.kubatbekov.university_cms.serviceTest;

import kg.kubatbekov.university_cms.container.PostgresContainer;
import kg.kubatbekov.university_cms.service.GroupService;
import kg.kubatbekov.university_cms.ConsoleApp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class GroupServiceTest extends PostgresContainer {
    @MockBean
    private ConsoleApp consoleApp;
    @Autowired
    private GroupService groupService;

    @Test
    void getAll_testGetAllValues_whenThereIsValues() {
        int actual = groupService.findAll().size();
        Assertions.assertEquals(5, actual);
    }

    @Test
    void groupsSubjectsSize_testGroupsSubjectsSize_whenThereIsValues() {
        int actual = groupService.groupsSubjectsSize();
        Assertions.assertEquals(26, actual);
    }

}
