package br.com.alura.tabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosVeiculos(@JsonAlias("codigo") String codigo, @JsonAlias("nome") String descricao) {

    @Override
    public String toString() {
        return "Cód: " + codigo +
                " Descrição: " + descricao;
    }
}
