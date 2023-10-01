/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.utesa.algoritmosparalelos.algoritmoscarrera;

import java.io.IOException;
import static java.net.Authenticator.RequestorType.SERVER;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author manny
 */
public class AlgoritmosCarrera {
private static String server = "http://www.google.com/";
    public static void main(String[] args) throws MalformedURLException, ProtocolException, IOException {
    
URL url = new URL( "http://localhost:8080" );
HttpURLConnection httpConn =  (HttpURLConnection)url.openConnection();
httpConn.setInstanceFollowRedirects( false );
httpConn.setRequestMethod( "HEAD" ); 
try{
    httpConn.connect();
     System.out.println( "google.com : " + httpConn.getResponseCode());
}catch(java.net.ConnectException e){
     System.out.println( "google.com is down ");
}
//System.out.println(isReachable("www.google.com.do", 80, 1000));
    }
    private static boolean isReachable(String host, int openPort, int timeOutMillis) {
    try {
        try (Socket soc = new Socket()) {
            soc.connect(new InetSocketAddress(host, openPort), timeOutMillis);
        }
        return true;
    } catch (IOException ex) {
        return false;
    }
}
    private static boolean hostsWebApp(String host, int timeOutMillis) {
        boolean isReachable = isReachable(host, 80, timeOutMillis);
    if(!isReachable) {
        return isReachable(host, 443, timeOutMillis);
    } else {
        return true;
    }
}
}
