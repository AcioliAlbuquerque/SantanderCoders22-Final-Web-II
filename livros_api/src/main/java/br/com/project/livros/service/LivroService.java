package br.com.project.livros.service;

import br.com.project.livros.controller.requests.LivroRequestBody;
import br.com.project.livros.domain.Categoria;
import br.com.project.livros.domain.Editora;
import br.com.project.livros.domain.Livro;
import br.com.project.livros.exception.NotFoundException;
import br.com.project.livros.mapper.LivroMapper;
import br.com.project.livros.repository.CategoriaRepository;
import br.com.project.livros.repository.EditoraRepository;
import br.com.project.livros.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    private final EditoraRepository editoraRepository;

    private final CategoriaRepository categoriaRepository;

    public Livro save(LivroRequestBody livroRequestBody) {
        Livro livro = LivroMapper.INSTANCE.toLivro(livroRequestBody);
        return livroRepository.save(livro);
    }

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public List<Livro> findByName(String name) {
        if (name.isBlank()) {
            return Collections.emptyList();
        }
        return livroRepository.findByNameStartingWithIgnoreCase(name);
    }

    public List<Editora> findByEditora(String name) {
        if (name.isBlank()) {
            return Collections.emptyList();
        }
        return editoraRepository.findByNameStartingWithIgnoreCase(name);
    }

    public List<Categoria> findByCategoria(String name) {
        if (name.isBlank()) {
            return Collections.emptyList();
        }
        return categoriaRepository.findByNameStartingWithIgnoreCase(name);
    }

    public Livro findById(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id " + id + " not found"));
    }

    public Livro replace(LivroRequestBody livroRequestBody) {
        Livro byId = findById(livroRequestBody.getId());

        Livro livro = LivroMapper.INSTANCE.toLivro(livroRequestBody);

        livro.setId(byId.getId());

        return livroRepository.save(livro);
    }

    public void deleteId(Long id) {
        livroRepository.deleteById(findById(id).getId());
    }
}
