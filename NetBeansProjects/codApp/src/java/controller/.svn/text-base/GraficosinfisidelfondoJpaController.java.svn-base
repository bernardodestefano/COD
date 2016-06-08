/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Graficosinfisidelfondo;
import controller.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import bean.Bambino;

/**
 *
 * @author Lodato
 */
public class GraficosinfisidelfondoJpaController {

    public GraficosinfisidelfondoJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Graficosinfisidelfondo graficosinfisidelfondo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Bambino bambino = graficosinfisidelfondo.getBambino();
            if (bambino != null) {
                bambino = em.getReference(bambino.getClass(), bambino.getId());
                graficosinfisidelfondo.setBambino(bambino);
            }
            em.persist(graficosinfisidelfondo);
            if (bambino != null) {
                bambino.getGraficosinfisidelfondoList().add(graficosinfisidelfondo);
                bambino = em.merge(bambino);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Graficosinfisidelfondo graficosinfisidelfondo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Graficosinfisidelfondo persistentGraficosinfisidelfondo = em.find(Graficosinfisidelfondo.class, graficosinfisidelfondo.getId());
            Bambino bambinoOld = persistentGraficosinfisidelfondo.getBambino();
            Bambino bambinoNew = graficosinfisidelfondo.getBambino();
            if (bambinoNew != null) {
                bambinoNew = em.getReference(bambinoNew.getClass(), bambinoNew.getId());
                graficosinfisidelfondo.setBambino(bambinoNew);
            }
            graficosinfisidelfondo = em.merge(graficosinfisidelfondo);
            if (bambinoOld != null && !bambinoOld.equals(bambinoNew)) {
                bambinoOld.getGraficosinfisidelfondoList().remove(graficosinfisidelfondo);
                bambinoOld = em.merge(bambinoOld);
            }
            if (bambinoNew != null && !bambinoNew.equals(bambinoOld)) {
                bambinoNew.getGraficosinfisidelfondoList().add(graficosinfisidelfondo);
                bambinoNew = em.merge(bambinoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = graficosinfisidelfondo.getId();
                if (findGraficosinfisidelfondo(id) == null) {
                    throw new NonexistentEntityException("The graficosinfisidelfondo with id " + id + " no longer exists.");
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
            Graficosinfisidelfondo graficosinfisidelfondo;
            try {
                graficosinfisidelfondo = em.getReference(Graficosinfisidelfondo.class, id);
                graficosinfisidelfondo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The graficosinfisidelfondo with id " + id + " no longer exists.", enfe);
            }
            Bambino bambino = graficosinfisidelfondo.getBambino();
            if (bambino != null) {
                bambino.getGraficosinfisidelfondoList().remove(graficosinfisidelfondo);
                bambino = em.merge(bambino);
            }
            em.remove(graficosinfisidelfondo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Graficosinfisidelfondo> findGraficosinfisidelfondoEntities() {
        return findGraficosinfisidelfondoEntities(true, -1, -1);
    }

    public List<Graficosinfisidelfondo> findGraficosinfisidelfondoEntities(int maxResults, int firstResult) {
        return findGraficosinfisidelfondoEntities(false, maxResults, firstResult);
    }

    private List<Graficosinfisidelfondo> findGraficosinfisidelfondoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Graficosinfisidelfondo.class));
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

    public Graficosinfisidelfondo findGraficosinfisidelfondo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Graficosinfisidelfondo.class, id);
        } finally {
            em.close();
        }
    }

    public int getGraficosinfisidelfondoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Graficosinfisidelfondo> rt = cq.from(Graficosinfisidelfondo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
