/**
 * 
 */
package org.benevolat.project.service;

import java.util.ArrayList;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

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

@Singleton
@Startup
public class InitializationService {

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
	InscriptionMissionService inscriptionMissionService;

	@PostConstruct
	void init() throws Exception {
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
		a.setButs("EI est une Organisation non Gouvernementale (ONG)");// à but
																		// non-lucratif
																		// dont
																		// l’objectif
																		// est
																		// d’apporter
																		// un
																		// soutien
																		// à des
																		// initiatives
																		// locales
																		// favorisant
																		// le
																		// capital
																		// social.
																		// Ce
																		// soutien
																		// est
																		// basé
																		// sur
																		// le
																		// respect
																		// des
																		// populations
																		// locales
																		// et
																		// sur
																		// le
																		// respect
																		// de
																		// notre
																		// Charte
																		// d’éthique.");
		a.setCommune("Genève");
		a.setContact("Eric Burki");
		a.setDomaineNiveau1(Domaine.SOCIAL);
		a.setEmail("contact@evolutio-international.org");
		a.setNpa("1201");
		a.setPresentation("Le but d’Evolutio International est d’encourager le développement ");// social
																								// et
																								// humain
																								// des
																								// communautés
																								// défavorisées
																								// à
																								// travers
																								// l’élaboration
																								// de
																								// projets
																								// et
																								// le
																								// financement
																								// d’initiatives
																								// locales
																								// durables
																								// et
																								// régissant
																								// sur
																								// le
																								// partenariat.
																								// Nos
																								// domaines
																								// d’activité
																								// sont
																								// la
																								// santé,
																								// l’éducation,
																								// l’économie,
																								// l’environnement
																								// et
																								// la
																								// culture.
																								// L’organisation
																								// est
																								// de
																								// type
																								// non
																								// gouvernementale,
																								// ses
																								// activités
																								// sont
																								// entièrement
																								// non
																								// lucratives
																								// et
																								// libres
																								// de
																								// toute
																								// appartenance
																								// politique
																								// ou
																								// religieuse.
																								// Evolutio
																								// International
																								// privilégie
																								// une
																								// approche
																								// de
																								// soutien
																								// au
																								// développement
																								// qui
																								// se
																								// base
																								// essentiellement
																								// sur
																								// le
																								// respect
																								// de
																								// la
																								// dignité
																								// humaine
																								// et
																								// sur
																								// la
																								// promotion
																								// des
																								// droits
																								// fondamentaux,
																								// afin
																								// de
																								// permettre
																								// aux
																								// personnes
																								// défavorisées
																								// d’initier
																								// des
																								// activités
																								// communes,
																								// en
																								// donnant
																								// des
																								// moyens
																								// pour
																								// sortir
																								// de
																								// situations
																								// difficiles
																								// et
																								// mieux
																								// satisfaire
																								// leurs
																								// besoins.
																								// Si
																								// vous
																								// êtes
																								// curieux
																								// d’en
																								// apprendre
																								// plus
																								// sur
																								// les
																								// objectifs
																								// et
																								// les
																								// valeurs
																								// d’Evolutio
																								// International,
																								// veuillez
																								// s’il
																								// vous
																								// plaît
																								// vous
																								// référer
																								// à
																								// la
																								// Charte
																								// Ethique.");
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
		// e.setImage(i);

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

		// b.setInscriptionsMissions(imL);
		// m.setInscriptionsMissions(imL);
		// im.setBenevole(b);
		// im.setMission(m);

		// b.setNom("Cateau");

		// benevoleService.refresh(b);
		// benevoleService.remove(b);

		// *************************************************

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
		// imageService.save(i);

		e = new Evenement();
		e.setNom("Festival des GEunes Talents");
		e.setLieu("Onex");
		e.setUrl("http://www.cabareve.ch");
		e.setImage(i);
		e.setDateDebut(cal.getTime());
		e.setDescription("Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore");// Découvrez
																																																																																																						// les
																																																																																																						// talents
																																																																																																						// de
																																																																																																						// la
																																																																																																						// région
																																																																																																						// genevoise");
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

}
