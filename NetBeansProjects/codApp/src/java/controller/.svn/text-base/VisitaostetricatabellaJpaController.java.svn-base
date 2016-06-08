/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Visitaostetricatabella;
import controller.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import bean.Visitaostetrica;

/**
 *
 * @author Lodato
 */
public class VisitaostetricatabellaJpaController {

    public VisitaostetricatabellaJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Visitaostetricatabella visitaostetricatabella) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Visitaostetrica visitaostetrica = visitaostetricatabella.getVisitaostetrica();
            if (visitaostetrica != null) {
                visitaostetrica = em.getReference(visitaostetrica.getClass(), visitaostetrica.getId());
                visitaostetricatabella.setVisitaostetrica(visitaostetrica);
            }
            em.persist(visitaostetricatabella);
            if (visitaostetrica != null) {
                visitaostetrica.getVisitaostetricatabellaList().add(visitaostetricatabella);
                visitaostetrica = em.merge(visitaostetrica);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Visitaostetricatabella visitaostetricatabella) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Visitaostetricatabella persistentVisitaostetricatabella = em.find(Visitaostetricatabella.class, visitaostetricatabella.getId());
            Visitaostetrica visitaostetricaOld = persistentVisitaostetricatabella.getVisitaostetrica();
            Visitaostetrica visitaostetricaNew = visitaostetricatabella.getVisitaostetrica();
            if (visitaostetricaNew != null) {
                visitaostetricaNew = em.getReference(visitaostetricaNew.getClass(), visitaostetricaNew.getId());
                visitaostetricatabella.setVisitaostetrica(visitaostetricaNew);
            }
            visitaostetricatabella = em.merge(visitaostetricatabella);
            if (visitaostetricaOld != null && !visitaostetricaOld.equals(visitaostetricaNew)) {
                visitaostetricaOld.getVisitaostetricatabellaList().remove(visitaostetricatabella);
                visitaostetricaOld = em.merge(visitaostetricaOld);
            }
            if (visitaostetricaNew != null && !visitaostetricaNew.equals(visitaostetricaOld)) {
                visitaostetricaNew.getVisitaostetricatabellaList().add(visitaostetricatabella);
                visitaostetricaNew = em.merge(visitaostetricaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = visitaostetricatabella.getId();
                if (findVisitaostetricatabella(id) == null) {
                    throw new NonexistentEntityException("The visitaostetricatabella with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Visitaostetricatabella visitaostetricatabella;
            try {
                visitaostetricatabella = em.getReference(Visitaostetricatabella.class, id);
                visitaostetricatabella.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The visitaostetricatabella with id " + id + " no longer exists.", enfe);
            }
            Visitaostetrica visitaostetrica = visitaostetricatabella.getVisitaostetrica();
            if (visitaostetrica != null) {
                visitaostetrica.getVisitaostetricatabellaList().remove(visitaostetricatabella);
                visitaostetrica = em.merge(visitaostetrica);
            }
            em.remove(visitaostetricatabella);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Visitaostetricatabella> findVisitaostetricatabellaEntities() {
        return findVisitaostetricatabellaEntities(true, -1, -1);
    }

    public List<Visitaostetricatabella> findVisitaostetricatabellaEntities(int maxResults, int firstResult) {
        return findVisitaostetricatabellaEntities(false, maxResults, firstResult);
    }

    private List<Visitaostetricatabella> findVisitaostetricatabellaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Visitaostetricatabella.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Visitaostetricatabella findVisitaostetricatabella(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Visitaostetricatabella.class, id);
        } finally {
            em.close();
        }
    }

    public int getVisitaostetricatabellaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Visitaostetricatabella> rt = cq.from(Visitaostetricatabella.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
