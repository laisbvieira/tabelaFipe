package br.com.alura.tabelaFipe.main;

import br.com.alura.tabelaFipe.model.DadosMarcas;
import br.com.alura.tabelaFipe.model.DadosVeiculos;
import br.com.alura.tabelaFipe.model.Veiculo;
import br.com.alura.tabelaFipe.service.ConsumoApi;
import br.com.alura.tabelaFipe.service.ConverterDados;
import java.util.*;

public class Principal {

    final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    final Scanner scanner = new Scanner(System.in);
    final ConverterDados conversor = new ConverterDados();
    final ConsumoApi consumoApi = new ConsumoApi();

    public void exibirMenu() {

        try {
        //opcoes menu
        System.out.println("""
                **** OPÇÕES ****
                Carro
                Moto
                Caminhão
                """);
        System.out.println("Digite uma das opções para consultar valores:");
        String tipoVeiculo = scanner.nextLine();
        String endereco;

        if (tipoVeiculo.toLowerCase().contains("carr")) {
            endereco = URL_BASE + "carros/marcas/";
        } else if (tipoVeiculo.toLowerCase().contains("mot")) {
            endereco = URL_BASE + "motos/marcas/";
        } else {
        endereco = URL_BASE + "caminhoes/marcas/";
        };

        //pega as marcas de acordo com o tipo de veículo selecionado
        var json = consumoApi.obterDados(endereco);
        System.out.println("---------------- JSON");
        System.out.println(json);
        List<DadosVeiculos> dadosVeiculos = Arrays.asList(conversor.obterDados(json, DadosVeiculos[].class));

        dadosVeiculos.stream()
                        .sorted(Comparator.comparing(DadosVeiculos::codigo))
                                .forEach(System.out::println);

        System.out.println("Informe o código da marca para consulta");
        String marca = scanner.nextLine();
        endereco += marca + "/modelos/";
        //pega os modelos de acordo com a marca selecionada
        //
        json = consumoApi.obterDados(endereco);
        DadosMarcas dadosMarcas = conversor.obterDados(json, DadosMarcas.class);
        List<DadosVeiculos> dadosModelos = dadosMarcas.modelos();
        dadosModelos.stream()
                        .sorted(Comparator.comparing(DadosVeiculos::codigo))
                                .forEach(System.out::println);

        System.out.println("Digite um trecho do nome do veículo para consulta:");
        String nomeVeiculo = scanner.nextLine();

        //pegar o código pelo nome digitado
        List<DadosVeiculos> modelosEncontrados = dadosModelos.stream()
                .filter(m -> m.descricao().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                .toList();

        if (!modelosEncontrados.isEmpty()) {
            List<Veiculo> veiculos = new ArrayList<>();

            for (DadosVeiculos modelo : modelosEncontrados) {
                String codigoModelo = modelo.codigo();
                String enderecoModelo = endereco + codigoModelo + "/anos";
                json = consumoApi.obterDados(enderecoModelo);
                List<DadosVeiculos> anos = Arrays.asList(conversor.obterDados(json, DadosVeiculos[].class));

                for (DadosVeiculos ano : anos) {
                    String enderecoAno = enderecoModelo + "/" + ano.codigo();
                    json = consumoApi.obterDados(enderecoAno);
                    Veiculo veiculo = conversor.obterDados(json, Veiculo.class);
                    veiculos.add(veiculo);
                }
            }

            System.out.println("----------- Lista de Veículos -----------");
            veiculos.forEach(System.out::println);
        } else {
            System.out.println("Nenhum modelo encontrado. Tente novamente.");
        }

        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao processar a solicitação: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
