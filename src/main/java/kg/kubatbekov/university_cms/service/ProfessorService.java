package kg.kubatbekov.university_cms.service;

import kg.kubatbekov.university_cms.model.Professor;
import kg.kubatbekov.university_cms.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public void save(Professor professor) {
        professorRepository.save(professor);
    }

    public Optional<Professor> findById(int professorId) {
        return professorRepository.findById(professorId);
    }

    public Professor update(Professor professor) {
        return professorRepository.save(professor);
    }

    public void deleteById(int id) {
        professorRepository.deleteById(id);
    }

}
