package com.tarefas.gerenciador.controller;

import com.tarefas.gerenciador.model.Tarefa;
import com.tarefas.gerenciador.repository.TarefaRepository;
import config.AmbienteConfiguracao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;
    @Autowired
    private AmbienteConfiguracao ambienteConfiguracao;

    @PostConstruct
    public void init() {
        // Adicionando tarefas iniciais
        Tarefa tarefa1 = new Tarefa();
        tarefa1.setDescricao("Comprar leite");
        tarefa1.setConcluida(false);
        tarefaRepository.save(tarefa1);

        Tarefa tarefa2 = new Tarefa();
        tarefa2.setDescricao("Estudar para a prova");
        tarefa2.setConcluida(true);
        tarefaRepository.save(tarefa2);

        Tarefa tarefa3 = new Tarefa();
        tarefa3.setDescricao("Ligar para o médico");
        tarefa3.setConcluida(false);
        tarefaRepository.save(tarefa3);
    }

    @GetMapping
    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada) {
        Tarefa tarefa = tarefaRepository.findById(id).orElse(null);
        if (tarefa != null) {
            tarefa.setDescricao(tarefaAtualizada.getDescricao());
            tarefa.setConcluida(tarefaAtualizada.isConcluida());
            return tarefaRepository.save(tarefa);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id) {
        tarefaRepository.deleteById(id);
    }
}