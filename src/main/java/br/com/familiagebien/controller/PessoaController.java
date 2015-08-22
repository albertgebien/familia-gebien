package br.com.familiagebien.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FlowEvent;

import br.com.familiagebien.entidades.Pessoa;
import br.com.familiagebien.entidades.RelacionamentoPessoa;
import br.com.familiagebien.entidades.RelacionamentoPessoaPK;
import br.com.familiagebien.entidades.TipoRelacionamentoPessoa;
import br.com.familiagebien.exceptions.BaseException;
import br.com.familiagebien.servico.impl.PessoaServicoEJB;
import br.com.familiagebien.servico.impl.RelacionamentoPessoaServicoEJB;
import br.com.familiagebien.servico.impl.TipoRelacionamentoPessoaServicoEJB;

@Named
@ViewScoped
public class PessoaController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Pessoa pessoa;
	private Boolean bolFalecida;
	private List<SelectItem> listaTipoRelacionamento;
	private Integer idTipoRelacionamentoSelecionado;
	
	private String nomePesquisa;
	private List<Pessoa> listaPessoasPesquisa;
	private Pessoa pessoaSelecionada;
	private Date dataCasamento;
	private List<RelacionamentoPessoa> relacionamentos;
	
	@Inject
	private PessoaServicoEJB pessoaService;
	
	@Inject
	private TipoRelacionamentoPessoaServicoEJB tipoRelacionamentoPessoaService;
	
	@Inject
	private RelacionamentoPessoaServicoEJB relacionamentoPessoaService;
	
	public void inicializar(Integer idPessoa) throws BaseException{
		if (idPessoa == null || idPessoa == 0) {
			this.pessoa = new Pessoa();
        } else {
            this.pessoa = pessoaService.obter(idPessoa);
        }
	}
	
	public void pesquisarPessoa() throws BaseException{
		this.setListaPessoasPesquisa(pessoaService.listar());
	}
	
	
	 public String processar(FlowEvent event) throws BaseException {
		 if(event.getOldStep().equals("cadPessoa")){
			 if(pessoa != null && pessoa.getId() != null){
				 pessoaService.alterar(pessoa);
			 } else {
				 pessoaService.incluir(pessoa);
			 }
		 } else  if(event.getOldStep().equals("cadRel")){
			 
		 }
		 return event.getNewStep();
	    }

	 public void inserirRelacionamento() throws BaseException{
		 TipoRelacionamentoPessoa tipoRelacionamento = tipoRelacionamentoPessoaService.obter(idTipoRelacionamentoSelecionado);
		 
		 RelacionamentoPessoa r1 = new RelacionamentoPessoa();
		 RelacionamentoPessoaPK id1 = new RelacionamentoPessoaPK();
		 id1.setIdPessoa(pessoa.getId());
		 id1.setIdPessoaRelacionada(getPessoaSelecionada().getId());
		 r1.setId(id1);
		 r1.setTipoRelacionamentoPessoa(tipoRelacionamento);
		 if(tipoRelacionamento.getId().equals(1)){
//			 r1.setDataRelacionamento(getDataCasamento());
		 }
		 
		 relacionamentoPessoaService.incluir(r1);
		 
		 if(tipoRelacionamento.getTipoRelacionamentoPessoaEspecial() != null){
			 RelacionamentoPessoa r2 = new RelacionamentoPessoa();
			 RelacionamentoPessoaPK id2 = new RelacionamentoPessoaPK();
			 id2.setIdPessoa(getPessoaSelecionada().getId());
			 id2.setIdPessoaRelacionada(pessoa.getId());
			 r2.setId(id2);
			 r2.setTipoRelacionamentoPessoa(tipoRelacionamento.getTipoRelacionamentoPessoaEspecial());
			 if(tipoRelacionamento.getId().equals(1)){
//				 r2.setDataRelacionamento(getDataCasamento());
			 }
			 
			 relacionamentoPessoaService.incluir(r2);
		 } else {
			 RelacionamentoPessoa r2 = new RelacionamentoPessoa();
			 RelacionamentoPessoaPK id2 = new RelacionamentoPessoaPK();
			 id2.setIdPessoa(getPessoaSelecionada().getId());
			 id2.setIdPessoaRelacionada(pessoa.getId());
			 r2.setId(id2);
			 r2.setTipoRelacionamentoPessoa(tipoRelacionamento);
			 if(tipoRelacionamento.getId().equals(1)){
//				 r2.setDataRelacionamento(getDataCasamento());
			 }
			 
			 relacionamentoPessoaService.incluir(r2);
		 }
	 }
	 
	 public void excluirRelacionamento(Integer idPessoa,Integer idPessoaRelacionada) throws BaseException{
		 RelacionamentoPessoaPK id = new RelacionamentoPessoaPK();
		 id.setIdPessoa(idPessoa);
		 id.setIdPessoaRelacionada(idPessoaRelacionada);
		 RelacionamentoPessoa relacionamentoPessoa = relacionamentoPessoaService.obter(id);
		 if(relacionamentoPessoa != null){
			 relacionamentoPessoaService.excluir(relacionamentoPessoa.getId());
		 }

		 id = new RelacionamentoPessoaPK();
		 id.setIdPessoa(idPessoaRelacionada);
		 id.setIdPessoaRelacionada(idPessoa);
		 relacionamentoPessoa = relacionamentoPessoaService.obter(id);
		 relacionamentoPessoaService.excluir(relacionamentoPessoa.getId());
		 if(relacionamentoPessoa != null){
			 relacionamentoPessoaService.excluir(relacionamentoPessoa.getId());
		 }
		 
		 this.relacionamentos = null;
		 
	 }
	 
	public void salvar() throws BaseException{
		pessoaService.incluir(pessoa);
		pessoa = new Pessoa();
	}
	
	public void limpar(){
		pessoa = new Pessoa();
	}
	
	public void onChangePessoaFalecida(){
		System.out.println(bolFalecida);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Boolean getBolFalecida() {
		return bolFalecida;
	}

	public void setBolFalecida(Boolean bolFalecida) {
		this.bolFalecida = bolFalecida;
	}

	public List<SelectItem> getListaTipoRelacionamento() throws BaseException {
		if(listaTipoRelacionamento == null){
			List<TipoRelacionamentoPessoa> tiposRelacionamentos = tipoRelacionamentoPessoaService.listar();
			listaTipoRelacionamento = new ArrayList<SelectItem>();
			for (TipoRelacionamentoPessoa tipoRelacionamentoPessoa : tiposRelacionamentos) {
				listaTipoRelacionamento.add(new SelectItem(tipoRelacionamentoPessoa.getId(), tipoRelacionamentoPessoa.getNomeTipoRelacionamento()));
			}
		}
		return listaTipoRelacionamento;
	}


	public void setListaTipoRelacionamento(List<SelectItem> listaTipoRelacionamento) {
		this.listaTipoRelacionamento = listaTipoRelacionamento;
	}


	public Integer getIdTipoRelacionamentoSelecionado() {
		return idTipoRelacionamentoSelecionado;
	}


	public void setIdTipoRelacionamentoSelecionado(
			Integer idTipoRelacionamentoSelecionado) {
		this.idTipoRelacionamentoSelecionado = idTipoRelacionamentoSelecionado;
	}

	public String getNomePesquisa() {
		return nomePesquisa;
	}

	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}

	public List<Pessoa> getListaPessoasPesquisa() {
		return listaPessoasPesquisa;
	}

	public void setListaPessoasPesquisa(List<Pessoa> listaPessoasPesquisa) {
		this.listaPessoasPesquisa = listaPessoasPesquisa;
	}

	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}

	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}

	public Date getDataCasamento() {
		return dataCasamento;
	}

	public void setDataCasamento(Date dataCasamento) {
		this.dataCasamento = dataCasamento;
	}

	public List<RelacionamentoPessoa> getRelacionamentos() {
		if(relacionamentos == null){
			relacionamentos = relacionamentoPessoaService.obterRelacionamentosPorIdPessoa(pessoa.getId());
		}
		return relacionamentos;
	}

	public void setRelacionamentos(List<RelacionamentoPessoa> relacionamentos) {
		this.relacionamentos = relacionamentos;
	}
}
