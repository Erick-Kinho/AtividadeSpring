package com.example.demo.Controller;

import com.example.demo.Model.Funcionario;  // Importa a classe Funcionario
import com.example.demo.Service.FuncionarioService;  // Importa a classe FuncionarioService
import jakarta.validation.Valid;  // Importa a anotação Valid para validar os objetos
import org.apache.coyote.BadRequestException;  // Importa a exceção BadRequestException
import org.springframework.http.HttpStatus;  // Importa o status HTTP
import org.springframework.http.ResponseEntity;  // Importa a classe para construir a resposta HTTP
import org.springframework.web.bind.annotation.*;  // Importa as anotações para a criação de endpoints REST

import java.util.List;  // Importa a classe List para manipulação de listas
import java.util.Map;  // Importa a classe Map para estruturar as respostas

@RestController  // Define a classe como um controlador REST
@RequestMapping("/funcionario")  // Define a URL base para as requisições neste controlador
public class FuncionarioController {

    // Instancia o serviço FuncionarioService
    private FuncionarioService funcionarioService;

    // Construtor para injeção de dependência do FuncionarioService
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    // Endpoint para listar todos os funcionários
    @GetMapping  // Define que a requisição é do tipo GET
    public List<Funcionario> listarTodos() {
        // Chama o serviço para retornar todos os funcionários
        return funcionarioService.listarTodos();
    }

    // Endpoint para salvar um novo funcionário
    @PostMapping  // Define que a requisição é do tipo POST
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Funcionario funcionario) {
        // Chama o serviço para salvar o funcionário no banco de dados
        funcionarioService.salvar(funcionario);

        // Retorna uma resposta HTTP com status CREATED (201) e uma mensagem indicando que o funcionário foi cadastrado com sucesso
        return ResponseEntity
                .status(HttpStatus.CREATED)  // Define o status HTTP como 201 (CREATED)
                .body(Map.of("mensagem", "funcionario " + funcionario.getNome() + " cadastrado com sucesso"));
    }

    // Endpoint para atualizar um funcionário existente
    @PutMapping  // Define que a requisição é do tipo PUT
    public ResponseEntity<Map<String, Object>> atualizar(@Valid @RequestBody Funcionario funcionario) {
        // Chama o serviço para atualizar os dados do funcionário
        funcionarioService.atualizar(funcionario);

        // Retorna uma resposta HTTP com status OK (200) e uma mensagem indicando que o funcionário foi atualizado com sucesso
        return ResponseEntity
                .status(HttpStatus.OK)  // Define o status HTTP como 200 (OK)
                .body(Map.of("mensagem", "Funcionario atualizado com sucesso"));
    }

    // Endpoint para excluir um funcionário
    @DeleteMapping("/{id}")  // Define que a requisição é do tipo DELETE e o ID é passado pela URL
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id) throws BadRequestException {
        // Chama o serviço para excluir o funcionário pelo ID
        funcionarioService.excluir(id);

        // Retorna uma resposta HTTP com status OK (200) e uma mensagem indicando que o funcionário foi excluído com sucesso
        return ResponseEntity
                .status(HttpStatus.OK)  // Define o status HTTP como 200 (OK)
                .body(Map.of("mensagem", "Funcionario excluido"));
    }
}
