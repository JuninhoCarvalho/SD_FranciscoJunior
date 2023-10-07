package br.inatel.labs.labjpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class NotaCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDate dataEmissao;

    @NotNull
    @ManyToOne
    private Fornecedor fornecedor;

    @OneToMany(mappedBy = "notaCompra")
    private List<NotaCompraItem> listaNotaCompraItem;

    //construtores
    public NotaCompra() {}

    public NotaCompra(LocalDate dataEmissao, Fornecedor fornecedor) {
        super();
        this.dataEmissao = dataEmissao;
        this.fornecedor = fornecedor;
    }

    public BigDecimal getCalculoTotalNota() {
        BigDecimal total = this.listaNotaCompraItem.stream()
                .map(i -> i.getCalculoTotalItem())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return total;
    }

    //acessores
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<NotaCompraItem> getListaNotaCompraItem() {
        return listaNotaCompraItem;
    }

    public void setListaNotaCompraItem(List<NotaCompraItem> listaNotaCompraItem) {
        this.listaNotaCompraItem = listaNotaCompraItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotaCompra that = (NotaCompra) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "NotaCompra[" +
                "id=" + id +
                ", dataEmissao=" + dataEmissao +
                ", fornecedor=" + fornecedor +
                ", listaNotaCompraItem=" + listaNotaCompraItem +
                ']';
    }
}