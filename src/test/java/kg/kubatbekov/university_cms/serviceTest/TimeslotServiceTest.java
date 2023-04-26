package kg.kubatbekov.university_cms.serviceTest;

import kg.kubatbekov.university_cms.service.TimeslotService;
import kg.kubatbekov.university_cms.ConsoleApp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class TimeslotServiceTest {
    @MockBean
    private ConsoleApp consoleApp;
    @Autowired
    private TimeslotService timeslotService;

    @Test
    void getAll_testGetAllValues_whenThereIsValues() {
        int actual = timeslotService.findAll().size();
        Assertions.assertEquals(25, actual);
    }

}
