package StudentSystem2;

import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;

class AddStudentTest {

    AddStudent addStudent;
    LinkedList<Student> testList;
    Studentdataread dataRead;

    @BeforeEach
    void setUp() throws CsvValidationException, IOException {
        testList = new LinkedList<>();
        dataRead = new Studentdataread();
        testList = dataRead.read();
        addStudent = new AddStudent(testList);

    }

    @Test
    void excute() throws IOException {
        System.out.println("Before: " + testList.size());

        addStudent.excute(100003, "Alice", 20, false, 10.5, 2,
                true, false, true, false, true);

        System.out.println("After: " + testList.size());
    }
}
