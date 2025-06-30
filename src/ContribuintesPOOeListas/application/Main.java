package ContribuintesPOOeListas.application;

import ContribuintesPOOeListas.entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = 0;
        double salaryIncome = 0;
        double servicesIncome = 0;
        double capitalIncome = 0;
        double healthSpending = 0;
        double educationSpending = 0;

        Scanner sc = new Scanner(System.in);

        List<TaxPayer> taxPayers = new ArrayList<>();

        System.out.print("Quantos contribuintes voce vai digitar? ");
        n = sc.nextInt();

        for (int i = 1; i <= n; i++){
            System.out.println("\nDigite os dados do " + i + "o contribuinte: ");
            System.out.print("Renda anual com salario: ");
            salaryIncome = sc.nextDouble();
            System.out.print("Renda anual com prestacao de servico: ");
            servicesIncome = sc.nextDouble();
            System.out.print("Renda anual com ganho de capital: ");
            capitalIncome = sc.nextDouble();
            System.out.print("Gastos medicos: ");
            healthSpending = sc.nextDouble();
            System.out.print("Gastos educacionais: ");
            educationSpending = sc.nextDouble();

            taxPayers.add(new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending));

        }

        int i = 1;
        for (TaxPayer t : taxPayers) {
            System.out.println("\n Resumo do " + i + "o contribuinte: ");
            System.out.printf("Imposto bruto total: %.2f\n", t.grossTax());
            System.out.printf("Abatimento: %.2f\n", t.taxRebate());
            System.out.printf("Imposto devido: %.2f\n", t.netTax());
            i++;
        }
        sc.close();
    }
}
