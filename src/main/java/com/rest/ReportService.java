package com.rest;

import com.model.ReportLog;
import com.model.ReportLogs;
import com.model.ReportSummaries;
import com.model.dao.ReportDAO;
import com.model.dao.SqlDBConnector;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("reportapi")
public class ReportService {

    @GET
    @Path("addreportlog") //localhost:8080/group3/rest/reportapi/addreportlog
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response ReportLog() throws IOException, FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        ReportDAO reportDAO = new ReportDAO(new SqlDBConnector().connection());
        reportDAO.createReportLog("2022-11-01", "2023-02-15");
        //reportDAO.createReportSummary("2022-11-01", "2023-02-15");
        ReportLog reportLog = reportDAO.showOne("2022-11-01", "2023-02-15");
        return Response.status(200).entity(reportLog).build();
    }

    @GET
    @Path("reportlogs") //localhost:8080/group3/rest/reportapi/reportlogs
    @Produces(MediaType.APPLICATION_XML)
    public ReportLogs reportLogs() throws IOException, FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        ReportDAO reportDAO = new ReportDAO(new SqlDBConnector().connection());
        ReportLogs reportLogs = new ReportLogs();
        reportLogs.addAll(reportDAO.getReportLogs());
        return reportLogs;
    }

    @GET
    @Path("reportsummaries") //localhost:8080/group3/rest/reportapi/reportsummaries
    @Produces(MediaType.APPLICATION_XML)
    public ReportSummaries reportSummaries() throws IOException, FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        ReportDAO reportDAO = new ReportDAO(new SqlDBConnector().connection());
        ReportSummaries reportSummaries = new ReportSummaries();
        reportSummaries.addAll(reportDAO.getReportSummaries());
        return reportSummaries;
    }

    @GET
    @Path("removereport/{ID}") //localhost:8080/group3/rest/reportapi/removereport/{ID}
    public void reportDeleteByID(@PathParam("ID") int ID) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        ReportDAO reportDAO = new ReportDAO(new SqlDBConnector().connection());
        reportDAO.delete(ID);
    }
}
