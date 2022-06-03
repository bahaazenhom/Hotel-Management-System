package DatabaseClasses;

import DatabaseClasses.Booking;
import DatabaseClasses.Hotels;
import DatabaseClasses.Payment_1;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-03T14:33:17", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Guest.class)
public class Guest_ { 

    public static volatile SingularAttribute<Guest, String> contactNum;
    public static volatile SingularAttribute<Guest, String> firstName;
    public static volatile SingularAttribute<Guest, Integer> id;
    public static volatile SingularAttribute<Guest, Hotels> hotelID;
    public static volatile SingularAttribute<Guest, String> proofID;
    public static volatile CollectionAttribute<Guest, Booking> bookingCollection;
    public static volatile CollectionAttribute<Guest, Payment_1> paymentCollection;
    public static volatile SingularAttribute<Guest, String> email;
    public static volatile SingularAttribute<Guest, String> secondName;

}