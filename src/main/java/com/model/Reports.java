package com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "reports")
public class Reports implements Serializable {
    
    @XmlElement(name = "report")
    private List<Report> reports = new ArrayList<>();

    public Reports() {
    }

     public void addAll(List<Report> temp){
        reports.addAll(temp);
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
    
     public void removeReport(int ID){
        reports.removeIf(r -> r.matchReport(ID));
    }
     
      public Report reports(int reportID){
       return this.reports.stream().filter(r -> r.matchReport(reportID)).findAny().orElse(null);
    }   
}
