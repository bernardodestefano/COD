/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Paziente;
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
import bean.Datiautenticazione;
import bean.Cartellaostetricadigitale;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lodato
 */
public class PazienteJpaController {

    public PazienteJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paziente paziente) throws PreexistingEntityException, Exception {
        if (paziente.getCartellaostetricadigitaleList() == null) {
            paziente.setCartellaostetricadigitaleList(new ArrayList<Cartellaostetricadigitale>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Datiautenticazione datiautenticazione = paziente.getDatiautenticazione();
            if (datiautenticazione != null) {
                datiautenticazione = em.getReference(datiautenticazione.getClass(), datiautenticazione.getUsername());
                paziente.setDatiautenticazione(datiautenticazione);
            }
            List<Cartellaostetricadigitale> attachedCartellaostetricadigitaleList = new ArrayList<Cartellaostetricadigitale>();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitaleToAttach : paziente.getCartellaostetricadigitaleList()) {
                cartellaostetricadigitaleListCartellaostetricadigitaleToAttach = em.getReference(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getClass(), cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getId());
                attachedCartellaostetricadigitaleList.add(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach);
            }
            paziente.setCartellaostetricadigitaleList(attachedCartellaostetricadigitaleList);
            em.persist(paziente);
            if (datiautenticazione != null) {
                datiautenticazione.getPazienteList().add(paziente);
                datiautenticazione = em.merge(datiautenticazione);
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitale : paziente.getCartellaostetricadigitaleList()) {
                Paziente oldPazienteOfCartellaostetricadigitaleListCartellaostetricadigitale = cartellaostetricadigitaleListCartellaostetricadigitale.getPaziente();
                cartellaostetricadigitaleListCartellaostetricadigitale.setPaziente(paziente);
                cartellaostetricadigitaleListCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListCartellaostetricadigitale);
                if (oldPazienteOfCartellaostetricadigitaleListCartellaostetricadigitale != null) {
                    oldPazienteOfCartellaostetricadigitaleListCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListCartellaostetricadigitale);
                    oldPazienteOfCartellaostetricadigitaleListCartellaostetricadigitale = em.merge(oldPazienteOfCartellaostetricadigitaleListCartellaostetricadigitale);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPaziente(paziente.getCodiceFiscale()) != null) {
                throw new PreexistingEntityException("Paziente " + paziente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paziente paziente) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paziente persistentPaziente = em.find(Paziente.class, paziente.getCodiceFiscale());
            Datiautenticazione datiautenticazioneOld = persistentPaziente.getDatiautenticazione();
            Datiautenticazione datiautenticazioneNew = paziente.getDatiautenticazione();
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOld = persistentPaziente.getCartellaostetricadigitaleList();
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListNew = paziente.getCartellaostetricadigitaleList();
            List<String> illegalOrphanMessages = null;
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOldCartellaostetricadigitale : cartellaostetricadigitaleListOld) {
                if (!cartellaostetricadigitaleListNew.contains(cartellaostetricadigitaleListOldCartellaostetricadigitale)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cartellaostetricadigitale " + cartellaostetricadigitaleListOldCartellaostetricadigitale + " since its paziente field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (datiautenticazioneNew != null) {
                datiautenticazioneNew = em.getReference(datiautenticazioneNew.getClass(), datiautenticazioneNew.getUsername());
                paziente.setDatiautenticazione(datiautenticazioneNew);
            }
            List<Cartellaostetricadigitale> attachedCartellaostetricadigitaleListNew = new ArrayList<Cartellaostetricadigitale>();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach : cartellaostetricadigitaleListNew) {
                cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach = em.getReference(cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach.getClass(), cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach.getId());
                attachedCartellaostetricadigitaleListNew.add(cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach);
            }
            cartellaostetricadigitaleListNew = attachedCartellaostetricadigitaleListNew;
            paziente.setCartellaostetricadigitaleList(cartellaostetricadigitaleListNew);
            paziente = em.merge(paziente);
            if (datiautenticazioneOld != null && !datiautenticazioneOld.equals(datiautenticazioneNew)) {
                datiautenticazioneOld.getPazienteList().remove(paziente);
                datiautenticazioneOld = em.merge(datiautenticazioneOld);
            }
            if (datiautenticazioneNew != null && !datiautenticazioneNew.equals(datiautenticazioneOld)) {
                datiautenticazioneNew.getPazienteList().add(paziente);
                datiautenticazioneNew = em.merge(datiautenticazioneNew);
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListNewCartellaostetricadigitale : cartellaostetricadigitaleListNew) {
                if (!cartellaostetricadigitaleListOld.contains(cartellaostetricadigitaleListNewCartellaostetricadigitale)) {
                    Paziente oldPazienteOfCartellaostetricadigitaleListNewCartellaostetricadigitale = cartellaostetricadigitaleListNewCartellaostetricadigitale.getPaziente();
                    cartellaostetricadigitaleListNewCartellaostetricadigitale.setPaziente(paziente);
                    cartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                    if (oldPazienteOfCartellaostetricadigitaleListNewCartellaostetricadigitale != null && !oldPazienteOfCartellaostetricadigitaleListNewCartellaostetricadigitale.equals(paziente)) {
                        oldPazienteOfCartellaostetricadigitaleListNewCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                        oldPazienteOfCartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(oldPazienteOfCartellaostetricadigitaleListNewCartellaostetricadigitale);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = paziente.getCodiceFiscale();
                if (findPaziente(id) == null) {
                    throw new NonexistentEntityException("The paziente with id " + id + " no longer exists.");
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
            Paziente paziente;
            try {
                paziente = em.getReference(Paziente.class, id);
                paziente.getCodiceFiscale();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paziente with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOrphanCheck = paziente.getCartellaostetricadigitaleList();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale : cartellaostetricadigitaleListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Paziente (" + paziente + ") cannot be destroyed since the Cartellaostetricadigitale " + cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale + " in its cartellaostetricadigitaleList field has a non-nullable paziente field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Datiautenticazione datiautenticazione = paziente.getDatiautenticazione();
            if (datiautenticazione != null) {
                datiautenticazione.getPazienteList().remove(paziente);
                datiautenticazione = em.merge(datiautenticazione);
            }
            em.remove(paziente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paziente> findPazienteEntities() {
        return findPazienteEntities(true, -1, -1);
    }

    public List<Paziente> findPazienteEntities(int maxResults, int firstResult) {
        return findPazienteEntities(false, maxResults, firstResult);
    }

    private List<Paziente> findPazienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paziente.class));
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

    public Paziente findPaziente(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paziente.class, id);
        } finally {
            em.close();
        }
    }

    public int getPazienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paziente> rt = cq.from(Paziente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
