package model.security;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.security.Group;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T01:22:25")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile ListAttribute<User, Group> groups;
    public static volatile SingularAttribute<User, String> userName;
    public static volatile SingularAttribute<User, Boolean> enabled;

}