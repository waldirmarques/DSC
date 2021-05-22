package br.com.laboratorio03.nota;

import br.com.laboratorio03.nota.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Long> {}
