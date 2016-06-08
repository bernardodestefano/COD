/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Anamnesipersonale;
import controller.exceptions.IllegalOrphanException;
import controller.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import bean.Disturbi;
import bean.Cartellaostetricadigitale;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lodato
 */
public class AnamnesipersonaleJpaController {

    public AnamnesipersonaleJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Anamnesipersonale anamnesipersonale) {
        if (anamnesipersonale.getCartellaostetricadigitaleList() == null) {
            anamnesipersonale.setCartellaostetricadigitaleList(new ArrayList<Cartellaostetricadigitale>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Disturbi disturbi = anamnesipersonale.getDisturbi();
            if (disturbi != null) {
                disturbi = em.getReference(disturbi.getClass(), disturbi.getAnamnesiPersonaleid());
                anamnesipersonale.setDisturbi(disturbi);
            }
            List<Cartellaostetricadigitale> attachedCartellaostetricadigitaleList = new ArrayList<Cartellaostetricadigitale>();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitaleToAttach : anamnesipersonale.getCartellaostetricadigitaleList()) {
                cartellaostetricadigitaleListCartellaostetricadigitaleToAttach = em.getReference(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getClass(), cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getId());
                attachedCartellaostetricadigitaleList.add(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach);
            }
            anamnesipersonale.setCartellaostetricadigitaleList(attachedCartellaostetricadigitaleList);
            em.persist(anamnesipersonale);
            if (disturbi != null) {
                Anamnesipersonale oldAnamnesipersonaleOfDisturbi = disturbi.getAnamnesipersonale();
                if (oldAnamnesipersonaleOfDisturbi != null) {
                    oldAnamnesipersonaleOfDisturbi.setDisturbi(null);
                    oldAnamnesipersonaleOfDisturbi = em.merge(oldAnamnesipersonaleOfDisturbi);
                }
                disturbi.setAnamnesipersonale(anamnesipersonale);
                disturbi = em.merge(disturbi);
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitale : anamnesipersonale.getCartellaostetricadigitaleList()) {
                Anamnesipersonale oldAnamnesipersonaleOfCartellaostetricadigitaleListCartellaostetricadigitale = cartellaostetricadigitaleListCartellaostetricadigitale.getAnamnesipersonale();
                cartellaostetricadigitaleListCartellaostetricadigitale.setAnamnesipersonale(anamnesipersonale);
                cartellaostetricadigitaleListCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListCartellaostetricadigitale);
                if (oldAnamnesipersonaleOfCartellaostetricadigitaleListCartellaostetricadigitale != null) {
                    oldAnamnesipersonaleOfCartellaostetricadigitaleListCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListCartellaostetricadigitale);
                    oldAnamnesipersonaleOfCartellaostetricadigitaleListCartellaostetricadigitale = em.merge(oldAnamnesipersonaleOfCartellaostetricadigitaleListCartellaostetricadigitale);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Anamnesipersonale anamnesipersonale) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Anamnesipersonale persistentAnamnesipersonale = em.find(Anamnesipersonale.class, anamnesipersonale.getId());
            Disturbi disturbiOld = persistentAnamnesipersonale.getDisturbi();
            Disturbi disturbiNew = anamnesipersonale.getDisturbi();
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOld = persistentAnamnesipersonale.getCartellaostetricadigitaleList();
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListNew = anamnesipersonale.getCartellaostetricadigitaleList();
            List<String> illegalOrphanMessages = null;
            if (disturbiOld != null && !disturbiOld.equals(disturbiNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Disturbi " + disturbiOld + " since its anamnesipersonale field is not nullable.");
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOldCartellaostetricadigitale : cartellaostetricadigitaleListOld) {
                if (!cartellaostetricadigitaleListNew.contains(cartellaostetricadigitaleListOldCartellaostetricadigitale)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cartellaostetricadigitale " + cartellaostetricadigitaleListOldCartellaostetricadigitale + " since its anamnesipersonale field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (disturbiNew != null) {
                disturbiNew = em.getReference(disturbiNew.getClass(), disturbiNew.getAnamnesiPersonaleid());
                anamnesipersonale.setDisturbi(disturbiNew);
            }
            List<Cartellaostetricadigitale> attachedCartellaostetricadigitaleListNew = new ArrayList<Cartellaostetricadigitale>();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach : cartellaostetricadigitaleListNew) {
                cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach = em.getReference(cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach.getClass(), cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach.getId());
                attachedCartellaostetricadigitaleListNew.add(cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach);
            }
            cartellaostetricadigitaleListNew = attachedCartellaostetricadigitaleListNew;
            anamnesipersonale.setCartellaostetricadigitaleList(cartellaostetricadigitaleListNew);
            anamnesipersonale = em.merge(anamnesipersonale);
            if (disturbiNew != null && !disturbiNew.equals(disturbiOld)) {
                Anamnesipersonale oldAnamnesipersonaleOfDisturbi = disturbiNew.getAnamnesipersonale();
                if (oldAnamnesipersonaleOfDisturbi != null) {
                    oldAnamnesipersonaleOfDisturbi.setDisturbi(null);
                    oldAnamnesipersonaleOfDisturbi = em.merge(oldAnamnesipersonaleOfDisturbi);
                }
                disturbiNew.setAnamnesipersonale(anamnesipersonale);
                disturbiNew = em.merge(disturbiNew);
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListNewCartellaostetricadigitale : cartellaostetricadigitaleListNew) {
                if (!cartellaostetricadigitaleListOld.contains(cartellaostetricadigitaleListNewCartellaostetricadigitale)) {
                    Anamnesipersonale oldAnamnesipersonaleOfCartellaostetricadigitaleListNewCartellaostetricadigitale = cartellaostetricadigitaleListNewCartellaostetricadigitale.getAnamnesipersonale();
                    cartellaostetricadigitaleListNewCartellaostetricadigitale.setAnamnesipersonale(anamnesipersonale);
                    cartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                    if (oldAnamnesipersonaleOfCartellaostetricadigitaleListNewCartellaostetricadigitale != null && !oldAnamnesipersonaleOfCartellaostetricadigitaleListNewCartellaostetricadigitale.equals(anamnesipersonale)) {
                        oldAnamnesipersonaleOfCartellaostetricadigitaleListNewCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                        oldAnamnesipersonaleOfCartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(oldAnamnesipersonaleOfCartellaostetricadigitaleListNewCartellaostetricadigitale);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = anamnesipersonale.getId();
                if (findAnamnesipersonale(id) == null) {
                    throw new NonexistentEntityException("The anamnesipersonale with id " + id + " no longer exists.");
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
            Anamnesipersonale anamnesipersonale;
            try {
                anamnesipersonale = em.getReference(Anamnesipersonale.class, id);
                anamnesipersonale.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The anamnesipersonale with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Disturbi disturbiOrphanCheck = anamnesipersonale.getDisturbi();
            if (disturbiOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Anamnesipersonale (" + anamnesipersonale + ") cannot be destroyed since the Disturbi " + disturbiOrphanCheck + " in its disturbi field has a non-nullable anamnesipersonale field.");
            }
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOrphanCheck = anamnesipersonale.getCartellaostetricadigitaleList();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale : cartellaostetricadigitaleListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Anamnesipersonale (" + anamnesipersonale + ") cannot be destroyed since the Cartellaostetricadigitale " + cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale + " in its cartellaostetricadigitaleList field has a non-nullable anamnesipersonale field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(anamnesipersonale);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Anamnesipersonale> findAnamnesipersonaleEntities() {
        return findAnamnesipersonaleEntities(true, -1, -1);
    }

    public List<Anamnesipersonale> findAnamnesipersonaleEntities(int maxResults, int firstResult) {
        return findAnamnesipersonaleEntities(false, maxResults, firstResult);
    }

    private List<Anamnesipersonale> findAnamnesipersonaleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Anamnesipersonale.class));
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

    public Anamnesipersonale findAnamnesipersonale(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Anamnesipersonale.class, id);
        } finally {
            em.close();
        }
    }

    public int getAnamnesipersonaleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Anamnesipersonale> rt = cq.from(Anamnesipersonale.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
