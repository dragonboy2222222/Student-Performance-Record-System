package StudentSystem2;

import com.opencsv.exceptions.CsvException;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.io.IOException;
import java.util.LinkedList;

public class ViewGPAAbove3Report implements Report {

    @Override
    public void generate() throws IOException, CsvException {
        LinkedList<Student> students = Studentdataread.read();

        AsciiTable table = new AsciiTable();
        table.setTextAlignment(TextAlignment.CENTER);
        table.getRenderer().setCWC(new de.vandermeer.asciitable.CWC_LongestWord());

        table.addRule();
        table.addRow("Student ID", "Name", "GPA");
        table.addRule();

        for (Student s : students) {
            if (s.getGPA() > 3.0) {
                table.addRow(s.getId(), s.getName(), String.format("%.2f", s.getGPA()));
                table.addRule();
            }
        }

        System.out.println(table.render());
    }
}
