package StudentSystem2;

public class ReportFactory {
    public static Report getReport(String type) {
        switch (type) {
            case "4":
                return new ViewNumberOfAbsence();
            case "5":
                return new ViewGpaReport();

            default:
                return null;
        }
    }
}
