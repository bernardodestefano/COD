/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Ecografie;
import controller.exceptions.IllegalOrphanException;
import controller.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import bean.Ecografiatabella;
import java.util.ArrayList;
import java.util.List;
import bean.Cartellaostetricadigitale;

/**
 *
 * @author Lodato
 */
public class EcografieJpaController {

    public EcografieJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ecografie ecografie) {
        if (ecografie.getEcografiatabellaList() == null) {
            ecografie.setEcografiatabellaList(new ArrayList<Ecografiatabella>());
        }
        if (ecografie.getCartellaostetricadigitaleList() == null) {
            ecografie.setCartellaostetricadigitaleList(new ArrayList<Cartellaostetricadigitale>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Ecografiatabella> attachedEcografiatabellaList = new ArrayList<Ecografiatabella>();
            for (Ecografiatabella ecografiatabellaListEcografiatabellaToAttach : ecografie.getEcografiatabellaList()) {
                ecografiatabellaListEcografiatabellaToAttach = em.getReference(ecografiatabellaListEcografiatabellaToAttach.getClass(), ecografiatabellaListEcografiatabellaToAttach.getId());
                attachedEcografiatabellaList.add(ecografiatabellaListEcografiatabellaToAttach);
            }
            ecografie.setEcografiatabellaList(attachedEcografiatabellaList);
            List<Cartellaostetricadigitale> attachedCartellaostetricadigitaleList = new ArrayList<Cartellaostetricadigitale>();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitaleToAttach : ecografie.getCartellaostetricadigitaleList()) {
                cartellaostetricadigitaleListCartellaostetricadigitaleToAttach = em.getReference(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getClass(), cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getId());
                attachedCartellaostetricadigitaleList.add(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach);
            }
            ecografie.setCartellaostetricadigitaleList(attachedCartellaostetricadigitaleList);
            em.persist(ecografie);
            for (Ecografiatabella ecografiatabellaListEcografiatabella : ecografie.getEcografiatabellaList()) {
                Ecografie oldEcografieOfEcografiatabellaListEcografiatabella = ecografiatabellaListEcografiatabella.getEcografie();
                ecografiatabellaListEcografiatabella.setEcografie(ecografie);
                ecografiatabellaListEcografiatabella = em.merge(ecografiatabellaListEcografiatabella);
                if (oldEcografieOfEcografiatabellaListEcografiatabella != null) {
                    oldEcografieOfEcografiatabellaListEcografiatabella.getEcografiatabellaList().remove(ecografiatabellaListEcografiatabella);
                    oldEcografieOfEcografiatabellaListEcografiatabella = em.merge(oldEcografieOfEcografiatabellaListEcografiatabella);
                }
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitale : ecografie.getCartellaostetricadigitaleList()) {
                Ecografie oldEcografieOfCartellaostetricadigitaleListCartellaostetricadigitale = cartellaostetricadigitaleListCartellaostetricadigitale.getEcografie();
                cartellaostetricadigitaleListCartellaostetricadigitale.setEcografie(ecografie);
                cartellaostetricadigitaleListCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListCartellaostetricadigitale);
                if (oldEcografieOfCartellaostetricadigitaleListCartellaostetricadigitale != null) {
                    oldEcografieOfCartellaostetricadigitaleListCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListCartellaostetricadigitale);
                    oldEcografieOfCartellaostetricadigitaleListCartellaostetricadigitale = em.merge(oldEcografieOfCartellaostetricadigitaleListCartellaostetricadigitale);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ecografie ecografie) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ecografie persistentEcografie = em.find(Ecografie.class, ecografie.getId());
            List<Ecografiatabella> ecografiatabellaListOld = persistentEcografie.getEcografiatabellaList();
            List<Ecografiatabella> ecografiatabellaListNew = ecografie.getEcografiatabellaList();
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOld = persistentEcografie.getCartellaostetricadigitaleList();
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListNew = ecografie.getCartellaostetricadigitaleList();
            List<String> illegalOrphanMessages = null;
            for (Ecografiatabella ecografiatabellaListOldEcografiatabella : ecografiatabellaListOld) {
                if (!ecografiatabellaListNew.contains(ecografiatabellaListOldEcografiatabella)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ecografiatabella " + ecografiatabellaListOldEcografiatabella + " since its ecografie field is not nullable.");
                }
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOldCartellaostetricadigitale : cartellaostetricadigitaleListOld) {
                if (!cartellaostetricadigitaleListNew.contains(cartellaostetricadigitaleListOldCartellaostetricadigitale)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cartellaostetricadigitale " + cartellaostetricadigitaleListOldCartellaostetricadigitale + " since its ecografie field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Ecografiatabella> attachedEcografiatabellaListNew = new ArrayList<Ecografiatabella>();
            for (Ecografiatabella ecografiatabellaListNewEcografiatabellaToAttach : ecografiatabellaListNew) {
                ecografiatabellaListNewEcografiatabellaToAttach = em.getReference(ecografiatabellaListNewEcografiatabellaToAttach.getClass(), ecografiatabellaListNewEcografiatabellaToAttach.getId());
                attachedEcografiatabellaListNew.add(ecografiatabellaListNewEcografiatabellaToAttach);
            }
            ecografiatabellaListNew = attachedEcografiatabellaListNew;
            ecografie.setEcografiatabellaList(ecografiatabellaListNew);
            List<Cartellaostetricadigitale> attachedCartellaostetricadigitaleListNew = new ArrayList<Cartellaostetricadigitale>();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach : cartellaostetricadigitaleListNew) {
                cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach = em.getReference(cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach.getClass(), cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach.getId());
                attachedCartellaostetricadigitaleListNew.add(cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach);
            }
            cartellaostetricadigitaleListNew = attachedCartellaostetricadigitaleListNew;
            ecografie.setCartellaostetricadigitaleList(cartellaostetricadigitaleListNew);
            ecografie = em.merge(ecografie);
            for (Ecografiatabella ecografiatabellaListNewEcografiatabella : ecografiatabellaListNew) {
                if (!ecografiatabellaListOld.contains(ecografiatabellaListNewEcografiatabella)) {
                    Ecografie oldEcografieOfEcografiatabellaListNewEcografiatabella = ecografiatabellaListNewEcografiatabella.getEcografie();
                    ecografiatabellaListNewEcografiatabella.setEcografie(ecografie);
                    ecografiatabellaListNewEcografiatabella = em.merge(ecografiatabellaListNewEcografiatabella);
                    if (oldEcografieOfEcografiatabellaListNewEcografiatabella != null && !oldEcografieOfEcografiatabellaListNewEcografiatabella.equals(ecografie)) {
                        oldEcografieOfEcografiatabellaListNewEcografiatabella.getEcografiatabellaList().remove(ecografiatabellaListNewEcografiatabella);
                        oldEcografieOfEcografiatabellaListNewEcografiatabella = em.merge(oldEcografieOfEcografiatabellaListNewEcografiatabella);
                    }
                }
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListNewCartellaostetricadigitale : cartellaostetricadigitaleListNew) {
                if (!cartellaostetricadigitaleListOld.contains(cartellaostetricadigitaleListNewCartellaostetricadigitale)) {
                    Ecografie oldEcografieOfCartellaostetricadigitaleListNewCartellaostetricadigitale = cartellaostetricadigitaleListNewCartellaostetricadigitale.getEcografie();
                    cartellaostetricadigitaleListNewCartellaostetricadigitale.setEcografie(ecografie);
                    cartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                    if (oldEcografieOfCartellaostetricadigitaleListNewCartellaostetricadigitale != null && !oldEcografieOfCartellaostetricadigitaleListNewCartellaostetricadigitale.equals(ecografie)) {
                        oldEcografieOfCartellaostetricadigitaleListNewCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                        oldEcografieOfCartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(oldEcografieOfCartellaostetricadigitaleListNewCartellaostetricadigitale);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ecografie.getId();
                if (findEcografie(id) == null) {
                    throw new NonexistentEntityException("The ecografie with id " + id + " no longer exists.");
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
            Ecografie ecografie;
            try {
                ecografie = em.getReference(Ecografie.class, id);
                ecografie.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ecografie with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Ecografiatabella> ecografiatabellaListOrphanCheck = ecografie.getEcografiatabellaList();
            for (Ecografiatabella ecografiatabellaListOrphanCheckEcografiatabella : ecografiatabellaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Ecografie (" + ecografie + ") cannot be destroyed since the Ecografiatabella " + ecografiatabellaListOrphanCheckEcografiatabella + " in its ecografiatabellaList field has a non-nullable ecografie field.");
            }
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOrphanCheck = ecografie.getCartellaostetricadigitaleList();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale : cartellaostetricadigitaleListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Ecografie (" + ecografie + ") cannot be destroyed since the Cartellaostetricadigitale " + cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale + " in its cartellaostetricadigitaleList field has a non-nullable ecografie field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(ecografie);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ecografie> findEcografieEntities() {
        return findEcografieEntities(true, -1, -1);
    }

    public List<Ecografie> findEcografieEntities(int maxResults, int firstResult) {
        return findEcografieEntities(false, maxResults, firstResult);
    }

    private List<Ecografie> findEcografieEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ecografie.class));
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

    public Ecografie findEcografie(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ecografie.class, id);
        } finally {
            em.close();
        }
    }

    public int getEcografieCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ecografie> rt = cq.from(Ecografie.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
