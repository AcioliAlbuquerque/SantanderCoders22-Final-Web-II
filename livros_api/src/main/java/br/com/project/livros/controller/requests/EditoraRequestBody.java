package br.com.project.livros.controller.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EditoraRequestBody {

    private Long id;

    @NotEmpty(message = "Preencha o campo corretamente.")
    @Size(min = 1, max = 255, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String name;
}
