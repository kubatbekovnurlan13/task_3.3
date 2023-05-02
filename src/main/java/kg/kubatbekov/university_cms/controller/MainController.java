package kg.kubatbekov.university_cms.controller;

import kg.kubatbekov.university_cms.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private final TimetableService timetableService;

    @Autowired
    public MainController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    private void createTimetable() {
        timetableService.runTimetableService();
    }

    @GetMapping("/")
    public String getIndex() {
        createTimetable();
        return "main";
    }
}
