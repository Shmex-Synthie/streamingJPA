package com.nossotubo.trabalho.config;

import com.nossotubo.trabalho.model.*;
import com.nossotubo.trabalho.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final UsuarioRepository usuarioRepo;
    private final PerfilRepository perfilRepo;
    private final CategoriaRepository categoriaRepo;
    private final VideoRepository videoRepo;
    private final VisualizacaoRepository visualizacaoRepo;
    private final AvaliacaoRepository avaliacaoRepo;

    public DataLoader(UsuarioRepository usuarioRepo,
                      PerfilRepository perfilRepo,
                      CategoriaRepository categoriaRepo,
                      VideoRepository videoRepo,
                      VisualizacaoRepository visualizacaoRepo,
                      AvaliacaoRepository avaliacaoRepo) {
        this.usuarioRepo = usuarioRepo;
        this.perfilRepo = perfilRepo;
        this.categoriaRepo = categoriaRepo;
        this.videoRepo = videoRepo;
        this.visualizacaoRepo = visualizacaoRepo;
        this.avaliacaoRepo = avaliacaoRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // Limpar (opcional)
        avaliacaoRepo.deleteAll();
        visualizacaoRepo.deleteAll();
        videoRepo.deleteAll();
        perfilRepo.deleteAll();
        usuarioRepo.deleteAll();
        categoriaRepo.deleteAll();

        // --- Usuários ---
        Usuario u1 = new Usuario();
        u1.setNome("João Silva");
        u1.setEmail("joao@example.com");
        u1.setSenha("senha");
        u1.setDataCadastro(LocalDateTime.now().minusMonths(3));

        Usuario u2 = new Usuario();
        u2.setNome("Maria Souza");
        u2.setEmail("maria@example.com");
        u2.setSenha("senha");
        u2.setDataCadastro(LocalDateTime.now().minusMonths(1));

        Usuario u3 = new Usuario();
        u3.setNome("Carlos Pereira");
        u3.setEmail("carlos@example.com");
        u3.setSenha("senha");
        u3.setDataCadastro(LocalDateTime.now().minusMonths(2));

        Usuario u4 = new Usuario();
        u4.setNome("Ana Lima");
        u4.setEmail("ana@example.com");
        u4.setSenha("senha");
        u4.setDataCadastro(LocalDateTime.now().minusDays(15));

        usuarioRepo.saveAll(List.of(u1, u2, u3, u4));

        // --- Perfis ---
        Perfil p1 = new Perfil();
        p1.setNomePerfil("Joao-Adulto");
        p1.setUsuario(u1);
        Perfil p2 = new Perfil();
        p2.setNomePerfil("Joao-Crianca");
        p2.setUsuario(u1);
        Perfil p3 = new Perfil();
        p3.setNomePerfil("Maria");
        p3.setUsuario(u2);
        Perfil p4 = new Perfil();
        p4.setNomePerfil("Carlos");
        p4.setUsuario(u3);
        Perfil p5 = new Perfil();
        p5.setNomePerfil("Ana");
        p5.setUsuario(u4);
        perfilRepo.saveAll(List.of(p1, p2, p3, p4, p5));

        // --- Categorias ---
        Categoria acao = new Categoria();
        acao.setNome("Ação");
        Categoria comedia = new Categoria();
        comedia.setNome("Comédia");
        Categoria drama = new Categoria();
        drama.setNome("Drama");
        Categoria terror = new Categoria();
        terror.setNome("Terror");
        categoriaRepo.saveAll(List.of(acao, comedia, drama, terror));

        // --- Videos ---
        Video v1 = new Video();
        v1.setTitulo("Missão Impossível");
        v1.setDescricao("Espionagem");
        v1.setDuracao(120);
        v1.setCategoria(acao);
        Video v2 = new Video();
        v2.setTitulo("Missão Secreta");
        v2.setDescricao("Aventura");
        v2.setDuracao(95);
        v2.setCategoria(acao);
        Video v3 = new Video();
        v3.setTitulo("Comédia Romântica");
        v3.setDescricao("Amor e risos");
        v3.setDuracao(110);
        v3.setCategoria(comedia);
        Video v4 = new Video();
        v4.setTitulo("Drama Familiar");
        v4.setDescricao("História emocionante");
        v4.setDuracao(130);
        v4.setCategoria(drama);
        Video v5 = new Video();
        v5.setTitulo("Missão Final");
        v5.setDescricao("Final da trilogia");
        v5.setDuracao(140);
        v5.setCategoria(acao);
        Video v6 = new Video();
        v6.setTitulo("Terror Noturno");
        v6.setDescricao("Medo à noite");
        v6.setDuracao(100);
        v6.setCategoria(terror);
        Video v7 = new Video();
        v7.setTitulo("Comédia de Erros");
        v7.setDescricao("Risos garantidos");
        v7.setDuracao(90);
        v7.setCategoria(comedia);
        videoRepo.saveAll(List.of(v1, v2, v3, v4, v5, v6, v7));

        // --- Visualizacoes ---
        visualizacaoRepo.saveAll(List.of(
                new Visualizacao(null, p1, v1, LocalDateTime.now().minusDays(10), 100),
                new Visualizacao(null, p1, v2, LocalDateTime.now().minusDays(9), 80),
                new Visualizacao(null, p1, v1, LocalDateTime.now().minusDays(2), 50),
                new Visualizacao(null, p2, v1, LocalDateTime.now().minusDays(5), 100),
                new Visualizacao(null, p3, v3, LocalDateTime.now().minusDays(3), 100),
                new Visualizacao(null, p3, v1, LocalDateTime.now().minusDays(1), 60),
                new Visualizacao(null, p3, v5, LocalDateTime.now().minusDays(1), 90),
                new Visualizacao(null, p4, v6, LocalDateTime.now().minusDays(4), 100),
                new Visualizacao(null, p4, v2, LocalDateTime.now().minusDays(2), 70),
                new Visualizacao(null, p5, v3, LocalDateTime.now().minusDays(1), 100),
                new Visualizacao(null, p5, v7, LocalDateTime.now().minusDays(1), 80)
        ));

        // --- Avaliacoes ---
        avaliacaoRepo.saveAll(List.of(
                new Avaliacao(null, p1, v1, 5, "Excelente"),
                new Avaliacao(null, p2, v1, 4, "Bom"),
                new Avaliacao(null, p3, v3, 5, "Muito bom"),
                new Avaliacao(null, p3, v5, 4, "Gostei"),
                new Avaliacao(null, p1, v2, 3, "OK"),
                new Avaliacao(null, p4, v6, 4, "Assustador"),
                new Avaliacao(null, p4, v2, 3, "Legal"),
                new Avaliacao(null, p5, v3, 5, "Ri muito"),
                new Avaliacao(null, p5, v7, 4, "Divertido")
        ));
    }
}