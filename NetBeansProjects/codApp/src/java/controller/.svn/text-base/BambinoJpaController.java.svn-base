/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Bambino;
import controller.exceptions.IllegalOrphanException;
import controller.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import bean.Graficosinfisidelfondo;
import java.util.ArrayList;
import java.util.List;
import bean.Cartellaostetricadigitale;

/**
 *
 * @author Lodato
 */
public class BambinoJpaController {

    public BambinoJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Bambino bambino) {
        if (bambino.getGraficosinfisidelfondoList() == null) {
            bambino.setGraficosinfisidelfondoList(new ArrayList<Graficosinfisidelfondo>());
        }
        if (bambino.getCartellaostetricadigitaleList() == null) {
            bambino.setCartellaostetricadigitaleList(new ArrayList<Cartellaostetricadigitale>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Graficosinfisidelfondo> attachedGraficosinfisidelfondoList = new ArrayList<Graficosinfisidelfondo>();
            for (Graficosinfisidelfondo graficosinfisidelfondoListGraficosinfisidelfondoToAttach : bambino.getGraficosinfisidelfondoList()) {
                graficosinfisidelfondoListGraficosinfisidelfondoToAttach = em.getReference(graficosinfisidelfondoListGraficosinfisidelfondoToAttach.getClass(), graficosinfisidelfondoListGraficosinfisidelfondoToAttach.getId());
                attachedGraficosinfisidelfondoList.add(graficosinfisidelfondoListGraficosinfisidelfondoToAttach);
            }
            bambino.setGraficosinfisidelfondoList(attachedGraficosinfisidelfondoList);
            List<Cartellaostetricadigitale> attachedCartellaostetricadigitaleList = new ArrayList<Cartellaostetricadigitale>();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitaleToAttach : bambino.getCartellaostetricadigitaleList()) {
                cartellaostetricadigitaleListCartellaostetricadigitaleToAttach = em.getReference(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getClass(), cartellaostetricadigitaleListCartellaostetricadigitaleToAttach.getId());
                attachedCartellaostetricadigitaleList.add(cartellaostetricadigitaleListCartellaostetricadigitaleToAttach);
            }
            bambino.setCartellaostetricadigitaleList(attachedCartellaostetricadigitaleList);
            em.persist(bambino);
            for (Graficosinfisidelfondo graficosinfisidelfondoListGraficosinfisidelfondo : bambino.getGraficosinfisidelfondoList()) {
                Bambino oldBambinoOfGraficosinfisidelfondoListGraficosinfisidelfondo = graficosinfisidelfondoListGraficosinfisidelfondo.getBambino();
                graficosinfisidelfondoListGraficosinfisidelfondo.setBambino(bambino);
                graficosinfisidelfondoListGraficosinfisidelfondo = em.merge(graficosinfisidelfondoListGraficosinfisidelfondo);
                if (oldBambinoOfGraficosinfisidelfondoListGraficosinfisidelfondo != null) {
                    oldBambinoOfGraficosinfisidelfondoListGraficosinfisidelfondo.getGraficosinfisidelfondoList().remove(graficosinfisidelfondoListGraficosinfisidelfondo);
                    oldBambinoOfGraficosinfisidelfondoListGraficosinfisidelfondo = em.merge(oldBambinoOfGraficosinfisidelfondoListGraficosinfisidelfondo);
                }
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListCartellaostetricadigitale : bambino.getCartellaostetricadigitaleList()) {
                Bambino oldBambinoOfCartellaostetricadigitaleListCartellaostetricadigitale = cartellaostetricadigitaleListCartellaostetricadigitale.getBambino();
                cartellaostetricadigitaleListCartellaostetricadigitale.setBambino(bambino);
                cartellaostetricadigitaleListCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListCartellaostetricadigitale);
                if (oldBambinoOfCartellaostetricadigitaleListCartellaostetricadigitale != null) {
                    oldBambinoOfCartellaostetricadigitaleListCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListCartellaostetricadigitale);
                    oldBambinoOfCartellaostetricadigitaleListCartellaostetricadigitale = em.merge(oldBambinoOfCartellaostetricadigitaleListCartellaostetricadigitale);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Bambino bambino) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Bambino persistentBambino = em.find(Bambino.class, bambino.getId());
            List<Graficosinfisidelfondo> graficosinfisidelfondoListOld = persistentBambino.getGraficosinfisidelfondoList();
            List<Graficosinfisidelfondo> graficosinfisidelfondoListNew = bambino.getGraficosinfisidelfondoList();
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOld = persistentBambino.getCartellaostetricadigitaleList();
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListNew = bambino.getCartellaostetricadigitaleList();
            List<String> illegalOrphanMessages = null;
            for (Graficosinfisidelfondo graficosinfisidelfondoListOldGraficosinfisidelfondo : graficosinfisidelfondoListOld) {
                if (!graficosinfisidelfondoListNew.contains(graficosinfisidelfondoListOldGraficosinfisidelfondo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Graficosinfisidelfondo " + graficosinfisidelfondoListOldGraficosinfisidelfondo + " since its bambino field is not nullable.");
                }
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOldCartellaostetricadigitale : cartellaostetricadigitaleListOld) {
                if (!cartellaostetricadigitaleListNew.contains(cartellaostetricadigitaleListOldCartellaostetricadigitale)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cartellaostetricadigitale " + cartellaostetricadigitaleListOldCartellaostetricadigitale + " since its bambino field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Graficosinfisidelfondo> attachedGraficosinfisidelfondoListNew = new ArrayList<Graficosinfisidelfondo>();
            for (Graficosinfisidelfondo graficosinfisidelfondoListNewGraficosinfisidelfondoToAttach : graficosinfisidelfondoListNew) {
                graficosinfisidelfondoListNewGraficosinfisidelfondoToAttach = em.getReference(graficosinfisidelfondoListNewGraficosinfisidelfondoToAttach.getClass(), graficosinfisidelfondoListNewGraficosinfisidelfondoToAttach.getId());
                attachedGraficosinfisidelfondoListNew.add(graficosinfisidelfondoListNewGraficosinfisidelfondoToAttach);
            }
            graficosinfisidelfondoListNew = attachedGraficosinfisidelfondoListNew;
            bambino.setGraficosinfisidelfondoList(graficosinfisidelfondoListNew);
            List<Cartellaostetricadigitale> attachedCartellaostetricadigitaleListNew = new ArrayList<Cartellaostetricadigitale>();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach : cartellaostetricadigitaleListNew) {
                cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach = em.getReference(cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach.getClass(), cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach.getId());
                attachedCartellaostetricadigitaleListNew.add(cartellaostetricadigitaleListNewCartellaostetricadigitaleToAttach);
            }
            cartellaostetricadigitaleListNew = attachedCartellaostetricadigitaleListNew;
            bambino.setCartellaostetricadigitaleList(cartellaostetricadigitaleListNew);
            bambino = em.merge(bambino);
            for (Graficosinfisidelfondo graficosinfisidelfondoListNewGraficosinfisidelfondo : graficosinfisidelfondoListNew) {
                if (!graficosinfisidelfondoListOld.contains(graficosinfisidelfondoListNewGraficosinfisidelfondo)) {
                    Bambino oldBambinoOfGraficosinfisidelfondoListNewGraficosinfisidelfondo = graficosinfisidelfondoListNewGraficosinfisidelfondo.getBambino();
                    graficosinfisidelfondoListNewGraficosinfisidelfondo.setBambino(bambino);
                    graficosinfisidelfondoListNewGraficosinfisidelfondo = em.merge(graficosinfisidelfondoListNewGraficosinfisidelfondo);
                    if (oldBambinoOfGraficosinfisidelfondoListNewGraficosinfisidelfondo != null && !oldBambinoOfGraficosinfisidelfondoListNewGraficosinfisidelfondo.equals(bambino)) {
                        oldBambinoOfGraficosinfisidelfondoListNewGraficosinfisidelfondo.getGraficosinfisidelfondoList().remove(graficosinfisidelfondoListNewGraficosinfisidelfondo);
                        oldBambinoOfGraficosinfisidelfondoListNewGraficosinfisidelfondo = em.merge(oldBambinoOfGraficosinfisidelfondoListNewGraficosinfisidelfondo);
                    }
                }
            }
            for (Cartellaostetricadigitale cartellaostetricadigitaleListNewCartellaostetricadigitale : cartellaostetricadigitaleListNew) {
                if (!cartellaostetricadigitaleListOld.contains(cartellaostetricadigitaleListNewCartellaostetricadigitale)) {
                    Bambino oldBambinoOfCartellaostetricadigitaleListNewCartellaostetricadigitale = cartellaostetricadigitaleListNewCartellaostetricadigitale.getBambino();
                    cartellaostetricadigitaleListNewCartellaostetricadigitale.setBambino(bambino);
                    cartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                    if (oldBambinoOfCartellaostetricadigitaleListNewCartellaostetricadigitale != null && !oldBambinoOfCartellaostetricadigitaleListNewCartellaostetricadigitale.equals(bambino)) {
                        oldBambinoOfCartellaostetricadigitaleListNewCartellaostetricadigitale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitaleListNewCartellaostetricadigitale);
                        oldBambinoOfCartellaostetricadigitaleListNewCartellaostetricadigitale = em.merge(oldBambinoOfCartellaostetricadigitaleListNewCartellaostetricadigitale);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = bambino.getId();
                if (findBambino(id) == null) {
                    throw new NonexistentEntityException("The bambino with id " + id + " no longer exists.");
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
            Bambino bambino;
            try {
                bambino = em.getReference(Bambino.class, id);
                bambino.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bambino with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Graficosinfisidelfondo> graficosinfisidelfondoListOrphanCheck = bambino.getGraficosinfisidelfondoList();
            for (Graficosinfisidelfondo graficosinfisidelfondoListOrphanCheckGraficosinfisidelfondo : graficosinfisidelfondoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Bambino (" + bambino + ") cannot be destroyed since the Graficosinfisidelfondo " + graficosinfisidelfondoListOrphanCheckGraficosinfisidelfondo + " in its graficosinfisidelfondoList field has a non-nullable bambino field.");
            }
            List<Cartellaostetricadigitale> cartellaostetricadigitaleListOrphanCheck = bambino.getCartellaostetricadigitaleList();
            for (Cartellaostetricadigitale cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale : cartellaostetricadigitaleListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Bambino (" + bambino + ") cannot be destroyed since the Cartellaostetricadigitale " + cartellaostetricadigitaleListOrphanCheckCartellaostetricadigitale + " in its cartellaostetricadigitaleList field has a non-nullable bambino field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(bambino);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Bambino> findBambinoEntities() {
        return findBambinoEntities(true, -1, -1);
    }

    public List<Bambino> findBambinoEntities(int maxResults, int firstResult) {
        return findBambinoEntities(false, maxResults, firstResult);
    }

    private List<Bambino> findBambinoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Bambino.class));
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

    public Bambino findBambino(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Bambino.class, id);
        } finally {
            em.close();
        }
    }

    public int getBambinoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Bambino> rt = cq.from(Bambino.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
