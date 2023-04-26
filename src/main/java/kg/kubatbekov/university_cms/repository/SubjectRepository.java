package kg.kubatbekov.university_cms.repository;

import kg.kubatbekov.university_cms.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
