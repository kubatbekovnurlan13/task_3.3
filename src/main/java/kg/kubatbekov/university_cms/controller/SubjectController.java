package kg.kubatbekov.university_cms.controller;

import kg.kubatbekov.university_cms.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubjectController {
    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/subjects")
    public String getSubjects(Model model){
        model.addAttribute("subjects",subjectService.findAll());
        return "subjects";
    }
}
