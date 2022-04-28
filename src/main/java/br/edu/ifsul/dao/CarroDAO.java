/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Carro;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rubia
 */
@Stateless
public class CarroDAO  implements Serializable{
    
    @PersistenceContext(unitName = "SW-CRUDCARRO-PU")  //esta na persistence.xml
    private EntityManager em;

    private List<Carro> lista;

    public CarroDAO() {
        
    }
   
    public List<Carro> getLista() {
        return em.createQuery("from Carro order by id").getResultList();
    }

    public void setLista(List<Carro> lista) {
        this.lista = lista;
    }
    
    public Carro persist(Carro objeto) throws Exception {
        objeto.setId(null);
        em.persist(objeto);
        return objeto;
    }

    public Carro merge(Carro objeto) throws Exception {
        em.merge(objeto);
        return objeto;
    }

    public void remove(Object id) throws Exception {
        Carro obj = em.find(Carro.class, id);
        em.remove(obj);
    }

    public Carro findById(Integer id) throws Exception {
        return (Carro) em.find(Carro.class, id);
    }
}
