# 🚗 Tabela FIPE - Consulta de Preços de Veículos

Este projeto em Java permite consultar os valores de veículos (carros, motos e caminhões) na Tabela FIPE, utilizando a API Parallelum FIPE.

### 📌 Tecnologias Utilizadas

Java 17+

Spring Boot

Jackson (para conversão de JSON)

Consumo de APIs REST com HttpURLConnection

### 🚀 Funcionalidades

Selecionar o tipo de veículo: Carro, Moto ou Caminhão.

Buscar marcas disponíveis na FIPE.

Listar modelos de veículos da marca escolhida.

Filtrar modelos pelo nome.

Consultar valores de mercado com base no ano do veículo.

### 📦 Como Executar o Projeto

1️⃣ Clonar o repositório

```bash
git clone https://github.com/laisbvieira/tabelaFipe.git
cd tabelaFipe
```

2️⃣ Compilar e Executar
```bash
javac -d bin -cp src src/br/com/alura/tabelaFipe/main/Principal.java
java -cp bin br.com.alura.tabelaFipe.main.Principal
```
