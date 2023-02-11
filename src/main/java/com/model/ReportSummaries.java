package com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "reportsummaries")
public class ReportSummaries implements Serializable {

    @XmlElement(name = "reportsummary")
    private List<ReportSummary> reportSummaries = new ArrayList();

    public void addAll(List<ReportSummary> temp) {
        reportSummaries.addAll(temp);
    }

    public List<ReportSummary> getReportSummaries() {
        return reportSummaries;
    }

    public void setReportSummaries(List<ReportSummary> reportSummaries) {
        this.reportSummaries = reportSummaries;
    }

    public void removeReportSummary(int ID) {
        reportSummaries.removeIf(r -> r.matchReport(ID));
    }

    public ReportSummary reports(int reportID) {
        return this.reportSummaries.stream().filter(r -> r.matchReport(reportID)).findAny().orElse(null);
    }
}
