package kg.kubatbekov.university_cms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "professors")
@Getter
@Setter
public class Professor {
    @Id
    @Column(name = "professor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int professorId;

    @Column(name = "professor_name")
    private String professorName;

    @ManyToMany(mappedBy = "professors", fetch = FetchType.EAGER)
    private List<Subject> subjects;

    @OneToMany(mappedBy = "professor")
    private List<Lesson> cours;

    public Professor() {
    }

    public Professor(int professorId, String professorName) {
        this.professorId = professorId;
        this.professorName = professorName;
    }
}
