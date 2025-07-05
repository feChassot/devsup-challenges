package AnaliseDeVendas2.application;

import AnaliseDeVendas1.entities.Sale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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

            Map<String, Double> totalPerSeller = list.stream()
                    .collect(Collectors.groupingBy(s -> s.getSeller(), Collectors.summingDouble(s -> s.getTotal())));

            System.out.println("\nTotal de vendas por vendedor: ");

            for(Map.Entry<String, Double> entry : totalPerSeller.entrySet()) {
                System.out.printf("%s - R$ %.2f%n", entry.getKey(), entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}
