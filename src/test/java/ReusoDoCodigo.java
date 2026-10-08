import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class PontoDoacao {
    String nome;
    String email;
    String cep;
    Integer numero;
    String complemento;
    String pets; // Recebe cachorros ou gatos

    // Método construtor
    public PontoDoacao(String nome, String email, String cep, Integer numero, String complemento, String pets) {
        // Propriedades
        this.nome = nome;
        this.email = email;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.pets = pets;
    }
}

class Cadastro {

    private void submeteFormulario(PontoDoacao ponto){
        $("input[placeholder='Nome do ponto de doação']").setValue(ponto.nome);
        $("input[name=email]").setValue(ponto.email);
        $("input[name=cep]").setValue(ponto.cep);
        $("input[value='Buscar CEP']").click();
        $("input[name='addressNumber']").setValue(ponto.numero.toString());
        $("input[name='addressDetails']").setValue(ponto.complemento);
        $(By.xpath("//span[text()=\"" + ponto.pets +"\"]/..")).click();
        $(".button-register").click();
    }

    @Test
    @DisplayName("Deve poder cadastrar um ponto de doação")
    void createPoint() {

        //Pré condição
        PontoDoacao ponto = new PontoDoacao(
            "Estação Pet",
            "estacao@pet.com.br",
            "31930250",
            1000,
            "Ao lado da padaria",
            "Cachorros"
        );

        // Login
        open("https://petlov.vercel.app/signup");
        $("h1").shouldHave(text("Cadastro de ponto de doação"));

        // Ação
        submeteFormulario(ponto);

        // Resultado esperado
        String target = "Seu ponto de doação foi adicionado com sucesso. Juntos, podemos criar um mundo onde todos os animais recebam o amor e cuidado que merecem.";
        $("#success-page p").shouldHave(text(target));
    }
}
