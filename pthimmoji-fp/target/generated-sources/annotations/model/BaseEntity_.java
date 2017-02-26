package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T01:22:25")
@StaticMetamodel(BaseEntity.class)
public class BaseEntity_ { 

    public static volatile SingularAttribute<BaseEntity, Date> lastUpdated;
    public static volatile SingularAttribute<BaseEntity, String> description;
    public static volatile SingularAttribute<BaseEntity, Integer> id;
    public static volatile SingularAttribute<BaseEntity, String> title;
    public static volatile SingularAttribute<BaseEntity, Integer> version;

}