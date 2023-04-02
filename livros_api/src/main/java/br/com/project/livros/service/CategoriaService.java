package br.com.project.livros.service;

import br.com.project.livros.controller.requests.CategoriaRequestBody;
import br.com.project.livros.domain.Categoria;
import br.com.project.livros.mapper.CategoriaMapper;
import br.com.project.livros.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public Categoria save(CategoriaRequestBody categoriaRequestBody) {
        return categoriaRepository.save(CategoriaMapper.INSTANCE.toCategoria(categoriaRequestBody));
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Transactional
    public List<Categoria> findByName(String name) {
        if (name.isBlank()) {
            return Collections.emptyList();
        }
        return categoriaRepository.findByNameStartingWithIgnoreCase(name);
    }

    public Categoria replace(CategoriaRequestBody categoriaRequestBody) {
        Categoria categoria = CategoriaMapper.INSTANCE.toCategoria(categoriaRequestBody);
        return categoriaRepository.save(categoria);
    }

    public void deleteId(Long id) {
        categoriaRepository.findById(id);
    }
}
