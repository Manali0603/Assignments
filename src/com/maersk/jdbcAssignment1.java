package com.maersk;

import java.sql.*;

public class jdbcAssignment1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Mamata@1769");
        //con.setAutoCommit(false);

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("Select * from EmployeeTable");
        System.out.println("....DETAILS OF EMPLOYEES....");
        while (rs.next())
            System.out.println(rs.getInt(1) + "   " + rs.getString(2) + "      " + rs.getInt(3) +
                    "   " + rs.getInt(4));

        /*ResultSet rs1 = stmt.executeQuery("SELECT dept_name AS 'Dept_Name', COUNT(*) AS 'Total Employees' FROM EmployeeTable GROUP BY emp_dept");*/

        //NUMBER OF EMPLOYEES IN A DEPARTMENT
        System.out.println("\n....NUMBER OF EMPLOYEES IN A DEPARTMENT....\n");
        ResultSet rs1 = stmt.executeQuery("SELECT e2.emp_dept, d2.dept_name,count(*) \n" +
                "     FROM employeetable e2  \n" +
                "      INNER JOIN departmenttable d2 \n" +
                "        ON e2.emp_dept = d2.dept_id group by e2.emp_dept,d2.dept_id ");
        while (rs1.next()) {
            int count_emp = rs1.getInt("count");
            System.out.println(rs1.getInt("emp_dept") + "   " + rs1.getString("dept_name") + "   " + count_emp);
        }


        //GETTING NAMES OF ALL THE DEPARTMENTS
        System.out.println("\n.....DEPARTMENT NAMES.....\n");
        ResultSet rs2 = stmt.executeQuery("SELECT Dept_name from DepartmentTable");
        while (rs2.next())
            System.out.println(rs2.getString(1));


        //GET NUMBER OF EMPLOYEES WORKING IN COMPANIES
        System.out.println("\n....NUMBER OF EMPLOYEES IN A COMPANY....\n");
        ResultSet rs3 = stmt.executeQuery("SELECT e2.emp_Company as \"Company_ID\", c2.name as \"Company_Name\",count(*) as \"Emp_Count\"\n" +
                "                     FROM employeetable e2  \n" +
                "                      INNER JOIN companytable c2\n" +
                "                        ON e2.emp_company = c2.comid group by e2.emp_company,c2.comid ");
        while (rs3.next()) {
            int count_emp = rs3.getInt("Emp_Count");
            System.out.println(rs3.getInt("Company_ID") + "   " + rs3.getString("Company_Name") + "   " + count_emp);
        }


        System.out.println("\n....EMPLOYEE DETAILS AFTER UPDATE....\n");
        stmt.executeUpdate("update EmployeeTable set emp_dept =941 where Emp_ID > 119; ");
        ResultSet updated_table = stmt.executeQuery("SELECT e2.emp_id ,e2.emp_name , d2.dept_name,c2.name \n" +
                "     FROM((employeetable e2  \n" +
                "      INNER JOIN departmenttable d2 ON e2.emp_dept = d2.dept_id)\n" +
                "      inner join companytable c2 on e2.emp_company =c2.comid) ;");
        while (updated_table.next()) {
            System.out.println(updated_table.getInt("emp_id") + "   " + updated_table.getString("emp_name") + "   " +
                    updated_table.getString("dept_name") + "   " + updated_table.getString("name"));
        }

        con.close();
    }
}
