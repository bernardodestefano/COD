/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Amministratore;
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
import bean.Datiautenticazione;

/**
 *
 * @author Lodato
 */
public class AmministratoreJpaController {

    public AmministratoreJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Amministratore amministratore) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Datiautenticazione datiautenticazione = amministratore.getDatiautenticazione();
            if (datiautenticazione != null) {
                datiautenticazione = em.getReference(datiautenticazione.getClass(), datiautenticazione.getUsername());
                amministratore.setDatiautenticazione(datiautenticazione);
            }
            em.persist(amministratore);
            if (datiautenticazione != null) {
                datiautenticazione.getAmministratoreList().add(amministratore);
                datiautenticazione = em.merge(datiautenticazione);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAmministratore(amministratore.getCodiceFiscale()) != null) {
                throw new PreexistingEntityException("Amministratore " + amministratore + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Amministratore amministratore) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Amministratore persistentAmministratore = em.find(Amministratore.class, amministratore.getCodiceFiscale());
            Datiautenticazione datiautenticazioneOld = persistentAmministratore.getDatiautenticazione();
            Datiautenticazione datiautenticazioneNew = amministratore.getDatiautenticazione();
            if (datiautenticazioneNew != null) {
                datiautenticazioneNew = em.getReference(datiautenticazioneNew.getClass(), datiautenticazioneNew.getUsername());
                amministratore.setDatiautenticazione(datiautenticazioneNew);
            }
            amministratore = em.merge(amministratore);
            if (datiautenticazioneOld != null && !datiautenticazioneOld.equals(datiautenticazioneNew)) {
                datiautenticazioneOld.getAmministratoreList().remove(amministratore);
                datiautenticazioneOld = em.merge(datiautenticazioneOld);
            }
            if (datiautenticazioneNew != null && !datiautenticazioneNew.equals(datiautenticazioneOld)) {
                datiautenticazioneNew.getAmministratoreList().add(amministratore);
                datiautenticazioneNew = em.merge(datiautenticazioneNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = amministratore.getCodiceFiscale();
                if (findAmministratore(id) == null) {
                    throw new NonexistentEntityException("The amministratore with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Amministratore amministratore;
            try {
                amministratore = em.getReference(Amministratore.class, id);
                amministratore.getCodiceFiscale();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The amministratore with id " + id + " no longer exists.", enfe);
            }
            Datiautenticazione datiautenticazione = amministratore.getDatiautenticazione();
            if (datiautenticazione != null) {
                datiautenticazione.getAmministratoreList().remove(amministratore);
                datiautenticazione = em.merge(datiautenticazione);
            }
            em.remove(amministratore);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Amministratore> findAmministratoreEntities() {
        return findAmministratoreEntities(true, -1, -1);
    }

    public List<Amministratore> findAmministratoreEntities(int maxResults, int firstResult) {
        return findAmministratoreEntities(false, maxResults, firstResult);
    }

    private List<Amministratore> findAmministratoreEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Amministratore.class));
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

    public Amministratore findAmministratore(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Amministratore.class, id);
        } finally {
            em.close();
        }
    }

    public int getAmministratoreCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Amministratore> rt = cq.from(Amministratore.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
