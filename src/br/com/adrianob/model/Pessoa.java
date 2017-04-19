package br.com.adrianob.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author Administrador
 */
@Entity(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id")
    private Integer id;

    public static final String PROP_ID = "id";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        propertyChangeSupport.firePropertyChange(PROP_ID, oldId, id);
    }
    @Column(name = "nome_razao")
    private String nomeRazao;

    public static final String PROP_NOMERAZAO = "nomeRazao";

    public String getNomeRazao() {
        return nomeRazao;
    }

    public void setNomeRazao(String nomeRazao) {
        String oldNomeRazao = this.nomeRazao;
        this.nomeRazao = nomeRazao;
        propertyChangeSupport.firePropertyChange(PROP_NOMERAZAO, oldNomeRazao, nomeRazao);
    }
    @Column(name = "cpf_cnpj")
    private String cpfCnpj;

    public static final String PROP_CPFCNPJ = "cpfCnpj";

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        String oldCpfCnpj = this.cpfCnpj;
        this.cpfCnpj = cpfCnpj;
        propertyChangeSupport.firePropertyChange(PROP_CPFCNPJ, oldCpfCnpj, cpfCnpj);
    }
    @Column(name = "situacao")
    private String situacao;

    public static final String PROP_SITUACAO = "situacao";

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        String oldSituacao = this.situacao;
        this.situacao = situacao;
        propertyChangeSupport.firePropertyChange(PROP_SITUACAO, oldSituacao, situacao);
    }
    @Transient
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
