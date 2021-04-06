package br.com.laboratorio.diciplina.service;

import br.com.laboratorio.diciplina.Disciplina;
import br.com.laboratorio.diciplina.DisciplinaDTO;
import br.com.laboratorio.diciplina.exception.DisciplinaFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DisciplinaServiceImpl implements DisciplinaService {
    private List<Disciplina> disciplinas = new ArrayList<>();
    private int geradorId = 1;

    @Override
    public void save(Disciplina disciplina) {
        disciplina.setId(geradorId);
        disciplinas.add(disciplina);
        this.geradorId++;
    }

    @Override
    public List<Disciplina> findAll() {
        return disciplinas;
    }

    @Override
    public Disciplina findById(int id) {
        return disciplinas
                .stream()
                .filter(disciplina -> disciplina.getId() == id)
                .findFirst()
                .orElseThrow(DisciplinaFoundException::new);
    }

    @Override
    public Disciplina updateName(int id, DisciplinaDTO disciplinaDTO) {
        Disciplina disciplina = this.findById(id);
        int index = disciplinas.indexOf(disciplina);
        disciplina.setNome(disciplinaDTO.getNome());
        return disciplinas.set(index, disciplina);
    }

    @Override
    public Disciplina updateNota(int id, DisciplinaDTO disciplinaDTO) {
        Disciplina disciplina = this.findById(id);
        int index = disciplinas.indexOf(disciplina);
        disciplina.setNota(disciplinaDTO.getNota());
        return disciplinas.set(index, disciplina);
    }

    @Override
    public void remove(int id) {
        this.disciplinas.remove(this.findById(id));
    }

    @Override
    public List<Disciplina> sortNotaDisciplinas() {
        this.findAll().sort(Comparator.comparingDouble(Disciplina::getNota));
        return this.findAll();
    }
}
