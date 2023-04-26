package kg.kubatbekov.university_cms.service;

import kg.kubatbekov.university_cms.model.Student;
import kg.kubatbekov.university_cms.model.Subject;
import kg.kubatbekov.university_cms.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SubjectService {
    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    public int subjectsProfessorsSize() {
        List<Subject> subjects = subjectRepository.findAll();
        int size = 0;

        for (Subject subject : subjects) {
            size = size + subject.getProfessors().size();
        }
        return size;
    }

    public void save(Subject subject) {
        subjectRepository.save(subject);
    }

    public Optional<Subject> findById(int id){
        return subjectRepository.findById(id);
    }

    public Subject update(Subject subject) {
        return subjectRepository.save(subject);
    }

    public void deleteById(int id) {
        subjectRepository.deleteById(id);
    }
}
