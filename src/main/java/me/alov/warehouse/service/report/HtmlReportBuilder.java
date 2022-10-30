package me.alov.warehouse.service.report;

import me.alov.warehouse.exception.NotImplementedYet;
import me.alov.warehouse.model.report.ReportFormat;
import me.alov.warehouse.model.report.ReportType;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class HtmlReportBuilder implements ReportBuilder {
    @Override
    public boolean support(ReportFormat format) {
        return format == ReportFormat.HTML;
    }

    @Override
    public File build(List<String> filteredItems, ReportType type) {
        throw new NotImplementedYet("Html reports not implemented yet");

    }
}
