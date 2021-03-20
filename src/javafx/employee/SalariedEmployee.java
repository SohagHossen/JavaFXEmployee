package javafx.employee;

public class SalariedEmployee extends EmployeeType {

    double monthlySalary;

    public SalariedEmployee(String name, String id, String designation, double monthlySalary) {
        super(name, id, designation);
        this.monthlySalary = monthlySalary;
    }

    @Override
    void increaseSalary(double amt) {

        monthlySalary += amt;
    }

    @Override
    double getSalary() {

        return monthlySalary;
    }

    @Override
    String display() {
        String s = "Name: " + getName() + " ID: " + getId() + " Designation: " + getDesignation() + " Salary: " + this.getSalary() + " (Salaried Employee)";
        return s;
    }
}
