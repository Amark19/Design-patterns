package solid.live.srp;

public class Employee {
    private int empId;
    private static int TOTAL_LEAVES_ALLOWED = 30;

    private double monthlySalary;
    private String name;
    private String addressStreet;
    private String addressCity;
    private String addressCountry;
    private int leavesTaken;
    private int totalLeaveAllowed;
    private int leaveTaken;
    private String manager;
    private int yearsInOrg;
    private int thisYeard;
    private int[] leavesLeftPreviously;

    public Employee(int empId, double monthlySalary, String name, String addressStreet, String addressCity,
            String addressCountry, int leavesTaken, int[] leavesLeftPreviously,int totalLeaveAllowed) {
        this.empId = empId;
        this.monthlySalary = monthlySalary;
        this.name = name;
        this.addressStreet = addressStreet;
        this.addressCity = addressCity;
        this.addressCountry = addressCountry;
        this.leavesTaken = leavesTaken;
        this.leavesLeftPreviously = leavesLeftPreviously;
        this.yearsInOrg = leavesLeftPreviously.length;
        this.totalLeaveAllowed = totalLeaveAllowed;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public int leaveCalculation(){
        return totalLeaveAllowed - leaveTaken;
    }

    public String getManager(){
        return manager;
    }

    public double getSalary(){
        return monthlySalary;
    }

    public String leaveLeftsCalculation(){
        int years = 3;
        if (yearsInOrg < 3) {
            years = yearsInOrg;
        }
        int totalLeaveLeftPreviously = 0;
        for (int i = 0; i < years; i++) {
            totalLeaveLeftPreviously += leavesLeftPreviously[yearsInOrg - i - 1];
        }
        return "<span>" + totalLeaveLeftPreviously + "</span>";

    }
}

class Formatter {
    Employee employee;

    Formatter(Employee employee) {
        this.employee = employee;
    }

    public String toHtml() {
        String str = "<div>" +
                "<h1>Employee Info</h1>" +
                "<div id='emp" + employee.getEmpId() + "'>" +
                "<span>" + employee.getName() + "</span>" +
                "<div class='left'>" +
                "<span>Leave Left :</span>" +
                "<span>Annual Salary:</span>" +
                "<span>Manager:</span>" +
                "<span>Reimbursable Leave:</span>" +
                "</div>";
        str += "<div class='right'><span>" + employee.leaveCalculation() + "</span>";
        str += "<span>" + Math.round(employee.getSalary() * 12) + "</span>";
        if (employee.getManager() != null)
            str += "<span>" + employee.getManager() + "</span>";
        else
            str += "<span>None</span>";
        
        str += "<span>" + employee.leaveLeftsCalculation() + "</span>";
        return str + "</div> </div>";
    } 
}
