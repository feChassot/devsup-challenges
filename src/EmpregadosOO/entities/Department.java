package EmpregadosOO.entities;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private int payDay = 0;

    private List<Employee> employees = new ArrayList<>();

    private Address address;

    public Department() {

    }

    public Department(String name, int payDay, Address address) {
        this.name = name;
        this.payDay = payDay;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPayDay() {
        return payDay;
    }

    public void setPayDay(int payDay) {
        this.payDay = payDay;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double payroll() {
        double payroll = 0;
        for (Employee e : employees) {
            payroll += e.getSalary();
        }
        return payroll;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nFOLHA DE PAGAMENTO: ");
        sb.append("\nDepartamento de ").append(name).append(" = R$ ").append(String.format("%.2f", payroll()));
        sb.append("\nPagamento realizado no dia ").append(payDay);
        sb.append("\nFuncionarios: ");
        for (Employee e : employees) {
            sb.append("\n").append(e.getName());
        }
        sb.append("\nPara duvidas favor entrar em contato: ").append(address.getEmail());
        return sb.toString();
    }
}
