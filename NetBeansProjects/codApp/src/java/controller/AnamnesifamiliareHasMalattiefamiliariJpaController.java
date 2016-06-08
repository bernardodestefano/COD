/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.AnamnesifamiliareHasMalattiefamiliari;
import bean.AnamnesifamiliareHasMalattiefamiliariPK;
import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import bean.Malattiefamiliari;
import bean.Anamnesifamiliare;

/**
 *
 * @author Lodato
 */
public class AnamnesifamiliareHasMalattiefamiliariJpaController {

    public AnamnesifamiliareHasMalattiefamiliariJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AnamnesifamiliareHasMalattiefamiliari anamnesifamiliareHasMalattiefamiliari) throws PreexistingEntityException, Exception {
        if (anamnesifamiliareHasMalattiefamiliari.getAnamnesifamiliareHasMalattiefamiliariPK() == null) {
            anamnesifamiliareHasMalattiefamiliari.setAnamnesifamiliareHasMalattiefamiliariPK(new AnamnesifamiliareHasMalattiefamiliariPK());
        }
        anamnesifamiliareHasMalattiefamiliari.getAnamnesifamiliareHasMalattiefamiliariPK().setAnamnesiFamiliareid(anamnesifamiliareHasMalattiefamiliari.getAnamnesifamiliare().getId());
        anamnesifamiliareHasMalattiefamiliari.getAnamnesifamiliareHasMalattiefamiliariPK().setMalattieFamiliarinome(anamnesifamiliareHasMalattiefamiliari.getMalattiefamiliari().getNome());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Malattiefamiliari malattiefamiliari = anamnesifamiliareHasMalattiefamiliari.getMalattiefamiliari();
            if (malattiefamiliari != null) {
                malattiefamiliari = em.getReference(malattiefamiliari.getClass(), malattiefamiliari.getNome());
                anamnesifamiliareHasMalattiefamiliari.setMalattiefamiliari(malattiefamiliari);
            }
            Anamnesifamiliare anamnesifamiliare = anamnesifamiliareHasMalattiefamiliari.getAnamnesifamiliare();
            if (anamnesifamiliare != null) {
                anamnesifamiliare = em.getReference(anamnesifamiliare.getClass(), anamnesifamiliare.getId());
                anamnesifamiliareHasMalattiefamiliari.setAnamnesifamiliare(anamnesifamiliare);
            }
            em.persist(anamnesifamiliareHasMalattiefamiliari);
            if (malattiefamiliari != null) {
                malattiefamiliari.getAnamnesifamiliareHasMalattiefamiliariList().add(anamnesifamiliareHasMalattiefamiliari);
                malattiefamiliari = em.merge(malattiefamiliari);
            }
            if (anamnesifamiliare != null) {
                anamnesifamiliare.getAnamnesifamiliareHasMalattiefamiliariList().add(anamnesifamiliareHasMalattiefamiliari);
                anamnesifamiliare = em.merge(anamnesifamiliare);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAnamnesifamiliareHasMalattiefamiliari(anamnesifamiliareHasMalattiefamiliari.getAnamnesifamiliareHasMalattiefamiliariPK()) != null) {
                throw new PreexistingEntityException("AnamnesifamiliareHasMalattiefamiliari " + anamnesifamiliareHasMalattiefamiliari + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AnamnesifamiliareHasMalattiefamiliari anamnesifamiliareHasMalattiefamiliari) throws NonexistentEntityException, Exception {
        anamnesifamiliareHasMalattiefamiliari.getAnamnesifamiliareHasMalattiefamiliariPK().setAnamnesiFamiliareid(anamnesifamiliareHasMalattiefamiliari.getAnamnesifamiliare().getId());
        anamnesifamiliareHasMalattiefamiliari.getAnamnesifamiliareHasMalattiefamiliariPK().setMalattieFamiliarinome(anamnesifamiliareHasMalattiefamiliari.getMalattiefamiliari().getNome());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AnamnesifamiliareHasMalattiefamiliari persistentAnamnesifamiliareHasMalattiefamiliari = em.find(AnamnesifamiliareHasMalattiefamiliari.class, anamnesifamiliareHasMalattiefamiliari.getAnamnesifamiliareHasMalattiefamiliariPK());
            Malattiefamiliari malattiefamiliariOld = persistentAnamnesifamiliareHasMalattiefamiliari.getMalattiefamiliari();
            Malattiefamiliari malattiefamiliariNew = anamnesifamiliareHasMalattiefamiliari.getMalattiefamiliari();
            Anamnesifamiliare anamnesifamiliareOld = persistentAnamnesifamiliareHasMalattiefamiliari.getAnamnesifamiliare();
            Anamnesifamiliare anamnesifamiliareNew = anamnesifamiliareHasMalattiefamiliari.getAnamnesifamiliare();
            if (malattiefamiliariNew != null) {
                malattiefamiliariNew = em.getReference(malattiefamiliariNew.getClass(), malattiefamiliariNew.getNome());
                anamnesifamiliareHasMalattiefamiliari.setMalattiefamiliari(malattiefamiliariNew);
            }
            if (anamnesifamiliareNew != null) {
                anamnesifamiliareNew = em.getReference(anamnesifamiliareNew.getClass(), anamnesifamiliareNew.getId());
                anamnesifamiliareHasMalattiefamiliari.setAnamnesifamiliare(anamnesifamiliareNew);
            }
            anamnesifamiliareHasMalattiefamiliari = em.merge(anamnesifamiliareHasMalattiefamiliari);
            if (malattiefamiliariOld != null && !malattiefamiliariOld.equals(malattiefamiliariNew)) {
                malattiefamiliariOld.getAnamnesifamiliareHasMalattiefamiliariList().remove(anamnesifamiliareHasMalattiefamiliari);
                malattiefamiliariOld = em.merge(malattiefamiliariOld);
            }
            if (malattiefamiliariNew != null && !malattiefamiliariNew.equals(malattiefamiliariOld)) {
                malattiefamiliariNew.getAnamnesifamiliareHasMalattiefamiliariList().add(anamnesifamiliareHasMalattiefamiliari);
                malattiefamiliariNew = em.merge(malattiefamiliariNew);
            }
            if (anamnesifamiliareOld != null && !anamnesifamiliareOld.equals(anamnesifamiliareNew)) {
                anamnesifamiliareOld.getAnamnesifamiliareHasMalattiefamiliariList().remove(anamnesifamiliareHasMalattiefamiliari);
                anamnesifamiliareOld = em.merge(anamnesifamiliareOld);
            }
            if (anamnesifamiliareNew != null && !anamnesifamiliareNew.equals(anamnesifamiliareOld)) {
                anamnesifamiliareNew.getAnamnesifamiliareHasMalattiefamiliariList().add(anamnesifamiliareHasMalattiefamiliari);
                anamnesifamiliareNew = em.merge(anamnesifamiliareNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                AnamnesifamiliareHasMalattiefamiliariPK id = anamnesifamiliareHasMalattiefamiliari.getAnamnesifamiliareHasMalattiefamiliariPK();
                if (findAnamnesifamiliareHasMalattiefamiliari(id) == null) {
                    throw new NonexistentEntityException("The anamnesifamiliareHasMalattiefamiliari with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(AnamnesifamiliareHasMalattiefamiliariPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AnamnesifamiliareHasMalattiefamiliari anamnesifamiliareHasMalattiefamiliari;
            try {
                anamnesifamiliareHasMalattiefamiliari = em.getReference(AnamnesifamiliareHasMalattiefamiliari.class, id);
                anamnesifamiliareHasMalattiefamiliari.getAnamnesifamiliareHasMalattiefamiliariPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The anamnesifamiliareHasMalattiefamiliari with id " + id + " no longer exists.", enfe);
            }
            Malattiefamiliari malattiefamiliari = anamnesifamiliareHasMalattiefamiliari.getMalattiefamiliari();
            if (malattiefamiliari != null) {
                malattiefamiliari.getAnamnesifamiliareHasMalattiefamiliariList().remove(anamnesifamiliareHasMalattiefamiliari);
                malattiefamiliari = em.merge(malattiefamiliari);
            }
            Anamnesifamiliare anamnesifamiliare = anamnesifamiliareHasMalattiefamiliari.getAnamnesifamiliare();
            if (anamnesifamiliare != null) {
                anamnesifamiliare.getAnamnesifamiliareHasMalattiefamiliariList().remove(anamnesifamiliareHasMalattiefamiliari);
                anamnesifamiliare = em.merge(anamnesifamiliare);
            }
            em.remove(anamnesifamiliareHasMalattiefamiliari);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AnamnesifamiliareHasMalattiefamiliari> findAnamnesifamiliareHasMalattiefamiliariEntities() {
        return findAnamnesifamiliareHasMalattiefamiliariEntities(true, -1, -1);
    }

    public List<AnamnesifamiliareHasMalattiefamiliari> findAnamnesifamiliareHasMalattiefamiliariEntities(int maxResults, int firstResult) {
        return findAnamnesifamiliareHasMalattiefamiliariEntities(false, maxResults, firstResult);
    }

    private List<AnamnesifamiliareHasMalattiefamiliari> findAnamnesifamiliareHasMalattiefamiliariEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AnamnesifamiliareHasMalattiefamiliari.class));
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

    public AnamnesifamiliareHasMalattiefamiliari findAnamnesifamiliareHasMalattiefamiliari(AnamnesifamiliareHasMalattiefamiliariPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AnamnesifamiliareHasMalattiefamiliari.class, id);
        } finally {
            em.close();
        }
    }

    public int getAnamnesifamiliareHasMalattiefamiliariCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AnamnesifamiliareHasMalattiefamiliari> rt = cq.from(AnamnesifamiliareHasMalattiefamiliari.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
