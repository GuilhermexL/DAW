package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.impl.EmpregadoDAOImpl;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainEmpregadoDelete {
	public static void main(String[] args) {
		EmpregadoDAOImpl empregadoDAO = new EmpregadoDAOImpl();

		try {
			// Deletando empregado pelo ID
			empregadoDAO.delete(1L); // Substitua o ID pelo existente no banco
			System.out.println("Empregado deletado com sucesso!");

		} catch (Exception e) {
			System.err.println("Erro ao deletar empregado: " + e.getMessage());
		} finally {
			empregadoDAO.close();
		}
	}
}
