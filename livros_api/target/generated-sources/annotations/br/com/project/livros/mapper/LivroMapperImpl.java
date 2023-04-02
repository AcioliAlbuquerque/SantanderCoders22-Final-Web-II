package br.com.project.livros.mapper;

import br.com.project.livros.controller.requests.LivroRequestBody;
import br.com.project.livros.domain.Livro;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-02T03:04:22-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class LivroMapperImpl extends LivroMapper {

    @Override
    public Livro toLivro(LivroRequestBody livroRequestBody) {
        if ( livroRequestBody == null ) {
            return null;
        }

        Livro livro = new Livro();

        return livro;
    }
}
