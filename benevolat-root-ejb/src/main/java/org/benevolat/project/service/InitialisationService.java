package org.benevolat.project.service;

import java.util.Calendar;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.benevolat.project.model.Administrateur;
import org.benevolat.project.model.Association;
import org.benevolat.project.model.Benevole;
import org.benevolat.project.model.Domaine;
import org.benevolat.project.model.Evenement;
import org.benevolat.project.model.Mission;
import org.benevolat.project.model.TypeMission;

/**
 * SERVICE d'initialisatoin
 * 
 * @author tcormin
 */
@Singleton
@Startup
public class InitialisationService extends PersistenceService{

	@Inject
	private AssociationService associationService;
	@Inject
	private MissionService missionService;
	@Inject
	private BenevoleService benevoleService;
	@Inject
	private EvenementService evenementService;
	@Inject
	private AdministrateurService administrateurService;
	@Inject
	private ImageService imageService;
	@Inject
	private InscriptionMissionService inscriptionMissionService;
	
//	@PostConstruct
	public void initReally(){
		Administrateur a = new Administrateur();
		a.setPassword("admini");
		a.setUsername("admini");
		
		this.save(a);
	}
	
	//@PostConstruct
	public void init(){

		// Dates préparées
		Calendar cal = Calendar.getInstance();
		cal.set(2013, Calendar.DECEMBER, 12);
		
		Calendar calNaissance = Calendar.getInstance();
		calNaissance.set(1984, Calendar.APRIL, 29);
		
		Calendar calDebut = Calendar.getInstance();
		calDebut.set(2013, Calendar.SEPTEMBER, 29);
		
		Calendar calFin = Calendar.getInstance();
		calFin.set(2013, Calendar.SEPTEMBER, 30);
		
		Calendar calDelai = Calendar.getInstance();
		calDelai.set(2013, Calendar.SEPTEMBER, 10);
		
		   Association a = new Association();
		   a.setUsername("evolutio");
		   a.setNom("Evolutio International");
		   a.setAcronyme("Evolutio");
		   a.setAdresse("Rue de la Navigation 21");
		   a.setButs("EI est une Organisation non Gouvernementale (ONG)");
		   a.setCommune("Genève");
		   a.setContact("Eric Burki");
		   a.setDomaineNiveau1(Domaine.SOCIAL);
		   a.setEmail("contact@evolutio-international.org");
		   a.setNpa("1201");
		   a.setPresentation("Le but d’Evolutio International est d’encourager le développement ");
		   a.setUrl("www.evolutio-international.org");
		   a.setTelephone("");
		   a.setPassword("evolutio");
		   associationService.save(a);
		   
		   Benevole b = new Benevole();
		   b.setUsername("tcormin");
		   b.setNom("Corminboeuf");
		   b.setPrenom("Thomas");
		   b.setAdresse("Avenue des Amazones 12");
		   b.setCommune("1224");
		   b.setEmail("tcormin@bluewin.ch");
		   b.setCommune("Chêne-Bougeries");
		   b.setPresentation("Etudiant, musicien, matheux, fondateur de plusieurs associations et engagé dans un certain nombre d'autres.");
		   b.setProfession("Etudiant");
		   b.setTelephone("079 735 72 49");
		   b.setPassword("tcormin");
		   b.setDateNaissance(calNaissance.getTime());
		   benevoleService.save(b);
		   
		   a = associationService.getFromId(Association.class, "1");
		   Evenement e = new Evenement();
		   e.setNom("Course de l'Escalade");
		   e.setLieu("Onex");
		   e.setUrl("http://www.cabareve.ch");
		   e.setDescription("Salut");
		   e.setDateDebut(cal.getTime());
		   e.setOrganisateur(a);
		   evenementService.save(e);

		   a = associationService.getFromId(Association.class, "1");
		   e = associationService.getFromId(Evenement.class, "1");
		   Mission m = new Mission();
		   m.setTitre("Responsable buvette");
		   m.setNombreBenevoles(2);
		   m.setDescription("Servir les gens");
		   m.setAssociation(a);
		   a.addMission(m);
		   m.setEvenement(e);
		   e.addMission(m);
		   m.setDateDebut(calDebut.getTime());
		   m.setDateFin(calFin.getTime());
		   m.setCategorie(Domaine.MUSIQUE);
		   m.setLieu("Onex");
		   m.setTypeMission(TypeMission.REGULIERE);
		   
		   e = new Evenement();
		   e.setNom("Fête de la musique");
		   e.setLieu("Genève");
		   e.setUrl("http://www.cabareve.ch");
		   e.setDateDebut(cal.getTime());
		   e.setDescription("Salut");
		   evenementService.save(e);
	}

}