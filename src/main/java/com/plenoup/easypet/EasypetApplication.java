package com.plenoup.easypet;

import com.plenoup.easypet.controller.ServicoController;
import com.plenoup.easypet.core.CepService;
import com.plenoup.easypet.repository.PetshopRepository;
import com.plenoup.easypet.repository.ServicoRepository;
import com.plenoup.easypet.repository.entity.PetshopEntity;
import com.plenoup.easypet.repository.entity.ServicoEntity;
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

    @Autowired
    private CepService cepService;

    public static void main(final String[] args) {
        SpringApplication.run(EasypetApplication.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {

//        TESTE WIREMOCK
        cepService.buscaEndereco("30260070");

        final PetshopEntity petshopEntity = PetshopEntity.builder()
                .nome("Easy Pet")
                .build();

        final ServicoEntity servicoEntityTosa = ServicoEntity.builder()
                .nome("Tosa")
                .valor(BigDecimal.valueOf(85))
                .petshop(petshopEntity)
                .build();

        final ServicoEntity servicoEntityBanho = ServicoEntity.builder()
                .nome("Banho")
                .valor(BigDecimal.valueOf(45))
                .petshop(petshopEntity)
                .build();

        petshopRepository.save(petshopEntity);
        petshopEntity.setServicos((Arrays.asList(servicoEntityTosa, servicoEntityBanho)));
        servicoRepository.saveAll(Arrays.asList(servicoEntityTosa, servicoEntityBanho));
    }
}
