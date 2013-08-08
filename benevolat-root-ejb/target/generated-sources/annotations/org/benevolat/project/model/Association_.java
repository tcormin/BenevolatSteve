package org.benevolat.project.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Association.class)
public abstract class Association_ extends org.benevolat.project.model.Utilisateur_ {

	public static volatile SingularAttribute<Association, String> dateCreation;
	public static volatile SingularAttribute<Association, String> presentation;
	public static volatile SingularAttribute<Association, String> acronyme;
	public static volatile CollectionAttribute<Association, Mission> missions;
	public static volatile SingularAttribute<Association, Image> image;
	public static volatile SingularAttribute<Association, String> buts;
	public static volatile SingularAttribute<Association, String> contact;
	public static volatile SingularAttribute<Association, String> nom;
	public static volatile SingularAttribute<Association, Domaine> domaineNiveau1;

}

