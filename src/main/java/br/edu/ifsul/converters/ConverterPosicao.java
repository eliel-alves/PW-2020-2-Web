/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.converters;

import br.edu.ifsul.modelo.Posicao;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author eliel
 */
@Named(value = "converterPosicao")
@RequestScoped
public class ConverterPosicao implements Serializable, Converter<Object> {

    @PersistenceContext(unitName = "PW-2020-2-WebPU")
    protected EntityManager em;
    
    // converte da tela para o objeto
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if(string == null || string.equals("Selecione um registro")) {
            return null;
        }
        return em.find(Posicao.class, Integer.parseInt(string));
    }

    // converte do objeto para a tela
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if(t == null)
            return null;
        
        Posicao obj = (Posicao) t;
        return obj.getId().toString();
    }
    
}
