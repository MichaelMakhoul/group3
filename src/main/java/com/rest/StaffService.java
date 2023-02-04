//package com.rest;
//
//import com.model.Staffs;
//import com.model.dao.SqlDBConnector;
//import com.model.dao.StaffDAO;
//import java.io.IOException;
//import java.sql.SQLException;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//
///**
// *
// * @author 236336
// */
//@Path("staffapi")
//public class StaffService {
//    
//    @GET
//    @Path("staffs")  //http://localhost:8080/group3/rest/staffapi/staffs
//    @Produces(MediaType.APPLICATION_XML)
//    public Staffs staffs() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException{
//        StaffDAO staffDAO = new StaffDAO(new SqlDBConnector().connection());
//        Staffs staffs = new Staffs();
//        staffs.addAll(staffDAO.getStaffs());
//        return staffs;
//    }
//}
