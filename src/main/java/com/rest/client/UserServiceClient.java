//package com.rest.client;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//
///**
// *
// * @author 236351
// */
//public class UserServiceClient {
//
//    public static String xmlPath(String url, String xml) throws MalformedURLException, IOException {
//        URL uri = new URL(url);
//        HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
//        connection.setRequestMethod("GET");
//        connection.setRequestProperty("Accept", "application/xml");
//
//        if (connection.getResponseCode() != 200) {
//            return "Invalid API request";
////            throw new RuntimeException("Failed: HTTP error code: " + connection.getInputStream());
//        }
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//
//        File file = new File(xml);
//        if (!file.exists()) {
//            file.createNewFile();
//        }
//
//        FileWriter writer = new FileWriter(file);
//        BufferedWriter bw = new BufferedWriter(writer);
//
//        String output = "";
//
//        while ((output = br.readLine()) != null) {
//            bw.write(output);
//        }
//
//        bw.close();
//        connection.disconnect();
//        return file.getAbsolutePath();
//    }
//
//    public static String xmlPath() throws IOException {
//        return xmlPath("http://localhost:8080/labs/rest/sqlapi/users",
//                "C:\\Users\\236351\\Documents\\step_it_up\\labs\\src\\main\\webapp\\WEB-INF\\usergen.xml");
//        
////        return xmlPath("http://localhost:8080/labs/rest/userapi/getusers",
////                "C:\\Users\\236351\\Documents\\step_it_up\\labs\\src\\main\\webapp\\WEB-INF\\usergen.xml");
//    }
//
//    public static String fetchUser(int ID) throws IOException {
//        return xmlPath("http://localhost:8080/labs/rest/userapi/user/ID/" + ID,
//                "C:\\Users\\236351\\Documents\\step_it_up\\labs\\src\\main\\webapp\\WEB-INF\\fetchuser.xml");
//    }
//}
