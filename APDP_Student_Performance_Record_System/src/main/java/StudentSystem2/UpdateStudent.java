package StudentSystem2;

import java.io.IOException;
import java.util.LinkedList;

public class UpdateStudent extends StudentOperationTemplate {
    private final DataValidation userValidation = new DataValidation();
    private final Studentdatawrite writeToCSV = new Studentdatawrite();
    private final CheckData searchStudentId = new CheckData();

    // ✅ Constructor for testing
    public UpdateStudent(LinkedList<Student> customList) {
        this.students = customList;
    }

    // ✅ Default constructor
    public UpdateStudent() {
        super();
    }

    @Override
    protected void execute() throws IOException {
        int id = userValidation.getId();
        int index = searchStudentId.searchId(students, id);

        while (index < 0) {
            System.err.println("'" + id + "' doesn't exist.");
            id = userValidation.getId();
            index = searchStudentId.searchId(students, id);
        }

        String name = userValidation.getName();
        int age = userValidation.getAge();
        boolean gender = userValidation.getGenderAsBoolean();
        double studyTime = userValidation.getStudyTime();
        int absences = userValidation.getAbsences();
        boolean tutoring = userValidation.getBooleanInput("Tutoring");
        boolean extracurriculum = userValidation.getBooleanInput("Extracurriculum");
        boolean sports = userValidation.getBooleanInput("Sports");
        boolean music = userValidation.getBooleanInput("Music");
        boolean volunteering = userValidation.getBooleanInput("Volunteering");

        double GPA = userValidation.calculateGPA(
                studyTime, absences, tutoring,
                extracurriculum, sports, music, volunteering
        );

        students.set(index, new Student(id, name, age, gender, studyTime, absences,
                tutoring, extracurriculum, sports, music, volunteering, GPA));

        writeToCSV.writeToFile(students, "data/student dataset.csv");

        System.out.println("\n✅ Student Information Successfully Updated!");
        System.out.println("📊 Updated Student Dataset Size: " + students.size());
    }

    // Public update method for test
    public void excute(int id, String name, int age, boolean gender, double studyTime, int absences,
                       boolean tutoring, boolean extracurriculum, boolean sports,
                       boolean music, boolean volunteering) throws IOException {

        int index = searchStudentId.searchId(students, id);


        double GPA = userValidation.calculateGPA(
                studyTime, absences, tutoring,
                extracurriculum, sports, music, volunteering
        );

        students.set(index, new Student(id, name, age, gender, studyTime, absences,
                tutoring, extracurriculum, sports, music, volunteering, GPA));

        writeToCSV.writeToFile(students, "data/student dataset.csv");

        System.out.println("\n✅ Student Information Successfully Updated");
    }
}
