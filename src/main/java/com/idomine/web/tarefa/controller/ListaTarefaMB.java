package com.idomine.web.tarefa.controller;

import static com.idomine.infrastructure.util.FacesUtil.addInfoMessage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.idomine.domain.tarefa.model.Tarefa;
import com.idomine.domain.tarefa.service.TarefaFacade;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class ListaTarefaMB implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Inject
    private TarefaFacade tarefaService;
    @Getter
    @Setter
    private List<Tarefa> tarefas = new ArrayList<>();
    @Getter
    @Setter
    private List<Tarefa> tarefaSelecionadas = new ArrayList<>();

    @PostConstruct
    public void inicializar()
    {
        tarefas = tarefaService.listAll();
    }

    public void excluirSelecionados()
    {
        for (Tarefa tarefa : tarefaSelecionadas)
        {
            tarefaService.excluir(tarefa);
            tarefas.remove(tarefa);
        }
        addInfoMessage("Tarefa(s) excluída(s) com sucesso!");
    }
}
