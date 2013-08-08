package org.benevolat.project.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Benevole.class)
public abstract class Benevole_ extends org.benevolat.project.model.Utilisateur_ {

	public static volatile SingularAttribute<Benevole, String> prenom;
	public static volatile SingularAttribute<Benevole, Date> dateNaissance;
	public static volatile SingularAttribute<Benevole, String> presentation;
	public static volatile SingularAttribute<Benevole, String> profession;
	public static volatile SingularAttribute<Benevole, Image> image;
	public static volatile CollectionAttribute<Benevole, InscriptionMission> inscriptionsMissions;
	public static volatile SingularAttribute<Benevole, String> nom;

}

