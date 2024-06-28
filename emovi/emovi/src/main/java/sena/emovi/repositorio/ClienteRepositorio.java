package sena.emovi.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.emovi.modelo.cliente;

public interface ClienteRepositorio extends JpaRepository<cliente, Integer> {
}
