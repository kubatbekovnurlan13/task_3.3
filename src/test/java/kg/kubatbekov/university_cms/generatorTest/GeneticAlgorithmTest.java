package kg.kubatbekov.university_cms.generatorTest;

import kg.kubatbekov.university_cms.generator.GeneticAlgorithm;
import kg.kubatbekov.university_cms.generator.Population;
import kg.kubatbekov.university_cms.generator.Solution;
import kg.kubatbekov.university_cms.generator.Timetable;
import kg.kubatbekov.university_cms.service.TimetableService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GeneticAlgorithmTest {
    private final TimetableService timetableService;

    @Autowired
    public GeneticAlgorithmTest(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    @Test
    void crossoverPopulation_testCrossoverPopulation_whenThereIsValues() {
        Timetable timetable = timetableService.initializeTimetable();
        GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.01, 0.9, 2, 5);
        Population population = ga.initializePopulation(timetable);

        Population mutatedPopulation = ga.crossoverPopulation(population);

        Assertions.assertNotEquals(population, mutatedPopulation);
    }

    @Test
    void mutatePopulation_testMutatePopulation_whenThereIsValues() {
        Timetable timetable = timetableService.initializeTimetable();
        GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.01, 0.9, 2, 5);
        Population population = ga.initializePopulation(timetable);

        Population mutatedPopulation = ga.mutatePopulation(population, timetable);

        Assertions.assertNotEquals(population, mutatedPopulation);
    }

    @Test
    void getSolutionOfSortedPopulation_testGetSolutionOfSortedPopulation_whenThereIsValues() {
        Timetable timetable = timetableService.initializeTimetable();
        GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.01, 0.9, 2, 5);
        Population population = ga.initializePopulation(timetable);

        Solution solution = population.getSolutionOfSortedPopulation(1);

        Assertions.assertNotNull(solution);
    }
}
