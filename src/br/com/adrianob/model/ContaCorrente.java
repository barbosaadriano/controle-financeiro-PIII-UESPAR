package br.com.adrianob.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author Administrador
 */
@Entity(name = "contacorrente")
public class ContaCorrente {

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
    private String banco;

    public static final String PROP_BANCO = "banco";

    public String getBanco() {
        return banco;
    }
    @Column(length = 25)
    private String numero;

    public static final String PROP_NUMERO = "numero";

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        String oldNumero = this.numero;
        this.numero = numero;
        propertyChangeSupport.firePropertyChange(PROP_NUMERO, oldNumero, numero);
    }

    public void setBanco(String banco) {
        String oldBanco = this.banco;
        this.banco = banco;
        propertyChangeSupport.firePropertyChange(PROP_BANCO, oldBanco, banco);
    }
    @Column(length = 15)
    private String agencia;

    public static final String PROP_AGENCIA = "agencia";

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        String oldAgencia = this.agencia;
        this.agencia = agencia;
        propertyChangeSupport.firePropertyChange(PROP_AGENCIA, oldAgencia, agencia);
    }
    @Column(length = 10)
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
    private float saldo;

    public static final String PROP_SALDO = "saldo";

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        float oldSaldo = this.saldo;
        this.saldo = saldo;
        propertyChangeSupport.firePropertyChange(PROP_SALDO, oldSaldo, saldo);
    }

    @Column(name = "ultima_atualizacao")
    private Date ultimaAtualizacao;

    public static final String PROP_ULTIMAATUALIZACAO = "ultimaAtualizacao";

    public Date getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(Date ultimaAtualizacao) {
        Date oldUltimaAtualizacao = this.ultimaAtualizacao;
        this.ultimaAtualizacao = ultimaAtualizacao;
        propertyChangeSupport.firePropertyChange(PROP_ULTIMAATUALIZACAO, oldUltimaAtualizacao, ultimaAtualizacao);
    }
    @Column(length = 7)
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
    @OneToMany(mappedBy = "contaCorrente",
            targetEntity = FluxoDeCaixa.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = false)
    private List<FluxoDeCaixa> fluxosDeCaixa;

    public static final String PROP_FLUXOSDECAIXA = "fluxosDeCaixa";

    public List<FluxoDeCaixa> getFluxosDeCaixa() {
        return fluxosDeCaixa;
    }

    public void setFluxosDeCaixa(List<FluxoDeCaixa> fluxosDeCaixa) {
        List<FluxoDeCaixa> oldFluxosDeCaixa = this.fluxosDeCaixa;
        this.fluxosDeCaixa = fluxosDeCaixa;
        propertyChangeSupport.firePropertyChange(PROP_FLUXOSDECAIXA, oldFluxosDeCaixa, fluxosDeCaixa);
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
