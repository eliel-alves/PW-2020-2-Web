/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edul.ifsul.controle;

import br.edu.ifsul.dao.PosicaoDAO;
import br.edu.ifsul.modelo.Posicao;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author eliel
 */
@Named(value = "controlePosicao")
@ViewScoped
public class ControlePosicao implements Serializable {
    
    @EJB
    private PosicaoDAO<Posicao> dao;
    private Posicao objeto;
    
    public ControlePosicao(){
        
    }
    
    public String listar(){
        return "/privado/posicao/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Posicao();
    }
    
    public void alterar(Object id){
        try {
            objeto = dao.getObjectByID(id);
        } catch (Exception e) {
            Util.mensagemInformacao("Erro ao recuperar o objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void excluir(Object id){
        try {
            objeto = dao.getObjectByID(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e) {
            Util.mensagemInformacao("Erro ao remover o objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void salvar(){
        try {
            if(objeto.getId() == null){
                dao.persist(objeto);
            }else{
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e) {
            Util.mensagemInformacao("Erro ao salvar o objeto: " + Util.getMensagemErro(e));
        }
    }

    public PosicaoDAO<Posicao> getDao() {
        return dao;
    }

    public void setDao(PosicaoDAO<Posicao> dao) {
        this.dao = dao;
    }

    public Posicao getObjeto() {
        return objeto;
    }

    public void setObjeto(Posicao objeto) {
        this.objeto = objeto;
    }
}
