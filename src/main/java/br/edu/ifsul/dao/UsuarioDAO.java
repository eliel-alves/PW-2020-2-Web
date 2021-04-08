/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.converters.ConverterOrdem;
import br.edu.ifsul.modelo.Usuario;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author eliel
 */
@Stateful
public class UsuarioDAO<TIPO> extends DAOGenerico<Usuario> implements Serializable{
    
    public UsuarioDAO(){
        super();
        classePersistente = Usuario.class;
        
        // definir as ordens possíveis
        listaOrdem.add(new Ordem("nomeUsuario", "Nome de Usuário", "like"));
        listaOrdem.add(new Ordem("nome", "Nome", "like"));
        listaOrdem.add(new Ordem("email", "E-mail", "like"));
        
        // definir a ordem inicial
        ordemAtual = listaOrdem.get(1);
        
        //inicializa o conversor das ordens
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }
    
}
