package com.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Used for Staff bean
 * Class has a default Constructor
 * Inherits the User class 
 *
 * @author Aimnan, Antonella
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "staff")
public class Staff extends User implements Serializable{

    public Staff() {
    }    
}
