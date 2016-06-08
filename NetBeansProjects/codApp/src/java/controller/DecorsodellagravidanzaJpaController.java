/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Decorsodellagravidanza;
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
public class DecorsodellagravidanzaJpaController {

    public DecorsodellagravidanzaJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Decorsodellagravidanza decorsodellagravidanza) {
        if (decorsodellagravidanza.getCartellaostetricadigitaleList() == null) {
            decorsodellagravidanza.setCartellaostetricadigitaleList(new ArrayList<Cartellaostetricadigitale>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Cartellaostetricadigitale> attachedCartellaostetricadigitaleList = new ArrayList<Cartellaostetricadigitale>();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitaleToAttach : decorsodellagravidanza.getCartellaostetricadigitaleList()) {
                cartellaostetricadigitaleListCartellaostetricadigitaleToAttach = em.getReference(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getClass(), cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getId());
                attachedCartellaostetricadigitaleList.add(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach);
            }
            decorsodellagravidanza.setCartellaostetricadigitaleList(attachedCartellaostetricadigitaleList);
            em.persist(decorsodellagravidanza);
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitale : decorsodellagravidanza.getCartellaostetricadigitaleList()) {
                Decorsodellagravidanza oldDecorsodellagravidanzaOfCartellaostetricadigitaleListCartellaostetricadigitale = cartellaostetricadigitaleListCartellaostetricadigitale.getDecorsodellagravidanza();
                cartellaostetricadigitaleListCartellaostetricadigitale.setDecorsodellagravidanza(decorsodellagravidanza);
                cartellaostetricadigitaleListCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListCartellaostetricadigitale);
                if (oldDecorsodellagravidanzaOfCartellaostetricadigitaleListCartellaostetricadigitale != null) {
                    oldDecorsodellagravidanzaOfCartellaostetricadigitaleListCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListCartellaostetricadigitale);
                    oldDecorsodellagravidanzaOfCartellaostetricadigitaleListCartellaostetricadigitale = em.merge(oldDecorsodellagravidanzaOfCartellaostetricadigitaleListCartellaostetricadigitale);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Decorsodellagravidanza decorsodellagravidanza) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Decorsodellagravidanza persistentDecorsodellagravidanza = em.find(Decorsodellagravidanza.class, decorsodellagravidanza.getId());
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOld = persistentDecorsodellagravidanza.getCartellaostetricadigitaleList();
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListNew = decorsodellagravidanza.getCartellaostetricadigitaleList();
            List<String> illegalOrphanMessages = null;
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOldCartellaostetricadigitale : cartellaostetricadigitaleListOld) {
                if (!cartellaostetricadigitaleListNew.contains(cartellaostetricadigitaleListOldCartellaostetricadigitale)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cartellaostetricadigitale " + cartellaostetricadigitaleListOldCartellaostetricadigitale + " since its decorsodellagravidanza field is not nullable.");
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
            decorsodellagravidanza.setCartellaostetricadigitaleList(cartellaostetricadigitaleListNew);
            decorsodellagravidanza = em.merge(decorsodellagravidanza);
            for (Cartellaostetricadigitale cartellaostetricadigitaleListNewCartellaostetricadigitale : cartellaostetricadigitaleListNew) {
                if (!cartellaostetricadigitaleListOld.contains(cartellaostetricadigitaleListNewCartellaostetricadigitale)) {
                    Decorsodellagravidanza oldDecorsodellagravidanzaOfCartellaostetricadigitaleListNewCartellaostetricadigitale = cartellaostetricadigitaleListNewCartellaostetricadigitale.getDecorsodellagravidanza();
                    cartellaostetricadigitaleListNewCartellaostetricadigitale.setDecorsodellagravidanza(decorsodellagravidanza);
                    cartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                    if (oldDecorsodellagravidanzaOfCartellaostetricadigitaleListNewCartellaostetricadigitale != null && !oldDecorsodellagravidanzaOfCartellaostetricadigitaleListNewCartellaostetricadigitale.equals(decorsodellagravidanza)) {
                        oldDecorsodellagravidanzaOfCartellaostetricadigitaleListNewCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                        oldDecorsodellagravidanzaOfCartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(oldDecorsodellagravidanzaOfCartellaostetricadigitaleListNewCartellaostetricadigitale);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = decorsodellagravidanza.getId();
                if (findDecorsodellagravidanza(id) == null) {
                    throw new NonexistentEntityException("The decorsodellagravidanza with id " + id + " no longer exists.");
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
            Decorsodellagravidanza decorsodellagravidanza;
            try {
                decorsodellagravidanza = em.getReference(Decorsodellagravidanza.class, id);
                decorsodellagravidanza.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The decorsodellagravidanza with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOrphanCheck = decorsodellagravidanza.getCartellaostetricadigitaleList();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale : cartellaostetricadigitaleListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Decorsodellagravidanza (" + decorsodellagravidanza + ") cannot be destroyed since the Cartellaostetricadigitale " + cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale + " in its cartellaostetricadigitaleList field has a non-nullable decorsodellagravidanza field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(decorsodellagravidanza);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Decorsodellagravidanza> findDecorsodellagravidanzaEntities() {
        return findDecorsodellagravidanzaEntities(true, -1, -1);
    }

    public List<Decorsodellagravidanza> findDecorsodellagravidanzaEntities(int maxResults, int firstResult) {
        return findDecorsodellagravidanzaEntities(false, maxResults, firstResult);
    }

    private List<Decorsodellagravidanza> findDecorsodellagravidanzaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Decorsodellagravidanza.class));
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

    public Decorsodellagravidanza findDecorsodellagravidanza(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Decorsodellagravidanza.class, id);
        } finally {
            em.close();
        }
    }

    public int getDecorsodellagravidanzaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Decorsodellagravidanza> rt = cq.from(Decorsodellagravidanza.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
