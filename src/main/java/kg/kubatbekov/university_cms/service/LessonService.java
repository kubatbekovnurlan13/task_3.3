package kg.kubatbekov.university_cms.service;

import kg.kubatbekov.university_cms.model.Lesson;
import kg.kubatbekov.university_cms.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LessonService {
    private final LessonRepository lessonRepository;

    @Autowired
    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public void saveAll(List<Lesson> courses) {
        lessonRepository.saveAll(courses);
    }

    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    public void deleteAll() {
        lessonRepository.deleteAll();
    }

    public List<Lesson> findByGroupId(int groupId) {
        return lessonRepository
                .findAll()
                .stream()
                .filter(course -> course.getGroup().getGroupId() == groupId)
                .toList();
    }

    public List<Lesson> findByProfessorId(int professorId) {
        return lessonRepository
                .findAll()
                .stream()
                .filter(course -> course.getProfessor().getProfessorId() == professorId)
                .toList();
    }

    public void save(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    public Optional<Lesson> findById(int id) {
        return lessonRepository.findById(id);
    }

    public Lesson update(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public void deleteById(int id) {
        lessonRepository.deleteById(id);
    }
}
