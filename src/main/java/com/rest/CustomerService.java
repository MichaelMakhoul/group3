package com.rest;

import com.model.Customer;
import com.model.Customers;
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
 *
 * @author 236351
 */
@Path("customerapi")
public class CustomerService {

    @GET
    @Path("customers") //http://localhost:8080/group3/rest/customerapi/customers
    @Produces(MediaType.APPLICATION_XML)
    public Customers customers() throws IOException, FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        UserDAO customerDAO = new UserDAO(new SqlDBConnector().connection());
        Customers customers = new Customers();
        customers.addAll(customerDAO.getUsers("customer"));
        return customers;
    }

    @GET
    @Path("customer/{ID}") //http://localhost:8080/group3/rest/customerapi/customer/1001
    @Produces(MediaType.APPLICATION_XML)
    public Customers customer(@PathParam("ID") int ID) throws JAXBException, FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        UserDAO customerDAO = new UserDAO(new SqlDBConnector().connection());
        Customers customers = new Customers();        
        User user = customerDAO.getUser(ID, "customer");       
        customers.add(user);
        return customers;
    }

    @GET
    @Path("addcustomer") //http://localhost:8080/group3/rest/customerapi/addcustomer
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response addCustomer() throws IOException, FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        UserDAO customerDAO = new UserDAO(new SqlDBConnector().connection());
        Customers customers = new Customers(); 
        customerDAO.create("customer", "Robert Michelakos", "rob.m@example.com", "Helloworld123", "1989-04-06", "0419364236");
        User customer = customerDAO.login("rob.m@example.com", "Helloworld123","customer");
        customers.add(customer);
        return Response.status(200).entity(customers).build();
    }
}