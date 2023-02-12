package com.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Used for Customer bean
 * Class has a default Constructor
 * Inherits the User class 
 *
 * @author Antonella, Micheal
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "customer")
public class Customer extends User implements Serializable {

    public Customer() {
        super();
    }
}