package br.com.erp.sapx;

import br.com.erp.sapx.repository.ClienteRepository;
import br.com.erp.sapx.repository.ProjectRepository;
import br.com.erp.sapx.repository.model.ClientModel;
import br.com.erp.sapx.repository.model.ProjectModel;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@AllArgsConstructor
@SpringBootApplication
public class SapxApplication implements CommandLineRunner {

	private final ProjectRepository projectRepository;
	private final ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(SapxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		projectRepository.deleteAll();
		clienteRepository.deleteAll();

		final var cliente1 = ClientModel.builder()
				.cnpj("08.726.922/0001-92")
				.nome("ABC Cosméticos")
				.build();

		clienteRepository.saveAll(List.of(cliente1));

		final var proj1 =
				ProjectModel.builder()
						.numProjeto(158L)
						.cliente(cliente1)
						.valor(5000.00)
						.dataInicio(LocalDate.now())
						.dataFim(LocalDate.of(2021, Month.JUNE, 20))
						.build();

		final var proj2 =
				ProjectModel.builder()
						.numProjeto(29894L)
						.cliente(cliente1)
						.valor(92000.00)
						.dataInicio(LocalDate.now())
						.dataFim(LocalDate.of(2025, Month.AUGUST, 18))
						.build();

		projectRepository.saveAll(List.of(proj1, proj2));

	}
}
