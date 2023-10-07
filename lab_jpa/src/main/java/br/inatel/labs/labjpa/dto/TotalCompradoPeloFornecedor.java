package br.inatel.labs.labjpa.dto;

import java.math.BigDecimal;

public record TotalCompradoPeloFornecedor(String fornecedorRazaoSocial, BigDecimal totalComprado) {
}
