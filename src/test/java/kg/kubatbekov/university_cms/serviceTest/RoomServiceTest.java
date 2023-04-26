package kg.kubatbekov.university_cms.serviceTest;

import kg.kubatbekov.university_cms.service.RoomService;
import kg.kubatbekov.university_cms.ConsoleApp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class RoomServiceTest {
    @MockBean
    private ConsoleApp consoleApp;
    @Autowired
    private RoomService roomService;

    @Test
    void getAll_testGetAllValues_whenThereIsValues() {
        int actual = roomService.findAll().size();
        Assertions.assertEquals(4, actual);
    }

}
