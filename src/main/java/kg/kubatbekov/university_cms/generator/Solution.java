package kg.kubatbekov.university_cms.generator;

import kg.kubatbekov.university_cms.model.Group;
import kg.kubatbekov.university_cms.model.Subject;

import java.util.ArrayList;
import java.util.List;


/**
 * Class Solution is one possible solution to the problem.
 */
public class Solution {
    private final List<Integer> chromosome;
    private double fitness = -1;

    /**
     * This constructor makes bone(skeleton) for courses:
     * randomly without any calculations.
     * It can be needed for crossover between population.
     */
    public Solution(int chromosomeLength) {
        // Create random individual
        List<Integer> individual = new ArrayList<>();

        for (int gene = 0; gene < chromosomeLength; gene++) {
            individual.add(gene);
        }
        this.chromosome = individual;
    }

    /**
     * This constructor makes bone(skeleton) for courses:
     * one bone(skeleton) looks like -> [timeId,roomId,professorId],
     * and then adds them to List without separation
     * like : [timeId,roomId,professorId,timeId,roomId, ... ]
     * List of bone(skeleton) called chromosome
     */
    public Solution(Timetable timetable) {
        // Create random individual
        List<Integer> newChromosome = new ArrayList<>();

        // Loop through groups
        for (Group group : timetable.getGroups()) {
            // Loop through modules
            for (int subjectId : group.getSubjectIds()) {
                // Add random time
                int timeslotId = timetable.getRandomTimeslot().getTimeslotId();
                newChromosome.add(timeslotId);

                // Add random room
                int roomId = timetable.getRandomRoom().getRoomId();
                newChromosome.add(roomId);

                // Add random professor
                Subject module = timetable.getSubjectById(subjectId);
                newChromosome.add(module.getRandomProfessorId());
            }
        }
        this.chromosome = newChromosome;
    }

    public List<Integer> getChromosome() {
        return this.chromosome;
    }

    public int getChromosomeLength() {
        return this.chromosome.size();
    }

    public void setGene(int index, int gene) {
        this.chromosome.set(index, gene);
    }

    public int getGene(int index) {
        return this.chromosome.get(index);
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double getFitness() {
        return this.fitness;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i : this.chromosome) {
            output.append(i).append(",");
        }
        return output.toString();
    }
}
