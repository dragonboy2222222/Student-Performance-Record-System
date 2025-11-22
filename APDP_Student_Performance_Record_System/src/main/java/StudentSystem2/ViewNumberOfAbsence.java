package StudentSystem2;

import com.opencsv.exceptions.CsvException;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class ViewNumberOfAbsence implements Report {

    @Override
    public void generate() throws IOException, CsvException {
        LinkedList<Student> students = Studentdataread.read();

        AsciiTable table = new AsciiTable();
        table.setTextAlignment(TextAlignment.CENTER);
        table.getRenderer().setCWC(new de.vandermeer.asciitable.CWC_LongestWord());

        table.addRule();
        table.addRow(Arrays.asList("Student ID", "Name", "Absences"));
        table.addRule();

        int limit = Math.min(30, students.size());
        for (int i = 0; i < limit; i++) {
            Student student = students.get(i);
            table.addRow(
                    student.getId(),
                    student.getName(),
                    student.getAbsences()
            );
            table.addRule();
        }

        System.out.println(table.render());
    }
}
