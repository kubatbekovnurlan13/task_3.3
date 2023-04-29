package kg.kubatbekov.university_cms.controller;

import kg.kubatbekov.university_cms.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfessorController {

    private final ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping("/professors")
    public String getProfessors(Model model) {
        model.addAttribute("professors", professorService.findAll());
        return "professors";
    }
}
