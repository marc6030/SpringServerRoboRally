package com.example.springboot_example.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkUtils {

    public static String getIpAddress() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            return inetAddress.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "Unknown IP Address";
        }
    }
}
