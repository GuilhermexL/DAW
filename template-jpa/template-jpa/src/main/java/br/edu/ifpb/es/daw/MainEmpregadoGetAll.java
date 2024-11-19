package br.edu.ifpb.es.daw;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import br.edu.ifpb.es.daw.dao.impl.EmpregadoDAOImpl;
import br.edu.ifpb.es.daw.entities.Empregado;

import java.util.List;

public class MainEmpregadoGetAll {
	public static void main(String[] args) {
		EmpregadoDAOImpl empregadoDAO = new EmpregadoDAOImpl();

		try {
			// Listando todos os empregados
			List<Empregado> empregados = empregadoDAO.findAll();
			if (empregados.isEmpty()) {
				System.out.println("Nenhum empregado encontrado.");
			} else {
				System.out.println("Empregados encontrados:");
				for (Empregado empregado : empregados) {
					System.out.println(empregado);
				}
			}

		} catch (Exception e) {
			System.err.println("Erro ao listar empregados: " + e.getMessage());
		} finally {
			empregadoDAO.close();
		}
	}
}
