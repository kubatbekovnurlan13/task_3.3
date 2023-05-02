package kg.kubatbekov.university_cms.serviceTest;

import kg.kubatbekov.university_cms.service.RoomService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoomServiceTest {
    @Autowired
    private RoomService roomService;

    @Test
    void getAll_testGetAllValues_whenThereIsValues() {
        int actual = roomService.findAll().size();
        Assertions.assertEquals(4, actual);
    }

}
