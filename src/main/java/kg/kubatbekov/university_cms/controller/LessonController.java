package kg.kubatbekov.university_cms.controller;

import kg.kubatbekov.university_cms.model.Lesson;
import kg.kubatbekov.university_cms.service.LessonService;
import kg.kubatbekov.university_cms.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LessonController {
    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/lessons")
    public String getLessons(Model model) {
        model.addAttribute("lessons", lessonService.findAll());
        return "lessons";
    }
}
