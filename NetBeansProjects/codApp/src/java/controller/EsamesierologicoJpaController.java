/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Esamesierologico;
import controller.exceptions.IllegalOrphanException;
import controller.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import bean.Esamesierologicotabella;
import java.util.ArrayList;
import java.util.List;
import bean.Cartellaostetricadigitale;

/**
 *
 * @author Lodato
 */
public class EsamesierologicoJpaController {

    public EsamesierologicoJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Esamesierologico esamesierologico) {
        if (esamesierologico.getEsamesierologicotabellaList() == null) {
            esamesierologico.setEsamesierologicotabellaList(new ArrayList<Esamesierologicotabella>());
        }
        if (esamesierologico.getCartellaostetricadigitaleList() == null) {
            esamesierologico.setCartellaostetricadigitaleList(new ArrayList<Cartellaostetricadigitale>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Esamesierologicotabella> attachedEsamesierologicotabellaList = new ArrayList<Esamesierologicotabella>();
            for (Esamesierologicotabella esamesierologicotabellaListEsamesierologicotabellaToAttach : esamesierologico.getEsamesierologicotabellaList()) {
                esamesierologicotabellaListEsamesierologicotabellaToAttach = em.getReference(esamesierologicotabellaListEsamesierologicotabellaToAttach.getClass(), esamesierologicotabellaListEsamesierologicotabellaToAttach.getId());
                attachedEsamesierologicotabellaList.add(esamesierologicotabellaListEsamesierologicotabellaToAttach);
            }
            esamesierologico.setEsamesierologicotabellaList(attachedEsamesierologicotabellaList);
            List<Cartellaostetricadigitale> attachedCartellaostetricadigitaleList = new ArrayList<Cartellaostetricadigitale>();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitaleToAttach : esamesierologico.getCartellaostetricadigitaleList()) {
                cartellaostetricadigitaleListCartellaostetricadigitaleToAttach = em.getReference(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getClass(), cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getId());
                attachedCartellaostetricadigitaleList.add(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach);
            }
            esamesierologico.setCartellaostetricadigitaleList(attachedCartellaostetricadigitaleList);
            em.persist(esamesierologico);
            for (Esamesierologicotabella esamesierologicotabellaListEsamesierologicotabella : esamesierologico.getEsamesierologicotabellaList()) {
                Esamesierologico oldEsamesierologicoOfEsamesierologicotabellaListEsamesierologicotabella = esamesierologicotabellaListEsamesierologicotabella.getEsamesierologico();
                esamesierologicotabellaListEsamesierologicotabella.setEsamesierologico(esamesierologico);
                esamesierologicotabellaListEsamesierologicotabella = em.merge(esamesierologicotabellaListEsamesierologicotabella);
                if (oldEsamesierologicoOfEsamesierologicotabellaListEsamesierologicotabella != null) {
                    oldEsamesierologicoOfEsamesierologicotabellaListEsamesierologicotabella.getEsamesierologicotabellaList().remove(esamesierologicotabellaListEsamesierologicotabella);
                    oldEsamesierologicoOfEsamesierologicotabellaListEsamesierologicotabella = em.merge(oldEsamesierologicoOfEsamesierologicotabellaListEsamesierologicotabella);
                }
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitale : esamesierologico.getCartellaostetricadigitaleList()) {
                Esamesierologico oldEsamesierologicoOfCartellaostetricadigitaleListCartellaostetricadigitale = cartellaostetricadigitaleListCartellaostetricadigitale.getEsamesierologico();
                cartellaostetricadigitaleListCartellaostetricadigitale.setEsamesierologico(esamesierologico);
                cartellaostetricadigitaleListCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListCartellaostetricadigitale);
                if (oldEsamesierologicoOfCartellaostetricadigitaleListCartellaostetricadigitale != null) {
                    oldEsamesierologicoOfCartellaostetricadigitaleListCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListCartellaostetricadigitale);
                    oldEsamesierologicoOfCartellaostetricadigitaleListCartellaostetricadigitale = em.merge(oldEsamesierologicoOfCartellaostetricadigitaleListCartellaostetricadigitale);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Esamesierologico esamesierologico) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Esamesierologico persistentEsamesierologico = em.find(Esamesierologico.class, esamesierologico.getId());
            List<Esamesierologicotabella> esamesierologicotabellaListOld = persistentEsamesierologico.getEsamesierologicotabellaList();
            List<Esamesierologicotabella> esamesierologicotabellaListNew = esamesierologico.getEsamesierologicotabellaList();
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOld = persistentEsamesierologico.getCartellaostetricadigitaleList();
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListNew = esamesierologico.getCartellaostetricadigitaleList();
            List<String> illegalOrphanMessages = null;
            for (Esamesierologicotabella esamesierologicotabellaListOldEsamesierologicotabella : esamesierologicotabellaListOld) {
                if (!esamesierologicotabellaListNew.contains(esamesierologicotabellaListOldEsamesierologicotabella)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Esamesierologicotabella " + esamesierologicotabellaListOldEsamesierologicotabella + " since its esamesierologico field is not nullable.");
                }
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOldCartellaostetricadigitale : cartellaostetricadigitaleListOld) {
                if (!cartellaostetricadigitaleListNew.contains(cartellaostetricadigitaleListOldCartellaostetricadigitale)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cartellaostetricadigitale " + cartellaostetricadigitaleListOldCartellaostetricadigitale + " since its esamesierologico field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Esamesierologicotabella> attachedEsamesierologicotabellaListNew = new ArrayList<Esamesierologicotabella>();
            for (Esamesierologicotabella esamesierologicotabellaListNewEsamesierologicotabellaToAttach : esamesierologicotabellaListNew) {
                esamesierologicotabellaListNewEsamesierologicotabellaToAttach = em.getReference(esamesierologicotabellaListNewEsamesierologicotabellaToAttach.getClass(), esamesierologicotabellaListNewEsamesierologicotabellaToAttach.getId());
                attachedEsamesierologicotabellaListNew.add(esamesierologicotabellaListNewEsamesierologicotabellaToAttach);
            }
            esamesierologicotabellaListNew = attachedEsamesierologicotabellaListNew;
            esamesierologico.setEsamesierologicotabellaList(esamesierologicotabellaListNew);
            List<Cartellaostetricadigitale> attachedCartellaostetricadigitaleListNew = new ArrayList<Cartellaostetricadigitale>();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach : cartellaostetricadigitaleListNew) {
                cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach = em.getReference(cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach.getClass(), cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach.getId());
                attachedCartellaostetricadigitaleListNew.add(cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach);
            }
            cartellaostetricadigitaleListNew = attachedCartellaostetricadigitaleListNew;
            esamesierologico.setCartellaostetricadigitaleList(cartellaostetricadigitaleListNew);
            esamesierologico = em.merge(esamesierologico);
            for (Esamesierologicotabella esamesierologicotabellaListNewEsamesierologicotabella : esamesierologicotabellaListNew) {
                if (!esamesierologicotabellaListOld.contains(esamesierologicotabellaListNewEsamesierologicotabella)) {
                    Esamesierologico oldEsamesierologicoOfEsamesierologicotabellaListNewEsamesierologicotabella = esamesierologicotabellaListNewEsamesierologicotabella.getEsamesierologico();
                    esamesierologicotabellaListNewEsamesierologicotabella.setEsamesierologico(esamesierologico);
                    esamesierologicotabellaListNewEsamesierologicotabella = em.merge(esamesierologicotabellaListNewEsamesierologicotabella);
                    if (oldEsamesierologicoOfEsamesierologicotabellaListNewEsamesierologicotabella != null && !oldEsamesierologicoOfEsamesierologicotabellaListNewEsamesierologicotabella.equals(esamesierologico)) {
                        oldEsamesierologicoOfEsamesierologicotabellaListNewEsamesierologicotabella.getEsamesierologicotabellaList().remove(esamesierologicotabellaListNewEsamesierologicotabella);
                        oldEsamesierologicoOfEsamesierologicotabellaListNewEsamesierologicotabella = em.merge(oldEsamesierologicoOfEsamesierologicotabellaListNewEsamesierologicotabella);
                    }
                }
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListNewCartellaostetricadigitale : cartellaostetricadigitaleListNew) {
                if (!cartellaostetricadigitaleListOld.contains(cartellaostetricadigitaleListNewCartellaostetricadigitale)) {
                    Esamesierologico oldEsamesierologicoOfCartellaostetricadigitaleListNewCartellaostetricadigitale = cartellaostetricadigitaleListNewCartellaostetricadigitale.getEsamesierologico();
                    cartellaostetricadigitaleListNewCartellaostetricadigitale.setEsamesierologico(esamesierologico);
                    cartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                    if (oldEsamesierologicoOfCartellaostetricadigitaleListNewCartellaostetricadigitale != null && !oldEsamesierologicoOfCartellaostetricadigitaleListNewCartellaostetricadigitale.equals(esamesierologico)) {
                        oldEsamesierologicoOfCartellaostetricadigitaleListNewCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                        oldEsamesierologicoOfCartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(oldEsamesierologicoOfCartellaostetricadigitaleListNewCartellaostetricadigitale);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = esamesierologico.getId();
                if (findEsamesierologico(id) == null) {
                    throw new NonexistentEntityException("The esamesierologico with id " + id + " no longer exists.");
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
            Esamesierologico esamesierologico;
            try {
                esamesierologico = em.getReference(Esamesierologico.class, id);
                esamesierologico.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The esamesierologico with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Esamesierologicotabella> esamesierologicotabellaListOrphanCheck = esamesierologico.getEsamesierologicotabellaList();
            for (Esamesierologicotabella esamesierologicotabellaListOrphanCheckEsamesierologicotabella : esamesierologicotabellaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Esamesierologico (" + esamesierologico + ") cannot be destroyed since the Esamesierologicotabella " + esamesierologicotabellaListOrphanCheckEsamesierologicotabella + " in its esamesierologicotabellaList field has a non-nullable esamesierologico field.");
            }
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOrphanCheck = esamesierologico.getCartellaostetricadigitaleList();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale : cartellaostetricadigitaleListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Esamesierologico (" + esamesierologico + ") cannot be destroyed since the Cartellaostetricadigitale " + cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale + " in its cartellaostetricadigitaleList field has a non-nullable esamesierologico field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(esamesierologico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Esamesierologico> findEsamesierologicoEntities() {
        return findEsamesierologicoEntities(true, -1, -1);
    }

    public List<Esamesierologico> findEsamesierologicoEntities(int maxResults, int firstResult) {
        return findEsamesierologicoEntities(false, maxResults, firstResult);
    }

    private List<Esamesierologico> findEsamesierologicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Esamesierologico.class));
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

    public Esamesierologico findEsamesierologico(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Esamesierologico.class, id);
        } finally {
            em.close();
        }
    }

    public int getEsamesierologicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Esamesierologico> rt = cq.from(Esamesierologico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
