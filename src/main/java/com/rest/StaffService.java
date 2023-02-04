package com.rest;

<<<<<<< HEAD
import com.model.Staff;
import com.model.Staffs;
import com.model.dao.SqlDBConnector;
import java.io.FileNotFoundException;
=======
import com.model.Staffs;
import com.model.dao.SqlDBConnector;
import com.model.dao.StaffDAO;
>>>>>>> 762683202dc16a9ee88361267411ae4d82b2ad39
import java.io.IOException;
import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
<<<<<<< HEAD
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
=======
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
>>>>>>> 762683202dc16a9ee88361267411ae4d82b2ad39

/**
 *
 * @author 236336
 */
@Path("staffapi")
public class StaffService {
<<<<<<< HEAD
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
//    
//    @GET
//    @Path("staff/{ID}")//http://localhost:8080/group3/rest/staffapi/staff/10001
//    @Produces(MediaType.APPLICATION_XML)
//    public Staffs getStaff(@PathParam("ID") int ID) throws IOException, FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
//        StaffDAO staffDAO = new StaffDAO(new SqlDBConnector().connection());
//        
//        Staff staff = staffDAO.getStaff(ID);
//        Staffs staffs = new Staffs();
//        staffs.add(staff);
//        return staffs;
//    }
//
//    @GET
//    @Path("addstaff") //http://localhost:8080/group3/rest/staffapi/addstaff
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public Response Staff() throws IOException, FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
//        StaffDAO staffDAO = new StaffDAO(new SqlDBConnector().connection());
//        staffDAO.create("Robert Leen", "rob.l@example.com", "Helloworld123", "1989-04-06", "0419364236");
//        Staff staff = staffDAO.login("rob.l@example.com", "Helloworld123");
//        return Response.status(200).entity(staff).build();
//    }
=======
    
    @GET
    @Path("staffs")  //http://localhost:8080/group3/rest/staffapi/staffs
    @Produces(MediaType.APPLICATION_XML)
    public Staffs staffs() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException{
        StaffDAO staffDAO = new StaffDAO(new SqlDBConnector().connection());
        Staffs staffs = new Staffs();
        staffs.addAll(staffDAO.getStaffs());
        return staffs;
    }
>>>>>>> 762683202dc16a9ee88361267411ae4d82b2ad39
}
