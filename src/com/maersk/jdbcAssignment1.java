package com.maersk;

import java.sql.*;

public class jdbcAssignment1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Mamata@1769");
        //con.setAutoCommit(false);

        Statement stmt = con.createStatement();
        ResultSet emp_details = stmt.executeQuery("Select * from EmployeeTable");
        System.out.println("....DETAILS OF EMPLOYEES....");
        while (emp_details.next())
            System.out.println(emp_details.getInt(1) + "   " + emp_details.getString(2) + "      " + emp_details.getInt(3) +
                    "   " + emp_details.getInt(4));

        /*ResultSet rs1 = stmt.executeQuery("SELECT dept_name AS 'Dept_Name', COUNT(*) AS 'Total Employees' FROM EmployeeTable GROUP BY emp_dept");*/

        //NUMBER OF EMPLOYEES IN A DEPARTMENT
        System.out.println("\n....NUMBER OF EMPLOYEES IN A DEPARTMENT....\n");
        ResultSet empCountDept = stmt.executeQuery("SELECT e2.emp_dept, d2.dept_name,count(*) \n" +
                "     FROM employeetable e2  \n" +
                "      INNER JOIN departmenttable d2 \n" +
                "        ON e2.emp_dept = d2.dept_id group by e2.emp_dept,d2.dept_id ");
        while (empCountDept.next()) {
            int count_emp = empCountDept.getInt("count");
            System.out.println(empCountDept.getInt("emp_dept") + "   " + empCountDept.getString("dept_name") + "   " + count_emp);
        }


        //GETTING NAMES OF ALL THE DEPARTMENTS
        System.out.println("\n.....DEPARTMENT NAMES.....\n");
        ResultSet deptNames = stmt.executeQuery("SELECT Dept_name from DepartmentTable");
        while (deptNames.next())
            System.out.println(deptNames.getString(1));


        //GET NUMBER OF EMPLOYEES WORKING IN COMPANIES
        System.out.println("\n....NUMBER OF EMPLOYEES IN A COMPANY....\n");
        ResultSet empCountCompany = stmt.executeQuery("SELECT e2.emp_Company as \"Company_ID\", c2.name as \"Company_Name\",count(*) as \"Emp_Count\"\n" +
                "                     FROM employeetable e2  \n" +
                "                      INNER JOIN companytable c2\n" +
                "                        ON e2.emp_company = c2.comid group by e2.emp_company,c2.comid ");
        while (empCountCompany.next()) {
            int count_emp = empCountCompany.getInt("Emp_Count");
            System.out.println(empCountCompany.getInt("Company_ID") + "   " + empCountCompany.getString("Company_Name") + "   " + count_emp);
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
