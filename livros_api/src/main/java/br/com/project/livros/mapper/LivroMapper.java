package br.com.project.livros.mapper;

import br.com.project.livros.controller.requests.LivroRequestBody;
import br.com.project.livros.domain.Livro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class LivroMapper {
    public static final LivroMapper INSTANCE = Mappers.getMapper(LivroMapper.class);

//    @Mapping(target = "name", source = "livroRequestBody.name")
    public abstract Livro toLivro(LivroRequestBody livroRequestBody);

}
