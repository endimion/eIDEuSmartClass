/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.aegean.eIdEuSmartClass.model.service.impl;

import gr.aegean.eIdEuSmartClass.model.service.RasberryInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nikos
 */
@Service
public class RasberryInterfaceImpl implements RasberryInterface {

    private final String USER_AGENT = "Mozilla/5.0";

    @Autowired
    public ConfigPropertiesServiceImpl propServ;

    @Override
    public boolean requestCloseRoom(String roomName) throws MalformedURLException, ProtocolException, IOException {
        String url = propServ.getPropByName("RASBERRY_URL");
        String endpoint = propServ.getPropByName("RASBERRY_CLOSE_ROOM");

        URL obj;
        obj = new URL(url + "/" + endpoint +"?roomName="+roomName);
        HttpURLConnection con;
        con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();

        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print result

        return false;
    }

}
