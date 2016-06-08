/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Storiaostretricatabella;
import controller.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import bean.Storiaostetrica;

/**
 *
 * @author Lodato
 */
public class StoriaostretricatabellaJpaController {

    public StoriaostretricatabellaJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Storiaostretricatabella storiaostretricatabella) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Storiaostetrica storiaostetrica = storiaostretricatabella.getStoriaostetrica();
            if (storiaostetrica != null) {
                storiaostetrica = em.getReference(storiaostetrica.getClass(), storiaostetrica.getId());
                storiaostretricatabella.setStoriaostetrica(storiaostetrica);
            }
            em.persist(storiaostretricatabella);
            if (storiaostetrica != null) {
                storiaostetrica.getStoriaostretricatabellaList().add(storiaostretricatabella);
                storiaostetrica = em.merge(storiaostetrica);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Storiaostretricatabella storiaostretricatabella) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Storiaostretricatabella persistentStoriaostretricatabella = em.find(Storiaostretricatabella.class, storiaostretricatabella.getId());
            Storiaostetrica storiaostetricaOld = persistentStoriaostretricatabella.getStoriaostetrica();
            Storiaostetrica storiaostetricaNew = storiaostretricatabella.getStoriaostetrica();
            if (storiaostetricaNew != null) {
                storiaostetricaNew = em.getReference(storiaostetricaNew.getClass(), storiaostetricaNew.getId());
                storiaostretricatabella.setStoriaostetrica(storiaostetricaNew);
            }
            storiaostretricatabella = em.merge(storiaostretricatabella);
            if (storiaostetricaOld != null && !storiaostetricaOld.equals(storiaostetricaNew)) {
                storiaostetricaOld.getStoriaostretricatabellaList().remove(storiaostretricatabella);
                storiaostetricaOld = em.merge(storiaostetricaOld);
            }
            if (storiaostetricaNew != null && !storiaostetricaNew.equals(storiaostetricaOld)) {
                storiaostetricaNew.getStoriaostretricatabellaList().add(storiaostretricatabella);
                storiaostetricaNew = em.merge(storiaostetricaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = storiaostretricatabella.getId();
                if (findStoriaostretricatabella(id) == null) {
                    throw new NonexistentEntityException("The storiaostretricatabella with id " + id + " no longer exists.");
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
            Storiaostretricatabella storiaostretricatabella;
            try {
                storiaostretricatabella = em.getReference(Storiaostretricatabella.class, id);
                storiaostretricatabella.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The storiaostretricatabella with id " + id + " no longer exists.", enfe);
            }
            Storiaostetrica storiaostetrica = storiaostretricatabella.getStoriaostetrica();
            if (storiaostetrica != null) {
                storiaostetrica.getStoriaostretricatabellaList().remove(storiaostretricatabella);
                storiaostetrica = em.merge(storiaostetrica);
            }
            em.remove(storiaostretricatabella);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Storiaostretricatabella> findStoriaostretricatabellaEntities() {
        return findStoriaostretricatabellaEntities(true, -1, -1);
    }

    public List<Storiaostretricatabella> findStoriaostretricatabellaEntities(int maxResults, int firstResult) {
        return findStoriaostretricatabellaEntities(false, maxResults, firstResult);
    }

    private List<Storiaostretricatabella> findStoriaostretricatabellaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Storiaostretricatabella.class));
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

    public Storiaostretricatabella findStoriaostretricatabella(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Storiaostretricatabella.class, id);
        } finally {
            em.close();
        }
    }

    public int getStoriaostretricatabellaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Storiaostretricatabella> rt = cq.from(Storiaostretricatabella.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
