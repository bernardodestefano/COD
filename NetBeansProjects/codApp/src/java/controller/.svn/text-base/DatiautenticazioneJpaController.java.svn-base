/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Datiautenticazione;
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
import bean.Dottore;
import java.util.ArrayList;
import java.util.List;
import bean.Paziente;
import bean.Amministratore;

/**
 *
 * @author Lodato
 */
public class DatiautenticazioneJpaController {

    public DatiautenticazioneJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Datiautenticazione datiautenticazione) throws PreexistingEntityException, Exception {
        if (datiautenticazione.getDottoreList() == null) {
            datiautenticazione.setDottoreList(new ArrayList<Dottore>());
        }
        if (datiautenticazione.getPazienteList() == null) {
            datiautenticazione.setPazienteList(new ArrayList<Paziente>());
        }
        if (datiautenticazione.getAmministratoreList() == null) {
            datiautenticazione.setAmministratoreList(new ArrayList<Amministratore>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Dottore> attachedDottoreList = new ArrayList<Dottore>();
            for (Dottore dottoreListDottoreToAttach : datiautenticazione.getDottoreList()) {
                dottoreListDottoreToAttach = em.getReference(dottoreListDottoreToAttach.getClass(), dottoreListDottoreToAttach.getCodiceFiscale());
                attachedDottoreList.add(dottoreListDottoreToAttach);
            }
            datiautenticazione.setDottoreList(attachedDottoreList);
            List<Paziente> attachedPazienteList = new ArrayList<Paziente>();
            for (Paziente pazienteListPazienteToAttach : datiautenticazione.getPazienteList()) {
                pazienteListPazienteToAttach = em.getReference(pazienteListPazienteToAttach.getClass(), pazienteListPazienteToAttach.getCodiceFiscale());
                attachedPazienteList.add(pazienteListPazienteToAttach);
            }
            datiautenticazione.setPazienteList(attachedPazienteList);
            List<Amministratore> attachedAmministratoreList = new ArrayList<Amministratore>();
            for (Amministratore amministratoreListAmministratoreToAttach : datiautenticazione.getAmministratoreList()) {
                amministratoreListAmministratoreToAttach = em.getReference(amministratoreListAmministratoreToAttach.getClass(), amministratoreListAmministratoreToAttach.getCodiceFiscale());
                attachedAmministratoreList.add(amministratoreListAmministratoreToAttach);
            }
            datiautenticazione.setAmministratoreList(attachedAmministratoreList);
            em.persist(datiautenticazione);
            for (Dottore dottoreListDottore : datiautenticazione.getDottoreList()) {
                Datiautenticazione oldDatiautenticazioneOfDottoreListDottore = dottoreListDottore.getDatiautenticazione();
                dottoreListDottore.setDatiautenticazione(datiautenticazione);
                dottoreListDottore = em.merge(dottoreListDottore);
                if (oldDatiautenticazioneOfDottoreListDottore != null) {
                    oldDatiautenticazioneOfDottoreListDottore.getDottoreList().remove(dottoreListDottore);
                    oldDatiautenticazioneOfDottoreListDottore = em.merge(oldDatiautenticazioneOfDottoreListDottore);
                }
            }
            for (Paziente pazienteListPaziente : datiautenticazione.getPazienteList()) {
                Datiautenticazione oldDatiautenticazioneOfPazienteListPaziente = pazienteListPaziente.getDatiautenticazione();
                pazienteListPaziente.setDatiautenticazione(datiautenticazione);
                pazienteListPaziente = em.merge(pazienteListPaziente);
                if (oldDatiautenticazioneOfPazienteListPaziente != null) {
                    oldDatiautenticazioneOfPazienteListPaziente.getPazienteList().remove(pazienteListPaziente);
                    oldDatiautenticazioneOfPazienteListPaziente = em.merge(oldDatiautenticazioneOfPazienteListPaziente);
                }
            }
            for (Amministratore amministratoreListAmministratore : datiautenticazione.getAmministratoreList()) {
                Datiautenticazione oldDatiautenticazioneOfAmministratoreListAmministratore = amministratoreListAmministratore.getDatiautenticazione();
                amministratoreListAmministratore.setDatiautenticazione(datiautenticazione);
                amministratoreListAmministratore = em.merge(amministratoreListAmministratore);
                if (oldDatiautenticazioneOfAmministratoreListAmministratore != null) {
                    oldDatiautenticazioneOfAmministratoreListAmministratore.getAmministratoreList().remove(amministratoreListAmministratore);
                    oldDatiautenticazioneOfAmministratoreListAmministratore = em.merge(oldDatiautenticazioneOfAmministratoreListAmministratore);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDatiautenticazione(datiautenticazione.getUsername()) != null) {
                throw new PreexistingEntityException("Datiautenticazione " + datiautenticazione + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Datiautenticazione datiautenticazione) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Datiautenticazione persistentDatiautenticazione = em.find(Datiautenticazione.class, datiautenticazione.getUsername());
            List<Dottore> dottoreListOld = persistentDatiautenticazione.getDottoreList();
            List<Dottore> dottoreListNew = datiautenticazione.getDottoreList();
            List<Paziente> pazienteListOld = persistentDatiautenticazione.getPazienteList();
            List<Paziente> pazienteListNew = datiautenticazione.getPazienteList();
            List<Amministratore> amministratoreListOld = persistentDatiautenticazione.getAmministratoreList();
            List<Amministratore> amministratoreListNew = datiautenticazione.getAmministratoreList();
            List<String> illegalOrphanMessages = null;
            for (Dottore dottoreListOldDottore : dottoreListOld) {
                if (!dottoreListNew.contains(dottoreListOldDottore)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Dottore " + dottoreListOldDottore + " since its datiautenticazione field is not nullable.");
                }
            }
            for (Paziente pazienteListOldPaziente : pazienteListOld) {
                if (!pazienteListNew.contains(pazienteListOldPaziente)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Paziente " + pazienteListOldPaziente + " since its datiautenticazione field is not nullable.");
                }
            }
            for (Amministratore amministratoreListOldAmministratore : amministratoreListOld) {
                if (!amministratoreListNew.contains(amministratoreListOldAmministratore)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Amministratore " + amministratoreListOldAmministratore + " since its datiautenticazione field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Dottore> attachedDottoreListNew = new ArrayList<Dottore>();
            for (Dottore dottoreListNewDottoreToAttach : dottoreListNew) {
                dottoreListNewDottoreToAttach = em.getReference(dottoreListNewDottoreToAttach.getClass(), dottoreListNewDottoreToAttach.getCodiceFiscale());
                attachedDottoreListNew.add(dottoreListNewDottoreToAttach);
            }
            dottoreListNew = attachedDottoreListNew;
            datiautenticazione.setDottoreList(dottoreListNew);
            List<Paziente> attachedPazienteListNew = new ArrayList<Paziente>();
            for (Paziente pazienteListNewPazienteToAttach : pazienteListNew) {
                pazienteListNewPazienteToAttach = em.getReference(pazienteListNewPazienteToAttach.getClass(), pazienteListNewPazienteToAttach.getCodiceFiscale());
                attachedPazienteListNew.add(pazienteListNewPazienteToAttach);
            }
            pazienteListNew = attachedPazienteListNew;
            datiautenticazione.setPazienteList(pazienteListNew);
            List<Amministratore> attachedAmministratoreListNew = new ArrayList<Amministratore>();
            for (Amministratore amministratoreListNewAmministratoreToAttach : amministratoreListNew) {
                amministratoreListNewAmministratoreToAttach = em.getReference(amministratoreListNewAmministratoreToAttach.getClass(), amministratoreListNewAmministratoreToAttach.getCodiceFiscale());
                attachedAmministratoreListNew.add(amministratoreListNewAmministratoreToAttach);
            }
            amministratoreListNew = attachedAmministratoreListNew;
            datiautenticazione.setAmministratoreList(amministratoreListNew);
            datiautenticazione = em.merge(datiautenticazione);
            for (Dottore dottoreListNewDottore : dottoreListNew) {
                if (!dottoreListOld.contains(dottoreListNewDottore)) {
                    Datiautenticazione oldDatiautenticazioneOfDottoreListNewDottore = dottoreListNewDottore.getDatiautenticazione();
                    dottoreListNewDottore.setDatiautenticazione(datiautenticazione);
                    dottoreListNewDottore = em.merge(dottoreListNewDottore);
                    if (oldDatiautenticazioneOfDottoreListNewDottore != null && !oldDatiautenticazioneOfDottoreListNewDottore.equals(datiautenticazione)) {
                        oldDatiautenticazioneOfDottoreListNewDottore.getDottoreList().remove(dottoreListNewDottore);
                        oldDatiautenticazioneOfDottoreListNewDottore = em.merge(oldDatiautenticazioneOfDottoreListNewDottore);
                    }
                }
            }
            for (Paziente pazienteListNewPaziente : pazienteListNew) {
                if (!pazienteListOld.contains(pazienteListNewPaziente)) {
                    Datiautenticazione oldDatiautenticazioneOfPazienteListNewPaziente = pazienteListNewPaziente.getDatiautenticazione();
                    pazienteListNewPaziente.setDatiautenticazione(datiautenticazione);
                    pazienteListNewPaziente = em.merge(pazienteListNewPaziente);
                    if (oldDatiautenticazioneOfPazienteListNewPaziente != null && !oldDatiautenticazioneOfPazienteListNewPaziente.equals(datiautenticazione)) {
                        oldDatiautenticazioneOfPazienteListNewPaziente.getPazienteList().remove(pazienteListNewPaziente);
                        oldDatiautenticazioneOfPazienteListNewPaziente = em.merge(oldDatiautenticazioneOfPazienteListNewPaziente);
                    }
                }
            }
            for (Amministratore amministratoreListNewAmministratore : amministratoreListNew) {
                if (!amministratoreListOld.contains(amministratoreListNewAmministratore)) {
                    Datiautenticazione oldDatiautenticazioneOfAmministratoreListNewAmministratore = amministratoreListNewAmministratore.getDatiautenticazione();
                    amministratoreListNewAmministratore.setDatiautenticazione(datiautenticazione);
                    amministratoreListNewAmministratore = em.merge(amministratoreListNewAmministratore);
                    if (oldDatiautenticazioneOfAmministratoreListNewAmministratore != null && !oldDatiautenticazioneOfAmministratoreListNewAmministratore.equals(datiautenticazione)) {
                        oldDatiautenticazioneOfAmministratoreListNewAmministratore.getAmministratoreList().remove(amministratoreListNewAmministratore);
                        oldDatiautenticazioneOfAmministratoreListNewAmministratore = em.merge(oldDatiautenticazioneOfAmministratoreListNewAmministratore);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = datiautenticazione.getUsername();
                if (findDatiautenticazione(id) == null) {
                    throw new NonexistentEntityException("The datiautenticazione with id " + id + " no longer exists.");
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
            Datiautenticazione datiautenticazione;
            try {
                datiautenticazione = em.getReference(Datiautenticazione.class, id);
                datiautenticazione.getUsername();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The datiautenticazione with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Dottore> dottoreListOrphanCheck = datiautenticazione.getDottoreList();
            for (Dottore dottoreListOrphanCheckDottore : dottoreListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Datiautenticazione (" + datiautenticazione + ") cannot be destroyed since the Dottore " + dottoreListOrphanCheckDottore + " in its dottoreList field has a non-nullable datiautenticazione field.");
            }
            List<Paziente> pazienteListOrphanCheck = datiautenticazione.getPazienteList();
            for (Paziente pazienteListOrphanCheckPaziente : pazienteListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Datiautenticazione (" + datiautenticazione + ") cannot be destroyed since the Paziente " + pazienteListOrphanCheckPaziente + " in its pazienteList field has a non-nullable datiautenticazione field.");
            }
            List<Amministratore> amministratoreListOrphanCheck = datiautenticazione.getAmministratoreList();
            for (Amministratore amministratoreListOrphanCheckAmministratore : amministratoreListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Datiautenticazione (" + datiautenticazione + ") cannot be destroyed since the Amministratore " + amministratoreListOrphanCheckAmministratore + " in its amministratoreList field has a non-nullable datiautenticazione field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(datiautenticazione);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Datiautenticazione> findDatiautenticazioneEntities() {
        return findDatiautenticazioneEntities(true, -1, -1);
    }

    public List<Datiautenticazione> findDatiautenticazioneEntities(int maxResults, int firstResult) {
        return findDatiautenticazioneEntities(false, maxResults, firstResult);
    }

    private List<Datiautenticazione> findDatiautenticazioneEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Datiautenticazione.class));
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

    public Datiautenticazione findDatiautenticazione(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Datiautenticazione.class, id);
        } finally {
            em.close();
        }
    }

    public int getDatiautenticazioneCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Datiautenticazione> rt = cq.from(Datiautenticazione.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
