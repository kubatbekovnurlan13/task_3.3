package kg.kubatbekov.university_cms.controllerTest;

import kg.kubatbekov.university_cms.controller.RoomController;
import kg.kubatbekov.university_cms.service.RoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Path;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RoomController.class)
public class RoomControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoomService roomService;

    @Test
    public void getRooms_testGetRooms_whenMethodReturnsValue() throws Exception {
        mockMvc.perform(get(Path.of("/rooms").toUri()))
                .andExpect(model().attributeExists("rooms"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
