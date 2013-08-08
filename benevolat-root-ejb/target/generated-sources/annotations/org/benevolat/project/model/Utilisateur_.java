package org.benevolat.project.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Utilisateur.class)
public abstract class Utilisateur_ {

	public static volatile SingularAttribute<Utilisateur, Long> id;
	public static volatile SingularAttribute<Utilisateur, String> username;
	public static volatile SingularAttribute<Utilisateur, String> adresse;
	public static volatile SingularAttribute<Utilisateur, String> email;
	public static volatile SingularAttribute<Utilisateur, String> commune;
	public static volatile SingularAttribute<Utilisateur, String> npa;
	public static volatile SingularAttribute<Utilisateur, String> telephone;
	public static volatile SingularAttribute<Utilisateur, String> password;
	public static volatile SingularAttribute<Utilisateur, String> url;

}

