/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Esameematochimicitabella;
import controller.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import bean.Esameematochimici;

/**
 *
 * @author Lodato
 */
public class EsameematochimicitabellaJpaController {

    public EsameematochimicitabellaJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Esameematochimicitabella esameematochimicitabella) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Esameematochimici esameematochimici = esameematochimicitabella.getEsameematochimici();
            if (esameematochimici != null) {
                esameematochimici = em.getReference(esameematochimici.getClass(), esameematochimici.getId());
                esameematochimicitabella.setEsameematochimici(esameematochimici);
            }
            em.persist(esameematochimicitabella);
            if (esameematochimici != null) {
                esameematochimici.getEsameematochimicitabellaList().add(esameematochimicitabella);
                esameematochimici = em.merge(esameematochimici);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Esameematochimicitabella esameematochimicitabella) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Esameematochimicitabella persistentEsameematochimicitabella = em.find(Esameematochimicitabella.class, esameematochimicitabella.getId());
            Esameematochimici esameematochimiciOld = persistentEsameematochimicitabella.getEsameematochimici();
            Esameematochimici esameematochimiciNew = esameematochimicitabella.getEsameematochimici();
            if (esameematochimiciNew != null) {
                esameematochimiciNew = em.getReference(esameematochimiciNew.getClass(), esameematochimiciNew.getId());
                esameematochimicitabella.setEsameematochimici(esameematochimiciNew);
            }
            esameematochimicitabella = em.merge(esameematochimicitabella);
            if (esameematochimiciOld != null && !esameematochimiciOld.equals(esameematochimiciNew)) {
                esameematochimiciOld.getEsameematochimicitabellaList().remove(esameematochimicitabella);
                esameematochimiciOld = em.merge(esameematochimiciOld);
            }
            if (esameematochimiciNew != null && !esameematochimiciNew.equals(esameematochimiciOld)) {
                esameematochimiciNew.getEsameematochimicitabellaList().add(esameematochimicitabella);
                esameematochimiciNew = em.merge(esameematochimiciNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = esameematochimicitabella.getId();
                if (findEsameematochimicitabella(id) == null) {
                    throw new NonexistentEntityException("The esameematochimicitabella with id " + id + " no longer exists.");
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
            Esameematochimicitabella esameematochimicitabella;
            try {
                esameematochimicitabella = em.getReference(Esameematochimicitabella.class, id);
                esameematochimicitabella.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The esameematochimicitabella with id " + id + " no longer exists.", enfe);
            }
            Esameematochimici esameematochimici = esameematochimicitabella.getEsameematochimici();
            if (esameematochimici != null) {
                esameematochimici.getEsameematochimicitabellaList().remove(esameematochimicitabella);
                esameematochimici = em.merge(esameematochimici);
            }
            em.remove(esameematochimicitabella);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Esameematochimicitabella> findEsameematochimicitabellaEntities() {
        return findEsameematochimicitabellaEntities(true, -1, -1);
    }

    public List<Esameematochimicitabella> findEsameematochimicitabellaEntities(int maxResults, int firstResult) {
        return findEsameematochimicitabellaEntities(false, maxResults, firstResult);
    }

    private List<Esameematochimicitabella> findEsameematochimicitabellaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Esameematochimicitabella.class));
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

    public Esameematochimicitabella findEsameematochimicitabella(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Esameematochimicitabella.class, id);
        } finally {
            em.close();
        }
    }

    public int getEsameematochimicitabellaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Esameematochimicitabella> rt = cq.from(Esameematochimicitabella.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
