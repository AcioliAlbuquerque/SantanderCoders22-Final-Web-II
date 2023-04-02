package br.com.project.livros.mapper;

import br.com.project.livros.controller.requests.EditoraRequestBody;
import br.com.project.livros.domain.Editora;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-02T03:04:22-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class EditoraMapperImpl extends EditoraMapper {

    @Override
    public Editora toEditora(EditoraRequestBody editoraRequestBody) {
        if ( editoraRequestBody == null ) {
            return null;
        }

        Editora editora = new Editora();

        return editora;
    }
}
