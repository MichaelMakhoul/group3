package com.rest;

import com.model.Staffs;
import com.model.User;
import com.model.dao.SqlDBConnector;
import com.model.dao.UserDAO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;

/**
 * This rest web gives the output for
 * - view the list of staff
 * - view a staff member searching by ID
 * - add a staff to the database
 *
 * @author Antonella and Aiman
 */

@Path("staffapi")
public class StaffService {
    
    /**
     * Web service Module: Staff Management
     * By: Aiman
     * 
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws SQLException 
     */
    
    @GET
    @Path("staffs") //http://localhost:8080/group3/rest/staffapi/staffs
    @Produces(MediaType.APPLICATION_XML)
    public Staffs staffs() throws IOException, FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        UserDAO userDAO = new UserDAO(new SqlDBConnector().connection());
        Staffs staffs = new Staffs();
        staffs.addAll(userDAO.getUsers("staff"));
        return staffs;
    }
    
    /**
     * Web service Module: User Registration
     * By: Antonella
     * 
     * @param ID
     * @return
     * @throws JAXBException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IOException 
     */

    @GET
    @Path("staff/{ID}") //http://localhost:8080/group3/rest/staffapi/staff/10001
    @Produces(MediaType.APPLICATION_XML)
    public Staffs staff(@PathParam("ID") int ID) throws JAXBException, FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        UserDAO userDAO = new UserDAO(new SqlDBConnector().connection());
        Staffs staffs = new Staffs();        
        User user = userDAO.getUser(ID, "staff");       
        staffs.add(user);
        return staffs;
    }
    
    /**
     * Web service Module: User Registration and Staff Management
     * By: Aiman and Antonella
     * 
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws SQLException 
     */

    @GET
    @Path("addstaff") //http://localhost:8080/group3/rest/staffapi/addstaff
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response addStaff() throws IOException, FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        UserDAO userDAO = new UserDAO(new SqlDBConnector().connection());
        Staffs staffs = new Staffs(); 
        userDAO.create("staff", "Robert Michelakos", "rob.m@tgsstaff.com", "Helloworld123", "1989-04-06", "+61419364236");
        User staff = userDAO.login("rob.m@tgsstaff.com", "Helloworld123","staff");
        staffs.add(staff);
        return Response.status(200).entity(staffs).build();
    }
}
