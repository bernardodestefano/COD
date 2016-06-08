/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Cartellaostetricadigitale;
import controller.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import bean.Visite;
import bean.Visitaostetrica;
import bean.Storiapreconcezionale;
import bean.Storiaostretricamadredelladonna;
import bean.Storiaostetrica;
import bean.Storiamestruale;
import bean.Storiaginecologica;
import bean.Abitudinidivita;
import bean.Anamnesifamiliare;
import bean.Anamnesipartner;
import bean.Anamnesipersonale;
import bean.Anticoncezionali;
import bean.Bambino;
import bean.Controllogravidanza;
import bean.Decorsodellagravidanza;
import bean.Dottore;
import bean.Ecografie;
import bean.Esameematochimici;
import bean.Esamesierologico;
import bean.Paziente;

/**
 *
 * @author Lodato
 */
public class CartellaostetricadigitaleJpaController {

    public CartellaostetricadigitaleJpaController() {
        emf = Persistence.createEntityManagerFactory("codAppPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cartellaostetricadigitale cartellaostetricadigitale) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Visite visite = cartellaostetricadigitale.getVisite();
            if (visite != null) {
                visite = em.getReference(visite.getClass(), visite.getId());
                cartellaostetricadigitale.setVisite(visite);
            }
            Visitaostetrica visitaostetrica = cartellaostetricadigitale.getVisitaostetrica();
            if (visitaostetrica != null) {
                visitaostetrica = em.getReference(visitaostetrica.getClass(), visitaostetrica.getId());
                cartellaostetricadigitale.setVisitaostetrica(visitaostetrica);
            }
            Storiapreconcezionale storiapreconcezionale = cartellaostetricadigitale.getStoriapreconcezionale();
            if (storiapreconcezionale != null) {
                storiapreconcezionale = em.getReference(storiapreconcezionale.getClass(), storiapreconcezionale.getId());
                cartellaostetricadigitale.setStoriapreconcezionale(storiapreconcezionale);
            }
            Storiaostretricamadredelladonna storiaostretricamadredelladonna = cartellaostetricadigitale.getStoriaostretricamadredelladonna();
            if (storiaostretricamadredelladonna != null) {
                storiaostretricamadredelladonna = em.getReference(storiaostretricamadredelladonna.getClass(), storiaostretricamadredelladonna.getId());
                cartellaostetricadigitale.setStoriaostretricamadredelladonna(storiaostretricamadredelladonna);
            }
            Storiaostetrica storiaostetrica = cartellaostetricadigitale.getStoriaostetrica();
            if (storiaostetrica != null) {
                storiaostetrica = em.getReference(storiaostetrica.getClass(), storiaostetrica.getId());
                cartellaostetricadigitale.setStoriaostetrica(storiaostetrica);
            }
            Storiamestruale storiamestruale = cartellaostetricadigitale.getStoriamestruale();
            if (storiamestruale != null) {
                storiamestruale = em.getReference(storiamestruale.getClass(), storiamestruale.getId());
                cartellaostetricadigitale.setStoriamestruale(storiamestruale);
            }
            Storiaginecologica storiaginecologica = cartellaostetricadigitale.getStoriaginecologica();
            if (storiaginecologica != null) {
                storiaginecologica = em.getReference(storiaginecologica.getClass(), storiaginecologica.getId());
                cartellaostetricadigitale.setStoriaginecologica(storiaginecologica);
            }
            Abitudinidivita abitudinidivita = cartellaostetricadigitale.getAbitudinidivita();
            if (abitudinidivita != null) {
                abitudinidivita = em.getReference(abitudinidivita.getClass(), abitudinidivita.getId());
                cartellaostetricadigitale.setAbitudinidivita(abitudinidivita);
            }
            Anamnesifamiliare anamnesifamiliare = cartellaostetricadigitale.getAnamnesifamiliare();
            if (anamnesifamiliare != null) {
                anamnesifamiliare = em.getReference(anamnesifamiliare.getClass(), anamnesifamiliare.getId());
                cartellaostetricadigitale.setAnamnesifamiliare(anamnesifamiliare);
            }
            Anamnesipartner anamnesipartner = cartellaostetricadigitale.getAnamnesipartner();
            if (anamnesipartner != null) {
                anamnesipartner = em.getReference(anamnesipartner.getClass(), anamnesipartner.getId());
                cartellaostetricadigitale.setAnamnesipartner(anamnesipartner);
            }
            Anamnesipersonale anamnesipersonale = cartellaostetricadigitale.getAnamnesipersonale();
            if (anamnesipersonale != null) {
                anamnesipersonale = em.getReference(anamnesipersonale.getClass(), anamnesipersonale.getId());
                cartellaostetricadigitale.setAnamnesipersonale(anamnesipersonale);
            }
            Anticoncezionali anticoncezionali = cartellaostetricadigitale.getAnticoncezionali();
            if (anticoncezionali != null) {
                anticoncezionali = em.getReference(anticoncezionali.getClass(), anticoncezionali.getId());
                cartellaostetricadigitale.setAnticoncezionali(anticoncezionali);
            }
            Bambino bambino = cartellaostetricadigitale.getBambino();
            if (bambino != null) {
                bambino = em.getReference(bambino.getClass(), bambino.getId());
                cartellaostetricadigitale.setBambino(bambino);
            }
            Controllogravidanza controllogravidanza = cartellaostetricadigitale.getControllogravidanza();
            if (controllogravidanza != null) {
                controllogravidanza = em.getReference(controllogravidanza.getClass(), controllogravidanza.getId());
                cartellaostetricadigitale.setControllogravidanza(controllogravidanza);
            }
            Decorsodellagravidanza decorsodellagravidanza = cartellaostetricadigitale.getDecorsodellagravidanza();
            if (decorsodellagravidanza != null) {
                decorsodellagravidanza = em.getReference(decorsodellagravidanza.getClass(), decorsodellagravidanza.getId());
                cartellaostetricadigitale.setDecorsodellagravidanza(decorsodellagravidanza);
            }
            Dottore dottore = cartellaostetricadigitale.getDottore();
            if (dottore != null) {
                dottore = em.getReference(dottore.getClass(), dottore.getCodiceFiscale());
                cartellaostetricadigitale.setDottore(dottore);
            }
            Ecografie ecografie = cartellaostetricadigitale.getEcografie();
            if (ecografie != null) {
                ecografie = em.getReference(ecografie.getClass(), ecografie.getId());
                cartellaostetricadigitale.setEcografie(ecografie);
            }
            Esameematochimici esameematochimici = cartellaostetricadigitale.getEsameematochimici();
            if (esameematochimici != null) {
                esameematochimici = em.getReference(esameematochimici.getClass(), esameematochimici.getId());
                cartellaostetricadigitale.setEsameematochimici(esameematochimici);
            }
            Esamesierologico esamesierologico = cartellaostetricadigitale.getEsamesierologico();
            if (esamesierologico != null) {
                esamesierologico = em.getReference(esamesierologico.getClass(), esamesierologico.getId());
                cartellaostetricadigitale.setEsamesierologico(esamesierologico);
            }
            Paziente paziente = cartellaostetricadigitale.getPaziente();
            if (paziente != null) {
                paziente = em.getReference(paziente.getClass(), paziente.getCodiceFiscale());
                cartellaostetricadigitale.setPaziente(paziente);
            }
            em.persist(cartellaostetricadigitale);
            if (visite != null) {
                visite.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                visite = em.merge(visite);
            }
            if (visitaostetrica != null) {
                visitaostetrica.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                visitaostetrica = em.merge(visitaostetrica);
            }
            if (storiapreconcezionale != null) {
                storiapreconcezionale.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                storiapreconcezionale = em.merge(storiapreconcezionale);
            }
            if (storiaostretricamadredelladonna != null) {
                storiaostretricamadredelladonna.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                storiaostretricamadredelladonna = em.merge(storiaostretricamadredelladonna);
            }
            if (storiaostetrica != null) {
                storiaostetrica.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                storiaostetrica = em.merge(storiaostetrica);
            }
            if (storiamestruale != null) {
                storiamestruale.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                storiamestruale = em.merge(storiamestruale);
            }
            if (storiaginecologica != null) {
                storiaginecologica.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                storiaginecologica = em.merge(storiaginecologica);
            }
            if (abitudinidivita != null) {
                abitudinidivita.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                abitudinidivita = em.merge(abitudinidivita);
            }
            if (anamnesifamiliare != null) {
                anamnesifamiliare.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                anamnesifamiliare = em.merge(anamnesifamiliare);
            }
            if (anamnesipartner != null) {
                anamnesipartner.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                anamnesipartner = em.merge(anamnesipartner);
            }
            if (anamnesipersonale != null) {
                anamnesipersonale.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                anamnesipersonale = em.merge(anamnesipersonale);
            }
            if (anticoncezionali != null) {
                anticoncezionali.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                anticoncezionali = em.merge(anticoncezionali);
            }
            if (bambino != null) {
                bambino.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                bambino = em.merge(bambino);
            }
            if (controllogravidanza != null) {
                controllogravidanza.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                controllogravidanza = em.merge(controllogravidanza);
            }
            if (decorsodellagravidanza != null) {
                decorsodellagravidanza.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                decorsodellagravidanza = em.merge(decorsodellagravidanza);
            }
            if (dottore != null) {
                dottore.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                dottore = em.merge(dottore);
            }
            if (ecografie != null) {
                ecografie.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                ecografie = em.merge(ecografie);
            }
            if (esameematochimici != null) {
                esameematochimici.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                esameematochimici = em.merge(esameematochimici);
            }
            if (esamesierologico != null) {
                esamesierologico.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                esamesierologico = em.merge(esamesierologico);
            }
            if (paziente != null) {
                paziente.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                paziente = em.merge(paziente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cartellaostetricadigitale cartellaostetricadigitale) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cartellaostetricadigitale persistentCartellaostetricadigitale = em.find(Cartellaostetricadigitale.class, cartellaostetricadigitale.getId());
            Visite visiteOld = persistentCartellaostetricadigitale.getVisite();
            Visite visiteNew = cartellaostetricadigitale.getVisite();
            Visitaostetrica visitaostetricaOld = persistentCartellaostetricadigitale.getVisitaostetrica();
            Visitaostetrica visitaostetricaNew = cartellaostetricadigitale.getVisitaostetrica();
            Storiapreconcezionale storiapreconcezionaleOld = persistentCartellaostetricadigitale.getStoriapreconcezionale();
            Storiapreconcezionale storiapreconcezionaleNew = cartellaostetricadigitale.getStoriapreconcezionale();
            Storiaostretricamadredelladonna storiaostretricamadredelladonnaOld = persistentCartellaostetricadigitale.getStoriaostretricamadredelladonna();
            Storiaostretricamadredelladonna storiaostretricamadredelladonnaNew = cartellaostetricadigitale.getStoriaostretricamadredelladonna();
            Storiaostetrica storiaostetricaOld = persistentCartellaostetricadigitale.getStoriaostetrica();
            Storiaostetrica storiaostetricaNew = cartellaostetricadigitale.getStoriaostetrica();
            Storiamestruale storiamestrualeOld = persistentCartellaostetricadigitale.getStoriamestruale();
            Storiamestruale storiamestrualeNew = cartellaostetricadigitale.getStoriamestruale();
            Storiaginecologica storiaginecologicaOld = persistentCartellaostetricadigitale.getStoriaginecologica();
            Storiaginecologica storiaginecologicaNew = cartellaostetricadigitale.getStoriaginecologica();
            Abitudinidivita abitudinidivitaOld = persistentCartellaostetricadigitale.getAbitudinidivita();
            Abitudinidivita abitudinidivitaNew = cartellaostetricadigitale.getAbitudinidivita();
            Anamnesifamiliare anamnesifamiliareOld = persistentCartellaostetricadigitale.getAnamnesifamiliare();
            Anamnesifamiliare anamnesifamiliareNew = cartellaostetricadigitale.getAnamnesifamiliare();
            Anamnesipartner anamnesipartnerOld = persistentCartellaostetricadigitale.getAnamnesipartner();
            Anamnesipartner anamnesipartnerNew = cartellaostetricadigitale.getAnamnesipartner();
            Anamnesipersonale anamnesipersonaleOld = persistentCartellaostetricadigitale.getAnamnesipersonale();
            Anamnesipersonale anamnesipersonaleNew = cartellaostetricadigitale.getAnamnesipersonale();
            Anticoncezionali anticoncezionaliOld = persistentCartellaostetricadigitale.getAnticoncezionali();
            Anticoncezionali anticoncezionaliNew = cartellaostetricadigitale.getAnticoncezionali();
            Bambino bambinoOld = persistentCartellaostetricadigitale.getBambino();
            Bambino bambinoNew = cartellaostetricadigitale.getBambino();
            Controllogravidanza controllogravidanzaOld = persistentCartellaostetricadigitale.getControllogravidanza();
            Controllogravidanza controllogravidanzaNew = cartellaostetricadigitale.getControllogravidanza();
            Decorsodellagravidanza decorsodellagravidanzaOld = persistentCartellaostetricadigitale.getDecorsodellagravidanza();
            Decorsodellagravidanza decorsodellagravidanzaNew = cartellaostetricadigitale.getDecorsodellagravidanza();
            Dottore dottoreOld = persistentCartellaostetricadigitale.getDottore();
            Dottore dottoreNew = cartellaostetricadigitale.getDottore();
            Ecografie ecografieOld = persistentCartellaostetricadigitale.getEcografie();
            Ecografie ecografieNew = cartellaostetricadigitale.getEcografie();
            Esameematochimici esameematochimiciOld = persistentCartellaostetricadigitale.getEsameematochimici();
            Esameematochimici esameematochimiciNew = cartellaostetricadigitale.getEsameematochimici();
            Esamesierologico esamesierologicoOld = persistentCartellaostetricadigitale.getEsamesierologico();
            Esamesierologico esamesierologicoNew = cartellaostetricadigitale.getEsamesierologico();
            Paziente pazienteOld = persistentCartellaostetricadigitale.getPaziente();
            Paziente pazienteNew = cartellaostetricadigitale.getPaziente();
            if (visiteNew != null) {
                visiteNew = em.getReference(visiteNew.getClass(), visiteNew.getId());
                cartellaostetricadigitale.setVisite(visiteNew);
            }
            if (visitaostetricaNew != null) {
                visitaostetricaNew = em.getReference(visitaostetricaNew.getClass(), visitaostetricaNew.getId());
                cartellaostetricadigitale.setVisitaostetrica(visitaostetricaNew);
            }
            if (storiapreconcezionaleNew != null) {
                storiapreconcezionaleNew = em.getReference(storiapreconcezionaleNew.getClass(), storiapreconcezionaleNew.getId());
                cartellaostetricadigitale.setStoriapreconcezionale(storiapreconcezionaleNew);
            }
            if (storiaostretricamadredelladonnaNew != null) {
                storiaostretricamadredelladonnaNew = em.getReference(storiaostretricamadredelladonnaNew.getClass(), storiaostretricamadredelladonnaNew.getId());
                cartellaostetricadigitale.setStoriaostretricamadredelladonna(storiaostretricamadredelladonnaNew);
            }
            if (storiaostetricaNew != null) {
                storiaostetricaNew = em.getReference(storiaostetricaNew.getClass(), storiaostetricaNew.getId());
                cartellaostetricadigitale.setStoriaostetrica(storiaostetricaNew);
            }
            if (storiamestrualeNew != null) {
                storiamestrualeNew = em.getReference(storiamestrualeNew.getClass(), storiamestrualeNew.getId());
                cartellaostetricadigitale.setStoriamestruale(storiamestrualeNew);
            }
            if (storiaginecologicaNew != null) {
                storiaginecologicaNew = em.getReference(storiaginecologicaNew.getClass(), storiaginecologicaNew.getId());
                cartellaostetricadigitale.setStoriaginecologica(storiaginecologicaNew);
            }
            if (abitudinidivitaNew != null) {
                abitudinidivitaNew = em.getReference(abitudinidivitaNew.getClass(), abitudinidivitaNew.getId());
                cartellaostetricadigitale.setAbitudinidivita(abitudinidivitaNew);
            }
            if (anamnesifamiliareNew != null) {
                anamnesifamiliareNew = em.getReference(anamnesifamiliareNew.getClass(), anamnesifamiliareNew.getId());
                cartellaostetricadigitale.setAnamnesifamiliare(anamnesifamiliareNew);
            }
            if (anamnesipartnerNew != null) {
                anamnesipartnerNew = em.getReference(anamnesipartnerNew.getClass(), anamnesipartnerNew.getId());
                cartellaostetricadigitale.setAnamnesipartner(anamnesipartnerNew);
            }
            if (anamnesipersonaleNew != null) {
                anamnesipersonaleNew = em.getReference(anamnesipersonaleNew.getClass(), anamnesipersonaleNew.getId());
                cartellaostetricadigitale.setAnamnesipersonale(anamnesipersonaleNew);
            }
            if (anticoncezionaliNew != null) {
                anticoncezionaliNew = em.getReference(anticoncezionaliNew.getClass(), anticoncezionaliNew.getId());
                cartellaostetricadigitale.setAnticoncezionali(anticoncezionaliNew);
            }
            if (bambinoNew != null) {
                bambinoNew = em.getReference(bambinoNew.getClass(), bambinoNew.getId());
                cartellaostetricadigitale.setBambino(bambinoNew);
            }
            if (controllogravidanzaNew != null) {
                controllogravidanzaNew = em.getReference(controllogravidanzaNew.getClass(), controllogravidanzaNew.getId());
                cartellaostetricadigitale.setControllogravidanza(controllogravidanzaNew);
            }
            if (decorsodellagravidanzaNew != null) {
                decorsodellagravidanzaNew = em.getReference(decorsodellagravidanzaNew.getClass(), decorsodellagravidanzaNew.getId());
                cartellaostetricadigitale.setDecorsodellagravidanza(decorsodellagravidanzaNew);
            }
            if (dottoreNew != null) {
                dottoreNew = em.getReference(dottoreNew.getClass(), dottoreNew.getCodiceFiscale());
                cartellaostetricadigitale.setDottore(dottoreNew);
            }
            if (ecografieNew != null) {
                ecografieNew = em.getReference(ecografieNew.getClass(), ecografieNew.getId());
                cartellaostetricadigitale.setEcografie(ecografieNew);
            }
            if (esameematochimiciNew != null) {
                esameematochimiciNew = em.getReference(esameematochimiciNew.getClass(), esameematochimiciNew.getId());
                cartellaostetricadigitale.setEsameematochimici(esameematochimiciNew);
            }
            if (esamesierologicoNew != null) {
                esamesierologicoNew = em.getReference(esamesierologicoNew.getClass(), esamesierologicoNew.getId());
                cartellaostetricadigitale.setEsamesierologico(esamesierologicoNew);
            }
            if (pazienteNew != null) {
                pazienteNew = em.getReference(pazienteNew.getClass(), pazienteNew.getCodiceFiscale());
                cartellaostetricadigitale.setPaziente(pazienteNew);
            }
            cartellaostetricadigitale = em.merge(cartellaostetricadigitale);
            if (visiteOld != null && !visiteOld.equals(visiteNew)) {
                visiteOld.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                visiteOld = em.merge(visiteOld);
            }
            if (visiteNew != null && !visiteNew.equals(visiteOld)) {
                visiteNew.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                visiteNew = em.merge(visiteNew);
            }
            if (visitaostetricaOld != null && !visitaostetricaOld.equals(visitaostetricaNew)) {
                visitaostetricaOld.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                visitaostetricaOld = em.merge(visitaostetricaOld);
            }
            if (visitaostetricaNew != null && !visitaostetricaNew.equals(visitaostetricaOld)) {
                visitaostetricaNew.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                visitaostetricaNew = em.merge(visitaostetricaNew);
            }
            if (storiapreconcezionaleOld != null && !storiapreconcezionaleOld.equals(storiapreconcezionaleNew)) {
                storiapreconcezionaleOld.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                storiapreconcezionaleOld = em.merge(storiapreconcezionaleOld);
            }
            if (storiapreconcezionaleNew != null && !storiapreconcezionaleNew.equals(storiapreconcezionaleOld)) {
                storiapreconcezionaleNew.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                storiapreconcezionaleNew = em.merge(storiapreconcezionaleNew);
            }
            if (storiaostretricamadredelladonnaOld != null && !storiaostretricamadredelladonnaOld.equals(storiaostretricamadredelladonnaNew)) {
                storiaostretricamadredelladonnaOld.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                storiaostretricamadredelladonnaOld = em.merge(storiaostretricamadredelladonnaOld);
            }
            if (storiaostretricamadredelladonnaNew != null && !storiaostretricamadredelladonnaNew.equals(storiaostretricamadredelladonnaOld)) {
                storiaostretricamadredelladonnaNew.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                storiaostretricamadredelladonnaNew = em.merge(storiaostretricamadredelladonnaNew);
            }
            if (storiaostetricaOld != null && !storiaostetricaOld.equals(storiaostetricaNew)) {
                storiaostetricaOld.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                storiaostetricaOld = em.merge(storiaostetricaOld);
            }
            if (storiaostetricaNew != null && !storiaostetricaNew.equals(storiaostetricaOld)) {
                storiaostetricaNew.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                storiaostetricaNew = em.merge(storiaostetricaNew);
            }
            if (storiamestrualeOld != null && !storiamestrualeOld.equals(storiamestrualeNew)) {
                storiamestrualeOld.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                storiamestrualeOld = em.merge(storiamestrualeOld);
            }
            if (storiamestrualeNew != null && !storiamestrualeNew.equals(storiamestrualeOld)) {
                storiamestrualeNew.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                storiamestrualeNew = em.merge(storiamestrualeNew);
            }
            if (storiaginecologicaOld != null && !storiaginecologicaOld.equals(storiaginecologicaNew)) {
                storiaginecologicaOld.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                storiaginecologicaOld = em.merge(storiaginecologicaOld);
            }
            if (storiaginecologicaNew != null && !storiaginecologicaNew.equals(storiaginecologicaOld)) {
                storiaginecologicaNew.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                storiaginecologicaNew = em.merge(storiaginecologicaNew);
            }
            if (abitudinidivitaOld != null && !abitudinidivitaOld.equals(abitudinidivitaNew)) {
                abitudinidivitaOld.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                abitudinidivitaOld = em.merge(abitudinidivitaOld);
            }
            if (abitudinidivitaNew != null && !abitudinidivitaNew.equals(abitudinidivitaOld)) {
                abitudinidivitaNew.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                abitudinidivitaNew = em.merge(abitudinidivitaNew);
            }
            if (anamnesifamiliareOld != null && !anamnesifamiliareOld.equals(anamnesifamiliareNew)) {
                anamnesifamiliareOld.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                anamnesifamiliareOld = em.merge(anamnesifamiliareOld);
            }
            if (anamnesifamiliareNew != null && !anamnesifamiliareNew.equals(anamnesifamiliareOld)) {
                anamnesifamiliareNew.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                anamnesifamiliareNew = em.merge(anamnesifamiliareNew);
            }
            if (anamnesipartnerOld != null && !anamnesipartnerOld.equals(anamnesipartnerNew)) {
                anamnesipartnerOld.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                anamnesipartnerOld = em.merge(anamnesipartnerOld);
            }
            if (anamnesipartnerNew != null && !anamnesipartnerNew.equals(anamnesipartnerOld)) {
                anamnesipartnerNew.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                anamnesipartnerNew = em.merge(anamnesipartnerNew);
            }
            if (anamnesipersonaleOld != null && !anamnesipersonaleOld.equals(anamnesipersonaleNew)) {
                anamnesipersonaleOld.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                anamnesipersonaleOld = em.merge(anamnesipersonaleOld);
            }
            if (anamnesipersonaleNew != null && !anamnesipersonaleNew.equals(anamnesipersonaleOld)) {
                anamnesipersonaleNew.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                anamnesipersonaleNew = em.merge(anamnesipersonaleNew);
            }
            if (anticoncezionaliOld != null && !anticoncezionaliOld.equals(anticoncezionaliNew)) {
                anticoncezionaliOld.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                anticoncezionaliOld = em.merge(anticoncezionaliOld);
            }
            if (anticoncezionaliNew != null && !anticoncezionaliNew.equals(anticoncezionaliOld)) {
                anticoncezionaliNew.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                anticoncezionaliNew = em.merge(anticoncezionaliNew);
            }
            if (bambinoOld != null && !bambinoOld.equals(bambinoNew)) {
                bambinoOld.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                bambinoOld = em.merge(bambinoOld);
            }
            if (bambinoNew != null && !bambinoNew.equals(bambinoOld)) {
                bambinoNew.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                bambinoNew = em.merge(bambinoNew);
            }
            if (controllogravidanzaOld != null && !controllogravidanzaOld.equals(controllogravidanzaNew)) {
                controllogravidanzaOld.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                controllogravidanzaOld = em.merge(controllogravidanzaOld);
            }
            if (controllogravidanzaNew != null && !controllogravidanzaNew.equals(controllogravidanzaOld)) {
                controllogravidanzaNew.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                controllogravidanzaNew = em.merge(controllogravidanzaNew);
            }
            if (decorsodellagravidanzaOld != null && !decorsodellagravidanzaOld.equals(decorsodellagravidanzaNew)) {
                decorsodellagravidanzaOld.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                decorsodellagravidanzaOld = em.merge(decorsodellagravidanzaOld);
            }
            if (decorsodellagravidanzaNew != null && !decorsodellagravidanzaNew.equals(decorsodellagravidanzaOld)) {
                decorsodellagravidanzaNew.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                decorsodellagravidanzaNew = em.merge(decorsodellagravidanzaNew);
            }
            if (dottoreOld != null && !dottoreOld.equals(dottoreNew)) {
                dottoreOld.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                dottoreOld = em.merge(dottoreOld);
            }
            if (dottoreNew != null && !dottoreNew.equals(dottoreOld)) {
                dottoreNew.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                dottoreNew = em.merge(dottoreNew);
            }
            if (ecografieOld != null && !ecografieOld.equals(ecografieNew)) {
                ecografieOld.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                ecografieOld = em.merge(ecografieOld);
            }
            if (ecografieNew != null && !ecografieNew.equals(ecografieOld)) {
                ecografieNew.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                ecografieNew = em.merge(ecografieNew);
            }
            if (esameematochimiciOld != null && !esameematochimiciOld.equals(esameematochimiciNew)) {
                esameematochimiciOld.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                esameematochimiciOld = em.merge(esameematochimiciOld);
            }
            if (esameematochimiciNew != null && !esameematochimiciNew.equals(esameematochimiciOld)) {
                esameematochimiciNew.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                esameematochimiciNew = em.merge(esameematochimiciNew);
            }
            if (esamesierologicoOld != null && !esamesierologicoOld.equals(esamesierologicoNew)) {
                esamesierologicoOld.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                esamesierologicoOld = em.merge(esamesierologicoOld);
            }
            if (esamesierologicoNew != null && !esamesierologicoNew.equals(esamesierologicoOld)) {
                esamesierologicoNew.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                esamesierologicoNew = em.merge(esamesierologicoNew);
            }
            if (pazienteOld != null && !pazienteOld.equals(pazienteNew)) {
                pazienteOld.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                pazienteOld = em.merge(pazienteOld);
            }
            if (pazienteNew != null && !pazienteNew.equals(pazienteOld)) {
                pazienteNew.getCartellaostetricadigitaleList().add(cartellaostetricadigitale);
                pazienteNew = em.merge(pazienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cartellaostetricadigitale.getId();
                if (findCartellaostetricadigitale(id) == null) {
                    throw new NonexistentEntityException("The cartellaostetricadigitale with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cartellaostetricadigitale cartellaostetricadigitale;
            try {
                cartellaostetricadigitale = em.getReference(Cartellaostetricadigitale.class, id);
                cartellaostetricadigitale.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cartellaostetricadigitale with id " + id + " no longer exists.", enfe);
            }
            Visite visite = cartellaostetricadigitale.getVisite();
            if (visite != null) {
                visite.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                visite = em.merge(visite);
            }
            Visitaostetrica visitaostetrica = cartellaostetricadigitale.getVisitaostetrica();
            if (visitaostetrica != null) {
                visitaostetrica.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                visitaostetrica = em.merge(visitaostetrica);
            }
            Storiapreconcezionale storiapreconcezionale = cartellaostetricadigitale.getStoriapreconcezionale();
            if (storiapreconcezionale != null) {
                storiapreconcezionale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                storiapreconcezionale = em.merge(storiapreconcezionale);
            }
            Storiaostretricamadredelladonna storiaostretricamadredelladonna = cartellaostetricadigitale.getStoriaostretricamadredelladonna();
            if (storiaostretricamadredelladonna != null) {
                storiaostretricamadredelladonna.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                storiaostretricamadredelladonna = em.merge(storiaostretricamadredelladonna);
            }
            Storiaostetrica storiaostetrica = cartellaostetricadigitale.getStoriaostetrica();
            if (storiaostetrica != null) {
                storiaostetrica.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                storiaostetrica = em.merge(storiaostetrica);
            }
            Storiamestruale storiamestruale = cartellaostetricadigitale.getStoriamestruale();
            if (storiamestruale != null) {
                storiamestruale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                storiamestruale = em.merge(storiamestruale);
            }
            Storiaginecologica storiaginecologica = cartellaostetricadigitale.getStoriaginecologica();
            if (storiaginecologica != null) {
                storiaginecologica.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                storiaginecologica = em.merge(storiaginecologica);
            }
            Abitudinidivita abitudinidivita = cartellaostetricadigitale.getAbitudinidivita();
            if (abitudinidivita != null) {
                abitudinidivita.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                abitudinidivita = em.merge(abitudinidivita);
            }
            Anamnesifamiliare anamnesifamiliare = cartellaostetricadigitale.getAnamnesifamiliare();
            if (anamnesifamiliare != null) {
                anamnesifamiliare.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                anamnesifamiliare = em.merge(anamnesifamiliare);
            }
            Anamnesipartner anamnesipartner = cartellaostetricadigitale.getAnamnesipartner();
            if (anamnesipartner != null) {
                anamnesipartner.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                anamnesipartner = em.merge(anamnesipartner);
            }
            Anamnesipersonale anamnesipersonale = cartellaostetricadigitale.getAnamnesipersonale();
            if (anamnesipersonale != null) {
                anamnesipersonale.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                anamnesipersonale = em.merge(anamnesipersonale);
            }
            Anticoncezionali anticoncezionali = cartellaostetricadigitale.getAnticoncezionali();
            if (anticoncezionali != null) {
                anticoncezionali.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                anticoncezionali = em.merge(anticoncezionali);
            }
            Bambino bambino = cartellaostetricadigitale.getBambino();
            if (bambino != null) {
                bambino.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                bambino = em.merge(bambino);
            }
            Controllogravidanza controllogravidanza = cartellaostetricadigitale.getControllogravidanza();
            if (controllogravidanza != null) {
                controllogravidanza.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                controllogravidanza = em.merge(controllogravidanza);
            }
            Decorsodellagravidanza decorsodellagravidanza = cartellaostetricadigitale.getDecorsodellagravidanza();
            if (decorsodellagravidanza != null) {
                decorsodellagravidanza.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                decorsodellagravidanza = em.merge(decorsodellagravidanza);
            }
            Dottore dottore = cartellaostetricadigitale.getDottore();
            if (dottore != null) {
                dottore.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                dottore = em.merge(dottore);
            }
            Ecografie ecografie = cartellaostetricadigitale.getEcografie();
            if (ecografie != null) {
                ecografie.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                ecografie = em.merge(ecografie);
            }
            Esameematochimici esameematochimici = cartellaostetricadigitale.getEsameematochimici();
            if (esameematochimici != null) {
                esameematochimici.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                esameematochimici = em.merge(esameematochimici);
            }
            Esamesierologico esamesierologico = cartellaostetricadigitale.getEsamesierologico();
            if (esamesierologico != null) {
                esamesierologico.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                esamesierologico = em.merge(esamesierologico);
            }
            Paziente paziente = cartellaostetricadigitale.getPaziente();
            if (paziente != null) {
                paziente.getCartellaostetricadigitaleList().remove(cartellaostetricadigitale);
                paziente = em.merge(paziente);
            }
            em.remove(cartellaostetricadigitale);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cartellaostetricadigitale> findCartellaostetricadigitaleEntities() {
        return findCartellaostetricadigitaleEntities(true, -1, -1);
    }

    public List<Cartellaostetricadigitale> findCartellaostetricadigitaleEntities(int maxResults, int firstResult) {
        return findCartellaostetricadigitaleEntities(false, maxResults, firstResult);
    }

    private List<Cartellaostetricadigitale> findCartellaostetricadigitaleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cartellaostetricadigitale.class));
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

    public Cartellaostetricadigitale findCartellaostetricadigitale(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cartellaostetricadigitale.class, id);
        } finally {
            em.close();
        }
    }

    public int getCartellaostetricadigitaleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cartellaostetricadigitale> rt = cq.from(Cartellaostetricadigitale.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
