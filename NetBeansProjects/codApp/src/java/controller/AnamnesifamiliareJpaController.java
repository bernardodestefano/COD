/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Anamnesifamiliare;
import controller.exceptions.IllegalOrphanException;
import controller.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import bean.AnamnesifamiliareHasMalattiefamiliari;
import java.util.ArrayList;
import java.util.List;
import bean.Cartellaostetricadigitale;

/**
 *
 * @author Lodato
 */
public class AnamnesifamiliareJpaController {

    public AnamnesifamiliareJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Anamnesifamiliare anamnesifamiliare) {
        if (anamnesifamiliare.getAnamnesifamiliareHasMalattiefamiliariList() == null) {
            anamnesifamiliare.setAnamnesifamiliareHasMalattiefamiliariList(new ArrayList<AnamnesifamiliareHasMalattiefamiliari>());
        }
        if (anamnesifamiliare.getCartellaostetricadigitaleList() == null) {
            anamnesifamiliare.setCartellaostetricadigitaleList(new ArrayList<Cartellaostetricadigitale>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<AnamnesifamiliareHasMalattiefamiliari> attachedAnamnesifamiliareHasMalattiefamiliariList = new ArrayList<AnamnesifamiliareHasMalattiefamiliari>();
            for (AnamnesifamiliareHasMalattiefamiliari anamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliariToAttach : anamnesifamiliare.getAnamnesifamiliareHasMalattiefamiliariList()) {
                anamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliariToAttach = em.getReference(anamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliariToAttach.getClass(), anamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliariToAttach.getAnamnesifamiliareHasMalattiefamiliariPK());
                attachedAnamnesifamiliareHasMalattiefamiliariList.add(anamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliariToAttach);
            }
            anamnesifamiliare.setAnamnesifamiliareHasMalattiefamiliariList(attachedAnamnesifamiliareHasMalattiefamiliariList);
            List<Cartellaostetricadigitale> attachedCartellaostetricadigitaleList = new ArrayList<Cartellaostetricadigitale>();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitaleToAttach : anamnesifamiliare.getCartellaostetricadigitaleList()) {
                cartellaostetricadigitaleListCartellaostetricadigitaleToAttach = em.getReference(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getClass(), cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getId());
                attachedCartellaostetricadigitaleList.add(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach);
            }
            anamnesifamiliare.setCartellaostetricadigitaleList(attachedCartellaostetricadigitaleList);
            em.persist(anamnesifamiliare);
            for (AnamnesifamiliareHasMalattiefamiliari anamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliari : anamnesifamiliare.getAnamnesifamiliareHasMalattiefamiliariList()) {
                Anamnesifamiliare oldAnamnesifamiliareOfAnamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliari = anamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliari.getAnamnesifamiliare();
                anamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliari.setAnamnesifamiliare(anamnesifamiliare);
                anamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliari = em.merge(anamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliari);
                if (oldAnamnesifamiliareOfAnamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliari != null) {
                    oldAnamnesifamiliareOfAnamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliari.getAnamnesifamiliareHasMalattiefamiliariList().remove(anamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliari);
                    oldAnamnesifamiliareOfAnamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliari = em.merge(oldAnamnesifamiliareOfAnamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliari);
                }
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitale : anamnesifamiliare.getCartellaostetricadigitaleList()) {
                Anamnesifamiliare oldAnamnesifamiliareOfCartellaostetricadigitaleListCartellaostetricadigitale = cartellaostetricadigitaleListCartellaostetricadigitale.getAnamnesifamiliare();
                cartellaostetricadigitaleListCartellaostetricadigitale.setAnamnesifamiliare(anamnesifamiliare);
                cartellaostetricadigitaleListCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListCartellaostetricadigitale);
                if (oldAnamnesifamiliareOfCartellaostetricadigitaleListCartellaostetricadigitale != null) {
                    oldAnamnesifamiliareOfCartellaostetricadigitaleListCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListCartellaostetricadigitale);
                    oldAnamnesifamiliareOfCartellaostetricadigitaleListCartellaostetricadigitale = em.merge(oldAnamnesifamiliareOfCartellaostetricadigitaleListCartellaostetricadigitale);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Anamnesifamiliare anamnesifamiliare) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Anamnesifamiliare persistentAnamnesifamiliare = em.find(Anamnesifamiliare.class, anamnesifamiliare.getId());
            List<AnamnesifamiliareHasMalattiefamiliari> anamnesifamiliareHasMalattiefamiliariListOld = persistentAnamnesifamiliare.getAnamnesifamiliareHasMalattiefamiliariList();
            List<AnamnesifamiliareHasMalattiefamiliari> anamnesifamiliareHasMalattiefamiliariListNew = anamnesifamiliare.getAnamnesifamiliareHasMalattiefamiliariList();
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOld = persistentAnamnesifamiliare.getCartellaostetricadigitaleList();
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListNew = anamnesifamiliare.getCartellaostetricadigitaleList();
            List<String> illegalOrphanMessages = null;
            for (AnamnesifamiliareHasMalattiefamiliari anamnesifamiliareHasMalattiefamiliariListOldAnamnesifamiliareHasMalattiefamiliari : anamnesifamiliareHasMalattiefamiliariListOld) {
                if (!anamnesifamiliareHasMalattiefamiliariListNew.contains(anamnesifamiliareHasMalattiefamiliariListOldAnamnesifamiliareHasMalattiefamiliari)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain AnamnesifamiliareHasMalattiefamiliari " + anamnesifamiliareHasMalattiefamiliariListOldAnamnesifamiliareHasMalattiefamiliari + " since its anamnesifamiliare field is not nullable.");
                }
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOldCartellaostetricadigitale : cartellaostetricadigitaleListOld) {
                if (!cartellaostetricadigitaleListNew.contains(cartellaostetricadigitaleListOldCartellaostetricadigitale)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cartellaostetricadigitale " + cartellaostetricadigitaleListOldCartellaostetricadigitale + " since its anamnesifamiliare field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<AnamnesifamiliareHasMalattiefamiliari> attachedAnamnesifamiliareHasMalattiefamiliariListNew = new ArrayList<AnamnesifamiliareHasMalattiefamiliari>();
            for (AnamnesifamiliareHasMalattiefamiliari anamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliariToAttach : anamnesifamiliareHasMalattiefamiliariListNew) {
                anamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliariToAttach = em.getReference(anamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliariToAttach.getClass(), anamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliariToAttach.getAnamnesifamiliareHasMalattiefamiliariPK());
                attachedAnamnesifamiliareHasMalattiefamiliariListNew.add(anamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliariToAttach);
            }
            anamnesifamiliareHasMalattiefamiliariListNew = attachedAnamnesifamiliareHasMalattiefamiliariListNew;
            anamnesifamiliare.setAnamnesifamiliareHasMalattiefamiliariList(anamnesifamiliareHasMalattiefamiliariListNew);
            List<Cartellaostetricadigitale> attachedCartellaostetricadigitaleListNew = new ArrayList<Cartellaostetricadigitale>();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach : cartellaostetricadigitaleListNew) {
                cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach = em.getReference(cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach.getClass(), cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach.getId());
                attachedCartellaostetricadigitaleListNew.add(cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach);
            }
            cartellaostetricadigitaleListNew = attachedCartellaostetricadigitaleListNew;
            anamnesifamiliare.setCartellaostetricadigitaleList(cartellaostetricadigitaleListNew);
            anamnesifamiliare = em.merge(anamnesifamiliare);
            for (AnamnesifamiliareHasMalattiefamiliari anamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliari : anamnesifamiliareHasMalattiefamiliariListNew) {
                if (!anamnesifamiliareHasMalattiefamiliariListOld.contains(anamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliari)) {
                    Anamnesifamiliare oldAnamnesifamiliareOfAnamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliari = anamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliari.getAnamnesifamiliare();
                    anamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliari.setAnamnesifamiliare(anamnesifamiliare);
                    anamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliari = em.merge(anamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliari);
                    if (oldAnamnesifamiliareOfAnamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliari != null && !oldAnamnesifamiliareOfAnamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliari.equals(anamnesifamiliare)) {
                        oldAnamnesifamiliareOfAnamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliari.getAnamnesifamiliareHasMalattiefamiliariList().remove(anamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliari);
                        oldAnamnesifamiliareOfAnamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliari = em.merge(oldAnamnesifamiliareOfAnamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliari);
                    }
                }
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListNewCartellaostetricadigitale : cartellaostetricadigitaleListNew) {
                if (!cartellaostetricadigitaleListOld.contains(cartellaostetricadigitaleListNewCartellaostetricadigitale)) {
                    Anamnesifamiliare oldAnamnesifamiliareOfCartellaostetricadigitaleListNewCartellaostetricadigitale = cartellaostetricadigitaleListNewCartellaostetricadigitale.getAnamnesifamiliare();
                    cartellaostetricadigitaleListNewCartellaostetricadigitale.setAnamnesifamiliare(anamnesifamiliare);
                    cartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                    if (oldAnamnesifamiliareOfCartellaostetricadigitaleListNewCartellaostetricadigitale != null && !oldAnamnesifamiliareOfCartellaostetricadigitaleListNewCartellaostetricadigitale.equals(anamnesifamiliare)) {
                        oldAnamnesifamiliareOfCartellaostetricadigitaleListNewCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                        oldAnamnesifamiliareOfCartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(oldAnamnesifamiliareOfCartellaostetricadigitaleListNewCartellaostetricadigitale);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = anamnesifamiliare.getId();
                if (findAnamnesifamiliare(id) == null) {
                    throw new NonexistentEntityException("The anamnesifamiliare with id " + id + " no longer exists.");
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
            Anamnesifamiliare anamnesifamiliare;
            try {
                anamnesifamiliare = em.getReference(Anamnesifamiliare.class, id);
                anamnesifamiliare.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The anamnesifamiliare with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<AnamnesifamiliareHasMalattiefamiliari> anamnesifamiliareHasMalattiefamiliariListOrphanCheck = anamnesifamiliare.getAnamnesifamiliareHasMalattiefamiliariList();
            for (AnamnesifamiliareHasMalattiefamiliari anamnesifamiliareHasMalattiefamiliariListOrphanCheckAnamnesifamiliareHasMalattiefamiliari : anamnesifamiliareHasMalattiefamiliariListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Anamnesifamiliare (" + anamnesifamiliare + ") cannot be destroyed since the AnamnesifamiliareHasMalattiefamiliari " + anamnesifamiliareHasMalattiefamiliariListOrphanCheckAnamnesifamiliareHasMalattiefamiliari + " in its anamnesifamiliareHasMalattiefamiliariList field has a non-nullable anamnesifamiliare field.");
            }
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOrphanCheck = anamnesifamiliare.getCartellaostetricadigitaleList();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale : cartellaostetricadigitaleListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Anamnesifamiliare (" + anamnesifamiliare + ") cannot be destroyed since the Cartellaostetricadigitale " + cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale + " in its cartellaostetricadigitaleList field has a non-nullable anamnesifamiliare field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(anamnesifamiliare);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Anamnesifamiliare> findAnamnesifamiliareEntities() {
        return findAnamnesifamiliareEntities(true, -1, -1);
    }

    public List<Anamnesifamiliare> findAnamnesifamiliareEntities(int maxResults, int firstResult) {
        return findAnamnesifamiliareEntities(false, maxResults, firstResult);
    }

    private List<Anamnesifamiliare> findAnamnesifamiliareEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Anamnesifamiliare.class));
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

    public Anamnesifamiliare findAnamnesifamiliare(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Anamnesifamiliare.class, id);
        } finally {
            em.close();
        }
    }

    public int getAnamnesifamiliareCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Anamnesifamiliare> rt = cq.from(Anamnesifamiliare.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
