package StudentSystem2;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Write student data into CSV file
 */
public class Studentdatawrite {

    // Overwrite CSV file with student data
    public void writeToFile(LinkedList<Student> students, String fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName, false);
        CSVWriter cw = new CSVWriter(fw);

        // Column headers matching Student fields
        String[] columnTitles = {
                "id",
                "name",
                "age",
                "gender",
                "studytime",
                "absences",
                "tutoring",
                "extracurrculum",
                "sports",
                "music",
                "volunteering",
                "GPA"
        };
        cw.writeNext(columnTitles);

        // Write each student as a row
        for (Student student : students) {
            String[] str = {
                    String.valueOf(student.getId()),
                    student.getName(),
                    String.valueOf(student.getAge()),
                    student.isGender() ? "1" : "0",
                    String.valueOf(student.getStudytime()),
                    String.valueOf(student.getAbsences()),
                    student.isTutoring() ? "1" : "0",
                    student.isExtracurrculum() ? "1" : "0",
                    student.isSports() ? "1" : "0",
                    student.isMusic() ? "1" : "0",
                    student.isVolunteering() ? "1" : "0",
                    String.valueOf(student.getGPA())
            };
            cw.writeNext(str);
        }


        cw.close();
        fw.close();
    }
}
