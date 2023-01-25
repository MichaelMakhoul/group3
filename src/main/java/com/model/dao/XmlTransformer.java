package com.model.dao;

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
 *
 * @author 236351
 */
public class XmlTransformer {
    public XmlTransformer(){}
    
//          --- Uncomment if needed to be used for (Customer, Staff, ...) ---  
//    public void transform(String xslPath, Customers users, StreamResult result) throws JAXBException, TransformerConfigurationException, TransformerException{
//        TransformerFactory tf = TransformerFactory.newInstance();
//        StreamSource xslSource = new StreamSource(xslPath);
//        JAXBContext jc = JAXBContext.newInstance(Customers.class);
//        JAXBSource xmlSource = new JAXBSource(jc, users);
//        Transformer transformer = tf.newTransformer(xslSource);
//        transformer.transform(xmlSource, result);
//    }
    
    public void transform(String xslPath, String xmlPath, StreamResult result) throws TransformerConfigurationException, TransformerException{
        TransformerFactory tf = TransformerFactory.newInstance();
        StreamSource xslSource = new StreamSource(xslPath);
        StreamSource xmlSource = new StreamSource(xmlPath);
        Transformer transformer = tf.newTransformer(xslSource);
        transformer.transform(xmlSource, result);
    }
}
