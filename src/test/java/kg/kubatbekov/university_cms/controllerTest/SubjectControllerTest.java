package kg.kubatbekov.university_cms.controllerTest;

import kg.kubatbekov.university_cms.controller.SubjectController;
import kg.kubatbekov.university_cms.service.SubjectService;
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

@WebMvcTest(SubjectController.class)
public class SubjectControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SubjectService subjectService;

    @Test
    public void getSubjects_testGetSubjects_whenMethodReturnsValue() throws Exception{
        mockMvc.perform(get(Path.of("/subjects").toUri()))
                .andExpect(model().attributeExists("subjects"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
