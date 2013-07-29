package org.benevolat.project.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.benevolat.project.model.Administrateur;
import org.benevolat.project.model.Association;
import org.benevolat.project.model.Benevole;
import org.benevolat.project.model.Domaine;
import org.benevolat.project.model.Evenement;
import org.benevolat.project.model.Image;
import org.benevolat.project.model.InscriptionMission;
import org.benevolat.project.model.Mission;
import org.benevolat.project.model.Status;
import org.benevolat.project.model.TypeMission;
import org.benevolat.project.model.Utilisateur;
import org.benevolat.project.service.AdministrateurService;
import org.benevolat.project.service.AssociationService;
import org.benevolat.project.service.BenevoleService;
import org.benevolat.project.service.EvenementService;
import org.benevolat.project.service.ImageService;
import org.benevolat.project.service.InscriptionMissionService;
import org.benevolat.project.service.MissionService;
import org.richfaces.application.push.Session;
import org.richfaces.application.push.SessionManager;

@Singleton
@Named("sessionBean")
public class SessionBean implements SessionManager, Serializable{

	private static final long serialVersionUID = 745858547796786996L;
	
	private String searchText = "";
	@Inject
	AssociationService associationService;
	@Inject
	MissionService missionService;
	@Inject
	BenevoleService benevoleService;
	@Inject
	EvenementService evenementService;
	@Inject
	AdministrateurService administrateurService;
	@Inject
	ImageService imageService;
	@Inject
	BenevoleView benevoleView;
	@Inject
	AssociationView associationView;
	@Inject
	InscriptionMissionService inscriptionMissionService;
	Utilisateur user;
	boolean log = false;
	
	public String getTitre(){
		return "Plateforme du Bénévolat";
	}
	
	@PostConstruct
	void init() throws Exception{
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
		   a.setButs("EI est une Organisation non Gouvernementale (ONG)");// à but non-lucratif dont l’objectif est d’apporter un soutien à des initiatives locales favorisant le capital social. Ce soutien est basé sur le respect des populations locales et sur le respect de notre Charte d’éthique.");
		   a.setCommune("Genève");
		   a.setContact("Eric Burki");
		   a.setDomaineNiveau1(Domaine.SOCIAL);
		   a.setEmail("contact@evolutio-international.org");
		   a.setNpa("1201");
		   a.setPresentation("Le but d’Evolutio International est d’encourager le développement ");//social et humain des communautés défavorisées à travers l’élaboration de projets et le financement d’initiatives locales durables et régissant sur le partenariat. Nos domaines d’activité sont la santé, l’éducation, l’économie, l’environnement et la culture. L’organisation est de type non gouvernementale, ses activités sont entièrement non lucratives et libres de toute appartenance politique ou religieuse. Evolutio International privilégie une approche de soutien au développement qui se base essentiellement sur le respect de la dignité humaine et sur la promotion des droits fondamentaux, afin de permettre aux personnes défavorisées d’initier des activités communes, en donnant des moyens pour sortir de situations difficiles et mieux satisfaire leurs besoins. Si vous êtes curieux d’en apprendre plus sur les objectifs et les valeurs d’Evolutio International, veuillez s’il vous plaît vous référer à la Charte Ethique.");
		   a.setUrl("www.evolutio-internanational.org");
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
		   
		   Evenement e = new Evenement();
		   e.setNom("Course de l'Escalade");
		   e.setLieu("Onex");
		   e.setUrl("http://www.cabareve.ch");
		   e.setDescription("Salut");
		   e.setDateDebut(cal.getTime());
		   evenementService.save(e);
		   //e.setImage(i);
		   
		   Mission m = new Mission();
		   m.setTitre("Responsable buvette");
		   m.setNombreBenevoles(2);
		   m.setDescription("Servir les gens");
		   m.setAssociation(a);
		   m.setEvenement(e);
		   m.setDateDebut(calDebut.getTime());
		   m.setDateFin(calFin.getTime());
		   m.setCategorie(Domaine.MUSIQUE);
		   m.setLieu("Onex");
		   m.setTypeMission(TypeMission.REGULIERE);
		   missionService.save(m);
		   
		   InscriptionMission im = new InscriptionMission();
		   im.setCommentaire("Test");
		   im.setStatus(Status.EN_COURS);
		   im.setDateInscription(calDelai.getTime());
		   inscriptionMissionService.save(im);
		   
		   ArrayList<InscriptionMission> imL = new ArrayList<InscriptionMission>();
		   imL.add(im);
		   
//		   b.setInscriptionsMissions(imL);
//		   m.setInscriptionsMissions(imL);
//		   im.setBenevole(b);
//		   im.setMission(m);

		   //b.setNom("Cateau");
		   
//		   benevoleService.refresh(b);
//		   benevoleService.remove(b);
		   
		   //*************************************************
		   
		   a = new Association();
		   a.setUsername("cabareve");
		   a.setNom("Cabareve, rire et illusion");
		   a.setAcronyme("Cabareve");
		   a.setAdresse("c/o Gérard Gualtier, avenue du Gros-Chêne 42");
		   a.setButs("Faire connaître les jeunes talents de la région genevoise");
		   a.setCommune("Onex");
		   a.setContact("Corminboeuf Thomas");
		   a.setDomaineNiveau1(Domaine.MUSIQUE);
		   a.setEmail("info@cabareve.ch");
		   a.setNpa("1213");
		   a.setPresentation("Nous organisons le Festival des GEunes Talents.");
		   a.setUrl("http://www.cabareve.ch");
		   a.setTelephone("079 735 72 49");
		   a.setPassword("cabareve");
		   associationService.save(a);
		   
		   a = new Association();
		   a.setUsername("escalade");
		   a.setNom("Escalade.ch");
		   a.setAcronyme("Escalade");
		   a.setDomaineNiveau1(Domaine.MUSIQUE);
		   a.setPassword("escalade");
		   associationService.save(a);
		   
		   a = new Association();
		   a.setUsername("sports-ge");
		   a.setNom("Association Genevoise des Sports");
		   a.setAcronyme("AGS");
		   a.setDomaineNiveau1(Domaine.MUSIQUE);
		   a.setPassword("sports-ge");
		   
		   associationService.save(a);
		   
		   Administrateur ad = new Administrateur();
		   ad.setUsername("thomas");
		   ad.setPassword("thomas");
		   administrateurService.save(ad);
		   
		   b = new Benevole();
		   b.setUsername("carodaiello");
		   b.setNom("D'Aiello");
		   b.setPrenom("Caroline");
		   b.setPassword("carodaiello");
		   b.setDateNaissance(calNaissance.getTime());
		   benevoleService.save(b);
		   
		   Image i = new Image();
		   i.setLength(100);
		   i.setName("Hublot");
		   //imageService.save(i);
		   
		   e = new Evenement();
		   e.setNom("Festival des GEunes Talents");
		   e.setLieu("Onex");
		   e.setUrl("http://www.cabareve.ch");
		   e.setImage(i);
		   e.setDateDebut(cal.getTime());
		   e.setDescription("Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore");//Découvrez les talents de la région genevoise");
		   evenementService.save(e);
		   
		   e = new Evenement();
		   e.setNom("Fête de la musique");
		   e.setLieu("Genève");
		   e.setUrl("http://www.cabareve.ch");
		   e.setDateDebut(cal.getTime());
		   e.setImage(i);
		   e.setDescription("Salut");
		   evenementService.save(e);
		   
		   e = new Evenement();
		   e.setNom("Joutes du lac");
		   e.setLieu("Genève");
		   e.setUrl("http://www.cabareve.ch");
		   e.setDateDebut(cal.getTime());
		   e.setImage(i);
		   e.setDescription("Salut");
		   evenementService.save(e);
		   
		   e = new Evenement();
		   e.setNom("Jeux de Genève");
		   e.setLieu("Genève");
		   e.setImage(i);
		   e.setUrl("http://www.cabareve.ch");
		   e.setDateDebut(cal.getTime());
		   e.setDescription("Salut");
		   evenementService.save(e);
		
		   e = new Evenement();
		   e.setNom("JOs");
		   e.setLieu("Genève");
		   e.setDescription("Salut");
		   e.setUrl("http://www.cabareve.ch");
		   e.setDateDebut(cal.getTime());
		   e.setImage(i);
		   evenementService.save(e);
		   
		   e = new Evenement();
		   e.setNom("Fête de l'espoir");
		   e.setLieu("Genève");
		   e.setDescription("Salut");
		   e.setUrl("http://www.cabareve.ch");
		   e.setDateDebut(cal.getTime());
		   e.setImage(i);
		   evenementService.save(e);
		   
		   e = new Evenement();
		   e.setNom("Noël des aînés");
		   e.setDescription("Salut");
		   e.setLieu("Genève");
		   e.setUrl("http://www.cabareve.ch");
		   e.setDateDebut(cal.getTime());
		   e.setImage(i);
		   evenementService.save(e);
		   
		   e = new Evenement();
		   e.setNom("Montreux Jazz Festival");
		   e.setLieu("Genève");
		   e.setUrl("http://www.cabareve.ch");
		   e.setDescription("Salut");
		   e.setDateDebut(cal.getTime());
		   e.setImage(i);
		   evenementService.save(e);
		   
		   e = new Evenement();
		   e.setNom("Paléo");
		   e.setLieu("Genève");
		   e.setDescription("Salut");
		   e.setUrl("http://www.cabareve.ch");
		   e.setDateDebut(cal.getTime());
		   e.setImage(i);
		   evenementService.save(e);
		   
		   e = new Evenement();
		   e.setNom("Beach tour");
		   e.setLieu("Genève");
		   e.setDescription("Salut");
		   e.setDateDebut(cal.getTime());
		   e.setUrl("http://www.cabareve.ch");
		   e.setImage(i);
		   evenementService.save(e);
		   
		   e = new Evenement();
		   e.setNom("Coupe du monde");
		   e.setDescription("Salut");
		   e.setLieu("Genève");
		   e.setDateDebut(cal.getTime());
		   e.setUrl("http://www.cabareve.ch");
		   e.setImage(i);
		   evenementService.save(e);
		   
		   e = new Evenement();
		   e.setNom("Foire au cochon");
		   e.setLieu("Onex");
		   e.setDateDebut(cal.getTime());
		   e.setDescription("Salut");
		   e.setUrl("http://www.cabareve.ch");
		   e.setImage(i);
		   evenementService.save(e);
		   
		   a = associationService.getFromId(Association.class, "1");
		   
		   m = new Mission();
		   m.setTitre("Coureur");
		   m.setNombreBenevoles(4);
		   m.setDescription("Sprinter pour le fun");
		   m.setTypeMission(TypeMission.PONCTUELLE);
		   m.setAssociation(a);
		   m.setLieu("Onex");
		   m.setDateDebut(calDebut.getTime());
		   m.setDateFin(calFin.getTime());
		   missionService.save(m);
		   
		   m = new Mission();
		   m.setTitre("DJs");
		   m.setNombreBenevoles(4);
		   m.setDescription("Sprinter pour le fun");
		   m.setTypeMission(TypeMission.PONCTUELLE);
		   m.setLieu("Onex");
		   m.setAssociation(a);
		   m.setEvenement(e);
		   m.setDateDebut(calDebut.getTime());
		   m.setDateFin(calFin.getTime());
		   missionService.save(m);
		   
		   m = new Mission();
		   m.setTitre("Concierge");
		   m.setNombreBenevoles(4);
		   m.setDescription("Sprinter pour le fun");
		   m.setLieu("Onex");
		   m.setTypeMission(TypeMission.REGULIERE);
		   m.setAssociation(a);
		   m.setDateDebut(calDebut.getTime());
		   m.setDateFin(calFin.getTime());
		   missionService.save(m);
		   
		   m = new Mission();
		   m.setTitre("Secrétariat");
		   m.setNombreBenevoles(4);
		   m.setDescription("Sprinter pour le fun");
		   m.setLieu("Onex");
		   m.setTypeMission(TypeMission.REGULIERE);
		   m.setAssociation(a);
		   m.setDateDebut(calDebut.getTime());
		   m.setDateFin(calFin.getTime());
		   missionService.save(m);
	}
	
//    public SessionBean() {
//        gFormations = new GestionnaireFormations();
//        gMissions = new GestionnaireMissions();
//        gUtilisateurs = new GestionnaireUtilisateurs();
//        
//        gUtilisateurs.getDaoAssociation().getAssociations().get(0).getMissions().add(gMissions.getDaoMission().getMissions().get(0));
//		gMissions.getDaoMission().getMissions().get(0).setAssociation(gUtilisateurs.getDaoAssociation().getAssociations().get(0));
//		
//		gUtilisateurs.getDaoAssociation().getAssociations().get(0).getMissions().add(gMissions.getDaoMission().getMissions().get(1));
//		gMissions.getDaoMission().getMissions().get(1).setAssociation(gUtilisateurs.getDaoAssociation().getAssociations().get(0));
//		
//		gUtilisateurs.getDaoAssociation().getAssociations().get(0).getMissions().add(gMissions.getDaoMission().getMissions().get(2));
//		gMissions.getDaoMission().getMissions().get(2).setAssociation(gUtilisateurs.getDaoAssociation().getAssociations().get(0));
//		
//		gUtilisateurs.getDaoAssociation().getAssociations().get(0).getMissions().add(gMissions.getDaoMission().getMissions().get(3));
//		gMissions.getDaoMission().getMissions().get(3).setAssociation(gUtilisateurs.getDaoAssociation().getAssociations().get(0));
//		
//		InscriptionMission i = new InscriptionMission();
//		i.setBenevole(gUtilisateurs.getDaoBenevole().getBenevoles().get(0));
//		i.setCommentaire("Trop jeune");
//		i.setStatus(Status.EN_COURS);
//		i.setMission(gMissions.getDaoMission().getMissions().get(0));
//		gUtilisateurs.getDaoBenevole().getBenevoles().get(0).getInscriptionsMissions().add(i);
//		gMissions.getDaoMission().getMissions().get(0).getInscriptionsMissions().add(i);
//		
//		i = new InscriptionMission();
//		i.setBenevole(gUtilisateurs.getDaoBenevole().getBenevoles().get(0));
//		i.setCommentaire("Bienvenue");
//		i.setStatus(Status.EN_COURS);
//		i.setMission(gMissions.getDaoMission().getMissions().get(1));
//		gUtilisateurs.getDaoBenevole().getBenevoles().get(0).getInscriptionsMissions().add(i);
//		gMissions.getDaoMission().getMissions().get(1).getInscriptionsMissions().add(i);
//		
//		i = new InscriptionMission();
//		i.setBenevole(gUtilisateurs.getDaoBenevole().getBenevoles().get(0));
//		i.setStatus(Status.EN_COURS);
//		i.setMission(gMissions.getDaoMission().getMissions().get(2));
//		gUtilisateurs.getDaoBenevole().getBenevoles().get(0).getInscriptionsMissions().add(i);
//		gMissions.getDaoMission().getMissions().get(2).getInscriptionsMissions().add(i);
//		
//		i = new InscriptionMission();
//		i.setBenevole(gUtilisateurs.getDaoBenevole().getBenevoles().get(0));
//		i.setStatus(Status.EN_COURS);
//		i.setMission(gMissions.getDaoMission().getMissions().get(3));
//		gUtilisateurs.getDaoBenevole().getBenevoles().get(0).getInscriptionsMissions().add(i);
//		gMissions.getDaoMission().getMissions().get(3).getInscriptionsMissions().add(i);
//		
//		gMissions.getDaoMission().getMissions().get(0).setEvenement(gMissions.getDaoEvenement().getEvenements().get(0));
//		
//		EntityManagerFactory emf = Persistence
//				.createEntityManagerFactory("JPADB");
//			
//				 entityManager = emf.createEntityManager();
		
//		EntityTransaction transac = entityManager.getTransaction();
//		Mission m = new Mission();
//		m.setTitre("Hublot");
////		transac.begin();
//		entityManager.persist(m);
//		transac.commit();
//		entityManager.close(); 
		
//    }

//    public void greet() {
//        Utilisateur user = this.gUtilisateurs.getForUsername(username);
//        if (user != null) {
//            greeting = "Hello, " + user.getUsername() + "!";
//        } else {
//            greeting = "No such user exists! Use 'emuster' or 'jdoe'";
//        }
//    }
    
//	public GestionnaireFormations getgFormations() {
//		return gFormations;
//	}
//
//	public void setgFormations(GestionnaireFormations gFormations) {
//		this.gFormations = gFormations;
//	}
//
//	public GestionnaireMissions getgMissions() {
//		return gMissions;
//	}
//
//	public void setgMissions(GestionnaireMissions gMissions) {
//		this.gMissions = gMissions;
//	}
//
//	public GestionnaireUtilisateurs getgUtilisateurs() {
//		return gUtilisateurs;
//	}
//
//	public void setgUtilisateurs(GestionnaireUtilisateurs gUtilisateurs) {
//		this.gUtilisateurs = gUtilisateurs;
//	}
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public Session getPushSession(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void putPushSession(Session arg0) throws IllegalStateException {
		// TODO Auto-generated method stub
		
	}

	public void requeue(Session arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
		System.out.println("J'ai trouvé un(e) : "+user.getClass());
		this.setLog(true);
	}

	public boolean isLog() {
		return log;
	}

	public void setLog(boolean log) {
		this.log = log;
	}

	public String logout(){
		this.user = null;
		this.log=false;
		return "index";
	}
	
	public String monProfil(){
		if (user.getClass() == Benevole.class){
			benevoleView.setNextBenevole(Long.toString(this.user.getid()));
			return "profileBenevole";
		}
		if (this.user.getClass() == Association.class){
			associationView.setNextAssociation(Long.toString(this.user.getid()));
			return "profileAssociation";
		}
		return "index";
	}
	
	public String myMissions(){
//		if (user.getClass() == Benevole.class){
//			benevoleView.setNextBenevole(Long.toString(this.user.getid()));
//			return "myMissionsBenevole";
//		}
//		if (this.user.getClass() == Association.class){
//			associationView.setNextAssociation(Long.toString(this.user.getid()));
//			return "myMissionsAssociation";
//		}
		return "myMissionsAssociation"; // index
	}
}
