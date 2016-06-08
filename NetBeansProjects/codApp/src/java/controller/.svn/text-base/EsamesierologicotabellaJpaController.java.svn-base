/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Esamesierologicotabella;
import controller.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import bean.Esamesierologico;

/**
 *
 * @author Lodato
 */
public class EsamesierologicotabellaJpaController {

    public EsamesierologicotabellaJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Esamesierologicotabella esamesierologicotabella) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Esamesierologico esamesierologico = esamesierologicotabella.getEsamesierologico();
            if (esamesierologico != null) {
                esamesierologico = em.getReference(esamesierologico.getClass(), esamesierologico.getId());
                esamesierologicotabella.setEsamesierologico(esamesierologico);
            }
            em.persist(esamesierologicotabella);
            if (esamesierologico != null) {
                esamesierologico.getEsamesierologicotabellaList().add(esamesierologicotabella);
                esamesierologico = em.merge(esamesierologico);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Esamesierologicotabella esamesierologicotabella) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Esamesierologicotabella persistentEsamesierologicotabella = em.find(Esamesierologicotabella.class, esamesierologicotabella.getId());
            Esamesierologico esamesierologicoOld = persistentEsamesierologicotabella.getEsamesierologico();
            Esamesierologico esamesierologicoNew = esamesierologicotabella.getEsamesierologico();
            if (esamesierologicoNew != null) {
                esamesierologicoNew = em.getReference(esamesierologicoNew.getClass(), esamesierologicoNew.getId());
                esamesierologicotabella.setEsamesierologico(esamesierologicoNew);
            }
            esamesierologicotabella = em.merge(esamesierologicotabella);
            if (esamesierologicoOld != null && !esamesierologicoOld.equals(esamesierologicoNew)) {
                esamesierologicoOld.getEsamesierologicotabellaList().remove(esamesierologicotabella);
                esamesierologicoOld = em.merge(esamesierologicoOld);
            }
            if (esamesierologicoNew != null && !esamesierologicoNew.equals(esamesierologicoOld)) {
                esamesierologicoNew.getEsamesierologicotabellaList().add(esamesierologicotabella);
                esamesierologicoNew = em.merge(esamesierologicoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = esamesierologicotabella.getId();
                if (findEsamesierologicotabella(id) == null) {
                    throw new NonexistentEntityException("The esamesierologicotabella with id " + id + " no longer exists.");
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
            Esamesierologicotabella esamesierologicotabella;
            try {
                esamesierologicotabella = em.getReference(Esamesierologicotabella.class, id);
                esamesierologicotabella.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The esamesierologicotabella with id " + id + " no longer exists.", enfe);
            }
            Esamesierologico esamesierologico = esamesierologicotabella.getEsamesierologico();
            if (esamesierologico != null) {
                esamesierologico.getEsamesierologicotabellaList().remove(esamesierologicotabella);
                esamesierologico = em.merge(esamesierologico);
            }
            em.remove(esamesierologicotabella);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Esamesierologicotabella> findEsamesierologicotabellaEntities() {
        return findEsamesierologicotabellaEntities(true, -1, -1);
    }

    public List<Esamesierologicotabella> findEsamesierologicotabellaEntities(int maxResults, int firstResult) {
        return findEsamesierologicotabellaEntities(false, maxResults, firstResult);
    }

    private List<Esamesierologicotabella> findEsamesierologicotabellaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Esamesierologicotabella.class));
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

    public Esamesierologicotabella findEsamesierologicotabella(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Esamesierologicotabella.class, id);
        } finally {
            em.close();
        }
    }

    public int getEsamesierologicotabellaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Esamesierologicotabella> rt = cq.from(Esamesierologicotabella.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
