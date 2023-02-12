package com.model.dao;

import com.model.Bookings;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Used to Bookings bean using xsl and load the Bookings List View
 * 
 * @author Shilpa
 */
public class XmlTransformer {
    public XmlTransformer(){}
    
       
    public void transform(String xslPath, Bookings bookings, StreamResult result) throws JAXBException, TransformerConfigurationException, TransformerException{
        TransformerFactory tf = TransformerFactory.newInstance();
        StreamSource xslSource = new StreamSource(xslPath);
        JAXBContext jc = JAXBContext.newInstance(Bookings.class);
        JAXBSource xmlSource = new JAXBSource(jc, bookings);
        Transformer transformer = tf.newTransformer(xslSource);
        transformer.transform(xmlSource, result);
    }

}
