package com.rest;

import com.model.Customer;
import com.model.Customers;
import com.model.dao.CustomerDAO;
import com.model.dao.SqlDBConnector;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
@Path("sqlapi")
public class CusromerSqlService {

    @GET
    @Path("customers") //http://localhost:8080/group3/rest/sqlapi/customers
    @Produces(MediaType.APPLICATION_XML)
    public Customers customers() throws IOException, FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        CustomerDAO customerDAO = new CustomerDAO(new SqlDBConnector().connection());
        Customers customers = new Customers();
        customers.addAll(customerDAO.getCustomers());
        return customers;
    }

//    @GET
//    @Path("customer/{ID}") //http://localhost:8080/labs/rest/sqlapi/customer/100000
//    @Produces(MediaType.APPLICATION_XML)
//    public Customers Customer(@PathParam("ID") int ID) throws JAXBException, FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
//        Customer customer = new Customer(new SqlDBConnector().connection());
//
//        Customer customer = Customer(ID);
//        Customer customer = new Customer();
//        customer.add(customer);
//        return customer;
//    }

//    @GET
//    @Path("customer") //http://localhost:8080/labs/rest/sqlapi/customer
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public Response Customer() throws IOException, FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
//        Customer customer = new Customer(new SqlDBConnector().connection());
//        customer.create("Sam", "sam@example.com", "Hello123", "2000-02-02");
//        
//        Customer customer = customer.login("sam@example.com", "Hello123");
//        
//        return Response.status(200).entity(customer).build();
//    }
}
