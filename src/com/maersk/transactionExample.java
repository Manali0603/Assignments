package com.maersk;

import java.sql.*;

public class transactionExample {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Mamata@1769");
        con.setAutoCommit(false);

        Statement stmt = con.createStatement();
//        stmt.executeUpdate("insert into employeedept values(10,'Siri')");
//        stmt.executeUpdate("insert into employeedept values(9,'umesh')");
        ResultSet rs =stmt.executeQuery("Select * from employeedept");
        while (rs.next())
            System.out.println(rs.getInt(1) + "  " + rs.getString(2));

        con.commit();
        con.close();
    }
}
