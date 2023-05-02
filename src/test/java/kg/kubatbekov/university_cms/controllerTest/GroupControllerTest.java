package kg.kubatbekov.university_cms.controllerTest;

import kg.kubatbekov.university_cms.controller.GroupController;
import kg.kubatbekov.university_cms.service.GroupService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Path;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GroupController.class)
public class GroupControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GroupService groupService;

    @Test
    public void getGroups_testGetGroups_whenMethodReturnsValue() throws Exception {
        mockMvc.perform(get(Path.of("/groups").toUri()))
                .andExpect(model().attributeExists("groups"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
