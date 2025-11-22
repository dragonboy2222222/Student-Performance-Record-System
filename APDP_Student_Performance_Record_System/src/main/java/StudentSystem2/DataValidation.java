package StudentSystem2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataValidation {
    Scanner sc = new Scanner(System.in);

    public int getId() {
        try {
            System.out.println("Enter Student ID (must be > 0):");
            int id = sc.nextInt();
            sc.nextLine();

            if (id <= 0) {
                System.err.println("ID must be greater than 0.");
                return getId();
            }

            return id;
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.err.println("ID must be a valid number.");
            return getId();
        }
    }
    public int getId(Scanner sc) {
        try {
//            System.out.println("Enter Student ID (must be > 0):");
            int id = sc.nextInt();


            if (id <= 0) {
                System.err.println("ID must be greater than 0.");
                return getId();
            }

            return id;
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.err.println("ID must be a valid number.");
            return getId();
        }
    }

    public String getName() {
        System.out.println("Enter Student Name:");
        String name = sc.nextLine();

        if (!name.matches("^[A-Za-z][A-Za-z\\s]{1,49}$")) {
            System.err.println("Invalid name. Only letters and spaces allowed, max 50 characters.");
            return getName();
        }

        return name;
    }

    public int getAge() {
        try {
            System.out.println("Enter Age (10 to 100):");
            int age = sc.nextInt();
            sc.nextLine();

            if (age < 10 || age > 100) {
                System.err.println("Age must be between 10 and 100.");
                return getAge();
            }

            return age;
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.err.println("Age must be a valid number.");
            return getAge();
        }
    }

    public boolean getGenderAsBoolean() {
        System.out.println("Enter Gender (Male/Female):");
        String gender = sc.nextLine();

        if (gender.equalsIgnoreCase("Male")) {
            return true; // true represents Male
        } else if (gender.equalsIgnoreCase("Female")) {
            return false; // false represents Female
        } else {
            System.err.println("Gender must be 'Male' or 'Female'.");
            return getGenderAsBoolean();
        }
    }


    public double getStudyTime() {
        try {
            System.out.println("Enter Weekly Study Time (hours, 0.0 to 25.0):");
            double time = sc.nextDouble(); // changed from int to double
            sc.nextLine();

            if (time < 0.0 || time > 25.0) {
                System.err.println("Study time must be between 0.0 and 25.0.");
                return getStudyTime();
            }

            return time;
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.err.println("Study time must be a decimal number.");
            return getStudyTime();
        }
    }


    public int getAbsences() {
        try {
            System.out.println("Enter Number of Absences (0 to 20):");
            int absences = sc.nextInt();
            sc.nextLine();

            if (absences < 0 || absences > 20) {
                System.err.println("Absences must be between 0 and 20.");
                return getAbsences();
            }

            return absences;
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.err.println("Absences must be a number.");
            return getAbsences();
        }
    }


    public boolean getBooleanInput(String fieldName) {
        System.out.printf("Is the student involved in %s? (yes/no):%n", fieldName);
        String input = sc.nextLine().trim().toLowerCase();

        if (input.equals("yes")) {
            return true;
        } else if (input.equals("no")) {
            return false;
        } else {
            System.err.println("Please enter 'yes' or 'no'.");
            return getBooleanInput(fieldName);
        }
    }

    public double calculateGPA(double studyTimeWeekly, int absences, boolean tutoring,
                               boolean extracurricular, boolean sports, boolean music, boolean volunteering) {
        double gpa = 2.0;

        // Study time bonus
        gpa += (studyTimeWeekly / 25.0) * 1.0;

        // Absences penalty
        gpa -= (absences / 20.0) * 0.5;

        // Tutoring bonus
        gpa += tutoring ? 0.2 : 0.0;

        // Activity bonus
        int activities = 0;
        if (extracurricular) activities++;
        if (sports) activities++;
        if (music) activities++;
        if (volunteering) activities++;

        gpa += activities * 0.05;

        // Clamp GPA between 0.0 and 4.0
        if (gpa > 4.0) gpa = 4.0;
        else if (gpa < 0.0) gpa = 0.0;

        return Math.round(gpa * 100.0) / 100.0; // Round to 2 decimal places
    }


    public String getName(Scanner sc) {
//        System.out.println("Enter Student Name:");
        String name = sc.nextLine();

        if (!name.matches("^[A-Za-z][A-Za-z\\s]{1,49}$")) {
            System.err.println("Invalid name. Only letters and spaces allowed, max 50 characters.");
            return getName();
        }

        return name;
    }

    public int getAge(Scanner sc) {
        try {
//            System.out.println("Enter Age (10 to 100):");
            int age = sc.nextInt();
          ;

            if (age < 10 || age > 100) {
                System.err.println("Age must be between 10 and 100.");
                return getAge();
            }

            return age;
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.err.println("Age must be a valid number.");
            return getAge();
        }
    }

    public boolean getGenderAsBoolean(Scanner sc) {
//        System.out.println("Enter Gender (Male/Female):");
        String gender = sc.nextLine();

        if (gender.equalsIgnoreCase("Male")) {
            return true; // true represents Male
        } else if (gender.equalsIgnoreCase("Female")) {
            return false; // false represents Female
        } else {
            System.err.println("Gender must be 'Male' or 'Female'.");
            return getGenderAsBoolean();
        }
    }


    public double getStudyTime(Scanner sc) {
        try {
//            System.out.println("Enter Weekly Study Time (hours, 0.0 to 25.0):");
            double time = sc.nextDouble(); // changed from int to double


            if (time < 0.0 || time > 25.0) {
                System.err.println("Study time must be between 0.0 and 25.0.");
                return getStudyTime();
            }

            return time;
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.err.println("Study time must be a decimal number.");
            return getStudyTime();
        }
    }
    public boolean getBooleanInput(String fieldName,Scanner sc) {
//        System.out.printf("Is the student involved in %s? (yes/no):%n", fieldName);
        String input = sc.nextLine().trim().toLowerCase();

        if (input.equals("yes")) {
            return true;
        } else if (input.equals("no")) {
            return false;
        } else {
            System.err.println("Please enter 'yes' or 'no'.");
            return getBooleanInput(fieldName);
        }
    }

    public int getAbsences(Scanner sc) {
        try {
//            System.out.println("Enter Number of Absences (0 to 20):");
            int absences = sc.nextInt();


            if (absences < 0 || absences > 20) {
                System.err.println("Absences must be between 0 and 20.");
                return getAbsences();
            }

            return absences;
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.err.println("Absences must be a number.");
            return getAbsences();
        }
    }




}

