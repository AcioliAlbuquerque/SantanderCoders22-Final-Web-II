package br.com.project.livros.service;

import br.com.project.livros.controller.requests.EditoraRequestBody;
import br.com.project.livros.domain.Editora;
import br.com.project.livros.mapper.EditoraMapper;
import br.com.project.livros.repository.EditoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EditoraService {

    private final EditoraRepository editoraRepository;

    public Editora save(EditoraRequestBody editoraRequestBody) {
        return editoraRepository.save(EditoraMapper.INSTANCE.toEditora(editoraRequestBody));
    }

    public List<Editora> findAll() {
        return editoraRepository.findAll();
    }


    public List<Editora> findByName(String name) {
        if (name.isBlank()) {
            return Collections.emptyList();
        }
        return editoraRepository.findByNameStartingWithIgnoreCase(name);
    }

    public Editora replace(EditoraRequestBody editoraRequestBody) {
        Editora editora = EditoraMapper.INSTANCE.toEditora(editoraRequestBody);
        return editoraRepository.save(editora);
    }

    public void deleteId(Long id) {
        editoraRepository.findById(id);
    }
}
