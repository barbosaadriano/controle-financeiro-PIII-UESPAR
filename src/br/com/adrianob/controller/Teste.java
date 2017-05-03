package br.com.adrianob.controller;

import br.com.adrianob.model.Conta;
import br.com.adrianob.model.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class Teste {

    public static void main(String args[]) {
        EntityManagerFactory efm =
                Persistence.createEntityManagerFactory("ControleFinanceiroPU");
        EntityManager em = efm.createEntityManager();
        
        Conta c1 = new Conta();
        c1.setTipo("Saida");
        c1.setTitulo("Transporte");
        c1.setSituacao("Ativo");
        
        Conta c2 = new Conta();
        c2.setTipo("Saida");
        c2.setTitulo("Combustível");
        c2.setSituacao("Ativo");
        
        Conta c3 = new Conta();
        c3.setTipo("Saida");
        c3.setSituacao("Ativo");
        c3.setTitulo("Combustível Moto");
        
        Conta c4 = new Conta();
        c4.setTipo("Saida");
        c4.setSituacao("Ativo");
        c4.setTitulo("Combustível Carro");
        
        c2.getContasFilhas().add(c4);
        c2.getContasFilhas().add(c3);
        c1.getContasFilhas().add(c2);
        c2.setContaPai(c1);
        c3.setContaPai(c2);
        c4.setContaPai(c2);
        
        em.getTransaction().begin();
        em.persist(c1);
        em.persist(c2);
        em.getTransaction().commit();
        em.close();
        efm.close();
        
    }

}
