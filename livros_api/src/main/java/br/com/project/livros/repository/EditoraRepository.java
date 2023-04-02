package br.com.project.livros.repository;

import br.com.project.livros.domain.Editora;
import br.com.project.livros.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {


    List<Editora> findByNameStartingWithIgnoreCase(String name);
}
