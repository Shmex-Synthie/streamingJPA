package com.nossotubo.trabalho.repository;

import com.nossotubo.trabalho.model.Video;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {
    // Buscar vídeos pelo título com ordenação
    List<Video> findByTituloContainingIgnoreCaseOrderByTituloAsc(String tituloPart);

    // Todos os vídeos de uma categoria ordenado pelo título (por nome da categoria)
    List<Video> findAllByCategoriaNomeOrderByTituloAsc(String nomeCategoria);

    // Top 10 vídeos mais bem avaliados (média das notas)
    @Query("SELECT v FROM Video v JOIN v.avaliacoes a GROUP BY v ORDER BY AVG(a.nota) DESC")
    List<Video> findTopByAverageRating(Pageable pageable);

    // Top 10 vídeos mais assistidos (contagem de visualizações)
    @Query("SELECT v FROM Video v JOIN v.visualizacoes vis GROUP BY v ORDER BY COUNT(vis) DESC")
    List<Video> findTopByViews(Pageable pageable);
}
