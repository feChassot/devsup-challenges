package PlataformaDeEnsino.application;

import PlataformaDeEnsino.entities.Lesson;
import PlataformaDeEnsino.entities.Task;
import PlataformaDeEnsino.entities.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Lesson> lesson = new ArrayList<>();

        System.out.print("Quantas aulas tem o curso? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nDados da " + i + " aula: ");
            System.out.print("Conteudo ou tarefa (c/t)? ");
            char ch = sc.next().charAt(0);
            sc.nextLine();

            System.out.print("Digite o titulo: ");
            String title = sc.nextLine();

            if (ch == 'c') {
                System.out.print("URL: ");
                String url = sc.nextLine();
                System.out.print("Duracao: ");
                int duracao = sc.nextInt();
                sc.nextLine();

                lesson.add(new Video(title, url, duracao));
            } else if (ch == 't') {
                System.out.print("Descricao: ");
                String descricao = sc.nextLine();
                System.out.print("Quantidade de questoes: ");
                int qtd = sc.nextInt();
                sc.nextLine();

                lesson.add(new Task(title, descricao, qtd));
            }
        }

        int duracaoTotal = 0;
        for (Lesson l : lesson) {
            duracaoTotal += l.duration();
        }

        System.out.println("\nDURACAO TOTAL DO CURSO = " + duracaoTotal);

        sc.close();
    }
}
