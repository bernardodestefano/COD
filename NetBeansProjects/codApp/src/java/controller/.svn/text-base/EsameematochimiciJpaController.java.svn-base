/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Esameematochimici;
import controller.exceptions.IllegalOrphanException;
import controller.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import bean.Esameematochimicitabella;
import java.util.ArrayList;
import java.util.List;
import bean.Cartellaostetricadigitale;

/**
 *
 * @author Lodato
 */
public class EsameematochimiciJpaController {

    public EsameematochimiciJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Esameematochimici esameematochimici) {
        if (esameematochimici.getEsameematochimicitabellaList() == null) {
            esameematochimici.setEsameematochimicitabellaList(new ArrayList<Esameematochimicitabella>());
        }
        if (esameematochimici.getCartellaostetricadigitaleList() == null) {
            esameematochimici.setCartellaostetricadigitaleList(new ArrayList<Cartellaostetricadigitale>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Esameematochimicitabella> attachedEsameematochimicitabellaList = new ArrayList<Esameematochimicitabella>();
            for (Esameematochimicitabella esameematochimicitabellaListEsameematochimicitabellaToAttach : esameematochimici.getEsameematochimicitabellaList()) {
                esameematochimicitabellaListEsameematochimicitabellaToAttach = em.getReference(esameematochimicitabellaListEsameematochimicitabellaToAttach.getClass(), esameematochimicitabellaListEsameematochimicitabellaToAttach.getId());
                attachedEsameematochimicitabellaList.add(esameematochimicitabellaListEsameematochimicitabellaToAttach);
            }
            esameematochimici.setEsameematochimicitabellaList(attachedEsameematochimicitabellaList);
            List<Cartellaostetricadigitale> attachedCartellaostetricadigitaleList = new ArrayList<Cartellaostetricadigitale>();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitaleToAttach : esameematochimici.getCartellaostetricadigitaleList()) {
                cartellaostetricadigitaleListCartellaostetricadigitaleToAttach = em.getReference(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getClass(), cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getId());
                attachedCartellaostetricadigitaleList.add(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach);
            }
            esameematochimici.setCartellaostetricadigitaleList(attachedCartellaostetricadigitaleList);
            em.persist(esameematochimici);
            for (Esameematochimicitabella esameematochimicitabellaListEsameematochimicitabella : esameematochimici.getEsameematochimicitabellaList()) {
                Esameematochimici oldEsameematochimiciOfEsameematochimicitabellaListEsameematochimicitabella = esameematochimicitabellaListEsameematochimicitabella.getEsameematochimici();
                esameematochimicitabellaListEsameematochimicitabella.setEsameematochimici(esameematochimici);
                esameematochimicitabellaListEsameematochimicitabella = em.merge(esameematochimicitabellaListEsameematochimicitabella);
                if (oldEsameematochimiciOfEsameematochimicitabellaListEsameematochimicitabella != null) {
                    oldEsameematochimiciOfEsameematochimicitabellaListEsameematochimicitabella.getEsameematochimicitabellaList().remove(esameematochimicitabellaListEsameematochimicitabella);
                    oldEsameematochimiciOfEsameematochimicitabellaListEsameematochimicitabella = em.merge(oldEsameematochimiciOfEsameematochimicitabellaListEsameematochimicitabella);
                }
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitale : esameematochimici.getCartellaostetricadigitaleList()) {
                Esameematochimici oldEsameematochimiciOfCartellaostetricadigitaleListCartellaostetricadigitale = cartellaostetricadigitaleListCartellaostetricadigitale.getEsameematochimici();
                cartellaostetricadigitaleListCartellaostetricadigitale.setEsameematochimici(esameematochimici);
                cartellaostetricadigitaleListCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListCartellaostetricadigitale);
                if (oldEsameematochimiciOfCartellaostetricadigitaleListCartellaostetricadigitale != null) {
                    oldEsameematochimiciOfCartellaostetricadigitaleListCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListCartellaostetricadigitale);
                    oldEsameematochimiciOfCartellaostetricadigitaleListCartellaostetricadigitale = em.merge(oldEsameematochimiciOfCartellaostetricadigitaleListCartellaostetricadigitale);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Esameematochimici esameematochimici) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Esameematochimici persistentEsameematochimici = em.find(Esameematochimici.class, esameematochimici.getId());
            List<Esameematochimicitabella> esameematochimicitabellaListOld = persistentEsameematochimici.getEsameematochimicitabellaList();
            List<Esameematochimicitabella> esameematochimicitabellaListNew = esameematochimici.getEsameematochimicitabellaList();
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOld = persistentEsameematochimici.getCartellaostetricadigitaleList();
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListNew = esameematochimici.getCartellaostetricadigitaleList();
            List<String> illegalOrphanMessages = null;
            for (Esameematochimicitabella esameematochimicitabellaListOldEsameematochimicitabella : esameematochimicitabellaListOld) {
                if (!esameematochimicitabellaListNew.contains(esameematochimicitabellaListOldEsameematochimicitabella)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Esameematochimicitabella " + esameematochimicitabellaListOldEsameematochimicitabella + " since its esameematochimici field is not nullable.");
                }
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOldCartellaostetricadigitale : cartellaostetricadigitaleListOld) {
                if (!cartellaostetricadigitaleListNew.contains(cartellaostetricadigitaleListOldCartellaostetricadigitale)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cartellaostetricadigitale " + cartellaostetricadigitaleListOldCartellaostetricadigitale + " since its esameematochimici field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Esameematochimicitabella> attachedEsameematochimicitabellaListNew = new ArrayList<Esameematochimicitabella>();
            for (Esameematochimicitabella esameematochimicitabellaListNewEsameematochimicitabellaToAttach : esameematochimicitabellaListNew) {
                esameematochimicitabellaListNewEsameematochimicitabellaToAttach = em.getReference(esameematochimicitabellaListNewEsameematochimicitabellaToAttach.getClass(), esameematochimicitabellaListNewEsameematochimicitabellaToAttach.getId());
                attachedEsameematochimicitabellaListNew.add(esameematochimicitabellaListNewEsameematochimicitabellaToAttach);
            }
            esameematochimicitabellaListNew = attachedEsameematochimicitabellaListNew;
            esameematochimici.setEsameematochimicitabellaList(esameematochimicitabellaListNew);
            List<Cartellaostetricadigitale> attachedCartellaostetricadigitaleListNew = new ArrayList<Cartellaostetricadigitale>();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach : cartellaostetricadigitaleListNew) {
                cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach = em.getReference(cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach.getClass(), cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach.getId());
                attachedCartellaostetricadigitaleListNew.add(cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach);
            }
            cartellaostetricadigitaleListNew = attachedCartellaostetricadigitaleListNew;
            esameematochimici.setCartellaostetricadigitaleList(cartellaostetricadigitaleListNew);
            esameematochimici = em.merge(esameematochimici);
            for (Esameematochimicitabella esameematochimicitabellaListNewEsameematochimicitabella : esameematochimicitabellaListNew) {
                if (!esameematochimicitabellaListOld.contains(esameematochimicitabellaListNewEsameematochimicitabella)) {
                    Esameematochimici oldEsameematochimiciOfEsameematochimicitabellaListNewEsameematochimicitabella = esameematochimicitabellaListNewEsameematochimicitabella.getEsameematochimici();
                    esameematochimicitabellaListNewEsameematochimicitabella.setEsameematochimici(esameematochimici);
                    esameematochimicitabellaListNewEsameematochimicitabella = em.merge(esameematochimicitabellaListNewEsameematochimicitabella);
                    if (oldEsameematochimiciOfEsameematochimicitabellaListNewEsameematochimicitabella != null && !oldEsameematochimiciOfEsameematochimicitabellaListNewEsameematochimicitabella.equals(esameematochimici)) {
                        oldEsameematochimiciOfEsameematochimicitabellaListNewEsameematochimicitabella.getEsameematochimicitabellaList().remove(esameematochimicitabellaListNewEsameematochimicitabella);
                        oldEsameematochimiciOfEsameematochimicitabellaListNewEsameematochimicitabella = em.merge(oldEsameematochimiciOfEsameematochimicitabellaListNewEsameematochimicitabella);
                    }
                }
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListNewCartellaostetricadigitale : cartellaostetricadigitaleListNew) {
                if (!cartellaostetricadigitaleListOld.contains(cartellaostetricadigitaleListNewCartellaostetricadigitale)) {
                    Esameematochimici oldEsameematochimiciOfCartellaostetricadigitaleListNewCartellaostetricadigitale = cartellaostetricadigitaleListNewCartellaostetricadigitale.getEsameematochimici();
                    cartellaostetricadigitaleListNewCartellaostetricadigitale.setEsameematochimici(esameematochimici);
                    cartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                    if (oldEsameematochimiciOfCartellaostetricadigitaleListNewCartellaostetricadigitale != null && !oldEsameematochimiciOfCartellaostetricadigitaleListNewCartellaostetricadigitale.equals(esameematochimici)) {
                        oldEsameematochimiciOfCartellaostetricadigitaleListNewCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                        oldEsameematochimiciOfCartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(oldEsameematochimiciOfCartellaostetricadigitaleListNewCartellaostetricadigitale);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = esameematochimici.getId();
                if (findEsameematochimici(id) == null) {
                    throw new NonexistentEntityException("The esameematochimici with id " + id + " no longer exists.");
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
            Esameematochimici esameematochimici;
            try {
                esameematochimici = em.getReference(Esameematochimici.class, id);
                esameematochimici.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The esameematochimici with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Esameematochimicitabella> esameematochimicitabellaListOrphanCheck = esameematochimici.getEsameematochimicitabellaList();
            for (Esameematochimicitabella esameematochimicitabellaListOrphanCheckEsameematochimicitabella : esameematochimicitabellaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Esameematochimici (" + esameematochimici + ") cannot be destroyed since the Esameematochimicitabella " + esameematochimicitabellaListOrphanCheckEsameematochimicitabella + " in its esameematochimicitabellaList field has a non-nullable esameematochimici field.");
            }
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOrphanCheck = esameematochimici.getCartellaostetricadigitaleList();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale : cartellaostetricadigitaleListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Esameematochimici (" + esameematochimici + ") cannot be destroyed since the Cartellaostetricadigitale " + cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale + " in its cartellaostetricadigitaleList field has a non-nullable esameematochimici field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(esameematochimici);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Esameematochimici> findEsameematochimiciEntities() {
        return findEsameematochimiciEntities(true, -1, -1);
    }

    public List<Esameematochimici> findEsameematochimiciEntities(int maxResults, int firstResult) {
        return findEsameematochimiciEntities(false, maxResults, firstResult);
    }

    private List<Esameematochimici> findEsameematochimiciEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Esameematochimici.class));
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

    public Esameematochimici findEsameematochimici(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Esameematochimici.class, id);
        } finally {
            em.close();
        }
    }

    public int getEsameematochimiciCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Esameematochimici> rt = cq.from(Esameematochimici.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
