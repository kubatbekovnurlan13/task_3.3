package kg.kubatbekov.university_cms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "subjects")
@Getter
@Setter
public class Subject {
    @Id
    @Column(name = "subject_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectId;

    //    subjectCode = something like “CS101” or “Hist302”
    @Column(name = "subject_code")
    private String subjectCode;

    @Column(name = "subject_name")
    private String subjectName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "subject_professor",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id"))
    private List<Professor> professors;

    @ManyToMany(mappedBy = "subjects", fetch = FetchType.EAGER)
    private List<Group> groups;

    @OneToMany(mappedBy = "subject")
    private List<Lesson> cours;

    public Subject() {
    }

    public Subject(int subjectId, String subjectCode, String subjectName) {
        this.subjectId = subjectId;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
    }

    public int getRandomProfessorId() {
        return this.professors.get((int) (this.professors.size() * Math.random())).getProfessorId();
    }
}
