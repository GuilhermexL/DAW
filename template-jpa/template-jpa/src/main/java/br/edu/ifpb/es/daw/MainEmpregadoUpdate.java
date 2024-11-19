package br.edu.ifpb.es.daw;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import br.edu.ifpb.es.daw.dao.impl.EmpregadoDAOImpl;
import br.edu.ifpb.es.daw.entities.Empregado;

import java.math.BigDecimal;

public class MainEmpregadoUpdate {
	public static void main(String[] args) {
		EmpregadoDAOImpl empregadoDAO = new EmpregadoDAOImpl();

		try {
			// Buscando o empregado pelo ID
			Empregado empregado = empregadoDAO.findById(1L); // Substitua o ID pelo existente no banco
			if (empregado != null) {
				// Atualizando informações
				empregado.setEndereco("Rua Nova, 456");
				empregado.setSalario(new BigDecimal("3000.75"));

				empregadoDAO.update(empregado);
				System.out.println("Empregado atualizado com sucesso!");
			} else {
				System.out.println("Empregado não encontrado.");
			}

		} catch (Exception e) {
			System.err.println("Erro ao atualizar empregado: " + e.getMessage());
		} finally {
			empregadoDAO.close();
		}
	}
}
