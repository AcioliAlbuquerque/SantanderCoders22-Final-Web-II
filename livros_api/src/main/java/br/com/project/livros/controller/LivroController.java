package br.com.project.livros.controller;

import br.com.project.livros.controller.requests.LivroRequestBody;
import br.com.project.livros.domain.Categoria;
import br.com.project.livros.domain.Editora;
import br.com.project.livros.domain.Livro;
import br.com.project.livros.service.LivroService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("livros")
public class LivroController {

    private final LivroService livroService;

    @PostMapping
    public ResponseEntity<Livro> save(@Valid @RequestBody LivroRequestBody livroRequestBody) {
        return new ResponseEntity<>(livroService.save(livroRequestBody), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> getAll() {
        return ResponseEntity.ok(livroService.findAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Livro>> findByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(livroService.findByName(name));
    }

    @GetMapping("/editora")
    public ResponseEntity<List<Editora>> buscarPorEditora(@RequestParam("editora") String nomeEditora) {
        List<Editora> editora = livroService.findByEditora(nomeEditora);
        return ResponseEntity.ok(editora);
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<Categoria>> buscarPorCategoria(@RequestParam("categoria") String nomeCategoria) {
        List<Categoria> categoria = livroService.findByCategoria(nomeCategoria);
        return ResponseEntity.ok(categoria);
    }

    @PutMapping
    public ResponseEntity<Livro> replace(@Valid @RequestBody LivroRequestBody livroRequestBody) {
        return new  ResponseEntity<>(livroService.replace(livroRequestBody), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        livroService.deleteId( id);
        return ResponseEntity.noContent().build();
    }
}
