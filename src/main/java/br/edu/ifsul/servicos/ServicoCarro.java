/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.servicos;

import br.edu.ifsul.dao.CarroDAO;
import br.edu.ifsul.modelo.Carro;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author rubia
 */
@WebService
public class ServicoCarro implements Serializable{
    @EJB
    private CarroDAO dao;

    public ServicoCarro() {
    }

    @WebMethod
    public List<Carro> listaCarros() {
        return dao.getLista();
    }
    
    @WebMethod
    public Carro inserir(@WebParam(name = "carro")
            @XmlElement(required = true) Carro objeto) {
        try {
            return dao.persist(objeto);
        } catch (Exception e) {
            return null;
        }
    }

    @WebMethod
    public Carro alterar(@WebParam(name = "carro")
            @XmlElement(required = true) Carro objeto) {

        try {
            return dao.merge(objeto);
        } catch (Exception e) {
            return null;
        }
    }

    @WebMethod
    public Boolean remover(@WebParam(name = "id")
            @XmlElement(required = true) Integer id) {
        try {
            dao.remove(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
