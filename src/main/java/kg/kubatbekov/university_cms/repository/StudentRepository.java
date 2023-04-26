package kg.kubatbekov.university_cms.repository;

import kg.kubatbekov.university_cms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}