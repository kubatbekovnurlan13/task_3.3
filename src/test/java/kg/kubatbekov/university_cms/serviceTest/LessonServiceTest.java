package kg.kubatbekov.university_cms.serviceTest;

import kg.kubatbekov.university_cms.container.PostgresContainer;
import kg.kubatbekov.university_cms.service.LessonService;
import kg.kubatbekov.university_cms.model.*;
import kg.kubatbekov.university_cms.ConsoleApp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class LessonServiceTest extends PostgresContainer {
    @MockBean
    private ConsoleApp consoleApp;

    @Autowired
    private LessonService lessonService;

    @Test
    void findAll_testFindAll_whenThereNoValueInput() {
        List<Lesson> cours = lessonService.findAll();
        int actual = cours.size();
        Assertions.assertEquals(0, actual);
    }

    @Test
    void findByGroupId_testFindByGroupId_whenThereNoValueInput() {
        List<Lesson> cours = lessonService.findByGroupId(1);
        int actual = cours.size();
        Assertions.assertEquals(0, actual);
    }

    @Test
    void findByProfessorId_testFindByProfessorId_whenThereNoValueInput() {
        List<Lesson> cours = lessonService.findByProfessorId(1);
        int actual = cours.size();
        Assertions.assertEquals(0, actual);
    }

    @Nested
    class TestNest {
        @BeforeEach
        public void saveCourse() {
            Room room = new Room(1, "a1", 15);
            Timeslot timeslot = new Timeslot(1, Timeslot.Weekday.wednesday, Timeslot.Duration.fifth_period.getHours());
            Professor professor = new Professor(1, "Mr. Jack");
            Subject subject = new Subject(1, "subject code ", "subject name");
            Group group = new Group(1, "group name ", 1);

            Lesson lesson = new Lesson(1, group, subject, professor, timeslot, room);
            List<Lesson> newCours = new ArrayList<>();
            newCours.add(lesson);
            lessonService.saveAll(newCours);
        }

        @Test
        void findAll_testFindAll_whenThereIsValueInput() {
            List<Lesson> cours = lessonService.findAll();
            int actual = cours.size();
            Assertions.assertEquals(1, actual);
        }

        @Test
        void findByGroupId_testFindByGroupId_whenThereIsValueInput() {
            List<Lesson> cours = lessonService.findByGroupId(1);
            int actual = cours.size();
            Assertions.assertEquals(1, actual);
        }

        @Test
        void findByProfessorId_testFindByProfessorId_whenThereIsValueInput() {
            List<Lesson> cours = lessonService.findByProfessorId(1);
            int actual = cours.size();
            Assertions.assertEquals(1, actual);
        }
    }
}
