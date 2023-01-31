package com.model;

import java.util.ArrayList;
import java.util.List;


public class ReportLogs {
    private List<ReportLog> reports = new ArrayList();
    
    public ReportLogs() {
    }

     public void addAll(List<ReportLog> temp){
        reports.addAll(temp);
    }

    public List<ReportLog> getReports() {
        return reports;
    }

    public void setReports(List<ReportLog> reports) {
        this.reports = reports;
    }
    
     public void removeReport(int ID){
        reports.removeIf(r -> r.matchReport(ID));
    }
     
      public ReportLog reports(int reportID){
       return this.reports.stream().filter(r -> r.matchReport(reportID)).findAny().orElse(null);
    }   
}

