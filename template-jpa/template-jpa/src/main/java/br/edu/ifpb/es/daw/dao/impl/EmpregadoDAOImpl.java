package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.EmpregadoDAO;
import br.edu.ifpb.es.daw.entities.Empregado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class EmpregadoDAOImpl implements EmpregadoDAO {

    private static final String PERSISTENCE_UNIT_NAME = "nome-da-unidade-de-persistencia"; // Substitua pelo nome da sua unidade de persistência no arquivo persistence.xml
    private EntityManagerFactory emf;
    private EntityManager em;

    public EmpregadoDAOImpl() {
        this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        this.em = emf.createEntityManager();
    }

    @Override
    public void save(Empregado empregado) {
        try {
            em.getTransaction().begin();
            em.persist(empregado); // Salva o empregado
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao salvar o empregado: " + e.getMessage());
        }
    }

    @Override
    public void update(Empregado empregado) {
        try {
            em.getTransaction().begin();
            em.merge(empregado); // Atualiza o empregado
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao atualizar o empregado: " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try {
            em.getTransaction().begin();
            Empregado empregado = em.find(Empregado.class, id); // Busca o empregado pelo ID
            if (empregado != null) {
                em.remove(empregado); // Remove o empregado
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao remover o empregado: " + e.getMessage());
        }
    }

    @Override
    public Empregado findById(Long id) {
        try {
            return em.find(Empregado.class, id); // Busca um empregado pelo ID
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar o empregado por ID: " + e.getMessage());
        }
    }

    @Override
    public List<Empregado> findAll() {
        try {
            return em.createQuery("SELECT e FROM Empregado e", Empregado.class).getResultList(); // Retorna todos os empregados
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar os empregados: " + e.getMessage());
        }
    }

    // Método para fechar o EntityManager e EntityManagerFactory
    public void close() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }
}
