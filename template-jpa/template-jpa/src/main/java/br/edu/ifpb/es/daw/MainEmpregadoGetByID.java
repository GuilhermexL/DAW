package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.impl.EmpregadoDAOImpl;
import br.edu.ifpb.es.daw.entities.Empregado;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainEmpregadoGetByID {
	public static void main(String[] args) {
		EmpregadoDAOImpl empregadoDAO = new EmpregadoDAOImpl();

		try {
			// Buscando empregado pelo ID
			Empregado empregado = empregadoDAO.findById(1L); // Substitua o ID pelo existente no banco
			if (empregado != null) {
				System.out.println("Empregado encontrado: " + empregado);
			} else {
				System.out.println("Empregado não encontrado.");
			}

		} catch (Exception e) {
			System.err.println("Erro ao buscar empregado: " + e.getMessage());
		} finally {
			empregadoDAO.close();
		}
	}
}
