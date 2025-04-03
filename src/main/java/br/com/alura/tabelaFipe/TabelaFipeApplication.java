package br.com.alura.tabelaFipe;

import br.com.alura.tabelaFipe.main.Principal;
import br.com.alura.tabelaFipe.service.ConsumoApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TabelaFipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TabelaFipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal main = new Principal();
		main.exibirMenu();
	}
}
