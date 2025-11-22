package StudentSystem2;

import org.junit.jupiter.api.*;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class DataValidationTest {

    DataValidation uin;

    @BeforeEach
    void setUp() {
        uin = new DataValidation();
    }

    @Test
    @DisplayName("ID Validation Test")
    void getId() {
        Scanner sc = new Scanner("1");
        assertEquals(1, uin.getId(sc));
        System.out.println("ID Validation Successful");
    }

    @Test
    @DisplayName("Name Validation Test")
    void getName() {
        Scanner sc = new Scanner("Alice Smith");
        assertEquals("Alice Smith", uin.getName(sc));
        System.out.println("Name Validation Successful");
    }

    @Test
    @DisplayName("Age Validation Test")
    void getAge() {
        Scanner sc = new Scanner("22");
        assertEquals(22, uin.getAge(sc));
        System.out.println("Age Validation Successful");
    }

    @Test
    @DisplayName("Gender Validation Test (Male)")
    void getGenderMale() {
        Scanner sc = new Scanner("Male");
        assertTrue(uin.getGenderAsBoolean(sc));
        System.out.println("Gender Male Validation Successful");
    }

    @Test
    @DisplayName("Study Time Validation Test")
    void getStudyTime() {
        Scanner sc = new Scanner("12.5");
        assertEquals(12.5, uin.getStudyTime(sc));
        System.out.println("Study Time Validation Test Successful");
    }

    @Test
    @DisplayName("Absences Validation Test")
    void getAbsences() {
        Scanner sc = new Scanner("3");
        assertEquals(3, uin.getAbsences(sc));
        System.out.println("Absences Validation Successful");
    }

    @Test
    @DisplayName("Boolean Input Validation Test")
    void getBooleanInput() {
        Scanner sc = new Scanner("yes");
        assertTrue(uin.getBooleanInput("sports", sc));
        System.out.println("Boolean Input Test Successful");
    }

    @Test
    @DisplayName("GPA Calculation Test")
    void calculateGPA() {
        double gpa = uin.calculateGPA(
                15.0,  // study time
                2,     // absences
                true,  // tutoring
                true,  // extracurricular
                false, // sports
                true,  // music
                false  // volunteering
        );
        assertEquals(2.85, gpa);
        System.out.println("GPA Calculation Test Successful");
    }


}
