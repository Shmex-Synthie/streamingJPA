package com.nossotubo.trabalho.repository;

import com.nossotubo.trabalho.model.Visualizacao;
import com.nossotubo.trabalho.model.Usuario;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VisualizacaoRepository extends JpaRepository<Visualizacao, Long> {
    // Recupera os usuários ordenados por total de visualizações (desc)
    @Query("SELECT vis.perfil.usuario AS usuario, COUNT(vis) AS cnt " +
            "FROM Visualizacao vis " +
            "GROUP BY vis.perfil.usuario " +
            "ORDER BY COUNT(vis) DESC")
    List<Object[]> findUsuariosOrderByViewsDesc(Pageable pageable);
}
