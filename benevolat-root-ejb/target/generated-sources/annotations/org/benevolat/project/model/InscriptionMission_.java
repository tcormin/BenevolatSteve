package org.benevolat.project.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(InscriptionMission.class)
public abstract class InscriptionMission_ {

	public static volatile SingularAttribute<InscriptionMission, Long> id;
	public static volatile SingularAttribute<InscriptionMission, Date> dateInscription;
	public static volatile SingularAttribute<InscriptionMission, Status> status;
	public static volatile SingularAttribute<InscriptionMission, Mission> mission;
	public static volatile SingularAttribute<InscriptionMission, String> commentaire;
	public static volatile SingularAttribute<InscriptionMission, Benevole> benevole;

}

