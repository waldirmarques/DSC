package br.com.laboratorio03.diciplina;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@RequiredArgsConstructor
@Service
public class MigrateDisciplina {
    private final DisciplinaRepository disciplinaRepository;
    private final ObjectMapper objectMapper;

    @PostConstruct
    public void insertDisciplinas() {
        try {
            Disciplina[] disciplinas = objectMapper.readValue(
                    new File("src/main/resources/static/json_disciplina.json"),
                    Disciplina[].class
            );

            for (Disciplina item: disciplinas) {
                disciplinaRepository.save(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
