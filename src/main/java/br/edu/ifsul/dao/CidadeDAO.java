/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.converters.ConverterOrdem;
import br.edu.ifsul.modelo.Cidade;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author eliel
 */
@Stateful
public class CidadeDAO<TIPO> extends DAOGenerico<Cidade> implements Serializable{
    
    public CidadeDAO(){
        super();
        classePersistente = Cidade.class;
        
        // definir as ordens possíveis
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("nome", "Nome", "like"));
        listaOrdem.add(new Ordem("estado.nome", "Estado", "like"));
        // definir a ordem inicial
        ordemAtual = listaOrdem.get(1);
        
        //inicializa o conversor das ordens
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }
    
}
