package org.benevolat.project.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Mission.class)
public abstract class Mission_ {

	public static volatile SingularAttribute<Mission, String> lieu;
	public static volatile SingularAttribute<Mission, Association> association;
	public static volatile SingularAttribute<Mission, Status> status;
	public static volatile SingularAttribute<Mission, Date> dateFin;
	public static volatile SingularAttribute<Mission, TypeMission> typeMission;
	public static volatile SingularAttribute<Mission, Evenement> evenement;
	public static volatile SingularAttribute<Mission, String> titre;
	public static volatile SingularAttribute<Mission, Date> dateDebut;
	public static volatile SingularAttribute<Mission, Long> id;
	public static volatile SingularAttribute<Mission, Date> delaiInscription;
	public static volatile SingularAttribute<Mission, Domaine> categorie;
	public static volatile SingularAttribute<Mission, String> description;
	public static volatile CollectionAttribute<Mission, InscriptionMission> inscriptionsMissions;
	public static volatile SingularAttribute<Mission, Integer> nombreBenevoles;

}

