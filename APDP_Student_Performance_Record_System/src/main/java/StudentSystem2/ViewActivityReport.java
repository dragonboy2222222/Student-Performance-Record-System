package StudentSystem2;

import com.opencsv.exceptions.CsvException;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ViewActivityReport implements Report {
    private List<Student> students;
    private final Scanner sc = new Scanner(System.in);

    @Override
    public void generate() throws IOException, CsvException {
        students = Studentdataread.read(); // Load student data inside the class

        System.out.print("Enter activity to search (music, sports, volunteering): ");
        String activity = sc.nextLine().trim().toLowerCase();

        while (!activity.equals("music") && !activity.equals("sports") && !activity.equals("volunteering")) {
            System.out.print("Invalid input. Please enter 'music', 'sports', or 'volunteering': ");
            activity = sc.nextLine().trim().toLowerCase();
        }

        List<Student> filteredStudents = filterByActivity(activity);
        displayTable(filteredStudents, activity);
    }

    private List<Student> filterByActivity(String activity) {
        switch (activity) {
            case "music":
                return students.stream().filter(Student::isMusic).collect(Collectors.toList());
            case "sports":
                return students.stream().filter(Student::isSports).collect(Collectors.toList());
            case "volunteering":
                return students.stream().filter(Student::isVolunteering).collect(Collectors.toList());
            default:
                return new ArrayList<>();
        }
    }

    private void displayTable(List<Student> filteredStudents, String activity) {
        if (filteredStudents.isEmpty()) {
            System.out.println("No students found participating in " + activity + ".");
            return;
        }

        AsciiTable table = new AsciiTable();
        table.setTextAlignment(TextAlignment.CENTER);
        table.getRenderer().setCWC(new de.vandermeer.asciitable.CWC_LongestWord());

        table.addRule();
        table.addRow("Student Name", "Student ID", "Activity");
        table.addRule();

        int limit = Math.min(30, filteredStudents.size());
        for (int i = 0; i < limit; i++) {
            Student student = filteredStudents.get(i);
            table.addRow(student.getName(), student.getId(), capitalize(activity));
            table.addRule();
        }

        System.out.println(table.render());
    }


    private String capitalize(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
