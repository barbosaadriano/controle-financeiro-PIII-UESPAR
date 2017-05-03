package br.com.adrianob.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author Administrador
 */
@Entity(name = "conta")
public class Conta {

    public Conta() {
        contasFilhas = new ArrayList<Conta>();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public static final String PROP_ID = "id";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        propertyChangeSupport.firePropertyChange(PROP_ID, oldId, id);
    }

    @Column
    private String titulo;

    public static final String PROP_TITULO = "titulo";

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        String oldTitulo = this.titulo;
        this.titulo = titulo;
        propertyChangeSupport.firePropertyChange(PROP_TITULO, oldTitulo, titulo);
    }
    @Column
    private String tipo;

    public static final String PROP_TIPO = "tipo";

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        String oldTipo = this.tipo;
        this.tipo = tipo;
        propertyChangeSupport.firePropertyChange(PROP_TIPO, oldTipo, tipo);
    }
    @Column
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
    @ManyToOne
    @JoinColumn(name = "conta_pai")
    private Conta contaPai;

    public static final String PROP_CONTAPAI = "contaPai";

    public Conta getContaPai() {
        return contaPai;
    }
    @OneToMany(targetEntity = Conta.class ,mappedBy = "conta",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)    
    @Transient
    private List<Conta> contasFilhas;
    public static final String PROP_CONTASFILHAS = "contasFilhas";
    public List<Conta> getContasFilhas() {
        return contasFilhas;
    }

    public void setContasFilhas(List<Conta> contasFilhas) {
        List<Conta> oldContasFilhas = this.contasFilhas;
        this.contasFilhas = contasFilhas;
        propertyChangeSupport.firePropertyChange(PROP_CONTASFILHAS, oldContasFilhas, contasFilhas);
    }


    public void setContaPai(Conta contaPai) {
        Conta oldContaPai = this.contaPai;
        this.contaPai = contaPai;
        propertyChangeSupport.firePropertyChange(PROP_CONTAPAI, oldContaPai, contaPai);
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
