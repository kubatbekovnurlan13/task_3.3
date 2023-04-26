package kg.kubatbekov.university_cms.generator;

import kg.kubatbekov.university_cms.model.*;

import java.util.ArrayList;
import java.util.List;


/**
 * A timetable represents a potential solution in human-readable form, unlike a
 * Solution or a (chromosome). This timetable class, then, can read a Solution class
 * and develop a timetable from it, and ultimately can evaluate the timetable
 * for its fitness and number of scheduling clashes.
 * <p>
 * The most important methods in this class are createCourses and calcClashes.
 */
public class Timetable {
    private final List<Room> rooms;
    private final List<Professor> professors;
    private final List<Subject> subjects;
    private final List<Group> groups;
    private final List<Timeslot> timeslots;

    private List<Lesson> cours;

    public Timetable() {
        this.rooms = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.subjects = new ArrayList<>();
        this.groups = new ArrayList<>();
        this.timeslots = new ArrayList<>();
    }

    public Timetable(Timetable cloneable) {
        this.rooms = cloneable.getRooms();
        this.professors = cloneable.getProfessors();
        this.subjects = cloneable.getSubjects();
        this.groups = cloneable.getGroups();
        this.timeslots = cloneable.getTimeslots();
    }


    /**
     * The createClasses method accepts a Solution (really, a chromosome, or course-bones),
     * unpacks its chromosome, and creates Course objects from the genetic
     * information. Course objects are lightweight; they're just containers for
     * information with getters and setters, but it's more convenient to work with
     * them than with the chromosome(course-bones) directly.
     */
    public void createCourses(Solution solution) {
        List<Lesson> classes = new ArrayList<>();

        // Get solution's solutionChromosome
        List<Integer> solutionChromosome = solution.getChromosome();
        int chromosomePosition = 0;
        int courseIndex = 1;

        for (Group group : this.getGroups()) {
            for (Subject subject : group.getSubjects()) {
                //Add course to list of Courses
                Lesson lesson = new Lesson(courseIndex, group, subject);

                // Add timeslot to the course
                addTimeslotToCourse(lesson, solutionChromosome, chromosomePosition);
                chromosomePosition++;

                // Add room to the course
                addRoomToCourse(lesson, solutionChromosome, chromosomePosition);
                chromosomePosition++;

                // Add professor to the course
                addProfessorToCourse(lesson, solutionChromosome, chromosomePosition);
                chromosomePosition++;

                classes.add(lesson);
                courseIndex++;
            }
        }
        this.cours = classes;
    }

    private void addTimeslotToCourse(
            Lesson lesson,
            List<Integer> solutionChromosome,
            int chromosomePosition) {
        // Add timeslot to the course
        int timeslotId = solutionChromosome.get(chromosomePosition);
        lesson.setTimeslot(getTimeslotById(timeslotId));
    }

    private void addRoomToCourse(
            Lesson lesson,
            List<Integer> solutionChromosome,
            int chromosomePosition) {
        // Add room to the course
        int roomId = solutionChromosome.get(chromosomePosition);
        lesson.setRoom(getRoomById(roomId));
    }

    private void addProfessorToCourse(
            Lesson lesson,
            List<Integer> solutionChromosome,
            int chromosomePosition) {
        // Add professor to the course
        int professorId = solutionChromosome.get(chromosomePosition);
        lesson.setProfessor(getProfessorById(professorId));
    }

    /**
     * The calcClashes method is used by GeneticAlgorithm.calcFitness, and requires
     * that createCourses has been run first. calcClashes looks at the Courses objects
     * created by createCourses, and figures out how many hard constraints have been
     * violated.
     */
    public int calculateClashes() {
        int clashes = 0;
        for (Lesson underTestLesson : this.cours) {

            clashes = checkRoomCapacity(underTestLesson, clashes);

            clashes = isRoomTaken(underTestLesson, clashes);

            clashes = isProfessorAvailable(underTestLesson, clashes);

        }
        return clashes;
    }

    private int checkRoomCapacity(Lesson underTestLesson, int clashes) {
        // Check room capacity
        int roomCapacity = underTestLesson.getRoom().getCapacity();
        int groupSize = underTestLesson.getGroup().getGroupSize();
        if (roomCapacity < groupSize) {
            clashes++;
        }
        return clashes;
    }

    private int isRoomTaken(Lesson underTestLesson, int clashes) {
        // Check if room is taken
        for (Lesson otherLesson : this.cours) {
            if (underTestLesson.getRoom().getRoomId() == otherLesson.getRoom().getRoomId()
                    && underTestLesson.getTimeslot().getTimeslotId() == otherLesson.getTimeslot().getTimeslotId()
                    && underTestLesson.getCourseId() != otherLesson.getCourseId()) {
                clashes++;
                break;
            }
        }
        return clashes;
    }

    private int isProfessorAvailable(Lesson underTestLesson, int clashes) {
        // Check if professor is available
        for (Lesson otherLesson : this.cours) {
            if (underTestLesson.getProfessor().getProfessorId() == otherLesson.getProfessor().getProfessorId()
                    && underTestLesson.getTimeslot().getTimeslotId() == otherLesson.getTimeslot().getTimeslotId()
                    && underTestLesson.getCourseId() != otherLesson.getCourseId()) {
                clashes++;
                break;
            }
        }
        return clashes;
    }

    public Room getRoomById(int roomId) {
        return this.rooms.stream()
                .filter(x -> x.getRoomId() == roomId)
                .toList().get(0);
    }

    public Professor getProfessorById(int professorId) {
        return this.professors.stream()
                .filter(x -> x.getProfessorId() == professorId)
                .toList().get(0);
    }

    public Subject getSubjectById(int subjectId) {
        return this.subjects.stream()
                .filter(subject -> subject.getSubjectId() == subjectId)
                .toList().get(0);
    }

    public Group getGroupById(int groupId) {
        return this.groups.stream()
                .filter(group -> group.getGroupId() == groupId)
                .toList().get(0);
    }

    public Timeslot getTimeslotById(int timeslotId) {
        return this.timeslots.stream()
                .filter(timeslot -> timeslot.getTimeslotId() == timeslotId)
                .toList().get(0);
    }

    public Timeslot getRandomTimeslot() {
        return this.timeslots.get((int) (this.timeslots.size() * Math.random()));
    }

    public Room getRandomRoom() {
        return this.rooms.get((int) (this.rooms.size() * Math.random()));
    }

    public List<Room> getRooms() {
        return this.rooms;
    }

    public List<Lesson> getCourses() {
        return this.cours;
    }

    public List<Group> getGroups() {
        return this.groups;
    }

    private List<Timeslot> getTimeslots() {
        return this.timeslots;
    }

    private List<Subject> getSubjects() {
        return this.subjects;
    }

    private List<Professor> getProfessors() {
        return this.professors;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms.addAll(rooms);
    }

    public void setTimeslots(List<Timeslot> timeslots) {
        this.timeslots.addAll(timeslots);
    }

    public void setProfessors(List<Professor> professors) {
        this.professors.addAll(professors);
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects.addAll(subjects);
    }

    public void setGroups(List<Group> groups) {
        this.groups.addAll(groups);
    }
}
