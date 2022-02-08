package org.launchcode.techjobs.oo.test;

import jdk.jfr.Label;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job j1 = new Job();
        Job j2 = new Job();
        assertNotEquals(j1, j2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job_test = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertTrue(job_test instanceof Job);
        assertEquals("Product tester", job_test.getName());
        assertTrue(job_test.getEmployer() instanceof Employer);
        assertEquals("ACME", job_test.getEmployer().getValue());
        assertTrue(job_test.getLocation() instanceof Location);
        assertEquals("Desert", job_test.getLocation().getValue());
        assertTrue(job_test.getPositionType() instanceof PositionType);
        assertEquals("Quality control", job_test.getPositionType().getValue());
        assertTrue(job_test.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", job_test.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job_test = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        Job job_test2 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertFalse(job_test.equals(job_test2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job_test = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals('\n', job_test.toString().charAt(0));
        assertEquals('\n', job_test.toString().charAt(job_test.toString().length() - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job_test = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\nID: "+ job_test.getId() +
                "\nName: "+ job_test.getName() +
                "\nEmployer: "+ job_test.getEmployer().toString() +
                "\nLocation: "+ job_test.getLocation().toString() +
                "\nPosition Type: " + job_test.getPositionType().toString() +
                "\nCore Competency: " + job_test.getCoreCompetency().toString() + "\n", job_test.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job_test = new Job("Product Tester", new Employer(""), new Location("Desert"), new PositionType(""), new CoreCompetency(""));
        assertEquals("\nID: " + job_test.getId() +
                "\nName: Product Tester" +
                "\nEmployer: Data not available" +
                "\nLocation: Desert" +
                "\nPosition Type: Data not available" +
                "\nCore Competency: Data not available\n", job_test.toString());
    }

    @Test
    public void testToStringHandlesOnlyIdField(){
        Job job_test = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals("\nOOPS! This job does not seem to exist.\n", job_test.toString());
    }

}
