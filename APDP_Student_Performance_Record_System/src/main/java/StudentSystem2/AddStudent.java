package StudentSystem2;

import java.io.IOException;
import java.util.LinkedList;

public class AddStudent extends StudentOperationTemplate {
    private final DataValidation userValidation = new DataValidation();
    private final Studentdatawrite dataWrite = new Studentdatawrite();
    private final CheckData searchStudentId = new CheckData();

    // New constructor so you can pass your own list
    public AddStudent(LinkedList<Student> customList) {
        this.students = customList;
    }

    // Default constructor for normal use
    public AddStudent() {
        super(); // if needed
    }

    @Override
    protected void execute() throws IOException {
        int id = userValidation.getId();

        while (searchStudentId.searchId(students, id) >= 0) {
            System.out.println("ID '" + id + "' already exists.");
            id = userValidation.getId();
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

        students.add(new Student(id, name, age, gender, studyTime, absences,
                tutoring, extracurriculum, sports, music, volunteering, GPA));

        dataWrite.writeToFile(students, "data/student dataset.csv");

        System.out.println("\n✅ Student Information Successfully Added!");
        System.out.println("📊 Updated Student Dataset Size: " + students.size());
    }

    // ✅ testing
    public void excute(int id, String name, int age, boolean gender, double studyTime, int absences,
                       boolean tutoring, boolean extracurriculum, boolean sports,
                       boolean music, boolean volunteering) throws IOException {

        if (searchStudentId.searchId(students, id) >= 0) {
            System.out.println("ID '" + id + "' already exists.");
            return;
        }

        double GPA = userValidation.calculateGPA(
                studyTime, absences, tutoring, extracurriculum, sports, music, volunteering
        );

        students.add(new Student(id, name, age, gender, studyTime, absences,
                tutoring, extracurriculum, sports, music, volunteering, GPA));

        dataWrite.writeToFile(students, "data/student dataset.csv");

        System.out.println("\n✅ Student Information Successfully Added via insert()!");
    }
}
