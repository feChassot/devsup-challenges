package EmpregadosOO.application;

import EmpregadosOO.entities.Address;
import EmpregadosOO.entities.Department;
import EmpregadosOO.entities.Employee;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        //nao setei o locale no desafio passado pois estou localizado nos EUA, mas irei setar nesse.
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do departamento: ");
        String deptName = (sc.nextLine());
        System.out.print("Dia do pagamento: ");
        int payDay = (sc.nextInt());
        sc.nextLine();
        System.out.print("Email: ");
        String email = (sc.nextLine());
        System.out.print("Telefone: ");
        String phone = (sc.nextLine());
        System.out.print("Quantos funcionarios tem o departamento? ");
        int n = sc.nextInt();
        sc.nextLine();

        Department dept = new Department(deptName, payDay, new Address(email, phone));

        for (int i = 1; i <= n; i++) {
            Employee e = new Employee();
            System.out.println("Dados do funcionario " + i + ": ");
            System.out.print("Nome: ");
            e.setName(sc.nextLine());
            System.out.print("Salario: ");
            e.setSalary(sc.nextDouble());
            sc.nextLine();
            dept.addEmployee(e);
        }
        showReport(dept);
        sc.close();
    }

    public static void showReport(Department dept) {
        System.out.println(dept.toString());
    }
}
