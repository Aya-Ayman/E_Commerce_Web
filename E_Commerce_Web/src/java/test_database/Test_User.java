/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_database;

import data_access_layer.DAO.User_DAO;
import data_access_layer.database_manager.DatabaseManager;
import data_transfer_layer.User_DTO;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Hesham
 */
public class Test_User {

 public static void main(String[] args) throws SQLException {



        
        
        
        /** start admin **/
        
        
            /** create 

            AdminImpl adi=new AdminImpl();
            DataBaseManager managerObj = new DataBaseManager();
            Connection con = managerObj.getCon();
            Admin ad=new Admin();
            ad.setPassword("ali");
            ad.setUserName("alix");
            adi.create(ad, con);
            con.close();
            
            **/
            
            
            
             /** retreive

            AdminImpl adi=new AdminImpl();
            DataBaseManager managerObj = new DataBaseManager();
            Connection con = managerObj.getCon();
            Admin ad;
            ad=adi.retreive("alix", con);
            System.out.println(ad.getPassword());
            con.close();
            
             **/             
            
            
            
            /** update 

            AdminImpl adi=new AdminImpl();
            DataBaseManager managerObj = new DataBaseManager();
            Connection con = managerObj.getCon();
            Admin ad;
            ad=adi.retreive("alix", con);
            ad.setPassword("123");
            adi.update(ad, con);
            con.close();
            
             **/  
            

            
            /** delete 
            AdminImpl adi=new AdminImpl();
            DataBaseManager managerObj = new DataBaseManager();
            Connection con = managerObj.getCon();
            Admin ad;
            ad=adi.retreive("alix", con);
            adi.delete(ad, con);
            con.close();

             **/              
        
        
        /** end of admin test **/
        
        
        /** start user**/
        
        
            /** create  
              
            UserWeb c12=new UserWeb();
            
            userImpl ci=new userImpl();
                
            c12.setcredit_limit(34234);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            c12.setDate(java.sql.Date.valueOf("3017-09-09"));
            c12.setAddress("84 ta3wnyat smo7a");
            c12.setEmail("abdalla@yahoo.com");
            c12.setPassword("1234");
            c12.setFirst_name("abdalla");
         //   userImpl ci=new userImpl();
            DataBaseManager managerObj=new DataBaseManager();
            Connection con =managerObj.getCon();
            ci.create(c12, con);
            con.close();
//            
             **/
            
            
            
             /** retreive */
        /*
            userImpl ci=new userImpl();

            DatabaseManager managerObj = new DatabaseManager();
            Connection con = managerObj.getCon();

            UserWeb c=new UserWeb();
            c=ci.retreive("abdalla@yahoo.com", con);
            System.out.println(c.getFirst_name());

            con.close();

        /*    **/             
            
            
            
            /** update **/
/*
            userImpl ci=new userImpl();

            DatabaseManager managerObj = new DatabaseManager();
            Connection con = managerObj.getCon();

            UserWeb c;
            c=ci.retreive("abdalla@saam.com", con);
            c.setName("abdo");
            ci.update(c, con);
            con.commit();
            con.close();
            
            */

            
           

/*       userImpl ci=new userImpl();

DatabaseManager managerObj = new DatabaseManager();
Connection con = managerObj.getCon();

UserWeb c;
c=ci.retreive("mayada@saam.com", con);
System.out.println(c.getEmail());
//c.setGender("female");
//ci.update(c, con);
ci.delete(c, con);
con.commit();
con.close();*/
                        
        
        
        /** end of client test **/        
        
        
        
       
           /** start contact**/
        
        
            /** create new contact

            ContactImpl coi=new ContactImpl();
            DataBaseManager managerObj = new DataBaseManager();
            Connection con = managerObj.getCon();
            Contact co=new Contact();

            userImpl cli=new userImpl();

            user cl1;
            cl1=cli.retreive("cc", con);
            
            user cl2;
            cl2=cli.retreive("abv", con);
            coi.create(cl1, cl2, con);
            con.close();
            **/           
            
            
             /** retreive all contact for a client
            ContactImpl coi=new ContactImpl();
            DataBaseManager managerObj = new DataBaseManager();
            Connection con = managerObj.getCon();


            userImpl cli=new userImpl();
            
            user cl2;
            cl2=cli.retreive("cc", con);
            ArrayList<Contact> ac=coi.retreiveall(cl2, con);
            System.out.println(ac.get(0).getEmail()+" "+ac.get(0).getContactEmail());
            con.close();

             **/             
            
            
            
            /** update 
            ContactImpl coi=new ContactImpl();
            DataBaseManager managerObj = new DataBaseManager();
            Connection con = managerObj.getCon();


            userImpl cli=new userImpl();
            
            user cl2;
            cl2=cli.retreive("cc", con);
            cl2.setEmail("ss");
            cli.update(cl2, con);
            coi.update("cc", cl2, con);
            con.close();
            **/  
            

            
            /** delete 
            ContactImpl coi=new ContactImpl();
            DataBaseManager managerObj = new DataBaseManager();
            Connection con = managerObj.getCon();
            Contact co=new Contact();

            userImpl cli=new userImpl();

            user cl1;
            cl1=cli.retreive("cc", con);
            
            user cl2;
            cl2=cli.retreive("abvb a", con);
            coi.delete(cl1, cl2, con);
            con.close();
             **/              
        
        
        /** end of contact test **/       
        

            
        /** start Groups**/
        
        
            /** create
            
            GroupsImpl gi=new GroupsImpl();
            DataBaseManager managerObj = new DataBaseManager();
            Connection con = managerObj.getCon();
            Groups g=new Groups();
            g.setId("3");
            g.setName("ali");
            gi.create(g, con);
            con.close();
            **/
            
            
            
             /** retreive

            GroupsImpl gi=new GroupsImpl();
            DataBaseManager managerObj = new DataBaseManager();
            Connection con = managerObj.getCon();
            Groups g;
            g=gi.retreive("3", con);
            System.out.println(g.getName());
            con.close();
            
            **/             
            
            
            
            /** update 
            GroupsImpl gi=new GroupsImpl();
            DataBaseManager managerObj = new DataBaseManager();
            Connection con = managerObj.getCon();
            Groups g;
            g=gi.retreive("3", con);
            g.setName("ali");
            gi.update(g, con);
            con.close();
            
             **/  
            

            
            /** delete 
            GroupsImpl gi=new GroupsImpl();
            DataBaseManager managerObj = new DataBaseManager();
            Connection con = managerObj.getCon();
            Groups g;
            g=gi.retreive("3", con);
            gi.delete(g, con);
            con.close();
            **/  
        
        /** end of Groups test **/              
            

            
         /** start Has**/
        
        
            /** create
            HasImpl hi=new HasImpl();
            DataBaseManager managerObj = new DataBaseManager();
            Connection con = managerObj.getCon();
            Has h=new Has();
            h.setEmail("cc");
            h.setId("3");
            hi.create(h, con);
            con.close();

             **/
            
            
            
             /** retreive all groups 

            HasImpl hi=new HasImpl();
            DataBaseManager managerObj = new DataBaseManager();
            Connection con = managerObj.getCon();
            
            ArrayList<Has> ac=hi.retreiveAll("cc", con);
            System.out.println(ac.get(0).getId()+" "+ac.get(0).getEmail());
            con.close();
            
             **/             
            
            
            
            /** update **/


            /** update **/  
            

            
            /** delete 
            HasImpl hi=new HasImpl();
            DataBaseManager managerObj = new DataBaseManager();
            Connection con = managerObj.getCon();
            
            ArrayList<Has> ac=hi.retreiveAll("cc", con);
            hi.delete(ac.get(0), con);
            con.close();

            **/              
        
        
        /** end of Has test **/             
            

            
        /** start requests**/
        
        
            /** create 
            RequestsImpl ri=new RequestsImpl();
            DataBaseManager managerObj = new DataBaseManager();
            Connection con = managerObj.getCon();
            Requests r=new Requests();
            r.setEmailSender("abvb a");
            r.setEmailReciever("cc");
            ri.create(r, con);
            con.close();

           **/
            
            
            
             /** retreive all requests 
            RequestsImpl hi=new RequestsImpl();
            DataBaseManager managerObj = new DataBaseManager();
            Connection con = managerObj.getCon();
            
            ArrayList<Requests> ac=hi.retreiveAll("cc", con);
            System.out.println(ac.get(0).getEmailSender()+" "+ac.get(0).getEmailReciever());
            con.close();

            **/             
            
            
            
            /** update 
             error logic

            **/  
            

            
            /** delete

            RequestsImpl hi=new RequestsImpl();
            DataBaseManager managerObj = new DataBaseManager();
            Connection con = managerObj.getCon();
            
            ArrayList<Requests> ac=hi.retreiveAll("cc", con);
            hi.delete(ac.get(0), con);
            con.close();
            **/              
        
        
        /** end of requests test **/              
            
            
            
            User_DAO dao = new User_DAO();
            User_DTO dto = new User_DTO();
            DatabaseManager mng = new DatabaseManager();
            
            dto.setEmail("email@email.com");
            dto.setPassword("1234");
            dto.setFirst_name("hesham");
            dto.setCredit_limit(5000L);
            dto.setDate(null);
            dto.setJob("dev");
            dto.setImage(null);
            dto.setAddress("alex");
            dto.setLast_name(null);
            
            Connection con = mng.getCon();
             int check =dao.update(dto, con);
             System.out.println(check);
             
             con.close();
            
    }
}
