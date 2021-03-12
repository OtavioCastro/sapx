package br.com.erp.sapx;

import br.com.erp.sapx.repository.ClienteRepository;
import br.com.erp.sapx.repository.ProjectRepository;
import br.com.erp.sapx.repository.model.ClientModel;
import br.com.erp.sapx.repository.model.HorasProjetoModel;
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

        final var client1 = ClientModel.builder()
                .numCliente(1)
                .cnpj("08.726.922/0001-92")
                .nome("ABC Cosméticos")
                .build();


        final var client2 = ClientModel.builder()
                .numCliente(2)
                .cnpj("42.126.333/0001-01")
                .nome("Serralheria dois irmãos")
                .build();

        clienteRepository.saveAll(List.of(client1, client2));

        final var proj1 =
                ProjectModel.builder()
                        .numProjeto(158L)
                        .cliente(client1)
                        .valor(5000.00)
                        .dataInicio(LocalDate.now())
                        .dataFim(LocalDate.of(2021, Month.JUNE, 20))
						.status("Em negociação")
                        .horasProjeto(HorasProjetoModel.builder()
                                .gerentes(2)
                                .arquitetos(5)
                                .progJr(80)
                                .progPl(100)
                                .progSr(200)
                                .dba(30)
                                .build())
                        .build();

        final var proj2 =
                ProjectModel.builder()
                        .numProjeto(29894L)
                        .cliente(client1)
                        .valor(92000.00)
                        .dataInicio(LocalDate.now())
                        .dataFim(LocalDate.of(2025, Month.AUGUST, 18))
						.status("Contratado")
                        .horasProjeto(HorasProjetoModel.builder()
                                .gerentes(100)
                                .arquitetos(50)
                                .progJr(809)
                                .progPl(1350)
                                .progSr(2800)
                                .dba(440)
                                .build())
                        .build();

		final var proj3 =
				ProjectModel.builder()
						.numProjeto(29811L)
						.cliente(client2)
						.valor(158000.00)
						.dataInicio(LocalDate.now())
						.dataFim(LocalDate.of(2026, Month.APRIL, 7))
						.status("Contratado")
						.horasProjeto(HorasProjetoModel.builder()
								.gerentes(200)
								.progJr(1500)
								.progPl(3000)
								.progSr(5000)
								.build())
						.build();

        projectRepository.saveAll(List.of(proj1, proj2, proj3));

    }
}
