package kg.kubatbekov.university_cms.controllerTest;

import kg.kubatbekov.university_cms.controller.LessonController;
import kg.kubatbekov.university_cms.service.LessonService;
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

@WebMvcTest(LessonController.class)
public class LessonControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LessonService lessonService;

    @Test
    public void getLessons_testGetLessons_whenMethodReturnsValue() throws Exception {
        mockMvc.perform(get(Path.of("/lessons").toUri()))
                .andExpect(model().attributeExists("lessons"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
