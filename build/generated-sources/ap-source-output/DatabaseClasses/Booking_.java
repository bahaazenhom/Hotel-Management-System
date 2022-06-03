package DatabaseClasses;

import DatabaseClasses.Employee;
import DatabaseClasses.Guest;
import DatabaseClasses.Payment_1;
import DatabaseClasses.Service;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-03T14:33:17", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Booking.class)
public class Booking_ { 

    public static volatile SingularAttribute<Booking, Date> date;
    public static volatile SingularAttribute<Booking, String> checkOutDate;
    public static volatile SingularAttribute<Booking, Payment_1> paymentID;
    public static volatile SingularAttribute<Booking, Integer> paymentId;
    public static volatile SingularAttribute<Booking, Employee> employeeID;
    public static volatile SingularAttribute<Booking, Integer> employeeId;
    public static volatile SingularAttribute<Booking, String> dateS;
    public static volatile SingularAttribute<Booking, Integer> id;
    public static volatile SingularAttribute<Booking, String> checkInDate;
    public static volatile CollectionAttribute<Booking, Service> serviceCollection;
    public static volatile SingularAttribute<Booking, Guest> guestID;
    public static volatile SingularAttribute<Booking, Integer> guestId;

}