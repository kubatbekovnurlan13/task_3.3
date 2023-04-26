package kg.kubatbekov.university_cms.generator;

public class GeneticAlgorithm {
    private final int populationSize;
    private final double mutationRate;
    private final double crossoverRate;
    private final int elitismCount;
    protected int tournamentSize;

    public GeneticAlgorithm(
            int populationSize,
            double mutationRate,
            double crossoverRate,
            int elitismCount,
            int tournamentSize) {
        this.populationSize = populationSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.elitismCount = elitismCount;
        this.tournamentSize = tournamentSize;
    }

    public Population mutatePopulation(Population population, Timetable timetable) {
        // Initialize new population
        Population newPopulation = new Population(this.populationSize);

        // Loop over current population by fitness
        for (int populationIndex = 0; populationIndex < population.size(); populationIndex++) {
            Solution solution = population.getSolutionOfSortedPopulation(populationIndex);

            // Create random solution to swap genes with
            Solution randomSolution = new Solution(timetable);

            // Loop over solution's genes
            for (int geneIndex = 0; geneIndex < solution.getChromosomeLength(); geneIndex++) {
                // Skip mutation if this is an elite individual
                if (populationIndex > this.elitismCount) {
                    // Does this gene need mutation?
                    if (this.mutationRate > Math.random()) {
                        // Swap for new gene
                        solution.setGene(geneIndex, randomSolution.getGene(geneIndex));
                    }
                }
            }
            // Add individual to population
            newPopulation.addSolution(solution);
        }
        // Return mutated population
        return newPopulation;
    }

    public Population crossoverPopulation(Population population) {
        // Create new population
        Population newPopulation = new Population(population.size());

        // Loop over current population by fitness
        for (int populationIndex = 0; populationIndex < population.size(); populationIndex++) {
            Solution parent1FittestSolution = population.getSolutionOfSortedPopulation(populationIndex);

            // Apply crossover to this individual?
            if (this.crossoverRate > Math.random() && populationIndex >= this.elitismCount) {
                // Initialize offspring
                Solution offspring = new Solution(parent1FittestSolution.getChromosomeLength());

                // Find second parent
                Solution parent2 = selectParent(population);

                // Loop over genome
                for (int geneIndex = 0; geneIndex < parent1FittestSolution.getChromosomeLength(); geneIndex++) {
                    // Use half of parent1FittestIndividual's genes and half of parent2's genes
                    if (0.5 > Math.random()) {
                        offspring.setGene(geneIndex, parent1FittestSolution.getGene(geneIndex));
                    } else {
                        offspring.setGene(geneIndex, parent2.getGene(geneIndex));
                    }
                }

                // Add offspring to new population
                newPopulation.addSolution(offspring);
            } else {
                // Add individual to new population without applying crossover
                newPopulation.addSolution(parent1FittestSolution);
            }
        }
        return newPopulation;
    }

    public Population initializePopulation(Timetable timetable) {
        // Initialize population
        return new Population(this.populationSize, timetable);
    }

    public Solution selectParent(Population population) {
        // Create tournament
        Population tournament = new Population(this.tournamentSize);

        // Add random individuals to the tournament
        population.shuffle();
        for (int i = 0; i < this.tournamentSize; i++) {
            Solution tournamentSolution = population.getSolution(i);
            tournament.addSolution(tournamentSolution);
        }

        // Return the best
        return tournament.getSolutionOfSortedPopulation(0);
    }

    public boolean isTerminationConditionMet(int generationsCount, int maxGenerations) {
        return (generationsCount > maxGenerations);
    }

    public boolean isTerminationConditionMet(Population population) {
        return population.getSolutionOfSortedPopulation(0).getFitness() == 1.0;
    }

    public void calculateFitnessOfSolutionInPopulation(Population population, Timetable timetable) {
        for (Solution solution : population.getSolutions()) {
            this.calculateFitnessOfSolution(solution, timetable);
        }
    }

    public void calculateFitnessOfSolution(Solution solution, Timetable timetable) {
        // Create new timetable object to use -- cloned from an existing timetable
        Timetable threadTimetable = new Timetable(timetable);
        threadTimetable.createCourses(solution);

        // Calculate fitness
        int clashes = threadTimetable.calculateClashes();
        double fitness = 1 / (double) (clashes + 1);

        solution.setFitness(fitness);
    }
}
