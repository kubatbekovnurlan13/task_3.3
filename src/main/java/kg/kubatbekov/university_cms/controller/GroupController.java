package kg.kubatbekov.university_cms.controller;

import kg.kubatbekov.university_cms.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GroupController {
    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/groups")
    public String getGroups(Model model){
        model.addAttribute("groups",groupService.findAll());
        return "groups";
    }
}
