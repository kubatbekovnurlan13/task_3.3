package kg.kubatbekov.university_cms.serviceTest;

import kg.kubatbekov.university_cms.service.TimeslotService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TimeslotServiceTest {
    @Autowired
    private TimeslotService timeslotService;

    @Test
    void getAll_testGetAllValues_whenThereIsValues() {
        int actual = timeslotService.findAll().size();
        Assertions.assertEquals(25, actual);
    }
}
