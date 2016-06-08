/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Malattiefamiliari;
import controller.exceptions.IllegalOrphanException;
import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
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

/**
 *
 * @author Lodato
 */
public class MalattiefamiliariJpaController {

    public MalattiefamiliariJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Malattiefamiliari malattiefamiliari) throws PreexistingEntityException, Exception {
        if (malattiefamiliari.getAnamnesifamiliareHasMalattiefamiliariList() == null) {
            malattiefamiliari.setAnamnesifamiliareHasMalattiefamiliariList(new ArrayList<AnamnesifamiliareHasMalattiefamiliari>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<AnamnesifamiliareHasMalattiefamiliari> attachedAnamnesifamiliareHasMalattiefamiliariList = new ArrayList<AnamnesifamiliareHasMalattiefamiliari>();
            for (AnamnesifamiliareHasMalattiefamiliari anamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliariToAttach : malattiefamiliari.getAnamnesifamiliareHasMalattiefamiliariList()) {
                anamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliariToAttach = em.getReference(anamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliariToAttach.getClass(), anamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliariToAttach.getAnamnesifamiliareHasMalattiefamiliariPK());
                attachedAnamnesifamiliareHasMalattiefamiliariList.add(anamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliariToAttach);
            }
            malattiefamiliari.setAnamnesifamiliareHasMalattiefamiliariList(attachedAnamnesifamiliareHasMalattiefamiliariList);
            em.persist(malattiefamiliari);
            for (AnamnesifamiliareHasMalattiefamiliari anamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliari : malattiefamiliari.getAnamnesifamiliareHasMalattiefamiliariList()) {
                Malattiefamiliari oldMalattiefamiliariOfAnamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliari = anamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliari.getMalattiefamiliari();
                anamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliari.setMalattiefamiliari(malattiefamiliari);
                anamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliari = em.merge(anamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliari);
                if (oldMalattiefamiliariOfAnamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliari != null) {
                    oldMalattiefamiliariOfAnamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliari.getAnamnesifamiliareHasMalattiefamiliariList().remove(anamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliari);
                    oldMalattiefamiliariOfAnamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliari = em.merge(oldMalattiefamiliariOfAnamnesifamiliareHasMalattiefamiliariListAnamnesifamiliareHasMalattiefamiliari);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMalattiefamiliari(malattiefamiliari.getNome()) != null) {
                throw new PreexistingEntityException("Malattiefamiliari " + malattiefamiliari + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Malattiefamiliari malattiefamiliari) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Malattiefamiliari persistentMalattiefamiliari = em.find(Malattiefamiliari.class, malattiefamiliari.getNome());
            List<AnamnesifamiliareHasMalattiefamiliari> anamnesifamiliareHasMalattiefamiliariListOld = persistentMalattiefamiliari.getAnamnesifamiliareHasMalattiefamiliariList();
            List<AnamnesifamiliareHasMalattiefamiliari> anamnesifamiliareHasMalattiefamiliariListNew = malattiefamiliari.getAnamnesifamiliareHasMalattiefamiliariList();
            List<String> illegalOrphanMessages = null;
            for (AnamnesifamiliareHasMalattiefamiliari anamnesifamiliareHasMalattiefamiliariListOldAnamnesifamiliareHasMalattiefamiliari : anamnesifamiliareHasMalattiefamiliariListOld) {
                if (!anamnesifamiliareHasMalattiefamiliariListNew.contains(anamnesifamiliareHasMalattiefamiliariListOldAnamnesifamiliareHasMalattiefamiliari)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain AnamnesifamiliareHasMalattiefamiliari " + anamnesifamiliareHasMalattiefamiliariListOldAnamnesifamiliareHasMalattiefamiliari + " since its malattiefamiliari field is not nullable.");
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
            malattiefamiliari.setAnamnesifamiliareHasMalattiefamiliariList(anamnesifamiliareHasMalattiefamiliariListNew);
            malattiefamiliari = em.merge(malattiefamiliari);
            for (AnamnesifamiliareHasMalattiefamiliari anamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliari : anamnesifamiliareHasMalattiefamiliariListNew) {
                if (!anamnesifamiliareHasMalattiefamiliariListOld.contains(anamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliari)) {
                    Malattiefamiliari oldMalattiefamiliariOfAnamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliari = anamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliari.getMalattiefamiliari();
                    anamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliari.setMalattiefamiliari(malattiefamiliari);
                    anamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliari = em.merge(anamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliari);
                    if (oldMalattiefamiliariOfAnamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliari != null && !oldMalattiefamiliariOfAnamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliari.equals(malattiefamiliari)) {
                        oldMalattiefamiliariOfAnamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliari.getAnamnesifamiliareHasMalattiefamiliariList().remove(anamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliari);
                        oldMalattiefamiliariOfAnamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliari = em.merge(oldMalattiefamiliariOfAnamnesifamiliareHasMalattiefamiliariListNewAnamnesifamiliareHasMalattiefamiliari);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = malattiefamiliari.getNome();
                if (findMalattiefamiliari(id) == null) {
                    throw new NonexistentEntityException("The malattiefamiliari with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Malattiefamiliari malattiefamiliari;
            try {
                malattiefamiliari = em.getReference(Malattiefamiliari.class, id);
                malattiefamiliari.getNome();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The malattiefamiliari with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<AnamnesifamiliareHasMalattiefamiliari> anamnesifamiliareHasMalattiefamiliariListOrphanCheck = malattiefamiliari.getAnamnesifamiliareHasMalattiefamiliariList();
            for (AnamnesifamiliareHasMalattiefamiliari anamnesifamiliareHasMalattiefamiliariListOrphanCheckAnamnesifamiliareHasMalattiefamiliari : anamnesifamiliareHasMalattiefamiliariListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Malattiefamiliari (" + malattiefamiliari + ") cannot be destroyed since the AnamnesifamiliareHasMalattiefamiliari " + anamnesifamiliareHasMalattiefamiliariListOrphanCheckAnamnesifamiliareHasMalattiefamiliari + " in its anamnesifamiliareHasMalattiefamiliariList field has a non-nullable malattiefamiliari field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(malattiefamiliari);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Malattiefamiliari> findMalattiefamiliariEntities() {
        return findMalattiefamiliariEntities(true, -1, -1);
    }

    public List<Malattiefamiliari> findMalattiefamiliariEntities(int maxResults, int firstResult) {
        return findMalattiefamiliariEntities(false, maxResults, firstResult);
    }

    private List<Malattiefamiliari> findMalattiefamiliariEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Malattiefamiliari.class));
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

    public Malattiefamiliari findMalattiefamiliari(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Malattiefamiliari.class, id);
        } finally {
            em.close();
        }
    }

    public int getMalattiefamiliariCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Malattiefamiliari> rt = cq.from(Malattiefamiliari.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
