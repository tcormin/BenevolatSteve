package org.benevolat.project.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Image.class)
public abstract class Image_ {

	public static volatile SingularAttribute<Image, Long> id;
	public static volatile SingularAttribute<Image, String> name;
	public static volatile SingularAttribute<Image, byte[]> data;
	public static volatile SingularAttribute<Image, Long> length;
	public static volatile SingularAttribute<Image, String> mime;

}

