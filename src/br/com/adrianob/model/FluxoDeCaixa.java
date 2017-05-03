package br.com.adrianob.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 *
 * @author Administrador
 */
@Entity(name = "fluxocaixa")
public class FluxoDeCaixa {

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
    @Column(length = 6)
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
    @Column(name = "data_movimento")
    private Date dataDeMovimento;

    public static final String PROP_DATADEMOVIMENTO = "dataDeMovimento";

    public Date getDataDeMovimento() {
        return dataDeMovimento;
    }

    public void setDataDeMovimento(Date dataDeMovimento) {
        Date oldDataDeMovimento = this.dataDeMovimento;
        this.dataDeMovimento = dataDeMovimento;
        propertyChangeSupport.firePropertyChange(PROP_DATADEMOVIMENTO, oldDataDeMovimento, dataDeMovimento);
    }
    @Column(name = "in_estorno")
    private boolean inEstorno;

    public static final String PROP_INESTORNO = "inEstorno";

    public boolean isInEstorno() {
        return inEstorno;
    }

    public void setInEstorno(boolean inEstorno) {
        boolean oldInEstorno = this.inEstorno;
        this.inEstorno = inEstorno;
        propertyChangeSupport.firePropertyChange(PROP_INESTORNO, oldInEstorno, inEstorno);
    }
    @Column
    private String descricao;

    public static final String PROP_DESCRICAO = "descricao";

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        propertyChangeSupport.firePropertyChange(PROP_DESCRICAO, oldDescricao, descricao);
    }
    @Column
    private float valor;

    public static final String PROP_VALOR = "valor";

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        float oldValor = this.valor;
        this.valor = valor;
        propertyChangeSupport.firePropertyChange(PROP_VALOR, oldValor, valor);
    }
    @Column(name = "nr_documento")
    private int numeroDocumento;

    public static final String PROP_NUMERODOCUMENTO = "numeroDocumento";

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        int oldNumeroDocumento = this.numeroDocumento;
        this.numeroDocumento = numeroDocumento;
        propertyChangeSupport.firePropertyChange(PROP_NUMERODOCUMENTO, oldNumeroDocumento, numeroDocumento);
    }
    @ManyToOne(targetEntity = ContaCorrente.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false)
    @JoinColumn(name = "contacorrente_id")
    private ContaCorrente contaCorrente;

    public static final String PROP_CONTACORRENTE = "contaCorrente";

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(ContaCorrente contaCorrente) {
        ContaCorrente oldContaCorrente = this.contaCorrente;
        this.contaCorrente = contaCorrente;
        propertyChangeSupport.firePropertyChange(PROP_CONTACORRENTE, oldContaCorrente, contaCorrente);
    }
    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false,
            targetEntity = Conta.class)
    @JoinColumn(name = "conta_id")
    private Conta conta;

    public static final String PROP_CONTA = "conta";

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        Conta oldConta = this.conta;
        this.conta = conta;
        propertyChangeSupport.firePropertyChange(PROP_CONTA, oldConta, conta);
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
