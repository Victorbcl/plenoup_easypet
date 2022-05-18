package com.plenoup.easypet;

import com.plenoup.easypet.controller.ServicoController;
import com.plenoup.easypet.entity.Petshop;
import com.plenoup.easypet.entity.Servico;
import com.plenoup.easypet.repository.PetshopRepository;
import com.plenoup.easypet.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
public class EasypetApplication implements CommandLineRunner {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private PetshopRepository petshopRepository;

    @Autowired
    private ServicoController servicoController;

    public static void main(final String[] args) {
        SpringApplication.run(EasypetApplication.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {

        final Petshop petshop = Petshop.builder()
                .nome("Easy Pet")
                .build();

        final Servico servicoTosa = Servico.builder()
                .nome("Tosa")
                .valor(BigDecimal.valueOf(80))
                .petshop(petshop)
                .build();

        final Servico servicoBanho = Servico.builder()
                .nome("Banho")
                .valor(BigDecimal.valueOf(45))
                .petshop(petshop)
                .build();

        petshopRepository.save(petshop);
        petshop.setServicos((Arrays.asList(servicoTosa, servicoBanho)));
        servicoRepository.saveAll(Arrays.asList(servicoTosa, servicoBanho));
    }
}
