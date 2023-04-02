package br.com.project.livros.controller;

import br.com.project.livros.controller.requests.CategoriaRequestBody;
import br.com.project.livros.domain.Categoria;
import br.com.project.livros.service.CategoriaService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> save(@Valid @RequestBody CategoriaRequestBody categoriaRequestBody) {
        return new ResponseEntity<>(categoriaService.save(categoriaRequestBody), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> getAll() {
        return ResponseEntity.ok(categoriaService.findAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Categoria>> findByName(@RequestBody String name) {
        return ResponseEntity.ok(categoriaService.findByName(name));
    }

    @PutMapping
    public ResponseEntity<Categoria> updadeById(@Valid @RequestBody CategoriaRequestBody categoriaRequestBody) {
        return new  ResponseEntity<>(categoriaService.replace(categoriaRequestBody), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoriaService.deleteId( id);
        return ResponseEntity.noContent().build();
    }
}
