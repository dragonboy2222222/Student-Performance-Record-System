package StudentSystem2;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Studentdataread {
    static LinkedList<Student> students = new LinkedList<>();

    public Studentdataread() {
        this.students = students;
    }

    public static LinkedList<Student> read() throws CsvValidationException, IOException {
        students = new LinkedList<>();

        FileReader fr = new FileReader("data/Student dataset.csv");  // Change path as needed
        CSVReader cr = new CSVReader(fr);

        // Skip the header row
        String[] str = cr.readNext();

        while ((str = cr.readNext()) != null) {
            students.add(new Student(Integer.parseInt(str[0]),                    // id
                    str[1],                                      // name
                    Integer.parseInt(str[2]),                    // age
                    str[3].equals("1"),                          // gender (1 = true)
                    Double.parseDouble(str[4]),                  // studytime
                    Integer.parseInt(str[5]),                    // absences
                    str[6].equals("1"),                          // tutoring
                    str[7].equals("1"),                          // extracurriculum
                    str[8].equals("1"),                          // sports
                    str[9].equals("1"),                          // music
                    str[10].equals("1"),                         // volunteering
                    Double.parseDouble(str[11])                  // GPA
            ));
        }


        cr.close();
        fr.close();

        return students;
    }
}
