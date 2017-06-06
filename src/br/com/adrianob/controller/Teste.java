package br.com.adrianob.controller;

import br.com.adrianob.model.Conta;
import br.com.adrianob.model.Pessoa;
import br.com.adrianob.view.MenuView;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;

/**
 *
 * @author Administrador
 */
public class Teste {
    
    public static void main(String args[]) {
        MenuView mv = new MenuView();
        mv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mv.setLocationRelativeTo(null);
        mv.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mv.setVisible(true);
    }
    
}
