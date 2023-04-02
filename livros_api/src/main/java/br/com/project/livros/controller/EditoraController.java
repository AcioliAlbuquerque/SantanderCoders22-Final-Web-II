package br.com.project.livros.controller;

import br.com.project.livros.controller.requests.EditoraRequestBody;
import br.com.project.livros.domain.Editora;
import br.com.project.livros.service.EditoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("editoras")
public class EditoraController {

    private final EditoraService editoraService;

    @PostMapping
    public ResponseEntity<Editora> save(@Valid @RequestBody EditoraRequestBody editoraRequestBody) {
        return new ResponseEntity<>(editoraService.save(editoraRequestBody), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Editora>> getAll() {
        return ResponseEntity.ok(editoraService.findAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Editora>> findByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(editoraService.findByName(name));
    }

    @PutMapping
    public ResponseEntity<Editora> updadeById(@Valid @RequestBody EditoraRequestBody editoraRequestBody) {
        return new  ResponseEntity<>(editoraService.replace(editoraRequestBody), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        editoraService.deleteId( id);
        return ResponseEntity.noContent().build();
    }
}
