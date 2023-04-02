package br.com.project.livros.mapper;

import br.com.project.livros.controller.requests.EditoraRequestBody;
import br.com.project.livros.domain.Editora;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class EditoraMapper {
    public static final EditoraMapper INSTANCE = Mappers.getMapper(EditoraMapper.class);

//    @Mapping(target = "name", source = "editoraRequestBody.name")
    public abstract Editora toEditora(EditoraRequestBody editoraRequestBody);

}
