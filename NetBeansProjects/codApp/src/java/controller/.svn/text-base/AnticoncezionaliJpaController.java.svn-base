/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Anticoncezionali;
import controller.exceptions.IllegalOrphanException;
import controller.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import bean.Cartellaostetricadigitale;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lodato
 */
public class AnticoncezionaliJpaController {

    public AnticoncezionaliJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Anticoncezionali anticoncezionali) {
        if (anticoncezionali.getCartellaostetricadigitaleList() == null) {
            anticoncezionali.setCartellaostetricadigitaleList(new ArrayList<Cartellaostetricadigitale>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Cartellaostetricadigitale> attachedCartellaostetricadigitaleList = new ArrayList<Cartellaostetricadigitale>();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitaleToAttach : anticoncezionali.getCartellaostetricadigitaleList()) {
                cartellaostetricadigitaleListCartellaostetricadigitaleToAttach = em.getReference(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getClass(), cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getId());
                attachedCartellaostetricadigitaleList.add(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach);
            }
            anticoncezionali.setCartellaostetricadigitaleList(attachedCartellaostetricadigitaleList);
            em.persist(anticoncezionali);
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitale : anticoncezionali.getCartellaostetricadigitaleList()) {
                Anticoncezionali oldAnticoncezionaliOfCartellaostetricadigitaleListCartellaostetricadigitale = cartellaostetricadigitaleListCartellaostetricadigitale.getAnticoncezionali();
                cartellaostetricadigitaleListCartellaostetricadigitale.setAnticoncezionali(anticoncezionali);
                cartellaostetricadigitaleListCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListCartellaostetricadigitale);
                if (oldAnticoncezionaliOfCartellaostetricadigitaleListCartellaostetricadigitale != null) {
                    oldAnticoncezionaliOfCartellaostetricadigitaleListCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListCartellaostetricadigitale);
                    oldAnticoncezionaliOfCartellaostetricadigitaleListCartellaostetricadigitale = em.merge(oldAnticoncezionaliOfCartellaostetricadigitaleListCartellaostetricadigitale);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Anticoncezionali anticoncezionali) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Anticoncezionali persistentAnticoncezionali = em.find(Anticoncezionali.class, anticoncezionali.getId());
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOld = persistentAnticoncezionali.getCartellaostetricadigitaleList();
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListNew = anticoncezionali.getCartellaostetricadigitaleList();
            List<String> illegalOrphanMessages = null;
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOldCartellaostetricadigitale : cartellaostetricadigitaleListOld) {
                if (!cartellaostetricadigitaleListNew.contains(cartellaostetricadigitaleListOldCartellaostetricadigitale)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cartellaostetricadigitale " + cartellaostetricadigitaleListOldCartellaostetricadigitale + " since its anticoncezionali field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Cartellaostetricadigitale> attachedCartellaostetricadigitaleListNew = new ArrayList<Cartellaostetricadigitale>();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach : cartellaostetricadigitaleListNew) {
                cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach = em.getReference(cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach.getClass(), cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach.getId());
                attachedCartellaostetricadigitaleListNew.add(cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach);
            }
            cartellaostetricadigitaleListNew = attachedCartellaostetricadigitaleListNew;
            anticoncezionali.setCartellaostetricadigitaleList(cartellaostetricadigitaleListNew);
            anticoncezionali = em.merge(anticoncezionali);
            for (Cartellaostetricadigitale cartellaostetricadigitaleListNewCartellaostetricadigitale : cartellaostetricadigitaleListNew) {
                if (!cartellaostetricadigitaleListOld.contains(cartellaostetricadigitaleListNewCartellaostetricadigitale)) {
                    Anticoncezionali oldAnticoncezionaliOfCartellaostetricadigitaleListNewCartellaostetricadigitale = cartellaostetricadigitaleListNewCartellaostetricadigitale.getAnticoncezionali();
                    cartellaostetricadigitaleListNewCartellaostetricadigitale.setAnticoncezionali(anticoncezionali);
                    cartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                    if (oldAnticoncezionaliOfCartellaostetricadigitaleListNewCartellaostetricadigitale != null && !oldAnticoncezionaliOfCartellaostetricadigitaleListNewCartellaostetricadigitale.equals(anticoncezionali)) {
                        oldAnticoncezionaliOfCartellaostetricadigitaleListNewCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                        oldAnticoncezionaliOfCartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(oldAnticoncezionaliOfCartellaostetricadigitaleListNewCartellaostetricadigitale);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = anticoncezionali.getId();
                if (findAnticoncezionali(id) == null) {
                    throw new NonexistentEntityException("The anticoncezionali with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Anticoncezionali anticoncezionali;
            try {
                anticoncezionali = em.getReference(Anticoncezionali.class, id);
                anticoncezionali.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The anticoncezionali with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOrphanCheck = anticoncezionali.getCartellaostetricadigitaleList();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale : cartellaostetricadigitaleListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Anticoncezionali (" + anticoncezionali + ") cannot be destroyed since the Cartellaostetricadigitale " + cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale + " in its cartellaostetricadigitaleList field has a non-nullable anticoncezionali field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(anticoncezionali);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Anticoncezionali> findAnticoncezionaliEntities() {
        return findAnticoncezionaliEntities(true, -1, -1);
    }

    public List<Anticoncezionali> findAnticoncezionaliEntities(int maxResults, int firstResult) {
        return findAnticoncezionaliEntities(false, maxResults, firstResult);
    }

    private List<Anticoncezionali> findAnticoncezionaliEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Anticoncezionali.class));
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

    public Anticoncezionali findAnticoncezionali(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Anticoncezionali.class, id);
        } finally {
            em.close();
        }
    }

    public int getAnticoncezionaliCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Anticoncezionali> rt = cq.from(Anticoncezionali.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
