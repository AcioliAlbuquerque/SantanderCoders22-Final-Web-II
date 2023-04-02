package br.com.project.livros.mapper;

import br.com.project.livros.controller.requests.CategoriaRequestBody;
import br.com.project.livros.domain.Categoria;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-02T03:04:22-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class CategoriaMapperImpl extends CategoriaMapper {

    @Override
    public Categoria toCategoria(CategoriaRequestBody categoriaRequestBody) {
        if ( categoriaRequestBody == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        return categoria;
    }
}
