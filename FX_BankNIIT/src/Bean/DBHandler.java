/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ferdinand
 */
public class DBHandler {
    
     public Connection con=null;
    public PreparedStatement pstmt=null;
    public Statement st=null;
    public ResultSet rs=null;
    public String sql=null;
    public String types;
    
    public Connection DBconnection() throws SQLException, ClassNotFoundException
    {
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fx_banking_niit","root","ferazi");
        Class.forName("com.mysql.jdbc.Driver");
        return con;
    }
    
    /*==========================================
       Peform all CRUD for Staff Bean
    ===========================================  */   
    
    //## CODE TO ADD A NEW STAFF
     public void addStadd(Staff staff) throws ClassNotFoundException{
        sql="INSERT IGNORE INTO staff (s_fname, s_lname, s_phone, s_dob, s_email, s_pass, s_address,s_role) values(?,?,?,?,?,?,?,?)";
                      
        try {
            pstmt=DBconnection().prepareStatement(sql);
            //pstmt.setInt(1, user.getUserID());
            pstmt.setString(1, staff.getFirstName());
            pstmt.setString(2, staff.getLastName());
            pstmt.setString(3, staff.getPhone());
            pstmt.setString(4, staff.getDob());
            pstmt.setString(5, staff.getEmail());
            pstmt.setString(6, staff.getPass());
            pstmt.setString(7, staff.getAddress());
            pstmt.setString(8, staff.getRole());
            
            
            if(pstmt.execute())
            {
                JOptionPane.showMessageDialog(null, "Staff added Successful ! ! !");
                pstmt.close();
            }           
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
     
     //### CODE TO UPDATE STAFF DETAILS
      //## CODE TO ADD A NEW STAFF
     public void UpdateStaff(Staff staff) throws ClassNotFoundException{
        sql="UPDATE staff set s_fname=?, s_lname=?, s_phone=?, s_dob=?, s_pass=?, s_address=?, s_role=? where s_email=?";
                      
        try {
            pstmt=DBconnection().prepareStatement(sql);
            //pstmt.setInt(1, user.getUserID());
            pstmt.setString(1, staff.getFirstName());
            pstmt.setString(2, staff.getLastName());
            pstmt.setString(3, staff.getPhone());
            pstmt.setString(4, staff.getDob());
//            pstmt.setString(5, staff.getEmail());
            pstmt.setString(5, staff.getPass());
            pstmt.setString(6, staff.getAddress());
            pstmt.setString(7, staff.getRole());
            pstmt.setString(8, staff.getEmail());
            
            
            pstmt.executeUpdate();
            if(pstmt.execute())
            {
                JOptionPane.showMessageDialog(null, "Staff updated Successful ! ! !");
                pstmt.close();
            }           
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
     
     
     //## CODE TO GET USER DETAILS
     public ResultSet getUser(Staff staff)
    {
       if(!staff.getEmail().equals("")||!staff.getPass().equals(""))
       {
       sql="select * from staff where s_email=? and s_pass=?";
           try 
           {
            /*select all from users where e.g email="max@live.com" and password="Freeman"*/
            pstmt=DBconnection().prepareStatement(sql);
            pstmt.setString(1, staff.getEmail());
            pstmt.setString(2, staff.getPass());
            
            rs= pstmt.executeQuery();
           } catch (SQLException | ClassNotFoundException e) 
           {
               JOptionPane.showMessageDialog(null, e.toString());
           }
         }
       else
       {
           JOptionPane.showMessageDialog(null, "Please enter the right credentials");
       }
        return rs;
    }
     
     //######## CODE TO DELETE STAFF DETAILS
     public  void deleteStaff( Staff staff) throws SQLException, ClassNotFoundException {
        String sql = "Delete From staff where s_email=?";
 
         pstmt = DBconnection().prepareStatement(sql);
            pstmt.setString(1, staff.getEmail());
//            pstmt.setString(2, staff.getPass());
 
        pstmt.executeUpdate();
    }
     
     //###  CODE TO DISPLAY STAFF DETAILS IN TABLEVIEW
             public void loadStaff() {
               try {
               String query="Select * from staff";

               pstmt=con.prepareStatement(query);
               rs=pstmt.executeQuery();

               pstmt.close();
               rs.close();
           } catch (SQLException e) {
               System.err.println(e);
           }

        }
             
             //####### GET STAFF FOR DELETE OR UPDATE
              public ResultSet searchUserForMan(Staff staff)
    {
       if(!staff.getEmail().equals("")||!staff.getPass().equals(""))
       {
       sql="select * from staff where s_email=?";
           try 
           {
            /*select all from users where e.g email="max@live.com" and password="Freeman"*/
            pstmt=DBconnection().prepareStatement(sql);
            pstmt.setString(1, staff.getEmail());
//            pstmt.setString(2, staff.getPass());
            
            rs= pstmt.executeQuery();
           } catch (SQLException | ClassNotFoundException e) 
           {
               JOptionPane.showMessageDialog(null, e.toString());
           }
         }
       else
       {
           JOptionPane.showMessageDialog(null, "Please enter the right credentials");
       }
        return rs;
    }
     
     
       /*==========================================
      // END OF  CRUD for Staff Bean
    ===========================================  */ 
     
     
    /*==========================================
       Peform all CRUD for Account  Bean
    ===========================================  */ 
     
     
         public void addAccount(Account acct) throws ClassNotFoundException
    {
        sql="INSERT IGNORE INTO accounts (a_fname, a_lname, a_phone,a_email, a_dob,  a_city, a_address,a_gender,a_national,a_acctNo,a_acctBal) values(?,?,?,?,?,?,?,?,?,?,?)";
                      
        try {
            pstmt=DBconnection().prepareStatement(sql);
            //pstmt.setInt(1, user.getUserID());
            pstmt.setString(1, acct.getFirstName());
            pstmt.setString(2, acct.getLastName());
            pstmt.setString(3, acct.getPhone());
            pstmt.setString(4, acct.getEmail());
            pstmt.setString(5, acct.getDob());  
            pstmt.setString(6, acct.getCity());
            pstmt.setString(7, acct.getAddress());
            pstmt.setString(8, acct.getGender());
            pstmt.setString(9, acct.getNationality());
            pstmt.setString(10, acct.getAcctNo());
            pstmt.setString(11, acct.getAcctBal());
            
            
            if(pstmt.execute())
            {
                JOptionPane.showMessageDialog(null, "Staff added Successful ! ! !");
                pstmt.close();
            }           
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        
    }
     
     
     
     public ResultSet fetchAccount(Account acct)
    {
       if(!acct.getAcctNo().equals(""))
           
       {
       sql="select * from accounts where a_acctNo=?";
           try 
           {
            /*select all from users where e.g email="max@live.com" and password="Freeman"*/
            pstmt=DBconnection().prepareStatement(sql);
            pstmt.setString(1, acct.getAcctNo());
   
            rs= pstmt.executeQuery();
         
           } catch (SQLException | ClassNotFoundException e) 
           {
               JOptionPane.showMessageDialog(null, e.toString());
           }
         }
       else
       {
           JOptionPane.showMessageDialog(null, "Please enter the right credentials");
       }
        return rs;
    }
     //DML for loading table values
        public void loadAcct() {
               try {
               String query="Select * from accounts";

               pstmt=con.prepareStatement(query);
               rs=pstmt.executeQuery();

               pstmt.close();
               rs.close();
           } catch (SQLException e) {
               System.err.println(e);
           }

        }
        
        /*
        ## UPDATING ACCOUNTS TABLE 
        
        */
    public void updateAccount(Account acct) throws ClassNotFoundException{
        sql="Update accounts set a_fname=?, a_lname=?, a_phone=?, a_email=?, a_dob=?,  a_city=?, a_address=?, a_gender=?, a_national=?, where a_acctNo=?";
                      
        try {
            pstmt=DBconnection().prepareStatement(sql);
            //pstmt.setInt(1, user.getUserID());
            pstmt.setString(1, acct.getFirstName());
            pstmt.setString(2, acct.getLastName());
            pstmt.setString(3, acct.getPhone());
            pstmt.setString(4, acct.getEmail());
            pstmt.setString(5, acct.getDob());  
            pstmt.setString(6, acct.getCity());
            pstmt.setString(7, acct.getAddress());
            pstmt.setString(8, acct.getGender());
            pstmt.setString(9, acct.getNationality());
            pstmt.setString(10, acct.getAcctNo());
//            pstmt.setString(11, acct.getAcctBal());
            
            
            if(pstmt.execute())
            {
                JOptionPane.showMessageDialog(null, "Staff updated Successful ! ! !");
                pstmt.close();
            }           
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        
    }
    
    public  void deleteAccount(Account acct) throws SQLException, ClassNotFoundException {
        String sql = "Delete From accounts where a_acctNo= ?";
 
         pstmt = DBconnection().prepareStatement(sql);
            pstmt.setString(1, acct.getAcctNo());
           
 
        pstmt.executeUpdate();
    }
     
     
     
     
   /*==========================================
      // END OF  CRUD for Account Bean
    ===========================================  */ 
//=============================================================================================================================
         /*==========================================
       Peform all CRUD for Account  Operations 
    ===========================================  */ 
     //1. Perform Deposit
     public void PerformDeposit(Account acct)
    {
   
       sql="update accounts set a_acctBal=? where a_acctNo=?";
           try 
           {
           
            pstmt=DBconnection().prepareStatement(sql);
            pstmt.setString(1, acct.getAcctBal());
            pstmt.setString(2, acct.getAcctNo());
            
            pstmt.executeUpdate();
   
           } catch (SQLException | ClassNotFoundException e) 
           {
               System.out.println("error"+e.getStackTrace() + e.getClass());
               JOptionPane.showMessageDialog(null, e.toString());
               
           }
        
   
       
    }
     
     
     
     
        /*==========================================
      // END OF  CRUD for Account Operations
    ===========================================  */ 
}
