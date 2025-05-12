 
package com.mycompany.atm_management_system.Service;
import java.sql.*;
import com.mycompany.atm_management_system.Entity.Person;
import com.mycompany.atm_management_system.Entity.Transaction;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import java.util.ArrayList;

 
public class PersonService {
    Connection con;
    Statement st;
    ResultSet rs;
    DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDateTime date= LocalDateTime.now();
    public PersonService()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/management","root","1234");
            st=con.createStatement();
            
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void changePassword(Person person)
    {
        try
        {
            st.executeUpdate("update person set password='"+person.getPassword()+"' where pid="+person.getpId());
            JOptionPane.showMessageDialog(null,"Deposit Succesfull" );
        }
        
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void depositeMoney(Person person)
    {
        try
        {
            st.executeUpdate("update person set balance="+person.getBalance()+" where pid ="+person.getpId()+"");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void withdrawMoney(Person person)
    {
        
        try
        {
           
            st.executeUpdate("update person set balance="+person.getBalance()+" where pid ="+person.getpId()+"");
            
        }
        catch(Exception e)
        {
          JOptionPane.showMessageDialog(null,e.getMessage() );  
        }
    }
  public void saveTransaction(String AccountNo,String type,int Amount)
  {
     try
     {
         st.executeUpdate("insert into transaction(Date,AccountNo,Type,Amount)values('"+dtf.format(date)+"','"+AccountNo+"','"+type+"',"+Amount+")");
         
     }
     catch(Exception e)
     {
         JOptionPane.showMessageDialog(null,e.getMessage());
     }
  }
 
      
  
    public String addPerson(Person person )
    {
        try{
            st.executeUpdate("insert into person (name,mobileNo,accountNo,password,balance) values('"+person.getName()+"','"+person.getMobileNo()+"','"+person.getAccountNo()+"','"+person.getPassword()+"',"+person.getBalance()+")");
            return person.getName()+"Added Successfully...";
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
    }
    public Person isUserValid(String account,String password)
    {
        try
        {
            rs=st.executeQuery("select * from person where accountNo='"+account+"' and password='"+password+"'");
            if(rs.next())
            {
                Person person = new Person();
                    person.setpId(rs.getInt("pid"));
                    person.setName(rs.getString("name"));
                    person.setMobileNo(rs.getString("mobileNo"));
                    person.setBalance(rs.getInt("balance"));
                    person.setAccountNo(rs.getString("accountNo"));
                    person.setPassword(rs.getString("password"));
                return person;
            }
            else
            {
                return null;
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
            return null;
        }
    }
    public ArrayList<Transaction> transaction(String AccountNo)
    {
        
        Transaction tran = new Transaction();
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        try
        {
           rs=st.executeQuery("select * from transaction where AccountNo='"+AccountNo+"'");
           while(rs.next())
           {
               Transaction transaction = new Transaction();
                    transaction.setTID(rs.getInt("TID"));
                    transaction.setAmount(rs.getInt("amount"));
                    transaction.setDate(rs.getString("Date"));
                    transaction.setAccountNo(rs.getString("AccountNo"));
                    transaction.setType(rs.getString("Type"));
                list.add(transaction);
           }
           return list;
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null, e.getMessage());
           return null;
        }
             
    }
}
