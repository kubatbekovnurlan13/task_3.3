package kg.kubatbekov.university_cms.service;

import kg.kubatbekov.university_cms.model.Room;
import kg.kubatbekov.university_cms.model.Student;
import kg.kubatbekov.university_cms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public Optional<Student> findById(int id){
        return studentRepository.findById(id);
    }

    public Student update(Student student) {
        return studentRepository.save(student);
    }

    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }
}
