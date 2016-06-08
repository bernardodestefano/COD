/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Storiapreconcezionale;
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
public class StoriapreconcezionaleJpaController {

    public StoriapreconcezionaleJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Storiapreconcezionale storiapreconcezionale) {
        if (storiapreconcezionale.getCartellaostetricadigitaleList() == null) {
            storiapreconcezionale.setCartellaostetricadigitaleList(new ArrayList<Cartellaostetricadigitale>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Cartellaostetricadigitale> attachedCartellaostetricadigitaleList = new ArrayList<Cartellaostetricadigitale>();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitaleToAttach : storiapreconcezionale.getCartellaostetricadigitaleList()) {
                cartellaostetricadigitaleListCartellaostetricadigitaleToAttach = em.getReference(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getClass(), cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getId());
                attachedCartellaostetricadigitaleList.add(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach);
            }
            storiapreconcezionale.setCartellaostetricadigitaleList(attachedCartellaostetricadigitaleList);
            em.persist(storiapreconcezionale);
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitale : storiapreconcezionale.getCartellaostetricadigitaleList()) {
                Storiapreconcezionale oldStoriapreconcezionaleOfCartellaostetricadigitaleListCartellaostetricadigitale = cartellaostetricadigitaleListCartellaostetricadigitale.getStoriapreconcezionale();
                cartellaostetricadigitaleListCartellaostetricadigitale.setStoriapreconcezionale(storiapreconcezionale);
                cartellaostetricadigitaleListCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListCartellaostetricadigitale);
                if (oldStoriapreconcezionaleOfCartellaostetricadigitaleListCartellaostetricadigitale != null) {
                    oldStoriapreconcezionaleOfCartellaostetricadigitaleListCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListCartellaostetricadigitale);
                    oldStoriapreconcezionaleOfCartellaostetricadigitaleListCartellaostetricadigitale = em.merge(oldStoriapreconcezionaleOfCartellaostetricadigitaleListCartellaostetricadigitale);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Storiapreconcezionale storiapreconcezionale) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Storiapreconcezionale persistentStoriapreconcezionale = em.find(Storiapreconcezionale.class, storiapreconcezionale.getId());
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOld = persistentStoriapreconcezionale.getCartellaostetricadigitaleList();
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListNew = storiapreconcezionale.getCartellaostetricadigitaleList();
            List<String> illegalOrphanMessages = null;
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOldCartellaostetricadigitale : cartellaostetricadigitaleListOld) {
                if (!cartellaostetricadigitaleListNew.contains(cartellaostetricadigitaleListOldCartellaostetricadigitale)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cartellaostetricadigitale " + cartellaostetricadigitaleListOldCartellaostetricadigitale + " since its storiapreconcezionale field is not nullable.");
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
            storiapreconcezionale.setCartellaostetricadigitaleList(cartellaostetricadigitaleListNew);
            storiapreconcezionale = em.merge(storiapreconcezionale);
            for (Cartellaostetricadigitale cartellaostetricadigitaleListNewCartellaostetricadigitale : cartellaostetricadigitaleListNew) {
                if (!cartellaostetricadigitaleListOld.contains(cartellaostetricadigitaleListNewCartellaostetricadigitale)) {
                    Storiapreconcezionale oldStoriapreconcezionaleOfCartellaostetricadigitaleListNewCartellaostetricadigitale = cartellaostetricadigitaleListNewCartellaostetricadigitale.getStoriapreconcezionale();
                    cartellaostetricadigitaleListNewCartellaostetricadigitale.setStoriapreconcezionale(storiapreconcezionale);
                    cartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                    if (oldStoriapreconcezionaleOfCartellaostetricadigitaleListNewCartellaostetricadigitale != null && !oldStoriapreconcezionaleOfCartellaostetricadigitaleListNewCartellaostetricadigitale.equals(storiapreconcezionale)) {
                        oldStoriapreconcezionaleOfCartellaostetricadigitaleListNewCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                        oldStoriapreconcezionaleOfCartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(oldStoriapreconcezionaleOfCartellaostetricadigitaleListNewCartellaostetricadigitale);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = storiapreconcezionale.getId();
                if (findStoriapreconcezionale(id) == null) {
                    throw new NonexistentEntityException("The storiapreconcezionale with id " + id + " no longer exists.");
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
            Storiapreconcezionale storiapreconcezionale;
            try {
                storiapreconcezionale = em.getReference(Storiapreconcezionale.class, id);
                storiapreconcezionale.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The storiapreconcezionale with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOrphanCheck = storiapreconcezionale.getCartellaostetricadigitaleList();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale : cartellaostetricadigitaleListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Storiapreconcezionale (" + storiapreconcezionale + ") cannot be destroyed since the Cartellaostetricadigitale " + cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale + " in its cartellaostetricadigitaleList field has a non-nullable storiapreconcezionale field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(storiapreconcezionale);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Storiapreconcezionale> findStoriapreconcezionaleEntities() {
        return findStoriapreconcezionaleEntities(true, -1, -1);
    }

    public List<Storiapreconcezionale> findStoriapreconcezionaleEntities(int maxResults, int firstResult) {
        return findStoriapreconcezionaleEntities(false, maxResults, firstResult);
    }

    private List<Storiapreconcezionale> findStoriapreconcezionaleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Storiapreconcezionale.class));
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

    public Storiapreconcezionale findStoriapreconcezionale(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Storiapreconcezionale.class, id);
        } finally {
            em.close();
        }
    }

    public int getStoriapreconcezionaleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Storiapreconcezionale> rt = cq.from(Storiapreconcezionale.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
