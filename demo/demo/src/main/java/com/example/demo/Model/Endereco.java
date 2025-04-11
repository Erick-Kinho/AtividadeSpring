package com.example.demo.Model;

import jakarta.persistence.*;  // Importa as anotações JPA para persistência no banco de dados
import jakarta.validation.constraints.NotBlank;  // Importa a anotação para validar que um campo não pode ser vazio

@Entity  // Marca a classe como uma entidade JPA que será mapeada para uma tabela no banco de dados
@Table(name = "Endereço")  // Define o nome da tabela como "Endereço"
public class Endereco {

    @Id  // Marca o campo 'id' como a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Gera automaticamente o valor do id (auto incremento)
    private Long id;

    @NotBlank(message = "Logradouro  é obrigatorio")  // Valida que o campo 'logradouro' não pode ser vazio
    private String logradouro;

    @NotBlank(message = "Numero é obrigatorio")  // Valida que o campo 'numero' não pode ser vazio
    private String numero;

    @NotBlank(message = "Complemento é obrigatorio")  // Valida que o campo 'complemento' não pode ser vazio
    private String complemento;

    @NotBlank(message = "A cidade é Obrigatoria")  // Valida que o campo 'cidade' não pode ser vazio
    private String cidade;

    // Construtor padrão
    public Endereco() {
    }

    // Métodos getters e setters para acessar e modificar os valores dos campos privados

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}

