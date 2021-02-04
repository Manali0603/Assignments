package com.maersk;

import java.sql.*;

public class demoTest1 {
    public static void main(String[] args) {

        try {
            //Setting up the connection
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", "postgres", "Mamata@1769");

            //Execute the query
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from employeedept");
/*            while (rs.next())
//                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getInt(3) + "  "
//                        + rs.getString(4) + "  " + rs.getFloat(5) + "  " + rs.getDate(6));
//
//            ResultSetMetaData rsmd= rs.getMetaData();
//            System.out.println("Total columns = "+rsmd.getColumnCount());
            System.out.println("Name of last Column = "+rsmd.getCatalogName(6));*/

            //Iterate through the result-set
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2));

/*            PreparedStatement ps = con.prepareStatement("insert into employeedept values(?,?)");
//            ps.setInt(1, 2);//1 specifies the first parameter in the query
//            ps.setString(2, "Ratan");

//            System.out.println("......AFTER......");
//            ResultSet rs1 = stmt.executeQuery("Select * from employeedept");
//            while (rs1.next())
               System.out.println(rs1.getInt(1) + "  " + rs1.getString(2));*/

            String sql = "INSERT INTO employeedept " +
                    "VALUES (3, 'Zara')";
            stmt.executeUpdate(sql);

/*            CallableStatement stmt1=con.prepareCall("{call insertR(?,?)}");
//            stmt1.setInt(1,6);
//            stmt1.setString(2,'Amit');
           stmt1.execute();*/

            //Getting the meta-data
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("Total columns = " + rsmd.getColumnCount());
            System.out.println("Table name = " + rsmd.getTableName(1));
            System.out.println("Name of second Column = " + rsmd.getColumnName(2));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
