package com.example.webcambrige;

import java.util.ArrayList;
import java.util.List;

import entities.ConexionBD;
import entities.Cursoingles;
import entities.Examenubicacion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

public class Gestor_Cursos {
    private List<Cursoingles> cursos;

    public Gestor_Cursos() {
        this.cursos = new ArrayList<>();
    }

    public List<Cursoingles> getCursos() {
        return cursos;
    }

    public Cursoingles buscarCursoPorHorario(String horario){
        Cursoingles cursoExistente = null;
        EntityTransaction transaction = null;
        try {
            EntityManager entityManager = ConexionBD.entityManager;
            transaction = entityManager.getTransaction();
            transaction.begin();

            String query = "SELECT u FROM Cursoingles u WHERE u.horarioCurso = :horario";

            cursoExistente = entityManager
                    .createQuery(query, entities.Cursoingles.class)
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
        return cursoExistente;
    }

    public String eliminarCurso(int id) {
        //MODIFICAR: POR AHORA ELIMINA DE LA LISTA PERO NO DE LA BASE DE DATOS
        String notificacion = "";
        Cursoingles curso = buscarCurso(id);
        if (curso != null) {
            cursos.remove(curso);
            notificacion = "curso eliminado";
        } else {
            notificacion = "curso no existe";
        }
        return notificacion;
    }

    public void agregarCurso(Cursoingles curso){
        EntityTransaction transaction = null;
        try{
            EntityManager entityManager = ConexionBD.entityManager;
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(curso);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Error durante la transaccion");
        }
    }

    public Cursoingles buscarCurso(int cursoId) {
        Cursoingles cursoExistente = null;
        EntityTransaction transaction = null;
        try {
            EntityManager entityManager = ConexionBD.entityManager;
            transaction = entityManager.getTransaction();
            transaction.begin();

            String query = "SELECT u FROM Cursoingles u WHERE u.id = :id";

            cursoExistente = entityManager
                    .createQuery(query, entities.Cursoingles.class)
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
                transaction.isActive();
            }
        }
        return cursoExistente;
    }

    public void borrarCurso(int cursoId) {
        EntityTransaction transaction = null;
        try {
            EntityManager entityManager = ConexionBD.entityManager;
            transaction = entityManager.getTransaction();
            transaction.begin();

            Cursoingles cursoExistente = entityManager.find(Cursoingles.class, cursoId);

            if (cursoExistente != null) {
                entityManager.remove(cursoExistente);
                transaction.commit();
                System.out.println("Curso eliminado exitosamente.");
            } else {
                System.out.println("No se encontró el curso con ID: " + cursoId);
            }

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
    }

    public List<Cursoingles> listarCursos() {
        List<Cursoingles> cursos = new ArrayList<>();
        EntityTransaction transaction = null;
        try {
            EntityManager entityManager = ConexionBD.entityManager;
            transaction = entityManager.getTransaction();
            transaction.begin();

            String query = "SELECT c FROM Cursoingles c";

            cursos = entityManager
                    .createQuery(query, Cursoingles.class)
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
        return cursos;
    }




}
