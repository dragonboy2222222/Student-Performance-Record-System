package StudentSystem2;

import com.opencsv.exceptions.CsvException;
import java.io.IOException;

public class ReportFacade {
    private final Report activityReport;
    private final Report gpaAbove3Report;

    public ReportFacade() {
        this.activityReport = new ViewActivityReport();
        this.gpaAbove3Report = new ViewGPAAbove3Report();
    }

    public void showActivityReport() throws Exception {
        activityReport.generate();
    }

    public void showGpaAbove3Report() throws Exception {
        gpaAbove3Report.generate();
    }
}
