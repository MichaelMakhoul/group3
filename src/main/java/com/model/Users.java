/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 236351
 */
public class Users {
    private List<User> users = new ArrayList();

    public Users() {}
    
    public void add(User user) {
        this.users.add(user);
    }

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
