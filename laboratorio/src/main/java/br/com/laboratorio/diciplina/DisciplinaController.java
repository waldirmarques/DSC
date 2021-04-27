package br.com.laboratorio.diciplina;

import br.com.laboratorio.diciplina.service.DisciplinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/api/disciplinas")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void saveDisciplina(@RequestBody DisciplinaDTO disciplina) {
        disciplinaService.save(Disciplina.from(disciplina));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Disciplina> findAllDisciplina() {
        return disciplinaService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Disciplina findByIdDisciplina(@PathVariable("id") int id) {
        return disciplinaService.findById(id);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping(value = "/{id}/nome", produces = MediaType.APPLICATION_JSON_VALUE)
    public Disciplina updateNameByIdDisciplina(
            @PathVariable("id") int id,
            @Valid @RequestBody DisciplinaDTO disciplinaDTO) {
        return disciplinaService.updateName(id, disciplinaDTO);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping(value = "/{id}/nota", produces = MediaType.APPLICATION_JSON_VALUE)
    public Disciplina updateNotaByIdDisciplina(
            @PathVariable("id") int id,
            @Valid @RequestBody DisciplinaDTO disciplinaDTO) {
        return disciplinaService.updateNota(id, disciplinaDTO);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeByIdDisciplina(@PathVariable("id") int id) {
        disciplinaService.remove(id);
    }

    @GetMapping(value = "/ranking", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Disciplina> findAllOrderNotaDisciplina() {
        return disciplinaService.sortNotaDisciplinas();
    }
}
