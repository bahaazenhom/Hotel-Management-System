package DatabaseClasses;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-03T14:33:17", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Room.class)
public class Room_ { 

    public static volatile SingularAttribute<Room, Integer> id;
    public static volatile SingularAttribute<Room, Boolean> petFiendly;
    public static volatile SingularAttribute<Room, Boolean> availability;
    public static volatile SingularAttribute<Room, String> type;
    public static volatile SingularAttribute<Room, Character> floor;
    public static volatile SingularAttribute<Room, Boolean> smokeFiendly;
    public static volatile SingularAttribute<Room, Boolean> airConditions;

}