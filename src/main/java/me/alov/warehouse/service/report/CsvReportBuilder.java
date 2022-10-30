package me.alov.warehouse.service.report;

import me.alov.warehouse.model.report.ReportFormat;
import me.alov.warehouse.model.report.ReportType;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class CsvReportBuilder implements ReportBuilder {
    @Override
    public boolean support(ReportFormat format) {
        return format == ReportFormat.CSV;

    }

    @Override
    public File build(List<String> filteredItems, ReportType type) {
        return null;
    }
}
