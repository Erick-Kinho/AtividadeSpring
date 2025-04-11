package com.example.demo.Service;

import com.example.demo.Model.Funcionario;
import com.example.demo.Repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }
public List<Funcionario>listarTodos(){
        return funcionarioRepository.findAll();
}

public Funcionario salvar(@Valid Funcionario funcionario) {
    if (funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()) {
        throw new RuntimeException("Funcionario cadastrado");
    }
    return funcionarioRepository.save(funcionario);
    }
public Funcionario atualizar(@Valid Funcionario funcionario){
        Funcionario funcionarioAtualizar = funcionarioRepository.findById(funcionario.getId())
                .orElseThrow(()-> new RuntimeException("Funcionario não encontrado"));

        funcionarioAtualizar.setNome(funcionario.getNome());
        funcionarioAtualizar.setCpf(funcionario.getCpf());
        funcionarioAtualizar.setDataDeNascimento(funcionario.getDataDeNascimento());
        funcionarioAtualizar.setSexo(funcionario.getSexo());
        funcionarioAtualizar.setSetor(funcionario.getSetor());


        return funcionarioRepository.save(funcionarioAtualizar);
}
public void excluir(Long id){
        Funcionario funcionarioAtualizar = funcionarioRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Funcionario não encontrado"));
        funcionarioRepository.deleteById(id);
}
}
