package kg.kubatbekov.university_cms.repository;

import kg.kubatbekov.university_cms.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
