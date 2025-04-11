package com.example.demo.Model;

import jakarta.persistence.*;  // Importa as anotações JPA para mapeamento de entidades no banco de dados
import jakarta.validation.constraints.Email;  // Valida o formato do e-mail
import jakarta.validation.constraints.NotBlank;  // Garante que o campo não seja em branco
import jakarta.validation.constraints.NotNull;  // Garante que o campo não seja nulo
import jakarta.validation.constraints.Size;  // Valida o tamanho de uma string

@Entity  // Marca a classe como uma entidade JPA que será mapeada para uma tabela no banco de dados
public class Funcionario {

    @Id  // Define o campo 'id' como a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Gera automaticamente o valor do 'id' no banco de dados (auto incremento)
    private Long id;

    @NotBlank(message = "é obrigatorio pôr o nome ")  // Valida que o nome não pode ser vazio
    private String nome;

    @NotBlank(message = "é Obrigatorio pôr o CPF")  // Valida que o CPF não pode ser vazio
    @Size(min = 11, max = 11, message = "O CPF tem que conter 11 digitos")  // Valida que o CPF tem 11 dígitos
    private String cpf;

    @NotBlank(message = "é obrigatorio pôr a data de nascimento ")  // Valida que a data de nascimento não pode ser vazia
    private String dataDeNascimento;

    @Enumerated(EnumType.STRING)  // Mapeia o 'sexo' como um valor de enum armazenado como String no banco de dados
    private Sexo sexo;

    @Enumerated(EnumType.STRING)  // Mapeia o 'setor' como um valor de enum armazenado como String no banco de dados
    private Setor setor;

    @Enumerated(EnumType.STRING)  // Mapeia o 'estadoCivil' como um valor de enum armazenado como String no banco de dados
    private EstadoCivil estadoCivil;

    @NotNull  // Garante que o salário não pode ser nulo
    private double salario;

    @OneToOne(cascade = CascadeType.ALL)  // Relacionamento 1:1 com a classe 'Endereco', com cascata de operações
    private Endereco endereco;

    @NotBlank(message = "Email é Obrigatorio")  // Valida que o e-mail não pode ser vazio
    @Email(message = "Insira um e-mail válido.")  // Valida que o e-mail tem um formato válido
    private String email;

    // Construtor padrão
    public Funcionario() {
    }

    // Métodos getters e setters para acessar e modificar os campos privados

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}