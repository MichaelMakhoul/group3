package com.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that contains the list of Users as field
 * A function to add a User to the bean
 * A function to add a List of User to the bean
 * Contains getter and setter of the list
 * 
 * @author Antonella, Micheal
 */
public class Users {
    private List<User> users = new ArrayList();

    public Users() {}
    
    //use for web service
    public void add(User user) {
        this.users.add(user);
    }
    
    //use for web service
    public void addAll(List<User> temp) {
        this.users.addAll(temp);
    }
    
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
