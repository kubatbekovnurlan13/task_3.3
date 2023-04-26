package kg.kubatbekov.university_cms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//      The Course represents a combination of all of the above. It represents a
//        student group taking a section of a module at a specific time, in a specific room,
//        with a specific professor.
@Entity
@Table(name = "courses")
@Getter
@Setter
public class Lesson {
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "professor_id", referencedColumnName = "professor_id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "timeslot_id", referencedColumnName = "timeslot_id")
    private Timeslot timeslot;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    private Room room;

    public Lesson() {
    }

    public Lesson(int courseId, Group group, Subject subject) {
        this.courseId = courseId;
        this.group = group;
        this.subject = subject;
    }

    public Lesson(
            int courseId,
            Group group,
            Subject subject,
            Professor professor,
            Timeslot timeslot,
            Room room) {
        this.courseId = courseId;
        this.group = group;
        this.subject = subject;
        this.professor = professor;
        this.timeslot = timeslot;
        this.room = room;
    }
}
