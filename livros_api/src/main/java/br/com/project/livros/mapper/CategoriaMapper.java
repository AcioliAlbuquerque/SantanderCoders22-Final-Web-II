package br.com.project.livros.mapper;

import br.com.project.livros.controller.requests.CategoriaRequestBody;
import br.com.project.livros.domain.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class CategoriaMapper {
    public static final CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

//    @Mapping(target = "name", source = "categoriaRequestBody.name")
    public abstract Categoria toCategoria(CategoriaRequestBody categoriaRequestBody);

}
