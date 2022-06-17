/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import DatabaseClasses.Room;
import DatabaseClasses.Guest;
import DatabaseClasses.Department;
import java.lang.*;
import java.util.*;
import java.sql.*;
import DatabaseClasses.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Bahaa Zenhom
 */
class Methods {
public static String Role;
public static Connection connect(){
        Properties prop=new Properties();
        try {
          prop.load(new FileInputStream("C:\\Users\\Bahaa Zenhom\\Documents\\NetBeansProjects\\JavaApplication3\\src\\GUI\\databaseConnection.properties"));
        } catch (IOException ex) {
            Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url = prop.getProperty("dburl");
        String user = prop.getProperty("user");
        String pass = prop.getProperty("password");
        Connection connect=null;
        try{
            connect=DriverManager.getConnection(url,user,pass);
        }
        catch(SQLException ex){
             System.out.println("error");
             ex.printStackTrace();
        }
   return connect;
}
public static Statement makeStatement(){
    Statement statement=null;
     try{
           statement=connect().createStatement();
        }
        catch(SQLException ex){
            System.out.println("error");
            ex.printStackTrace();
                    
        }
    return statement;
}
public static PreparedStatement getPreparedStatement(String query){
     PreparedStatement p_statement=null;
     try{
           p_statement=connect().prepareStatement(query);
        }
        catch(SQLException ex){
            System.out.println("error");
            ex.printStackTrace();          
        }
  return p_statement;
}
public static void addDepartment(Department newDep){
     try{
          PreparedStatement addDep=getPreparedStatement("insert into Department(name,description,hotel_branch_ID) values(?,?,1)");
          addDep.setString(1,newDep.getName());
          addDep.setString(2,newDep.getDescription());
          addDep.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println("error");
            ex.printStackTrace();
        }
}
public static void addGuest(Guest guest){
    PreparedStatement add=getPreparedStatement("insert into Guest(first_name,second_name,email,contuct_num,proof_ID,hotel_ID) values(?,?,?,?,?,1)");
    try{
    add.setString(1, guest.getFirstName());
    add.setString(2, guest.getSecondName());
    add.setString(3, guest.getEmail());
    add.setString(4, guest.getContactNum());
    add.setString(5, guest.getProofID());
    add.executeUpdate();
}
    catch(SQLException ex){
        ex.printStackTrace();
    }
}
public static void addRoom(Room room){
      PreparedStatement add=getPreparedStatement("insert into room(type,floor,air_conditions,smoke_fiendly,pet_fiendly) values(?,?,?,?,?)");
    try{
    add.setString(1, room.getType());
    add.setString(2, room.getFloor().toString());
    add.setBoolean(3, room.getAirConditions());
    add.setBoolean(4, room.getSmokeFiendly());
    add.setBoolean(5, room.getPetFiendly());
    add.executeUpdate();
}
    catch(SQLException ex){
        ex.printStackTrace();
    }
}
public static void addBookedRooms(Room room){
      PreparedStatement add=getPreparedStatement("insert into rooms_booked(booking_id,room_id) values(?,?)");
    try{
    Statement bookId=Methods.makeStatement();
    ResultSet result=bookId.executeQuery("select max(ID) as id from booking");
    int bookid=0;
    if(result.next())bookid=result.getInt("id");
    add.setInt(1, bookid);
    add.setInt(2, room.getId());
    add.executeUpdate();
}
    catch(SQLException ex){
        ex.printStackTrace();
    }
}
public static void addChoosenServices(Service service){
    PreparedStatement add=getPreparedStatement("insert into booking_has_service(booking_id,service_id) values(?,?)");
    try{
    Statement bookId=Methods.makeStatement();
    ResultSet result=bookId.executeQuery("select max(ID) as id from booking");
    int bookid=0;
    if(result.next())bookid=result.getInt("id");
    add.setInt(1, bookid);
    add.setInt(2, service.getId());
    add.executeUpdate();
}
    catch(SQLException ex){
        ex.printStackTrace();
    }
}
public static void addBooking(Booking booking){////String checkInDate,String checkOutDate,int employeeid,int guestid,int paymentid
      PreparedStatement add=getPreparedStatement("insert into booking(check_in_date,check_out_date,employee_ID,guest_ID,payment_ID) values(?,?,?,?,?)");
    try{ 
    add.setString(1, booking.getCheckInDate());
    add.setString(2, booking.getCheckOutDate());
    add.setInt(3, booking.getEmployeeID());
    add.setInt(4, booking.getGuestID());
    add.setInt(5, booking.getPaymentID());
    add.executeUpdate();
}
    catch(SQLException ex){
        ex.printStackTrace();
    }
}
public static void deleteRoom(Room room){
      PreparedStatement add=getPreparedStatement("delete from room where id=?");
    try{
    add.setInt(1, room.getId());
    add.executeUpdate();
}
    catch(SQLException ex){
        ex.printStackTrace();
    }
}
public static void addService(Service service){
      PreparedStatement add=getPreparedStatement("insert into Service(name,description,cost) values(?,?,?)");
    try{
    add.setString(1, service.getName());
    add.setString(2, service.getDescription());
    add.setFloat(3, (float) service.getCost());
    add.executeUpdate();
}
    catch(SQLException ex){
        ex.printStackTrace();
    }
}
public static void addEmployee(Employee employee,int depId){
    PreparedStatement insertEmployee=Methods.getPreparedStatement("insert into Employee(first_name, second_name,email,contuct_num,proof_ID,address,dep_ID,role,salary,Access,password) values(?,?,?,?,?,?,?,?,?,?,?)");
     try{
       insertEmployee.setString(1, employee.getFirstName());
       insertEmployee.setString(2, employee.getSecondName());
       insertEmployee.setString(3, employee.getEmail());
       insertEmployee.setString(4, employee.getContuctNum());
       insertEmployee.setString(5, employee.getProofID());
       insertEmployee.setString(6, employee.getAddress());
       insertEmployee.setInt(7,depId);
       insertEmployee.setString(8, employee.getRole());
       insertEmployee.setDouble(9, employee.getSalary());
       insertEmployee.setBoolean(10, employee.getAccess());
       insertEmployee.setString(11, employee.getPassword());
       insertEmployee.executeUpdate();
     }
     catch(SQLException ex){
         ex.printStackTrace();
     }
   
}
public static Room convertRowIntoRoomObject(ResultSet resultSet) throws SQLException {
        int id=Integer.parseInt(resultSet.getString("ID"));
        String rowType=resultSet.getString("type");
        char rowFloor=resultSet.getString("floor").charAt(0);
        boolean rowAir_con=resultSet.getBoolean("air_conditions");
        boolean rowSmoke=resultSet.getBoolean("smoke_fiendly");
        boolean rowPet=resultSet.getBoolean("pet_fiendly");
        boolean rowAvailable=resultSet.getBoolean("availability");
        return new Room(id,rowType,rowFloor,rowAir_con,rowSmoke,rowPet,rowAvailable);
    }
public static Booking convertRowIntoBookingObject(ResultSet resultSet) throws SQLException {
        String bookingDate=resultSet.getString("date");
        String checkIn=resultSet.getString("check_in_date");
        String check_out=resultSet.getString("check_out_date");
        int empId=resultSet.getInt("employee_id");
        int guestId=resultSet.getInt("guest_id");
        int payId=resultSet.getInt("payment_id");
        return new Booking(bookingDate,checkIn,check_out,empId,guestId,payId);
    }
public static Guest convertRowIntoGuestObject(ResultSet resultSet) throws SQLException {
        String firstName=resultSet.getString("first_name");
        String second_name=resultSet.getString("second_name");
        String email=resultSet.getString("email");
        String number=resultSet.getString("contuct_num");
        String proofId=resultSet.getString("proof_ID");
        return new Guest(firstName,second_name,email,number,proofId);
    }
public static Employee convertRowIntoEmployeeObject(ResultSet resultSet) throws SQLException {
        String firstName=resultSet.getString("first_name");
        String second_name=resultSet.getString("second_name");
        String email=resultSet.getString("email");
        String number=resultSet.getString("contuct_num");
        String role=resultSet.getString("role");
        String address=resultSet.getString("address");
        float salary=resultSet.getFloat("salary");
        String proofId=resultSet.getString("proof_ID");
        String password=resultSet.getString("password");
        boolean access=resultSet.getBoolean("Access");
        return new Employee(firstName,second_name,role,address,proofId,salary,number,email,password,access);
    }
public static List<Room> getAllRooms() throws SQLException {
        List<Room> list=new ArrayList<>();
      Statement statement=Methods.makeStatement();
      ResultSet resultSet=statement.executeQuery("select * from Room");
      while(resultSet.next()){
         Room room=Methods.convertRowIntoRoomObject(resultSet);
          list.add(room);
      }
      return list;

    }
public static List<Booking> getAllBookings() throws SQLException {
        List<Booking> list=new ArrayList<>();
      Statement statement=Methods.makeStatement();
      ResultSet resultSet=statement.executeQuery("select * from booking");
      while(resultSet.next()){
         Booking book=Methods.convertRowIntoBookingObject(resultSet);
          list.add(book);
      }
      return list;

    }
public static List<Guest> searchGuests(String filter,String first,String proof) throws SQLException {
        List<Guest> list=new ArrayList<>();
         PreparedStatement statement=null;
         ResultSet resultSet=null;
       if(filter=="First Name"){
            statement =Methods.getPreparedStatement("select * from guest where first_name like ?");
            StringBuffer test=new StringBuffer(first);
            test.append("%");
            statement.setString(1, test.toString());
            resultSet=statement.executeQuery();
       }
       else{
            statement =Methods.getPreparedStatement("select * from guest where proof_ID like ?");
            StringBuffer test=new StringBuffer(proof);
            test.append("%");
            statement.setString(1, test.toString());
            resultSet=statement.executeQuery();
       }
   
      while(resultSet.next()){
         Guest guest=Methods.convertRowIntoGuestObject(resultSet);
          list.add(guest);
      }
      return list;

    }
public static List<Guest> getAllGuests() throws SQLException {
        List<Guest> list=new ArrayList<>();
      Statement statement=Methods.makeStatement();
      ResultSet resultSet=statement.executeQuery("select * from guest");
      while(resultSet.next()){
         Guest guest=Methods.convertRowIntoGuestObject(resultSet);
          list.add(guest);
      }
      return list;

    }
public static List<Employee> searchEmployees(String filter,String first,String proof,String role) throws SQLException {
        List<Employee> list=new ArrayList<>();
         PreparedStatement statement=null;
         ResultSet resultSet=null;
       if(filter=="First Name"){
            statement =Methods.getPreparedStatement("select * from Employee where first_name like ?");
            StringBuffer test=new StringBuffer(first);
            test.append("%");
            statement.setString(1, test.toString());
            resultSet=statement.executeQuery();
       }
       else if(filter=="Proof ID"){
            statement =Methods.getPreparedStatement("select * from Employee where proof_ID like ?");
            StringBuffer test=new StringBuffer(proof);
            test.append("%");
            statement.setString(1, test.toString());
            resultSet=statement.executeQuery();
       }
       else {
           statement =Methods.getPreparedStatement("select * from Employee where role like ?");
            StringBuffer test=new StringBuffer(role);
            test.append("%");
            statement.setString(1, test.toString());
            resultSet=statement.executeQuery();
       }
   
      while(resultSet.next()){
         Employee employee=Methods.convertRowIntoEmployeeObject(resultSet);
          list.add(employee);
      }
      return list;

    }
public static List<Employee> getAllEmployees() throws SQLException {
        List<Employee> list=new ArrayList<>();
      Statement statement=Methods.makeStatement();
      ResultSet resultSet=statement.executeQuery("select * from Employee");
      while(resultSet.next()){
          Employee employee=Methods.convertRowIntoEmployeeObject(resultSet);
          list.add(employee);
      }
      return list;

    }
public static List<Room> filterRooms(String type,Character floor,boolean air_conditioned,boolean smoke,boolean pet) throws SQLException {
     List<Room> list=new ArrayList<>();
     PreparedStatement statement=Methods.getPreparedStatement("select * from Room where type=? and floor=? and air_conditions=? and smoke_fiendly=? and pet_fiendly=? and availability=?");
     statement.setString(1, type);
     statement.setString(2 ,floor.toString());
     statement.setBoolean(3, air_conditioned);
     statement.setBoolean(4, smoke);
     statement.setBoolean(5, pet);
     statement.setBoolean(6, true);
     ResultSet resultSet=statement.executeQuery();
      while(resultSet.next()){
         Room room=Methods.convertRowIntoRoomObject(resultSet);
          list.add(room);
      }
      return list;

    }
public static List<Booking> filterBooking(int guestId) throws SQLException {
     List<Booking> list=new ArrayList<>();
     PreparedStatement statement=Methods.getPreparedStatement("select * from booking where guest_id=?");
     statement.setInt(1, guestId);
     ResultSet resultSet=statement.executeQuery();
      while(resultSet.next()){
         Booking book=Methods.convertRowIntoBookingObject(resultSet);
          list.add(book);
      }
      return list;

    } 
public static List<Booking> filterBookingByID(int bookingId) throws SQLException {
     List<Booking> list=new ArrayList<>();
     PreparedStatement statement=Methods.getPreparedStatement("select * from booking where id=?");
     statement.setInt(1, bookingId);
     ResultSet resultSet=statement.executeQuery();
      while(resultSet.next()){
         Booking book=Methods.convertRowIntoBookingObject(resultSet);
          list.add(book);
      }
      return list;

    } 
public static List<Booking> nullCheckOutBooking() throws SQLException {
     List<Booking> list=new ArrayList<>();
     Statement statement=Methods.makeStatement();
     ResultSet resultSet=statement.executeQuery("select * from booking where check_out_date='NULL'");
      while(resultSet.next()){
         Booking book=Methods.convertRowIntoBookingObject(resultSet);
          list.add(book);
      }
      return list;

    } 
public static double getServiceCost(String service){
    PreparedStatement prepared=Methods.getPreparedStatement("select cost from service where name=?");
    ResultSet result=null;
    try{
        prepared.setString(1, service);
        result=prepared.executeQuery();
       
    }
    catch(SQLException ex){
       ex.printStackTrace();
    }
      try{
          if(result.next())
          return result.getDouble("cost");
    }
    catch(SQLException ex){
       ex.printStackTrace();
    }
    return 0;
}
public static int getServiceId(String service){
    PreparedStatement prepared=Methods.getPreparedStatement("select id from service where name=?");
    ResultSet result=null;
    try{
        prepared.setString(1, service);
        result=prepared.executeQuery();
       
    }
    catch(SQLException ex){
       ex.printStackTrace();
    }
      try{
          if(result.next())
          return result.getInt("id");
    }
    catch(SQLException ex){
       ex.printStackTrace();
    }
    return 0;
}
public static String getServiceDesc(String service){
    PreparedStatement prepared=Methods.getPreparedStatement("select description from service where name=?");
    ResultSet result=null;
    try{
        prepared.setString(1, service);
        result=prepared.executeQuery();
       
    }
    catch(SQLException ex){
       ex.printStackTrace();
    }
      try{
          if(result.next())
          return result.getString("description");
    }
    catch(SQLException ex){
       ex.printStackTrace();
    }
    return "";
}
public static int getDepId(String DepName){
PreparedStatement depID=Methods.getPreparedStatement("select ID from Department where name=?");
ResultSet result=null;
try{
    depID.setString(1, DepName);
    result=depID.executeQuery();
    while(result.next()){
        return result.getInt("ID");
    }
    
}
catch(SQLException ex){
    ex.printStackTrace();
    
}

return 0;


}
public static void changeAvailability(Room room){
    PreparedStatement prepared=Methods.getPreparedStatement("update room set availability=0 where id=?");
    ResultSet res=null;
    try{
         prepared.setInt(1, room.getId());
         prepared.executeUpdate();
    }
    catch(SQLException ex){
        ex.printStackTrace();
    }
    
   
    
}
public static int getLastGuestID(){
    Statement stm=Methods.makeStatement();
    ResultSet reslt=null;
    try{
    reslt=stm.executeQuery("select max(id) as id from guest");
    if(reslt.next())return reslt.getInt("id");
    }
    catch(SQLException ex){
        ex.printStackTrace();
    }
 return 0;
}
public static void addPayment(Payment_1 payment){
    PreparedStatement prep=Methods.getPreparedStatement("insert into payment(guest_id,type) values(?,?)");
    try{
         prep.setInt(1, payment.getGuestID());
         prep.setString(2, payment.getType());
         prep.executeUpdate();
    }
    catch(SQLException ex){
        ex.printStackTrace();
    }
   
    
}
public static void addCredit(CreditCard credit){
    PreparedStatement prep=Methods.getPreparedStatement("insert into credit(card_num,expire_date,cvv,guest_id) values(?,?,?,?)");
    
    try{
        prep.setString(1, credit.getCardNum());
        prep.setString(2, credit.getExpireDate());
        prep.setString(3, credit.getCvv());
        prep.setInt(4, credit.getGuestid());
        prep.executeUpdate();
    }
    catch(SQLException ex){
        ex.printStackTrace();
    }
   
    
}
public static void addCash(CreditCard credit){
    PreparedStatement prep=Methods.getPreparedStatement("insert into credit(card_num,expire_date,cvv,guest_id) values(?,?,?,?)");
    
    try{
        prep.setString(1, credit.getCardNum());
        prep.setString(2, credit.getExpireDate());
        prep.setString(3, credit.getCvv());
        prep.setInt(4, credit.getGuestid());
        prep.executeUpdate();
    }
    catch(SQLException ex){
        ex.printStackTrace();
    }
   
    
}
public static int getLastPaymetnID(){
    Statement stm=Methods.makeStatement();
    ResultSet reslt=null;
    try{
    reslt=stm.executeQuery("select max(id) as id from payment");
    if(reslt.next())return reslt.getInt("id");
    }
    catch(SQLException ex){
        ex.printStackTrace();
    }
 return 0;
}
public static String askAuthentication(String user,String pass){
    try{
        
            if(user.isEmpty()||pass.isEmpty())return "Enter Username or Password";
            PreparedStatement statement =Methods.getPreparedStatement("select * from Employee where first_name=?");
            statement.setString(1, user);
            ResultSet empDetails=statement.executeQuery();
            if(empDetails.next()){
            int flag=Integer.parseInt(empDetails.getString("Access"));
            if(flag==1){if(!empDetails.getString("password").equals(pass))return "Wrong Username or Password";}
            else return "You have no access";
            }
        }
        catch(SQLException ex){
             ex.printStackTrace();
             return "Error occured";
           
        }
return "success";
}
public static void setLoginRole(String role){
    Role=role;
}
public static String getLoginRole(){
    return Role;
}
public static void setBookingCheckOut(String checkOut,int id){
    PreparedStatement st=Methods.getPreparedStatement("update booking set check_out_date=? where id=?");
    try{
        st.setString(1, checkOut);
        st.setInt(2, id);
        st.executeUpdate();
    }
    catch(SQLException ex){
        ex.printStackTrace();
    }
}
public static String checkBooking(int id){
    PreparedStatement prp=Methods.getPreparedStatement("select check_out_date from booking where id=?");
    try{
        prp.setInt(1,id);
        ResultSet res=prp.executeQuery();
        if(res.next()){
            return res.getString("check_out_date");
        }
    }
    catch(SQLException ex){
        ex.printStackTrace();
    }
    return "null";  
}
}