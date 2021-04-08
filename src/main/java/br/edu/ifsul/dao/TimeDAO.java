/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.converters.ConverterOrdem;
import br.edu.ifsul.modelo.Time;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author eliel
 */
@Stateful
public class TimeDAO<TIPO> extends DAOGenerico<Time> implements Serializable{
    
    public TimeDAO(){
        super();
        classePersistente = Time.class;
        
        // definir as ordens possíveis
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("nome", "Nome", "like"));
        listaOrdem.add(new Ordem("cidade.nome", "Cidade", "like"));
        
        // definir a ordem inicial
        ordemAtual = listaOrdem.get(1);
        
        //inicializa o conversor das ordens
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }
    
    public Time getObjectByID(Object id) throws Exception {
        Time obj = em.find(Time.class, id);
        
        // uso para evitar o erro de lazy inicialization exception
        obj.getJogadores().size();
        return obj;
    }
    
}
