/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Dottore;
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
public class DottoreJpaController {

    public DottoreJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dottore dottore) throws PreexistingEntityException, Exception {
        if (dottore.getCartellaostetricadigitaleList() == null) {
            dottore.setCartellaostetricadigitaleList(new ArrayList<Cartellaostetricadigitale>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Datiautenticazione datiautenticazione = dottore.getDatiautenticazione();
            if (datiautenticazione != null) {
                datiautenticazione = em.getReference(datiautenticazione.getClass(), datiautenticazione.getUsername());
                dottore.setDatiautenticazione(datiautenticazione);
            }
            List<Cartellaostetricadigitale> attachedCartellaostetricadigitaleList = new ArrayList<Cartellaostetricadigitale>();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitaleToAttach : dottore.getCartellaostetricadigitaleList()) {
                cartellaostetricadigitaleListCartellaostetricadigitaleToAttach = em.getReference(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getClass(), cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getId());
                attachedCartellaostetricadigitaleList.add(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach);
            }
            dottore.setCartellaostetricadigitaleList(attachedCartellaostetricadigitaleList);
            em.persist(dottore);
            if (datiautenticazione != null) {
                datiautenticazione.getDottoreList().add(dottore);
                datiautenticazione = em.merge(datiautenticazione);
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitale : dottore.getCartellaostetricadigitaleList()) {
                Dottore oldDottoreOfCartellaostetricadigitaleListCartellaostetricadigitale = cartellaostetricadigitaleListCartellaostetricadigitale.getDottore();
                cartellaostetricadigitaleListCartellaostetricadigitale.setDottore(dottore);
                cartellaostetricadigitaleListCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListCartellaostetricadigitale);
                if (oldDottoreOfCartellaostetricadigitaleListCartellaostetricadigitale != null) {
                    oldDottoreOfCartellaostetricadigitaleListCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListCartellaostetricadigitale);
                    oldDottoreOfCartellaostetricadigitaleListCartellaostetricadigitale = em.merge(oldDottoreOfCartellaostetricadigitaleListCartellaostetricadigitale);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDottore(dottore.getCodiceFiscale()) != null) {
                throw new PreexistingEntityException("Dottore " + dottore + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dottore dottore) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dottore persistentDottore = em.find(Dottore.class, dottore.getCodiceFiscale());
            Datiautenticazione datiautenticazioneOld = persistentDottore.getDatiautenticazione();
            Datiautenticazione datiautenticazioneNew = dottore.getDatiautenticazione();
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOld = persistentDottore.getCartellaostetricadigitaleList();
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListNew = dottore.getCartellaostetricadigitaleList();
            List<String> illegalOrphanMessages = null;
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOldCartellaostetricadigitale : cartellaostetricadigitaleListOld) {
                if (!cartellaostetricadigitaleListNew.contains(cartellaostetricadigitaleListOldCartellaostetricadigitale)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cartellaostetricadigitale " + cartellaostetricadigitaleListOldCartellaostetricadigitale + " since its dottore field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (datiautenticazioneNew != null) {
                datiautenticazioneNew = em.getReference(datiautenticazioneNew.getClass(), datiautenticazioneNew.getUsername());
                dottore.setDatiautenticazione(datiautenticazioneNew);
            }
            List<Cartellaostetricadigitale> attachedCartellaostetricadigitaleListNew = new ArrayList<Cartellaostetricadigitale>();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach : cartellaostetricadigitaleListNew) {
                cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach = em.getReference(cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach.getClass(), cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach.getId());
                attachedCartellaostetricadigitaleListNew.add(cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach);
            }
            cartellaostetricadigitaleListNew = attachedCartellaostetricadigitaleListNew;
            dottore.setCartellaostetricadigitaleList(cartellaostetricadigitaleListNew);
            dottore = em.merge(dottore);
            if (datiautenticazioneOld != null && !datiautenticazioneOld.equals(datiautenticazioneNew)) {
                datiautenticazioneOld.getDottoreList().remove(dottore);
                datiautenticazioneOld = em.merge(datiautenticazioneOld);
            }
            if (datiautenticazioneNew != null && !datiautenticazioneNew.equals(datiautenticazioneOld)) {
                datiautenticazioneNew.getDottoreList().add(dottore);
                datiautenticazioneNew = em.merge(datiautenticazioneNew);
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListNewCartellaostetricadigitale : cartellaostetricadigitaleListNew) {
                if (!cartellaostetricadigitaleListOld.contains(cartellaostetricadigitaleListNewCartellaostetricadigitale)) {
                    Dottore oldDottoreOfCartellaostetricadigitaleListNewCartellaostetricadigitale = cartellaostetricadigitaleListNewCartellaostetricadigitale.getDottore();
                    cartellaostetricadigitaleListNewCartellaostetricadigitale.setDottore(dottore);
                    cartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                    if (oldDottoreOfCartellaostetricadigitaleListNewCartellaostetricadigitale != null && !oldDottoreOfCartellaostetricadigitaleListNewCartellaostetricadigitale.equals(dottore)) {
                        oldDottoreOfCartellaostetricadigitaleListNewCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                        oldDottoreOfCartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(oldDottoreOfCartellaostetricadigitaleListNewCartellaostetricadigitale);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = dottore.getCodiceFiscale();
                if (findDottore(id) == null) {
                    throw new NonexistentEntityException("The dottore with id " + id + " no longer exists.");
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
            Dottore dottore;
            try {
                dottore = em.getReference(Dottore.class, id);
                dottore.getCodiceFiscale();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dottore with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOrphanCheck = dottore.getCartellaostetricadigitaleList();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale : cartellaostetricadigitaleListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dottore (" + dottore + ") cannot be destroyed since the Cartellaostetricadigitale " + cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale + " in its cartellaostetricadigitaleList field has a non-nullable dottore field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Datiautenticazione datiautenticazione = dottore.getDatiautenticazione();
            if (datiautenticazione != null) {
                datiautenticazione.getDottoreList().remove(dottore);
                datiautenticazione = em.merge(datiautenticazione);
            }
            em.remove(dottore);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dottore> findDottoreEntities() {
        return findDottoreEntities(true, -1, -1);
    }

    public List<Dottore> findDottoreEntities(int maxResults, int firstResult) {
        return findDottoreEntities(false, maxResults, firstResult);
    }

    private List<Dottore> findDottoreEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dottore.class));
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

    public Dottore findDottore(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dottore.class, id);
        } finally {
            em.close();
        }
    }

    public int getDottoreCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dottore> rt = cq.from(Dottore.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
