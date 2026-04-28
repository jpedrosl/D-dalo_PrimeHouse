package com.projeto.meu_app.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.meu_app.models.ClienteModels;
import com.projeto.meu_app.repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired // "Pede" ao Spring para trazer as ferramentas de banco de dados
    private ClienteRepository repository;

    // Método para contar quantos clientes temos no sistema
    public long contarClientes() {
        return repository.count();
    }

    // Método para buscar um cliente específico pelo ID
    public ClienteModels buscarPorId(Integer id) {
        // O .orElse(null) evita que o programa trave se o ID não existir
        return repository.findById(id).orElse(null);
    }

    // Método para listar todos os clientes cadastrados
    public List<ClienteModels> listarTodos() {
        return repository.findAll();
    }

    // Método para deletar um cliente, mas só se ele realmente existir
    public Boolean deletar(Integer id) {
        if (repository.existsById(id)) { // Regra de negócio: verifica existência
            repository.deleteById(id);
            return true; // Sucesso
        }
        return false; // Falha (não encontrou o cliente)
    }

    // Método para salvar um novo cliente
    public ClienteModels cadastrar(ClienteModels cliente) {
        return repository.save(cliente);
    }

    // Método de atualização (O mais complexo, pois faz checagem campo por campo)
    public ClienteModels atualizar(Integer id, ClienteModels clienteEditado) {
        ClienteModels clienteOriginal = buscarPorId(id);

        if (clienteOriginal != null) {
            // Se o cliente existe, mantemos o ID e atualizamos apenas o que foi enviado
            clienteOriginal.setId(id);

            if (clienteEditado.getNomeCliente() != null) {
                clienteOriginal.setNomeCliente(clienteEditado.getNomeCliente());
            }
            if (clienteEditado.getCpfCliente() != null) {
                clienteOriginal.setCpfCliente(clienteEditado.getCpfCliente());
            }
            if (clienteEditado.getTelefoneCliente() != null) {
                clienteOriginal.setTelefoneCliente(clienteEditado.getTelefoneCliente());
            }
            if (clienteEditado.getEmailCliente() != null) {
                clienteOriginal.setEmailCliente(clienteEditado.getEmailCliente());
            }

            // Salva as alterações no banco
            return repository.save(clienteOriginal);
        }
        return null; // Retorna null se não encontrar o cliente para atualizar
    }
}