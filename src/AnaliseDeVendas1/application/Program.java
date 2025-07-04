package AnaliseDeVendas1.application;

import AnaliseDeVendas1.entities.Sale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre o caminho do arquivo: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            List<Sale> list = new ArrayList<>();

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                list.add(new Sale(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]),
                        fields[2], Integer.parseInt(fields[3]), Double.parseDouble(fields[4])));
                line = br.readLine();
            }
            System.out.println("\nCinco primeiras vendas de 2016 de maior preco medio: ");

            int yearToFilter = 2016;
            list.stream()
                    .filter(s -> s.getYear() == yearToFilter)
                    .sorted(Comparator.comparingDouble(Sale::averagePrice).reversed()) //Double.compare(y.averagePrice(), x.averagePrice())
                    .limit(5)
                    .forEach(System.out::println); //(s -> System.out.println(s));

            double totalSold = list.stream()
                    .filter(s -> s.getSeller().equals("Logan")
                            && (s.getMonth() == 1 || s.getMonth() == 7))
                    .map(Sale::getTotal) // (s -> s.getTotal());
                    .reduce(0.0, Double::sum); //(0.0, (x,y) -> x+y);

            System.out.println("\nValor total vendido pelo vendedor Logan nos meses 1 e 7 = "
                    + totalSold);




        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
                sc.close();
    }
}
