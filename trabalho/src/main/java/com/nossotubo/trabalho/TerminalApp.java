package com.nossotubo.trabalho;

import com.nossotubo.trabalho.model.Video;
import com.nossotubo.trabalho.model.Usuario;
import com.nossotubo.trabalho.service.UsuarioService;
import com.nossotubo.trabalho.service.VideoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class TerminalApp implements CommandLineRunner {

    private final VideoService videoService;
    private final UsuarioService usuarioService;

    public TerminalApp(VideoService videoService, UsuarioService usuarioService) {
        this.videoService = videoService;
        this.usuarioService = usuarioService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Buscar vídeos por título");
            System.out.println("2 - Buscar vídeos por categoria");
            System.out.println("3 - Top 10 vídeos mais bem avaliados");
            System.out.println("4 - Top 10 vídeos mais assistidos");
            System.out.println("5 - Usuário que mais assistiu vídeos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // consumir Enter

            switch (opcao) {
                case 1:
                    System.out.print("Digite parte do título: ");
                    String titulo = sc.nextLine();
                    List<Video> videosTitulo = videoService.buscarPorTitulo(titulo);
                    videosTitulo.forEach(v -> System.out.println(v.getTitulo()));
                    break;
                case 2:
                    System.out.print("Digite o nome da categoria: ");
                    String cat = sc.nextLine();
                    List<Video> videosCat = videoService.buscarPorCategoria(cat);
                    videosCat.forEach(v -> System.out.println(v.getTitulo()));
                    break;
                case 3:
                    System.out.println("Top 10 vídeos mais bem avaliados:");
                    videoService.top10Avaliados().forEach(v -> System.out.println(v.getTitulo()));
                    break;
                case 4:
                    System.out.println("Top 10 vídeos mais assistidos:");
                    videoService.top10MaisAssistidos().forEach(v -> System.out.println(v.getTitulo()));
                    break;
                case 5:
                    Usuario top = usuarioService.usuarioMaisAtivo();
                    if (top != null) {
                        System.out.println("Usuário mais ativo: " + top.getNome());
                    } else {
                        System.out.println("Nenhum usuário encontrado.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
