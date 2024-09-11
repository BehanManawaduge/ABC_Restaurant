package model;

public class Report {
    private int reportId;
    private String reportType;
    private String reportContent;

    public Report(int reportId, String reportType, String reportContent) {
        this.reportId = reportId;
        this.reportType = reportType;
        this.reportContent = reportContent;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }
}
