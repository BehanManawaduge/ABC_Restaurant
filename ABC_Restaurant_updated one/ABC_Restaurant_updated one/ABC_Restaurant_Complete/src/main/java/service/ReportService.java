package service;

import model.Report;
import repository.ReportRepository;

import java.util.List;

public class ReportService {

    private ReportRepository reportRepository = new ReportRepository();

    public List<Report> getAllReports() {
        return reportRepository.getAllReports();
    }
}
