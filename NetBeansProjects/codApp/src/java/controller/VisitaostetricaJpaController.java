/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Visitaostetrica;
import controller.exceptions.IllegalOrphanException;
import controller.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import bean.Visitaostetricatabella;
import java.util.ArrayList;
import java.util.List;
import bean.Cartellaostetricadigitale;

/**
 *
 * @author Lodato
 */
public class VisitaostetricaJpaController {

    public VisitaostetricaJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Visitaostetrica visitaostetrica) {
        if (visitaostetrica.getVisitaostetricatabellaList() == null) {
            visitaostetrica.setVisitaostetricatabellaList(new ArrayList<Visitaostetricatabella>());
        }
        if (visitaostetrica.getCartellaostetricadigitaleList() == null) {
            visitaostetrica.setCartellaostetricadigitaleList(new ArrayList<Cartellaostetricadigitale>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Visitaostetricatabella> attachedVisitaostetricatabellaList = new ArrayList<Visitaostetricatabella>();
            for (Visitaostetricatabella visitaostetricatabellaListVisitaostetricatabellaToAttach : visitaostetrica.getVisitaostetricatabellaList()) {
                visitaostetricatabellaListVisitaostetricatabellaToAttach = em.getReference(visitaostetricatabellaListVisitaostetricatabellaToAttach.getClass(), visitaostetricatabellaListVisitaostetricatabellaToAttach.getId());
                attachedVisitaostetricatabellaList.add(visitaostetricatabellaListVisitaostetricatabellaToAttach);
            }
            visitaostetrica.setVisitaostetricatabellaList(attachedVisitaostetricatabellaList);
            List<Cartellaostetricadigitale> attachedCartellaostetricadigitaleList = new ArrayList<Cartellaostetricadigitale>();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitaleToAttach : visitaostetrica.getCartellaostetricadigitaleList()) {
                cartellaostetricadigitaleListCartellaostetricadigitaleToAttach = em.getReference(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getClass(), cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getId());
                attachedCartellaostetricadigitaleList.add(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach);
            }
            visitaostetrica.setCartellaostetricadigitaleList(attachedCartellaostetricadigitaleList);
            em.persist(visitaostetrica);
            for (Visitaostetricatabella visitaostetricatabellaListVisitaostetricatabella : visitaostetrica.getVisitaostetricatabellaList()) {
                Visitaostetrica oldVisitaostetricaOfVisitaostetricatabellaListVisitaostetricatabella = visitaostetricatabellaListVisitaostetricatabella.getVisitaostetrica();
                visitaostetricatabellaListVisitaostetricatabella.setVisitaostetrica(visitaostetrica);
                visitaostetricatabellaListVisitaostetricatabella = em.merge(visitaostetricatabellaListVisitaostetricatabella);
                if (oldVisitaostetricaOfVisitaostetricatabellaListVisitaostetricatabella != null) {
                    oldVisitaostetricaOfVisitaostetricatabellaListVisitaostetricatabella.getVisitaostetricatabellaList().remove(visitaostetricatabellaListVisitaostetricatabella);
                    oldVisitaostetricaOfVisitaostetricatabellaListVisitaostetricatabella = em.merge(oldVisitaostetricaOfVisitaostetricatabellaListVisitaostetricatabella);
                }
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitale : visitaostetrica.getCartellaostetricadigitaleList()) {
                Visitaostetrica oldVisitaostetricaOfCartellaostetricadigitaleListCartellaostetricadigitale = cartellaostetricadigitaleListCartellaostetricadigitale.getVisitaostetrica();
                cartellaostetricadigitaleListCartellaostetricadigitale.setVisitaostetrica(visitaostetrica);
                cartellaostetricadigitaleListCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListCartellaostetricadigitale);
                if (oldVisitaostetricaOfCartellaostetricadigitaleListCartellaostetricadigitale != null) {
                    oldVisitaostetricaOfCartellaostetricadigitaleListCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListCartellaostetricadigitale);
                    oldVisitaostetricaOfCartellaostetricadigitaleListCartellaostetricadigitale = em.merge(oldVisitaostetricaOfCartellaostetricadigitaleListCartellaostetricadigitale);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Visitaostetrica visitaostetrica) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Visitaostetrica persistentVisitaostetrica = em.find(Visitaostetrica.class, visitaostetrica.getId());
            List<Visitaostetricatabella> visitaostetricatabellaListOld = persistentVisitaostetrica.getVisitaostetricatabellaList();
            List<Visitaostetricatabella> visitaostetricatabellaListNew = visitaostetrica.getVisitaostetricatabellaList();
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOld = persistentVisitaostetrica.getCartellaostetricadigitaleList();
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListNew = visitaostetrica.getCartellaostetricadigitaleList();
            List<String> illegalOrphanMessages = null;
            for (Visitaostetricatabella visitaostetricatabellaListOldVisitaostetricatabella : visitaostetricatabellaListOld) {
                if (!visitaostetricatabellaListNew.contains(visitaostetricatabellaListOldVisitaostetricatabella)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Visitaostetricatabella " + visitaostetricatabellaListOldVisitaostetricatabella + " since its visitaostetrica field is not nullable.");
                }
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOldCartellaostetricadigitale : cartellaostetricadigitaleListOld) {
                if (!cartellaostetricadigitaleListNew.contains(cartellaostetricadigitaleListOldCartellaostetricadigitale)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cartellaostetricadigitale " + cartellaostetricadigitaleListOldCartellaostetricadigitale + " since its visitaostetrica field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Visitaostetricatabella> attachedVisitaostetricatabellaListNew = new ArrayList<Visitaostetricatabella>();
            for (Visitaostetricatabella visitaostetricatabellaListNewVisitaostetricatabellaToAttach : visitaostetricatabellaListNew) {
                visitaostetricatabellaListNewVisitaostetricatabellaToAttach = em.getReference(visitaostetricatabellaListNewVisitaostetricatabellaToAttach.getClass(), visitaostetricatabellaListNewVisitaostetricatabellaToAttach.getId());
                attachedVisitaostetricatabellaListNew.add(visitaostetricatabellaListNewVisitaostetricatabellaToAttach);
            }
            visitaostetricatabellaListNew = attachedVisitaostetricatabellaListNew;
            visitaostetrica.setVisitaostetricatabellaList(visitaostetricatabellaListNew);
            List<Cartellaostetricadigitale> attachedCartellaostetricadigitaleListNew = new ArrayList<Cartellaostetricadigitale>();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach : cartellaostetricadigitaleListNew) {
                cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach = em.getReference(cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach.getClass(), cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach.getId());
                attachedCartellaostetricadigitaleListNew.add(cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach);
            }
            cartellaostetricadigitaleListNew = attachedCartellaostetricadigitaleListNew;
            visitaostetrica.setCartellaostetricadigitaleList(cartellaostetricadigitaleListNew);
            visitaostetrica = em.merge(visitaostetrica);
            for (Visitaostetricatabella visitaostetricatabellaListNewVisitaostetricatabella : visitaostetricatabellaListNew) {
                if (!visitaostetricatabellaListOld.contains(visitaostetricatabellaListNewVisitaostetricatabella)) {
                    Visitaostetrica oldVisitaostetricaOfVisitaostetricatabellaListNewVisitaostetricatabella = visitaostetricatabellaListNewVisitaostetricatabella.getVisitaostetrica();
                    visitaostetricatabellaListNewVisitaostetricatabella.setVisitaostetrica(visitaostetrica);
                    visitaostetricatabellaListNewVisitaostetricatabella = em.merge(visitaostetricatabellaListNewVisitaostetricatabella);
                    if (oldVisitaostetricaOfVisitaostetricatabellaListNewVisitaostetricatabella != null && !oldVisitaostetricaOfVisitaostetricatabellaListNewVisitaostetricatabella.equals(visitaostetrica)) {
                        oldVisitaostetricaOfVisitaostetricatabellaListNewVisitaostetricatabella.getVisitaostetricatabellaList().remove(visitaostetricatabellaListNewVisitaostetricatabella);
                        oldVisitaostetricaOfVisitaostetricatabellaListNewVisitaostetricatabella = em.merge(oldVisitaostetricaOfVisitaostetricatabellaListNewVisitaostetricatabella);
                    }
                }
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListNewCartellaostetricadigitale : cartellaostetricadigitaleListNew) {
                if (!cartellaostetricadigitaleListOld.contains(cartellaostetricadigitaleListNewCartellaostetricadigitale)) {
                    Visitaostetrica oldVisitaostetricaOfCartellaostetricadigitaleListNewCartellaostetricadigitale = cartellaostetricadigitaleListNewCartellaostetricadigitale.getVisitaostetrica();
                    cartellaostetricadigitaleListNewCartellaostetricadigitale.setVisitaostetrica(visitaostetrica);
                    cartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                    if (oldVisitaostetricaOfCartellaostetricadigitaleListNewCartellaostetricadigitale != null && !oldVisitaostetricaOfCartellaostetricadigitaleListNewCartellaostetricadigitale.equals(visitaostetrica)) {
                        oldVisitaostetricaOfCartellaostetricadigitaleListNewCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                        oldVisitaostetricaOfCartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(oldVisitaostetricaOfCartellaostetricadigitaleListNewCartellaostetricadigitale);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = visitaostetrica.getId();
                if (findVisitaostetrica(id) == null) {
                    throw new NonexistentEntityException("The visitaostetrica with id " + id + " no longer exists.");
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
            Visitaostetrica visitaostetrica;
            try {
                visitaostetrica = em.getReference(Visitaostetrica.class, id);
                visitaostetrica.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The visitaostetrica with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Visitaostetricatabella> visitaostetricatabellaListOrphanCheck = visitaostetrica.getVisitaostetricatabellaList();
            for (Visitaostetricatabella visitaostetricatabellaListOrphanCheckVisitaostetricatabella : visitaostetricatabellaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Visitaostetrica (" + visitaostetrica + ") cannot be destroyed since the Visitaostetricatabella " + visitaostetricatabellaListOrphanCheckVisitaostetricatabella + " in its visitaostetricatabellaList field has a non-nullable visitaostetrica field.");
            }
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOrphanCheck = visitaostetrica.getCartellaostetricadigitaleList();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale : cartellaostetricadigitaleListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Visitaostetrica (" + visitaostetrica + ") cannot be destroyed since the Cartellaostetricadigitale " + cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale + " in its cartellaostetricadigitaleList field has a non-nullable visitaostetrica field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(visitaostetrica);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Visitaostetrica> findVisitaostetricaEntities() {
        return findVisitaostetricaEntities(true, -1, -1);
    }

    public List<Visitaostetrica> findVisitaostetricaEntities(int maxResults, int firstResult) {
        return findVisitaostetricaEntities(false, maxResults, firstResult);
    }

    private List<Visitaostetrica> findVisitaostetricaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Visitaostetrica.class));
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

    public Visitaostetrica findVisitaostetrica(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Visitaostetrica.class, id);
        } finally {
            em.close();
        }
    }

    public int getVisitaostetricaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Visitaostetrica> rt = cq.from(Visitaostetrica.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
