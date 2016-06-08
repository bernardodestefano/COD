/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Disturbi;
import controller.exceptions.IllegalOrphanException;
import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import bean.Anamnesipersonale;
import java.util.ArrayList;

/**
 *
 * @author Lodato
 */
public class DisturbiJpaController {

    public DisturbiJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Disturbi disturbi) throws IllegalOrphanException, PreexistingEntityException, Exception {
        List<String> illegalOrphanMessages = null;
        Anamnesipersonale anamnesipersonaleOrphanCheck = disturbi.getAnamnesipersonale();
        if (anamnesipersonaleOrphanCheck != null) {
            Disturbi oldDisturbiOfAnamnesipersonale = anamnesipersonaleOrphanCheck.getDisturbi();
            if (oldDisturbiOfAnamnesipersonale != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Anamnesipersonale " + anamnesipersonaleOrphanCheck + " already has an item of type Disturbi whose anamnesipersonale column cannot be null. Please make another selection for the anamnesipersonale field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Anamnesipersonale anamnesipersonale = disturbi.getAnamnesipersonale();
            if (anamnesipersonale != null) {
                anamnesipersonale = em.getReference(anamnesipersonale.getClass(), anamnesipersonale.getId());
                disturbi.setAnamnesipersonale(anamnesipersonale);
            }
            em.persist(disturbi);
            if (anamnesipersonale != null) {
                anamnesipersonale.setDisturbi(disturbi);
                anamnesipersonale = em.merge(anamnesipersonale);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDisturbi(disturbi.getAnamnesiPersonaleid()) != null) {
                throw new PreexistingEntityException("Disturbi " + disturbi + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Disturbi disturbi) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Disturbi persistentDisturbi = em.find(Disturbi.class, disturbi.getAnamnesiPersonaleid());
            Anamnesipersonale anamnesipersonaleOld = persistentDisturbi.getAnamnesipersonale();
            Anamnesipersonale anamnesipersonaleNew = disturbi.getAnamnesipersonale();
            List<String> illegalOrphanMessages = null;
            if (anamnesipersonaleNew != null && !anamnesipersonaleNew.equals(anamnesipersonaleOld)) {
                Disturbi oldDisturbiOfAnamnesipersonale = anamnesipersonaleNew.getDisturbi();
                if (oldDisturbiOfAnamnesipersonale != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Anamnesipersonale " + anamnesipersonaleNew + " already has an item of type Disturbi whose anamnesipersonale column cannot be null. Please make another selection for the anamnesipersonale field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (anamnesipersonaleNew != null) {
                anamnesipersonaleNew = em.getReference(anamnesipersonaleNew.getClass(), anamnesipersonaleNew.getId());
                disturbi.setAnamnesipersonale(anamnesipersonaleNew);
            }
            disturbi = em.merge(disturbi);
            if (anamnesipersonaleOld != null && !anamnesipersonaleOld.equals(anamnesipersonaleNew)) {
                anamnesipersonaleOld.setDisturbi(null);
                anamnesipersonaleOld = em.merge(anamnesipersonaleOld);
            }
            if (anamnesipersonaleNew != null && !anamnesipersonaleNew.equals(anamnesipersonaleOld)) {
                anamnesipersonaleNew.setDisturbi(disturbi);
                anamnesipersonaleNew = em.merge(anamnesipersonaleNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = disturbi.getAnamnesiPersonaleid();
                if (findDisturbi(id) == null) {
                    throw new NonexistentEntityException("The disturbi with id " + id + " no longer exists.");
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
            Disturbi disturbi;
            try {
                disturbi = em.getReference(Disturbi.class, id);
                disturbi.getAnamnesiPersonaleid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The disturbi with id " + id + " no longer exists.", enfe);
            }
            Anamnesipersonale anamnesipersonale = disturbi.getAnamnesipersonale();
            if (anamnesipersonale != null) {
                anamnesipersonale.setDisturbi(null);
                anamnesipersonale = em.merge(anamnesipersonale);
            }
            em.remove(disturbi);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Disturbi> findDisturbiEntities() {
        return findDisturbiEntities(true, -1, -1);
    }

    public List<Disturbi> findDisturbiEntities(int maxResults, int firstResult) {
        return findDisturbiEntities(false, maxResults, firstResult);
    }

    private List<Disturbi> findDisturbiEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Disturbi.class));
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

    public Disturbi findDisturbi(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Disturbi.class, id);
        } finally {
            em.close();
        }
    }

    public int getDisturbiCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Disturbi> rt = cq.from(Disturbi.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
