package packagesAndExceptionAssignment3;

public class Employee {
    int empid;
    String empName;
    String designation;
    double basic;
    double hra;

    Employee() {

    }

    Employee(int empid, String empName, String designation, double basic) {
        this.empid = empid;
        this.empName = empName;
        this.designation = designation;
        this.basic = basic;


    }

    double getBasic() {
        if (basic < 500) {
            try {
                throw new LowSalException();

            } catch (LowSalException e) {
                // TODO Auto-generated catch block
                // e.printStackTrace();
                System.out.println(e);
            }
        }
        return basic;
    }

    public void printDET() {
        System.out.println("Id Of Employee :" + empid + "\n Name of Employee  :" + empName +
                "\n Designation Of Employee :" + designation + "\nSalary Of Employee :" + basic);
    }

    public void calculateHRA() {
        if (designation.equals("Officer")) {
            hra = 0.12 * basic;
            System.out.println("HRA OF OFFICER : " + hra);
        } else if (designation.equals("Manager")) {
            hra = 0.1 * basic;
            System.out.println("HRA OF MANAGER : " + hra);
        } else if (designation.equals("Clerk")) {
            hra = 0.05 * basic;
            System.out.println("HRA OF CLERK : " + hra);
        }
    }

    public static void main(String[] args) {
        Employee e = new Employee();
        e.getBasic();
        System.out.println();
        Employee e1 = new Employee(2, "Anmol", "Manager", 400);
        e1.calculateHRA();
        e1.printDET();
        System.out.println();
        Employee e2 = new Employee(3, "Surbhi", "officer", 100);
        e2.getBasic();
        e2.printDET();
        e2.calculateHRA();
        System.out.println();
        System.out.println();
        Employee e3 = new Employee(4, "Sukriti", "clerk", 15000);
        e3.printDET();
        e3.calculateHRA();
    }

}
