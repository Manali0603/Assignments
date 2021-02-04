package com.maersk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class transactionExample2 {
    public static void main(String[] args) {
        try {

            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Mamata@1769");
            con.setAutoCommit(false);

            PreparedStatement ps = con.prepareStatement("insert into employeedept values(?,?)");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {

                System.out.println("enter id");
                String s1 = br.readLine();
                int id = Integer.parseInt(s1);

                System.out.println("enter name");
                String name = br.readLine();



                ps.setInt(1, id);
                ps.setString(2, name);
                ps.executeUpdate();

                System.out.println("commit/rollback");
                String answer = br.readLine();
                if (answer.equals("commit")) {
                    con.commit();
                }
                if (answer.equals("rollback")) {
                    con.rollback();
                }


                System.out.println("Want to add more records y/n");
                String ans = br.readLine();
                if (ans.equals("n")) {
                    break;
                }

            }
            con.commit();
            System.out.println("record successfully saved");

            con.close();//before closing connection commit() is called
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
