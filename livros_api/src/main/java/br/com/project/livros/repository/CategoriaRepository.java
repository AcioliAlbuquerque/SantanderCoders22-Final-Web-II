package br.com.project.livros.repository;

import br.com.project.livros.domain.Categoria;
import br.com.project.livros.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findByNameStartingWithIgnoreCase(String name);

}
