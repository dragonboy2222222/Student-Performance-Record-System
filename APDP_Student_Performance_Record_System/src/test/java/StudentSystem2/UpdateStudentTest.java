package StudentSystem2;

import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;

class UpdateStudentTest {
    LinkedList<Student> studentList;
    Studentdataread dataRead;
    UpdateStudent updateStudent;

    @BeforeEach
    void setUp() throws IOException, CsvValidationException {
        studentList = new LinkedList<>();
        dataRead = new Studentdataread();
        studentList = dataRead.read();
        updateStudent = new UpdateStudent(studentList);
    }



    @Test
    @DisplayName("Update Student Info")
    void excute() throws IOException {
        updateStudent.excute(
                100001, "Alicia", 22, true,
                15.0, 1, true, true, false, false, true
        );
        System.out.println("update successful");
    }
}
