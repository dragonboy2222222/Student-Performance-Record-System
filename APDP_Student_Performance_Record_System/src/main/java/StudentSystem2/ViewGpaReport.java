package StudentSystem2;

import com.opencsv.exceptions.CsvException;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.io.IOException;
import java.util.LinkedList;

public class ViewGpaReport implements Report {

    @Override
    public void generate() throws IOException, CsvException {
        LinkedList<Student> students = Studentdataread.read();

        // Sort students by GPA descending
        students.sort((s1, s2) -> Double.compare(s2.getGPA(), s1.getGPA()));

        // Create ASCII table
        AsciiTable table = new AsciiTable();
        table.setTextAlignment(TextAlignment.CENTER);
        table.getRenderer().setCWC(new de.vandermeer.asciitable.CWC_LongestWord());

        table.addRule();
        table.addRow("Student Name", "Student ID", "GPA");
        table.addRule();

        // Show only top 30 records
        int limit = Math.min(30, students.size());
        for (int i = 0; i < limit; i++) {
            Student student = students.get(i);
            table.addRow(student.getName(), student.getId(), String.format("%.2f", student.getGPA()));
            table.addRule();
        }

        System.out.println(table.render());
    }
}
