package kg.kubatbekov.university_cms.controllerTest;

import kg.kubatbekov.university_cms.controller.MainController;
import kg.kubatbekov.university_cms.service.TimetableService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Path;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MainController.class)
public class MainControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TimetableService timetableService;

    @Test
    public void getIndex_testGetIndex_whenMethodDoNotReturnsValue() throws Exception {
        mockMvc.perform(get(Path.of("/").toUri()))
                .andExpect(status().isOk());
    }

//    @Test
//    public void testIndex() throws Exception {
//        File login = ResourceUtils.getFile("classpath:templates/main.html");
//        String html = new String(Files.readAllBytes(login.toPath()));
//
//        this.mockMvc.perform(get(Path.of("/").toUri()))
//                .andExpect(status().isOk())
//                .andExpect(content().string(html))
//                .andDo(print());
//    }
}
