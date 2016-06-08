/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Ecografiatabella;
import controller.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import bean.Ecografie;

/**
 *
 * @author Lodato
 */
public class EcografiatabellaJpaController {

    public EcografiatabellaJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ecografiatabella ecografiatabella) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ecografie ecografie = ecografiatabella.getEcografie();
            if (ecografie != null) {
                ecografie = em.getReference(ecografie.getClass(), ecografie.getId());
                ecografiatabella.setEcografie(ecografie);
            }
            em.persist(ecografiatabella);
            if (ecografie != null) {
                ecografie.getEcografiatabellaList().add(ecografiatabella);
                ecografie = em.merge(ecografie);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ecografiatabella ecografiatabella) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ecografiatabella persistentEcografiatabella = em.find(Ecografiatabella.class, ecografiatabella.getId());
            Ecografie ecografieOld = persistentEcografiatabella.getEcografie();
            Ecografie ecografieNew = ecografiatabella.getEcografie();
            if (ecografieNew != null) {
                ecografieNew = em.getReference(ecografieNew.getClass(), ecografieNew.getId());
                ecografiatabella.setEcografie(ecografieNew);
            }
            ecografiatabella = em.merge(ecografiatabella);
            if (ecografieOld != null && !ecografieOld.equals(ecografieNew)) {
                ecografieOld.getEcografiatabellaList().remove(ecografiatabella);
                ecografieOld = em.merge(ecografieOld);
            }
            if (ecografieNew != null && !ecografieNew.equals(ecografieOld)) {
                ecografieNew.getEcografiatabellaList().add(ecografiatabella);
                ecografieNew = em.merge(ecografieNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ecografiatabella.getId();
                if (findEcografiatabella(id) == null) {
                    throw new NonexistentEntityException("The ecografiatabella with id " + id + " no longer exists.");
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
            Ecografiatabella ecografiatabella;
            try {
                ecografiatabella = em.getReference(Ecografiatabella.class, id);
                ecografiatabella.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ecografiatabella with id " + id + " no longer exists.", enfe);
            }
            Ecografie ecografie = ecografiatabella.getEcografie();
            if (ecografie != null) {
                ecografie.getEcografiatabellaList().remove(ecografiatabella);
                ecografie = em.merge(ecografie);
            }
            em.remove(ecografiatabella);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ecografiatabella> findEcografiatabellaEntities() {
        return findEcografiatabellaEntities(true, -1, -1);
    }

    public List<Ecografiatabella> findEcografiatabellaEntities(int maxResults, int firstResult) {
        return findEcografiatabellaEntities(false, maxResults, firstResult);
    }

    private List<Ecografiatabella> findEcografiatabellaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ecografiatabella.class));
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

    public Ecografiatabella findEcografiatabella(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ecografiatabella.class, id);
        } finally {
            em.close();
        }
    }

    public int getEcografiatabellaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ecografiatabella> rt = cq.from(Ecografiatabella.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
