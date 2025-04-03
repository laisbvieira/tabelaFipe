package br.com.alura.tabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosMarcas(@JsonAlias("modelos") List<DadosVeiculos> modelos) {
    @Override
    public String toString() {
        return "DadosMarcas{" +
                "modelos=" + modelos +
                '}';
    }
}
