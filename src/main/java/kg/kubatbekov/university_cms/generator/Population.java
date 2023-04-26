package kg.kubatbekov.university_cms.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Class Population is many solutions,
 *      it helps to get best solution by making some operation
 *      to population like: sorting, mutating and crossover etc.
 */
public class Population {
    private final List<Solution> population;

    /**
     * This constructor makes empty population by certain size
     */
    public Population(int populationSize) {
        // Initial population
        this.population = new ArrayList<>(populationSize);
    }

    /**
     * This constructor makes fulfilled population by certain size
     */
    public Population(int populationSize, Timetable timetable) {
        // Initial population
        this.population = new ArrayList<>(populationSize);
        // Loop over population size
        for (int solutionCount = 0; solutionCount < populationSize; solutionCount++) {
            // Create solution
            Solution solution = new Solution(timetable);
            // Add individual to population
            this.population.add(solution);
        }
    }

    /**
     * This method returns one solution in population which sorted by fitness
     */
    public Solution getSolutionOfSortedPopulation(int index) {
        // Order population by fitness
        this.population.sort((o1, o2) -> {
            if (o1.getFitness() > o2.getFitness()) {
                return -1;
            } else if (o1.getFitness() < o2.getFitness()) {
                return 1;
            }
            return 0;
        });

        // Return the fittest solution
        return this.population.get(index);
    }

    /**
     * This method shuffles the population
     */
    public void shuffle() {
        Random random = new Random();
        for (int i = population.size() - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            Solution a = population.get(index);
            population.set(index, population.get(i));
            population.set(i, a);
        }
    }

    public int size() {
        return this.population.size();
    }

    public void addSolution(Solution solution) {
        population.add(solution);
    }

    public Solution getSolution(int index) {
        return population.get(index);
    }

    public List<Solution> getSolutions() {
        return this.population;
    }
}
