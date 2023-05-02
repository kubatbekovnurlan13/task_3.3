package kg.kubatbekov.university_cms.controllerTest;

import kg.kubatbekov.university_cms.controller.ProfessorController;
import kg.kubatbekov.university_cms.service.ProfessorService;
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

@WebMvcTest(ProfessorController.class)
public class ProfessorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProfessorService professorService;

    @Test
    public void getProfessors_testGetProfessors_whenMethodReturnsValue() throws Exception {
        mockMvc.perform(get(Path.of("/professors").toUri()))
                .andExpect(model().attributeExists("professors"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
