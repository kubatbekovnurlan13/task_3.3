package kg.kubatbekov.university_cms.controllerTest;

import kg.kubatbekov.university_cms.controller.TimeslotController;
import kg.kubatbekov.university_cms.service.TimeslotService;
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

@WebMvcTest(TimeslotController.class)
public class TimeslotControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TimeslotService timeslotService;

    @Test
    public void getTimeslots_testGetTimeslots_whenMethodReturnsValue() throws Exception {
        mockMvc.perform(get(Path.of("/timeslots").toUri()))
                .andExpect(model().attributeExists("timeslots"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
