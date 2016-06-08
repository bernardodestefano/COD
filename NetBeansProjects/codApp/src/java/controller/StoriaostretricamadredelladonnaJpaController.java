/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Storiaostretricamadredelladonna;
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
public class StoriaostretricamadredelladonnaJpaController {

    public StoriaostretricamadredelladonnaJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Storiaostretricamadredelladonna storiaostretricamadredelladonna) {
        if (storiaostretricamadredelladonna.getCartellaostetricadigitaleList() == null) {
            storiaostretricamadredelladonna.setCartellaostetricadigitaleList(new ArrayList<Cartellaostetricadigitale>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Cartellaostetricadigitale> attachedCartellaostetricadigitaleList = new ArrayList<Cartellaostetricadigitale>();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitaleToAttach : storiaostretricamadredelladonna.getCartellaostetricadigitaleList()) {
                cartellaostetricadigitaleListCartellaostetricadigitaleToAttach = em.getReference(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getClass(), cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getId());
                attachedCartellaostetricadigitaleList.add(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach);
            }
            storiaostretricamadredelladonna.setCartellaostetricadigitaleList(attachedCartellaostetricadigitaleList);
            em.persist(storiaostretricamadredelladonna);
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitale : storiaostretricamadredelladonna.getCartellaostetricadigitaleList()) {
                Storiaostretricamadredelladonna oldStoriaostretricamadredelladonnaOfCartellaostetricadigitaleListCartellaostetricadigitale = cartellaostetricadigitaleListCartellaostetricadigitale.getStoriaostretricamadredelladonna();
                cartellaostetricadigitaleListCartellaostetricadigitale.setStoriaostretricamadredelladonna(storiaostretricamadredelladonna);
                cartellaostetricadigitaleListCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListCartellaostetricadigitale);
                if (oldStoriaostretricamadredelladonnaOfCartellaostetricadigitaleListCartellaostetricadigitale != null) {
                    oldStoriaostretricamadredelladonnaOfCartellaostetricadigitaleListCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListCartellaostetricadigitale);
                    oldStoriaostretricamadredelladonnaOfCartellaostetricadigitaleListCartellaostetricadigitale = em.merge(oldStoriaostretricamadredelladonnaOfCartellaostetricadigitaleListCartellaostetricadigitale);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Storiaostretricamadredelladonna storiaostretricamadredelladonna) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Storiaostretricamadredelladonna persistentStoriaostretricamadredelladonna = em.find(Storiaostretricamadredelladonna.class, storiaostretricamadredelladonna.getId());
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOld = persistentStoriaostretricamadredelladonna.getCartellaostetricadigitaleList();
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListNew = storiaostretricamadredelladonna.getCartellaostetricadigitaleList();
            List<String> illegalOrphanMessages = null;
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOldCartellaostetricadigitale : cartellaostetricadigitaleListOld) {
                if (!cartellaostetricadigitaleListNew.contains(cartellaostetricadigitaleListOldCartellaostetricadigitale)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cartellaostetricadigitale " + cartellaostetricadigitaleListOldCartellaostetricadigitale + " since its storiaostretricamadredelladonna field is not nullable.");
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
            storiaostretricamadredelladonna.setCartellaostetricadigitaleList(cartellaostetricadigitaleListNew);
            storiaostretricamadredelladonna = em.merge(storiaostretricamadredelladonna);
            for (Cartellaostetricadigitale cartellaostetricadigitaleListNewCartellaostetricadigitale : cartellaostetricadigitaleListNew) {
                if (!cartellaostetricadigitaleListOld.contains(cartellaostetricadigitaleListNewCartellaostetricadigitale)) {
                    Storiaostretricamadredelladonna oldStoriaostretricamadredelladonnaOfCartellaostetricadigitaleListNewCartellaostetricadigitale = cartellaostetricadigitaleListNewCartellaostetricadigitale.getStoriaostretricamadredelladonna();
                    cartellaostetricadigitaleListNewCartellaostetricadigitale.setStoriaostretricamadredelladonna(storiaostretricamadredelladonna);
                    cartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                    if (oldStoriaostretricamadredelladonnaOfCartellaostetricadigitaleListNewCartellaostetricadigitale != null && !oldStoriaostretricamadredelladonnaOfCartellaostetricadigitaleListNewCartellaostetricadigitale.equals(storiaostretricamadredelladonna)) {
                        oldStoriaostretricamadredelladonnaOfCartellaostetricadigitaleListNewCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                        oldStoriaostretricamadredelladonnaOfCartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(oldStoriaostretricamadredelladonnaOfCartellaostetricadigitaleListNewCartellaostetricadigitale);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = storiaostretricamadredelladonna.getId();
                if (findStoriaostretricamadredelladonna(id) == null) {
                    throw new NonexistentEntityException("The storiaostretricamadredelladonna with id " + id + " no longer exists.");
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
            Storiaostretricamadredelladonna storiaostretricamadredelladonna;
            try {
                storiaostretricamadredelladonna = em.getReference(Storiaostretricamadredelladonna.class, id);
                storiaostretricamadredelladonna.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The storiaostretricamadredelladonna with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOrphanCheck = storiaostretricamadredelladonna.getCartellaostetricadigitaleList();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale : cartellaostetricadigitaleListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Storiaostretricamadredelladonna (" + storiaostretricamadredelladonna + ") cannot be destroyed since the Cartellaostetricadigitale " + cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale + " in its cartellaostetricadigitaleList field has a non-nullable storiaostretricamadredelladonna field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(storiaostretricamadredelladonna);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Storiaostretricamadredelladonna> findStoriaostretricamadredelladonnaEntities() {
        return findStoriaostretricamadredelladonnaEntities(true, -1, -1);
    }

    public List<Storiaostretricamadredelladonna> findStoriaostretricamadredelladonnaEntities(int maxResults, int firstResult) {
        return findStoriaostretricamadredelladonnaEntities(false, maxResults, firstResult);
    }

    private List<Storiaostretricamadredelladonna> findStoriaostretricamadredelladonnaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Storiaostretricamadredelladonna.class));
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

    public Storiaostretricamadredelladonna findStoriaostretricamadredelladonna(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Storiaostretricamadredelladonna.class, id);
        } finally {
            em.close();
        }
    }

    public int getStoriaostretricamadredelladonnaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Storiaostretricamadredelladonna> rt = cq.from(Storiaostretricamadredelladonna.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
