package br.edu.ifpb.es.daw.dao;

import br.edu.ifpb.es.daw.entities.Empregado;
import java.util.List;

public interface EmpregadoDAO {

    void save(Empregado empregado); // Cria um novo empregado
    void update(Empregado empregado); // Atualiza um empregado já cadastrado
    void delete(Long id); // Remove o empregado pelo ID
    Empregado findById(Long id); // Busca o empregado pelo ID
    List<Empregado> findAll(); // Lista todos os empregados
}
