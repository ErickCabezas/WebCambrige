package com.example.webcambrige;

import java.util.ArrayList;
import java.util.List;

import entities.ConexionBD;
import entities.Examenubicacion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

public class Gestor_ExamenUbicacion {
    private List<Examenubicacion> examenes;

    public Gestor_ExamenUbicacion() {
        this.examenes = new ArrayList<>();
    }

    public List<Examenubicacion> getExamenes() {
        return examenes;
    }

    public Examenubicacion buscarExamen(int cursoId) {
        Examenubicacion examenExistente = null;
        EntityTransaction transaction = null;
        try {
            EntityManager entityManager = ConexionBD.entityManager;
            transaction = entityManager.getTransaction();
            transaction.begin();

            String query = "SELECT u FROM Examenubicacion u WHERE u.id = :id";

            examenExistente = entityManager
                    .createQuery(query, entities.Examenubicacion.class)
                    .setParameter("id", cursoId)
                    .getSingleResult();

            transaction.commit();
        } catch (NoResultException e) {
            e.printStackTrace();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (transaction != null) {
                transaction.isActive(); // ensure all open transactions are closed
            }
        }
        return examenExistente;
    }

    public void agregarExamen(Examenubicacion examen){
        EntityTransaction transaction = null;
        try{
            EntityManager entityManager = ConexionBD.entityManager;
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(examen);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Error durante la transaccion");
        }
    }

    public Examenubicacion buscarExamenporHorario(String horario){
        Examenubicacion examenExistente = null;
        EntityTransaction transaction = null;
        try {
            EntityManager entityManager = ConexionBD.entityManager;
            transaction = entityManager.getTransaction();
            transaction.begin();

            String query = "SELECT u FROM Examenubicacion u WHERE u.horario = :horario";

            examenExistente = entityManager
                    .createQuery(query, entities.Examenubicacion.class)
                    .setParameter("horario", horario)
                    .getSingleResult();

            transaction.commit();
        } catch (NoResultException e) {
            e.printStackTrace();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (transaction != null) {
                transaction.isActive(); // ensure all open transactions are closed
            }
        }
        return examenExistente;
    }

    public List<Examenubicacion> listarExamenes() {
        List<Examenubicacion> examenes = new ArrayList<>();
        EntityTransaction transaction = null;
        try {
            EntityManager entityManager = ConexionBD.entityManager;
            transaction = entityManager.getTransaction();
            transaction.begin();

            String query = "SELECT e FROM Examenubicacion e";

            examenes = entityManager
                    .createQuery(query, Examenubicacion.class)
                    .getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (transaction != null) {
                transaction.isActive();
            }
        }
        return examenes;
    }



    public String eliminarExamen(int id) {
        String notificacion = "";
        Examenubicacion examen = buscarExamen(id);
        if (examen != null) {
            examenes.remove(examen);
            notificacion = "examen eliminado";
        } else {
            notificacion = "examen no existe";
        }
        return notificacion;
    }
}
