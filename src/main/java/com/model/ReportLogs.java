package com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Report Logs Class is used to create a List of Report Log
 * It is used in Report Service Class, as REST WEB SERVICE
 * To retrieve Report Logs
 * 
 * @author Monte
 */

//@XmlAccessorType provides control over the default serialization 
//of properties and fields in a class.
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlRootElement is used to specify the default root element
@XmlRootElement(name = "reportlogs")
public class ReportLogs implements Serializable{
    //@XmlRootElement is used to specify the default root element
    @XmlElement(name = "reportlog")
    private List<ReportLog> reports = new ArrayList();
    
    public ReportLogs() {
    }
    
    /**
     * Used Report Service to get a List of Report Logs
     * 
     * @param temp 
     */
     public void addAll(List<ReportLog> temp){
        reports.addAll(temp);
    }
}
