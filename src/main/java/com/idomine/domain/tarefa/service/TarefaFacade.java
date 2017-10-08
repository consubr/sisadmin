package com.idomine.domain.tarefa.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.idomine.domain.tarefa.model.Tarefa;
import com.idomine.infrastructure.util.Transacional;

public class TarefaFacade implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TarefaService tarefaDAO;	
	
	
	@Transacional
	public void salvar(Tarefa tarefa) {
		if (tarefa.isIncluindo()) {
			tarefa.setCriacao(new Date());
		}
		
		if (tarefa.isEditando()) {
			tarefa.setEdicao(new Date());
		}
		
		tarefaDAO.salvar(tarefa);
	}
	
	@Transacional
	public void excluir(Tarefa tarefa) {
		tarefaDAO.excluir(tarefa);
	}
	
	
	public List<Tarefa> listAll() {
		return tarefaDAO.listAll();
	}
	
	public Tarefa porId(Long id) {
		return tarefaDAO.porId(id);
	}

}
