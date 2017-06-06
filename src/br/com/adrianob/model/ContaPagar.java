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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Administrador
 */
@Entity(name = "contapagar")
public class ContaPagar {

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
    @Column(name = "data_vencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;

    public static final String PROP_DATAVENCIMENTO = "dataVencimento";

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        Date oldDataVencimento = this.dataVencimento;
        this.dataVencimento = dataVencimento;
        propertyChangeSupport.firePropertyChange(PROP_DATAVENCIMENTO, oldDataVencimento, dataVencimento);
    }
    @Column(name = "data_pagamento")
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;

    public static final String PROP_DATAPAGAMENTO = "dataPagamento";

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        Date oldDataPagamento = this.dataPagamento;
        this.dataPagamento = dataPagamento;
        propertyChangeSupport.firePropertyChange(PROP_DATAPAGAMENTO, oldDataPagamento, dataPagamento);
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
    @Column(name = "valor_pago")
    private float valor_pago;

    public static final String PROP_VALORPAGO = "valorPago";

    public float getValorPago() {
        return valor_pago;
    }

    public void setValorRecebido(float valorPago) {
        float oldValorPago = this.valor_pago;
        this.valor_pago = valorPago;
        propertyChangeSupport.firePropertyChange(PROP_VALORPAGO, oldValorPago, valorPago);
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
    @Column
    private int documento;

    public static final String PROP_DOCUMENTO = "documento";

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        int oldDocumento = this.documento;
        this.documento = documento;
        propertyChangeSupport.firePropertyChange(PROP_DOCUMENTO, oldDocumento, documento);
    }
    @Column
    private int parcela;

    public static final String PROP_PARCELA = "parcela";

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        int oldParcela = this.parcela;
        this.parcela = parcela;
        propertyChangeSupport.firePropertyChange(PROP_PARCELA, oldParcela, parcela);
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
    private String observacao;

    public static final String PROP_OBSERVACAO = "observacao";

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        String oldObservacao = this.observacao;
        this.observacao = observacao;
        propertyChangeSupport.firePropertyChange(PROP_OBSERVACAO, oldObservacao, observacao);
    }
    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false,
            targetEntity = Pessoa.class)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public static final String PROP_PESSOA = "pessoa";

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        Pessoa oldPessoa = this.pessoa;
        this.pessoa = pessoa;
        propertyChangeSupport.firePropertyChange(PROP_PESSOA, oldPessoa, pessoa);
    }
    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false,
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
