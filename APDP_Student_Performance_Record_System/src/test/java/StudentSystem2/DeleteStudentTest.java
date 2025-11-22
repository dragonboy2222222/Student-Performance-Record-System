package StudentSystem2;

import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;

class DeleteStudentTest {
    LinkedList<Student> students;
    Studentdataread dataRead;
    DeleteStudent deleteStudent;

    @BeforeEach
    void setUp() throws IOException, CsvValidationException {
        students = new LinkedList<>();
        dataRead = new Studentdataread();
        students = dataRead.read();
        deleteStudent = new DeleteStudent(students);
    }



    @Test
    @DisplayName("Delete One Student by ID")
    void excute() throws IOException {
        System.out.println(students.size());
        deleteStudent.excute(103);
        System.out.println(students.size());
    }
}
