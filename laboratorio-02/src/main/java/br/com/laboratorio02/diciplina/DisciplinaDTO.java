package br.com.laboratorio02.diciplina;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DisciplinaDTO {

    @Max(value = 10, message = "Nota inválida")
    @PositiveOrZero(message = "Nota não pode ser negativo")
    private Double nota;
    private String comentarios;
}
