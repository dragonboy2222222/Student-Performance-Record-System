package StudentSystem2;

import java.io.IOException;
import java.util.LinkedList;

public class DeleteStudent extends StudentOperationTemplate {
    private final DataValidation userValidation = new DataValidation();
    private final Studentdatawrite writeStudentCSV = new Studentdatawrite();
    private final CheckData searchStudentId = new CheckData();

    // Constructor for testing
    public DeleteStudent(LinkedList<Student> customList) {
        this.students = customList;
    }

    // Optional default constructor for regular use
    public DeleteStudent() {
        super(); // use parent list if needed
    }

    @Override
    protected void execute() throws IOException {
        int id = userValidation.getId();
        int index = searchStudentId.searchId(students, id);

        while (index < 0) {
            System.err.println("'" + id + "' doesn't exist to delete.");
            id = userValidation.getId();
            index = searchStudentId.searchId(students, id);
        }

        students.remove(index);

        writeStudentCSV.writeToFile(students, "data/Student dataset.csv");

        System.out.println(" Student information successfully deleted!");
        System.out.println(" Updated student dataset size: " + students.size());
    }

    //  testing
    public void excute(int id) throws IOException {
        int index = searchStudentId.searchId(students, id);
        if (index < 0) {
            System.out.println(" Student ID '" + id + "' not found. Nothing deleted.");
            return;
        }

        students.remove(index);
        writeStudentCSV.writeToFile(students, "data/Student dataset.csv");
        System.out.println("✅ Student with ID " + id + " deleted successfully!");
    }
}
