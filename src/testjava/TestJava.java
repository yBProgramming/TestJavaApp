/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class TestJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{  
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.131.21:1521/dwh","hongsakhon","HONG@1996");  
            /*BufferedReader in = new BufferedReader(new FileReader("C:\\bcel_branch.txt"));
            String line;
            while((line = in.readLine()) != null)
            {
                String []branch = line.split(",");
                System.out.println(branch[0]);
                System.out.println("Code: " + branch[0] + " Name: " + branch[1]);
                String sql = "insert into fi_branch(branch_code, branch_name, created_date) values(?,?, now())";
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setString(1, branch[0].trim());
                stm.setString(2, branch[1].trim());
                stm.executeUpdate();
            }
            in.close();*/
            /*BufferedReader in = new BufferedReader(new FileReader("C:\\departments.txt"));
            String line;
            while((line = in.readLine()) != null)
            {
                String []department = line.split(",");
                System.out.println(department[0]);
                System.out.println("Code: " + department[0] + " Name_LA: " + department[1] + " Name_EN: " + department[2] + " Branch: " + department[3]);
                String sql = "insert into fi_department(depart_id, depart_name_la, depart_name_en, branch_code, created_date) values(?,?,?,?, now())";
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setString(1, department[0].trim());
                stm.setString(2, department[1].trim());
                stm.setString(3, department[2].trim());
                stm.setString(4, department[3].trim());
                stm.executeUpdate();
            }
            in.close();*/
            
            /*BufferedReader in = new BufferedReader(new FileReader("C:\\division_d1.txt"));
            String line;
            while((line = in.readLine()) != null)
            {
                String []division = line.split(",");
                System.out.println(division[0]);
                System.out.println("Code: " + division[0] + " Name_LA: " + division[2] + " Dep_id: " + division[1]);
                String sql = "insert into fi_division(division_id, division_name_la, depart_id, created_date) values(?,?,?, now())";
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setString(1, division[0].trim());
                stm.setString(2, division[2].trim());
                stm.setString(3, division[1].trim());
                stm.executeUpdate();
            }
            in.close();*/
            
            /*BufferedReader in = new BufferedReader(new FileReader("C:\\division_b.txt"));
            String line;
            while((line = in.readLine()) != null)
            {
                String []division = line.split(",");
                System.out.println(division[0]);
                System.out.println("Code: " + division[0] + " Name_LA: " + division[2] + " Branch_id: " + division[1]);
                String sql = "insert into fi_division(division_id, division_name_la, branch_code, created_date) values(?,?,?, now())";
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setString(1, division[0].trim());
                stm.setString(2, division[2].trim());
                stm.setString(3, division[1].trim());
                stm.executeUpdate();
            }
            in.close();*/
            
           /*BufferedReader in = new BufferedReader(new FileReader("C:\\marketing_department.txt"));
            String line;
            while((line = in.readLine()) != null)
            {
                String []employees = line.split(",");
                String position = "";
                String ptn = "";
                if(employees[7].trim().equals("8")){
                    position="ຮອງຫົວໜ້າພະແນກ";
                    ptn = "ຮໜພ";
                } else if(employees[7].trim().equals("11")){
                    position="ຫົວໜ້າຂະແໜງ";
                    ptn = "ຫໜຂ";
                } else if(employees[7].trim().equals("12")){
                    position="ວ່າການຫົວໜ້າຂະແໜງ";
                    ptn = "ຫໜຂ";
                }  else if(employees[7].trim().equals("13")){
                    position="ຮອງຫົວໜ້າຂະແໜງ";
                    ptn = "ຮໜຂ";
                } else if(employees[7].trim().equals("14")){
                    position="ວິຊາການ";
                    ptn = "ວຊກ";
                } else if(employees[7].trim().equals("52")){
                    position="ພະນັກງານທົດສອບ";
                    ptn = "ພງສ";
                } else if(employees[7].trim().equals("54")){
                    position="ວິຊາການສັນຍາຈ້າງ";
                    ptn = "ວຊສ";
                }
                System.out.println(employees[0]);
                System.out.println(
                        "Title: " + employees[0].trim() + 
                        " Name_LA: " + employees[1].trim() + 
                        " Surname_la: " + employees[3].trim() + 
                        " Name_en: " + employees[2].trim() +
                        " Dep: " + employees[5].trim() + 
                        " Tel: " + employees[9].trim()+ 
                        " Disision: " + employees[6].trim()+ 
                        " Position: " + position+ 
                        " PTN: " + ptn);
                String sql = "insert into fi_user(userid, title, first_name, last_name, tel, position, position_abbreviation, division_id, depart_id, branch_code, created_date) values(?,?,?,?,?,?,?,?,'49','101', now())";
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setString(1, employees[2].trim() );
                stm.setString(2, employees[0].trim());
                stm.setString(3, employees[1].trim());
                stm.setString(4,  employees[3].trim() );
                stm.setString(5, employees[9].trim());
                stm.setString(6, position);
                stm.setString(7, ptn);
                stm.setString(8, (employees[6].trim().equals("472"))?null:employees[6].trim());
                stm.executeUpdate();
            }
            in.close();
            BufferedReader in = new BufferedReader(new FileReader("C:\\interest.txt"));
            String line;
            while((line = in.readLine()) != null)
            {
                String []division = line.split(",");
                System.out.println(division[0]);
                System.out.println("ID: " + division[0] + " Des en: " + division[1] + " Des la: " + division[2]+ " Type: " + division[3]);
                String sql = "insert into fi_aclass(account_class, description_en, description_la, deposit_type_id, created_date) values(?,?,?,?, now())";
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setString(1, division[0].trim());
                stm.setString(2, division[1].trim());
                stm.setString(3, division[2].trim());
                stm.setString(4, division[3].trim());
                stm.executeUpdate();
            }
            in.close();*/
            System.out.println("Connect database successfully");
            con.close();  
        }catch(SQLException e){ 
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestJava.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
