package br.com.laboratorio03.diciplina;

import br.com.laboratorio03.comentario.service.CreateComentarioDisciplinaService;
import br.com.laboratorio03.diciplina.service.GetAllDisciplinaService;
import br.com.laboratorio03.diciplina.service.GetDisciplinaService;
import br.com.laboratorio03.diciplina.service.GetListOrderNotasDisciplinaService;
import br.com.laboratorio03.diciplina.service.UpdateLikeDisciplinaService;
import br.com.laboratorio03.nota.service.UpdateNotaDisciplinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/disciplinas")
public class DisciplinaController {

    private final GetDisciplinaService getDisciplinaService;
    private final GetAllDisciplinaService getAllDisciplinaService;
    private final UpdateLikeDisciplinaService updateLikeDisciplinaService;
    private final UpdateNotaDisciplinaService updateNotaDisciplinaService;
    private final CreateComentarioDisciplinaService createComentarioDisciplinaService;
    private final GetListOrderNotasDisciplinaService getListOrderNotasDisciplinaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Disciplina> findAllDisciplinas() {
        return getAllDisciplinaService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Disciplina findByIdDisciplina(@PathVariable("id") Long id) {
        return getDisciplinaService.findById(id);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping(value = "likes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Disciplina updateLikeByIdDisciplina(@PathVariable("id") Long id) {
        return updateLikeDisciplinaService.updateLike(id);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping(value = "/comentarios/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Disciplina createComentarioByIdDisciplina(@PathVariable("id") Long id, @Valid @RequestBody DisciplinaDTO disciplinaDTO) {
        return createComentarioDisciplinaService.createComentario(id, disciplinaDTO);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping(value = "nota/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Disciplina updateNotaByIdDisciplina(
            @PathVariable("id") Long id,
            @Valid @RequestBody DisciplinaDTO disciplinaDTO) {
        return updateNotaDisciplinaService.updateNota(id, disciplinaDTO);
    }

    @GetMapping(value = "/ranking/notas", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Disciplina> findAllOrderNotaDisciplina() {
        return getListOrderNotasDisciplinaService.sortNotaDisciplinas();
    }
}
