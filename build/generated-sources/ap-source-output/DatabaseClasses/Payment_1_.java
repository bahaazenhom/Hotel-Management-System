package DatabaseClasses;

import DatabaseClasses.Booking;
import DatabaseClasses.Guest;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-03T14:33:17", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Payment_1.class)
public class Payment_1_ { 

    public static volatile SingularAttribute<Payment_1, Date> date;
    public static volatile SingularAttribute<Payment_1, Double> totalPayment;
    public static volatile SingularAttribute<Payment_1, Integer> id;
    public static volatile SingularAttribute<Payment_1, String> type;
    public static volatile CollectionAttribute<Payment_1, Booking> bookingCollection;
    public static volatile SingularAttribute<Payment_1, Guest> guestID;
    public static volatile SingularAttribute<Payment_1, Integer> guestId;

}