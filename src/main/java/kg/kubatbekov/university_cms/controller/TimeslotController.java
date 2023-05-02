package kg.kubatbekov.university_cms.controller;

import kg.kubatbekov.university_cms.service.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TimeslotController {
    private final TimeslotService timeslotService;

    @Autowired
    public TimeslotController(TimeslotService timeslotService) {
        this.timeslotService = timeslotService;
    }

    @GetMapping("/timeslots")
    public String getTimeslots(Model model){
        model.addAttribute("timeslots",timeslotService.findAll());
        return "timeslots";
    }
}
