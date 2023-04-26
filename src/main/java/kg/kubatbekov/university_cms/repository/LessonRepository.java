package kg.kubatbekov.university_cms.repository;


import kg.kubatbekov.university_cms.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
}
