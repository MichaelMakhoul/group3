package com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "reportlogs")
public class ReportLogs implements Serializable{
    @XmlElement(name = "reportlog")
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

