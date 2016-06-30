package br.com.caelum.tarefas.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefasController {
	@RequestMapping("novaTarefa")
	public String form() {

		return "tarefa/formulario";
	}

	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		if (result.hasErrors()) {
			return form();
		}

		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.adiciona(tarefa);

		return "tarefa/adicionada";
	}

	@RequestMapping("listaTarefas")
	public ModelAndView lista() {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		ModelAndView mv = new ModelAndView("tarefa/lista");
		return mv.addObject("tarefas", dao.lista());

	}

	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.remove(tarefa);

		return "redirect:listaTarefas";
	}

	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.altera(tarefa);

		return "redirect:listaTarefas";

	}

	@RequestMapping("mostraTarefa")
	public ModelAndView mostra(Long id) {
		ModelAndView mv = new ModelAndView("tarefa/mostra");
		JdbcTarefaDao dao = new JdbcTarefaDao();
		mv.addObject(dao.buscaPorId(id));
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("finalizaTarefa")
	public void finaliza (Long id){
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.finaliza(id);
	}

}
