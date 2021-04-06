package br.com.laboratorio.diciplina;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Disciplina {

    private int id;
    private String nome;
    private Double nota;

    public static Disciplina from(DisciplinaDTO disciplina) {
        return Disciplina
                .builder()
                .nome(disciplina.getNome())
                .nota(disciplina.getNota())
                .build();
    }
}
