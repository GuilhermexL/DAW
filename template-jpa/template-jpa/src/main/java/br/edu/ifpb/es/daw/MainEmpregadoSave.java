package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.impl.EmpregadoDAOImpl;
import br.edu.ifpb.es.daw.entities.Empregado;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainEmpregadoSave {
	public static void main(String[] args) {
		EmpregadoDAOImpl empregadoDAO = new EmpregadoDAOImpl();

		try {
			// Criando um novo empregado
			Empregado empregado = new Empregado();
			empregado.setNome("Guilherme");
			empregado.setSobrenome("Santos");
			empregado.setCpf("12345678901");
			empregado.setDataNascimento(LocalDate.of(1998, 5, 25));
			empregado.setEndereco("Rua Natal, 123");
			empregado.setSexo('M');
			empregado.setSalario(new BigDecimal("2500.50"));
			empregado.setnDependentes(2);

			// Salvando no banco
			empregadoDAO.save(empregado);
			System.out.println("Empregado salvo com sucesso!");

		} catch (Exception e) {
			System.err.println("Erro ao salvar empregado: " + e.getMessage());
		} finally {
			empregadoDAO.close();
		}
	}
}
