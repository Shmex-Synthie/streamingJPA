package com.nossotubo.trabalho.service;

import com.nossotubo.trabalho.model.Usuario;
import com.nossotubo.trabalho.repository.VisualizacaoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final VisualizacaoRepository visualizacaoRepository;

    public UsuarioService(VisualizacaoRepository visualizacaoRepository) {
        this.visualizacaoRepository = visualizacaoRepository;
    }

    // Usuário que mais assistiu vídeos
    public Usuario usuarioMaisAtivo() {
        List<Object[]> result = visualizacaoRepository.findUsuariosOrderByViewsDesc(PageRequest.of(0, 1));
        if (!result.isEmpty()) {
            return (Usuario) result.get(0)[0];
        }
        return null;
    }
}
