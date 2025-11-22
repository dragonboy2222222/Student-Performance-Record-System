package StudentSystem2;

import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.util.Scanner;

public class StudentOperation {
    Scanner sc = new Scanner(System.in);

    public void menu() {
        System.out.println("*************  Student Information System  *************");
        System.out.println("1. Add Student");
        System.out.println("2. Update Student");
        System.out.println("3. Delete Student");
        System.out.println("4. View Number of Absences per Student");
        System.out.println("5. Sort Students by GPA (Highest to Lowest)");
        System.out.println("6. List Students by Activity");
        System.out.println("7. View Students with GPA > 3");
        System.out.println("Choose a menu number between 1 to 7:");
    }

    private String getMenuNumber() {
        String input = sc.nextLine();
        if (!input.matches("^[1-7]$")) {
            System.out.println("Invalid choice! Please select between 1 to 7.");
            return getMenuNumber();
        }
        return input;
    }

    public void displayMenu() throws Exception {
        ReportFacade facade = new ReportFacade(); // Create once

        while (true) {
            menu();
            String choice = getMenuNumber();
            StudentOperationTemplate action = null;
            Report report = null;

            switch (choice) {
                case "1": action = new AddStudent(); break;
                case "2": action = new UpdateStudent(); break;
                case "3": action = new DeleteStudent(); break;
                case "4":
                case "5":
                    report = ReportFactory.getReport(choice);
                    break;
                case "6": facade.showActivityReport(); continue;
                case "7": facade.showGpaAbove3Report(); continue;
            }

            if (action != null) {
                action.run();
            } else if (report != null) {
                report.generate();
            }
        }
    }


    public static void main(String[] args) throws Exception {
        System.out.println("Loading...");
        StudentOperation operation = new StudentOperation();
        operation.displayMenu();
    }
}
