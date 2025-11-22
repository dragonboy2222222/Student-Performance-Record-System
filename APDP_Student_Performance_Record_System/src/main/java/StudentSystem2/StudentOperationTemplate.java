package StudentSystem2;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.LinkedList;

public abstract class StudentOperationTemplate {
    protected LinkedList<Student> students;

    public final void run() throws IOException, CsvException {
        readData();
        System.out.println("Student Dataset Size: " + students.size());
        execute();
    }

    protected void readData() throws IOException, CsvException {
        students = Studentdataread.read();
    }

    protected abstract void execute() throws IOException, CsvException;
}
