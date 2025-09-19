package com.nossotubo.trabalho.service;

import com.nossotubo.trabalho.model.Video;
import com.nossotubo.trabalho.repository.VideoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    // Buscar vídeos pelo título
    public List<Video> buscarPorTitulo(String titulo) {
        return videoRepository.findByTituloContainingIgnoreCaseOrderByTituloAsc(titulo);
    }

    // Buscar vídeos por categoria
    public List<Video> buscarPorCategoria(String categoria) {
        return videoRepository.findAllByCategoriaNomeOrderByTituloAsc(categoria);
    }

    // Top 10 vídeos mais bem avaliados
    public List<Video> top10Avaliados() {
        return videoRepository.findTopByAverageRating(PageRequest.of(0, 10));
    }

    // Top 10 vídeos mais assistidos
    public List<Video> top10MaisAssistidos() {
        return videoRepository.findTopByViews(PageRequest.of(0, 10));
    }
}
