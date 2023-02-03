package com.rest;

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
import javax.xml.bind.JAXBException;

/**
 *
 * @author 236351
 */
@Path("sqlapi")
public class CustomerService {

//    @GET
//    @Path("customers") //http://localhost:8080/group3/rest/sqlapi/customers
//    @Produces(MediaType.APPLICATION_XML)
//    public Customers customers() throws IOException, FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
//        UserDAO customerDAO = new UserDAO(new SqlDBConnector().connection());
//        Customers customers = new Customers();
//        customers.addAll(customerDAO.getUsers("customer"));
//        return customers;
//    }

//    @GET
//    @Path("customer/{ID}") //http://localhost:8080/group3/rest/sqlapi/customer/1001
//    @Produces(MediaType.APPLICATION_XML)
//    public Customer Customer(@PathParam("ID") int ID) throws JAXBException, FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
//        UserDAO customerDAO = new UserDAO(new SqlDBConnector().connection());
//
//        Customer customer = 
//        
//        User user = customerDAO.getUser(ID, "customer");
//        Customers customers = new Customers();
////        customers.add(customer);
//        return customer;
//    }

//    @GET
//    @Path("addcustomer") //http://localhost:8080/group3/rest/sqlapi/addcustomer
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public Response Customer() throws IOException, FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
//        CustomerDAO customerDAO = new CustomerDAO(new SqlDBConnector().connection());
//        customerDAO.create("Robert Michelakos", "rob.m@example.com", "Helloworld123", "1989-04-06", "0419364236");
//        Customer customer = customerDAO.login("rob.m@example.com", "Helloworld123");
//        return Response.status(200).entity(customer).build();
//    }
}
