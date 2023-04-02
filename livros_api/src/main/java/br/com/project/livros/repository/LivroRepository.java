package br.com.project.livros.repository;

import br.com.project.livros.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByNameStartingWithIgnoreCase(String name);

}
