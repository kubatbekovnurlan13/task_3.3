package kg.kubatbekov.university_cms.service;

import kg.kubatbekov.university_cms.model.Subject;
import kg.kubatbekov.university_cms.model.Timeslot;
import kg.kubatbekov.university_cms.repository.TimeslotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Repository
public class TimeslotService {
    private final TimeslotRepository timeslotRepository;

    @Autowired
    public TimeslotService(TimeslotRepository timeslotRepository) {
        this.timeslotRepository = timeslotRepository;
    }

    public List<Timeslot> findAll() {
        return timeslotRepository.findAll();
    }

    public void save(Timeslot timeslot) {
        timeslotRepository.save(timeslot);
    }

    public Optional<Timeslot> findById(int id){
        return timeslotRepository.findById(id);
    }

    public Timeslot update(Timeslot timeslot) {
        return timeslotRepository.save(timeslot);
    }

    public void deleteById(int id) {
        timeslotRepository.deleteById(id);
    }
}
