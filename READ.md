#  University CMS Console Application

### All models
We have models for building application:

* Course
* Group
* Professor
* Room
* Student
* Subject
* Timeslot

### Definitions
Definition of models:

* **Room** model -  represents oddly enough a room. 
  It has id, room number and capacity.
* **Timeslot** model - represents one unit of time for lesson.
  Like -> _Monday-9:00-10:30_. It has id, weekday(enum) and duration(enum).
* **Subject** model - represents subject for lesson.
    It has id, subject name, subject code and professor of subject.
* **Student** model - represents student. It has id, name, surname, 
        age and Group to which it belongs.
* **Professor** model - represents teacher. It has id, name and list of subjects.
* **Group** model - resents student group.
    It has id, name, grade, list of subjects and list of students.
* **Course** model - represents one class at unique Timeslot with unique Room, also Course 
    has Teacher which teaches certain Subject to one Group. 
  Actually lesson can not have duplicate. The list of certain Courses is make up schedule(timetable). 

### How it works in general
   
 First of all, timetable build with  algorithm named Genetic algorithm.
It is evangelical algorithm that simulates so-called nature evolution process,
it evolves, mutates, crossovers with other individuals and select result.
And sooner or later gives the best possible solution at range of certain evolution cycle or at limit of 
generation(you can pick max. limit of generation).

### About Schedule Generator classes

* **Solution class** represents one possible solution to the problem.
* **Population class** is many solutions, it helps to get best solution by making some operation
     to population like: sorting, mutating and crossover etc.
* **Timetable class**  represents a potential solution in human-readable form, 
  unlike a Solution or a (chromosome). This timetable class, then, can read a Solution class 
  and develop a timetable from it, and ultimately can evaluate the timetable
  for its fitness and number of scheduling clashes.
* **Genetic Algorithm class** represent execution of main operations mutation and crossover.
* **Console Application class** is executes all above classes, saves results and shows them.

