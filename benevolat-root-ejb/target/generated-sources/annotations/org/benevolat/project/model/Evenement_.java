package org.benevolat.project.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Evenement.class)
public abstract class Evenement_ {

	public static volatile SingularAttribute<Evenement, Long> id;
	public static volatile SingularAttribute<Evenement, String> lieu;
	public static volatile SingularAttribute<Evenement, String> description;
	public static volatile CollectionAttribute<Evenement, Mission> missions;
	public static volatile SingularAttribute<Evenement, Association> organisateur;
	public static volatile SingularAttribute<Evenement, Date> dateFin;
	public static volatile SingularAttribute<Evenement, Image> image;
	public static volatile SingularAttribute<Evenement, String> url;
	public static volatile SingularAttribute<Evenement, String> nom;
	public static volatile SingularAttribute<Evenement, Date> dateDebut;

}

