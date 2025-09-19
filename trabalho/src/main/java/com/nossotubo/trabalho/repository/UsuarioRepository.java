package com.nossotubo.trabalho.repository;

import com.nossotubo.trabalho.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
