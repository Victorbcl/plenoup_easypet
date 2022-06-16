package com.plenoup.easypet.archunit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

@AnalyzeClasses(packages = "com.plenoup.easypet", importOptions = {ImportOption.DoNotIncludeTests.class})
class RegrasArquiteturaTest {

    @ArchTest
    static final ArchRule classes_de_implementacao_nao_devem_ser_publicas =
            ArchRuleDefinition.classes()
                    .that().haveNameMatching(".*Impl.*")
                    .should().bePackagePrivate()
                    .because("Classes de implementação não devem ser publicas, e sim acessadas pela interface");

    @ArchTest
    static final ArchRule classes_exception_devem_possuir_mensagem_padrao =
            ArchRuleDefinition.fields()
                    .that().areDeclaredInClassesThat().haveNameMatching(".*Exception.*")
                    .should().bePrivate()
                    .andShould().beStatic()
                    .andShould().beFinal()
                    .andShould().haveRawType(String.class)
                    .because("Classes 'Exception' devem possuir campo de mensagem default");

    @ArchTest
    static final ArchRule classes_com_annotation_configuration_devem_possuir_sufixo_Configuration =
            ArchRuleDefinition.classes()
                    .that().areAnnotatedWith(Configuration.class)
                    .should().haveNameMatching(".*Configuration")
                    .because("Classes anotadas com '@Configuration' devem possuir 'Configuration' no sufixo");

    @ArchTest
    static final ArchRule classes_com_annotation_RestController_devem_possuir_sufixo_Controller =
            ArchRuleDefinition.classes()
                    .that().areAnnotatedWith(RestController.class)
                    .should().haveNameMatching(".*Controller.*")
                    .because("Classes Controller devem possuir 'Controller no sufixo'");
}
