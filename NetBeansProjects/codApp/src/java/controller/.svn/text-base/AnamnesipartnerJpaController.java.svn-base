/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Anamnesipartner;
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
public class AnamnesipartnerJpaController {

    public AnamnesipartnerJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Anamnesipartner anamnesipartner) {
        if (anamnesipartner.getCartellaostetricadigitaleList() == null) {
            anamnesipartner.setCartellaostetricadigitaleList(new ArrayList<Cartellaostetricadigitale>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Cartellaostetricadigitale> attachedCartellaostetricadigitaleList = new ArrayList<Cartellaostetricadigitale>();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitaleToAttach : anamnesipartner.getCartellaostetricadigitaleList()) {
                cartellaostetricadigitaleListCartellaostetricadigitaleToAttach = em.getReference(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getClass(), cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getId());
                attachedCartellaostetricadigitaleList.add(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach);
            }
            anamnesipartner.setCartellaostetricadigitaleList(attachedCartellaostetricadigitaleList);
            em.persist(anamnesipartner);
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitale : anamnesipartner.getCartellaostetricadigitaleList()) {
                Anamnesipartner oldAnamnesipartnerOfCartellaostetricadigitaleListCartellaostetricadigitale = cartellaostetricadigitaleListCartellaostetricadigitale.getAnamnesipartner();
                cartellaostetricadigitaleListCartellaostetricadigitale.setAnamnesipartner(anamnesipartner);
                cartellaostetricadigitaleListCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListCartellaostetricadigitale);
                if (oldAnamnesipartnerOfCartellaostetricadigitaleListCartellaostetricadigitale != null) {
                    oldAnamnesipartnerOfCartellaostetricadigitaleListCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListCartellaostetricadigitale);
                    oldAnamnesipartnerOfCartellaostetricadigitaleListCartellaostetricadigitale = em.merge(oldAnamnesipartnerOfCartellaostetricadigitaleListCartellaostetricadigitale);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Anamnesipartner anamnesipartner) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Anamnesipartner persistentAnamnesipartner = em.find(Anamnesipartner.class, anamnesipartner.getId());
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOld = persistentAnamnesipartner.getCartellaostetricadigitaleList();
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListNew = anamnesipartner.getCartellaostetricadigitaleList();
            List<String> illegalOrphanMessages = null;
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOldCartellaostetricadigitale : cartellaostetricadigitaleListOld) {
                if (!cartellaostetricadigitaleListNew.contains(cartellaostetricadigitaleListOldCartellaostetricadigitale)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cartellaostetricadigitale " + cartellaostetricadigitaleListOldCartellaostetricadigitale + " since its anamnesipartner field is not nullable.");
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
            anamnesipartner.setCartellaostetricadigitaleList(cartellaostetricadigitaleListNew);
            anamnesipartner = em.merge(anamnesipartner);
            for (Cartellaostetricadigitale cartellaostetricadigitaleListNewCartellaostetricadigitale : cartellaostetricadigitaleListNew) {
                if (!cartellaostetricadigitaleListOld.contains(cartellaostetricadigitaleListNewCartellaostetricadigitale)) {
                    Anamnesipartner oldAnamnesipartnerOfCartellaostetricadigitaleListNewCartellaostetricadigitale = cartellaostetricadigitaleListNewCartellaostetricadigitale.getAnamnesipartner();
                    cartellaostetricadigitaleListNewCartellaostetricadigitale.setAnamnesipartner(anamnesipartner);
                    cartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                    if (oldAnamnesipartnerOfCartellaostetricadigitaleListNewCartellaostetricadigitale != null && !oldAnamnesipartnerOfCartellaostetricadigitaleListNewCartellaostetricadigitale.equals(anamnesipartner)) {
                        oldAnamnesipartnerOfCartellaostetricadigitaleListNewCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                        oldAnamnesipartnerOfCartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(oldAnamnesipartnerOfCartellaostetricadigitaleListNewCartellaostetricadigitale);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = anamnesipartner.getId();
                if (findAnamnesipartner(id) == null) {
                    throw new NonexistentEntityException("The anamnesipartner with id " + id + " no longer exists.");
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
            Anamnesipartner anamnesipartner;
            try {
                anamnesipartner = em.getReference(Anamnesipartner.class, id);
                anamnesipartner.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The anamnesipartner with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOrphanCheck = anamnesipartner.getCartellaostetricadigitaleList();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale : cartellaostetricadigitaleListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Anamnesipartner (" + anamnesipartner + ") cannot be destroyed since the Cartellaostetricadigitale " + cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale + " in its cartellaostetricadigitaleList field has a non-nullable anamnesipartner field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(anamnesipartner);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Anamnesipartner> findAnamnesipartnerEntities() {
        return findAnamnesipartnerEntities(true, -1, -1);
    }

    public List<Anamnesipartner> findAnamnesipartnerEntities(int maxResults, int firstResult) {
        return findAnamnesipartnerEntities(false, maxResults, firstResult);
    }

    private List<Anamnesipartner> findAnamnesipartnerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Anamnesipartner.class));
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

    public Anamnesipartner findAnamnesipartner(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Anamnesipartner.class, id);
        } finally {
            em.close();
        }
    }

    public int getAnamnesipartnerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Anamnesipartner> rt = cq.from(Anamnesipartner.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
