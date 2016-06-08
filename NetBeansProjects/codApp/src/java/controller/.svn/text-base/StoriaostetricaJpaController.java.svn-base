/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Storiaostetrica;
import controller.exceptions.IllegalOrphanException;
import controller.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import bean.Storiaostretricatabella;
import java.util.ArrayList;
import java.util.List;
import bean.Cartellaostetricadigitale;

/**
 *
 * @author Lodato
 */
public class StoriaostetricaJpaController {

    public StoriaostetricaJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Storiaostetrica storiaostetrica) {
        if (storiaostetrica.getStoriaostretricatabellaList() == null) {
            storiaostetrica.setStoriaostretricatabellaList(new ArrayList<Storiaostretricatabella>());
        }
        if (storiaostetrica.getCartellaostetricadigitaleList() == null) {
            storiaostetrica.setCartellaostetricadigitaleList(new ArrayList<Cartellaostetricadigitale>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Storiaostretricatabella> attachedStoriaostretricatabellaList = new ArrayList<Storiaostretricatabella>();
            for (Storiaostretricatabella storiaostretricatabellaListStoriaostretricatabellaToAttach : storiaostetrica.getStoriaostretricatabellaList()) {
                storiaostretricatabellaListStoriaostretricatabellaToAttach = em.getReference(storiaostretricatabellaListStoriaostretricatabellaToAttach.getClass(), storiaostretricatabellaListStoriaostretricatabellaToAttach.getId());
                attachedStoriaostretricatabellaList.add(storiaostretricatabellaListStoriaostretricatabellaToAttach);
            }
            storiaostetrica.setStoriaostretricatabellaList(attachedStoriaostretricatabellaList);
            List<Cartellaostetricadigitale> attachedCartellaostetricadigitaleList = new ArrayList<Cartellaostetricadigitale>();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitaleToAttach : storiaostetrica.getCartellaostetricadigitaleList()) {
                cartellaostetricadigitaleListCartellaostetricadigitaleToAttach = em.getReference(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getClass(), cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getId());
                attachedCartellaostetricadigitaleList.add(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach);
            }
            storiaostetrica.setCartellaostetricadigitaleList(attachedCartellaostetricadigitaleList);
            em.persist(storiaostetrica);
            for (Storiaostretricatabella storiaostretricatabellaListStoriaostretricatabella : storiaostetrica.getStoriaostretricatabellaList()) {
                Storiaostetrica oldStoriaostetricaOfStoriaostretricatabellaListStoriaostretricatabella = storiaostretricatabellaListStoriaostretricatabella.getStoriaostetrica();
                storiaostretricatabellaListStoriaostretricatabella.setStoriaostetrica(storiaostetrica);
                storiaostretricatabellaListStoriaostretricatabella = em.merge(storiaostretricatabellaListStoriaostretricatabella);
                if (oldStoriaostetricaOfStoriaostretricatabellaListStoriaostretricatabella != null) {
                    oldStoriaostetricaOfStoriaostretricatabellaListStoriaostretricatabella.getStoriaostretricatabellaList().remove(storiaostretricatabellaListStoriaostretricatabella);
                    oldStoriaostetricaOfStoriaostretricatabellaListStoriaostretricatabella = em.merge(oldStoriaostetricaOfStoriaostretricatabellaListStoriaostretricatabella);
                }
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitale : storiaostetrica.getCartellaostetricadigitaleList()) {
                Storiaostetrica oldStoriaostetricaOfCartellaostetricadigitaleListCartellaostetricadigitale = cartellaostetricadigitaleListCartellaostetricadigitale.getStoriaostetrica();
                cartellaostetricadigitaleListCartellaostetricadigitale.setStoriaostetrica(storiaostetrica);
                cartellaostetricadigitaleListCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListCartellaostetricadigitale);
                if (oldStoriaostetricaOfCartellaostetricadigitaleListCartellaostetricadigitale != null) {
                    oldStoriaostetricaOfCartellaostetricadigitaleListCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListCartellaostetricadigitale);
                    oldStoriaostetricaOfCartellaostetricadigitaleListCartellaostetricadigitale = em.merge(oldStoriaostetricaOfCartellaostetricadigitaleListCartellaostetricadigitale);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Storiaostetrica storiaostetrica) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Storiaostetrica persistentStoriaostetrica = em.find(Storiaostetrica.class, storiaostetrica.getId());
            List<Storiaostretricatabella> storiaostretricatabellaListOld = persistentStoriaostetrica.getStoriaostretricatabellaList();
            List<Storiaostretricatabella> storiaostretricatabellaListNew = storiaostetrica.getStoriaostretricatabellaList();
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOld = persistentStoriaostetrica.getCartellaostetricadigitaleList();
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListNew = storiaostetrica.getCartellaostetricadigitaleList();
            List<String> illegalOrphanMessages = null;
            for (Storiaostretricatabella storiaostretricatabellaListOldStoriaostretricatabella : storiaostretricatabellaListOld) {
                if (!storiaostretricatabellaListNew.contains(storiaostretricatabellaListOldStoriaostretricatabella)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Storiaostretricatabella " + storiaostretricatabellaListOldStoriaostretricatabella + " since its storiaostetrica field is not nullable.");
                }
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOldCartellaostetricadigitale : cartellaostetricadigitaleListOld) {
                if (!cartellaostetricadigitaleListNew.contains(cartellaostetricadigitaleListOldCartellaostetricadigitale)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cartellaostetricadigitale " + cartellaostetricadigitaleListOldCartellaostetricadigitale + " since its storiaostetrica field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Storiaostretricatabella> attachedStoriaostretricatabellaListNew = new ArrayList<Storiaostretricatabella>();
            for (Storiaostretricatabella storiaostretricatabellaListNewStoriaostretricatabellaToAttach : storiaostretricatabellaListNew) {
                storiaostretricatabellaListNewStoriaostretricatabellaToAttach = em.getReference(storiaostretricatabellaListNewStoriaostretricatabellaToAttach.getClass(), storiaostretricatabellaListNewStoriaostretricatabellaToAttach.getId());
                attachedStoriaostretricatabellaListNew.add(storiaostretricatabellaListNewStoriaostretricatabellaToAttach);
            }
            storiaostretricatabellaListNew = attachedStoriaostretricatabellaListNew;
            storiaostetrica.setStoriaostretricatabellaList(storiaostretricatabellaListNew);
            List<Cartellaostetricadigitale> attachedCartellaostetricadigitaleListNew = new ArrayList<Cartellaostetricadigitale>();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach : cartellaostetricadigitaleListNew) {
                cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach = em.getReference(cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach.getClass(), cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach.getId());
                attachedCartellaostetricadigitaleListNew.add(cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach);
            }
            cartellaostetricadigitaleListNew = attachedCartellaostetricadigitaleListNew;
            storiaostetrica.setCartellaostetricadigitaleList(cartellaostetricadigitaleListNew);
            storiaostetrica = em.merge(storiaostetrica);
            for (Storiaostretricatabella storiaostretricatabellaListNewStoriaostretricatabella : storiaostretricatabellaListNew) {
                if (!storiaostretricatabellaListOld.contains(storiaostretricatabellaListNewStoriaostretricatabella)) {
                    Storiaostetrica oldStoriaostetricaOfStoriaostretricatabellaListNewStoriaostretricatabella = storiaostretricatabellaListNewStoriaostretricatabella.getStoriaostetrica();
                    storiaostretricatabellaListNewStoriaostretricatabella.setStoriaostetrica(storiaostetrica);
                    storiaostretricatabellaListNewStoriaostretricatabella = em.merge(storiaostretricatabellaListNewStoriaostretricatabella);
                    if (oldStoriaostetricaOfStoriaostretricatabellaListNewStoriaostretricatabella != null && !oldStoriaostetricaOfStoriaostretricatabellaListNewStoriaostretricatabella.equals(storiaostetrica)) {
                        oldStoriaostetricaOfStoriaostretricatabellaListNewStoriaostretricatabella.getStoriaostretricatabellaList().remove(storiaostretricatabellaListNewStoriaostretricatabella);
                        oldStoriaostetricaOfStoriaostretricatabellaListNewStoriaostretricatabella = em.merge(oldStoriaostetricaOfStoriaostretricatabellaListNewStoriaostretricatabella);
                    }
                }
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListNewCartellaostetricadigitale : cartellaostetricadigitaleListNew) {
                if (!cartellaostetricadigitaleListOld.contains(cartellaostetricadigitaleListNewCartellaostetricadigitale)) {
                    Storiaostetrica oldStoriaostetricaOfCartellaostetricadigitaleListNewCartellaostetricadigitale = cartellaostetricadigitaleListNewCartellaostetricadigitale.getStoriaostetrica();
                    cartellaostetricadigitaleListNewCartellaostetricadigitale.setStoriaostetrica(storiaostetrica);
                    cartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                    if (oldStoriaostetricaOfCartellaostetricadigitaleListNewCartellaostetricadigitale != null && !oldStoriaostetricaOfCartellaostetricadigitaleListNewCartellaostetricadigitale.equals(storiaostetrica)) {
                        oldStoriaostetricaOfCartellaostetricadigitaleListNewCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                        oldStoriaostetricaOfCartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(oldStoriaostetricaOfCartellaostetricadigitaleListNewCartellaostetricadigitale);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = storiaostetrica.getId();
                if (findStoriaostetrica(id) == null) {
                    throw new NonexistentEntityException("The storiaostetrica with id " + id + " no longer exists.");
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
            Storiaostetrica storiaostetrica;
            try {
                storiaostetrica = em.getReference(Storiaostetrica.class, id);
                storiaostetrica.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The storiaostetrica with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Storiaostretricatabella> storiaostretricatabellaListOrphanCheck = storiaostetrica.getStoriaostretricatabellaList();
            for (Storiaostretricatabella storiaostretricatabellaListOrphanCheckStoriaostretricatabella : storiaostretricatabellaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Storiaostetrica (" + storiaostetrica + ") cannot be destroyed since the Storiaostretricatabella " + storiaostretricatabellaListOrphanCheckStoriaostretricatabella + " in its storiaostretricatabellaList field has a non-nullable storiaostetrica field.");
            }
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOrphanCheck = storiaostetrica.getCartellaostetricadigitaleList();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale : cartellaostetricadigitaleListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Storiaostetrica (" + storiaostetrica + ") cannot be destroyed since the Cartellaostetricadigitale " + cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale + " in its cartellaostetricadigitaleList field has a non-nullable storiaostetrica field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(storiaostetrica);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Storiaostetrica> findStoriaostetricaEntities() {
        return findStoriaostetricaEntities(true, -1, -1);
    }

    public List<Storiaostetrica> findStoriaostetricaEntities(int maxResults, int firstResult) {
        return findStoriaostetricaEntities(false, maxResults, firstResult);
    }

    private List<Storiaostetrica> findStoriaostetricaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Storiaostetrica.class));
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

    public Storiaostetrica findStoriaostetrica(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Storiaostetrica.class, id);
        } finally {
            em.close();
        }
    }

    public int getStoriaostetricaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Storiaostetrica> rt = cq.from(Storiaostetrica.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
