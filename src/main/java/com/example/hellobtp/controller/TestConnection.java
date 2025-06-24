package com.example.hellobtp.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {
        try {
            Class.forName("com.sap.db.jdbc.Driver");

            String url = "jdbc:sap://327636abtrial.hana-tooling.ingress.orchestration.trial-us10.hanacloud.ondemand.com:443/?encrypt=true&validateCertificate=false";
            String username = "DBADMIN";
            String password = "Adminpass123*";

            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                System.out.println("Connection successful: " + conn.isValid(5));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
