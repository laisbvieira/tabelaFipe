package br.com.alura.tabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Veiculo(
        @JsonAlias("Valor") String valor,
        @JsonAlias("Marca") String marca,
        @JsonAlias("Modelo") String modelo,
        @JsonAlias("AnoModelo") Integer ano,
        @JsonAlias("Combustivel") String combustivel
) {

    @Override
    public String toString() {
        return """
           ----------------------------
           🚗 Veículo Detalhes:
           💰 Valor: %s
           🏷️ Marca: %s
           🚙 Modelo: %s
           📅 Ano: %d
           ⛽ Combustível: %s
           ----------------------------
           """.formatted(valor, marca, modelo, ano, combustivel);
    }
}
