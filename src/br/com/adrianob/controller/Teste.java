package br.com.adrianob.controller;

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
        
        Pessoa p = new Pessoa();
        p.setNomeRazao("Adriano");
         
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        efm.close();
        //http://mvnrepository.com/artifact/org.jboss/jandex/2.0.3.Final
    }

}
