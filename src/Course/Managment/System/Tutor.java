/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Course.Managment.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author abhishek
 */
public class Tutor extends Person {

    private String name;
    private String doj;
    private String degree;
    private String postAssigned;
    private String salary;
    private String courseName;

    public String getName() {
        return name;
    }

    public String getDoj() {
        return doj;
    }

    public String getDegree() {
        return degree;
    }

    public String getPostAssigned() {
        return postAssigned;
    }

    public String getSalary() {
        return salary;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setPostAssigned(String postAssigned) {
        this.postAssigned = postAssigned;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void viewDetails(int withCourse) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String query = "SELECT * from tutordetails where username=?";
            con = DriverManager.getConnection("jdbc:mysql://localhost"
                    + "/multiuserlogin", "root", "");
            pst = con.prepareStatement(query);
            pst.setString(1, super.userName);
            rs = pst.executeQuery();
            x = rs.next();
            System.out.println("t.x"+super.userName);
            if (x) {
                super.userName = (rs.getString("username"));
                this.name = (rs.getString("name"));
                super.password = (rs.getString("password"));
                this.postAssigned = (rs.getString("postassigned"));
                this.salary = rs.getString("salary");
                super.address = (rs.getString("address"));
                this.doj = rs.getString("DOJ");
                super.dob = (rs.getString("DOB"));
                super.contact = (rs.getString("contact"));
                this.degree = (rs.getString("degree"));//degree

                if (withCourse == 1) {
                    query = "SELECT c.coursename from (select course_id from taughtby where tusername=?) as t inner join coursedetails as c using (course_id)";/**/
                    con = DriverManager.getConnection("jdbc:mysql://localhost"
                            + "/multiuserlogin", "root", "");
                    pst = con.prepareStatement(query);
                    pst.setString(1, super.userName);
                    rs = pst.executeQuery();
                    String kk = "";
                    while (rs.next()) {
                        kk = kk + " " + rs.getString("c.coursename") + "\n";
                    }
                    this.courseName = kk;
                }

            } else {
                //JOptionPane.showMessageDialog(this,"No Record found!");
            }
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public String updateTutor() {
        Connection con = null;
        PreparedStatement pst = null;
        String fetch_user;
        AdminPage a = new AdminPage();
        fetch_user = a.getUserNameofStudents();
        try {
            String query = "UPDATE `tutordetails` SET `name`=?,`DOB`=?,`DOJ`=?,`contact`=? ,`password`=? ,`address`=? WHERE username=?";
            con = DriverManager.getConnection("jdbc:mysql://localhost/multiuserlogin", "root", "");
            pst = con.prepareStatement(query);
            pst.setString(1, this.name);
            pst.setString(2, super.dob);
            pst.setString(3, this.doj);
            pst.setString(4, super.contact);
            pst.setString(5, super.password);
            pst.setString(6, super.address);
            pst.setString(7, super.userName);
            int count = pst.executeUpdate();
            query = "UPDATE `userlogin` SET `password`=? where username=? ";
            pst = con.prepareStatement(query);
            pst.setString(1, super.password);
            pst.setString(2, fetch_user);
            count = pst.executeUpdate();
            return "Details has been successfully updated of the username: " + fetch_user;
            //JOptionPane.showMessageDialog(this,"Details has been successfully updated of the username: "+fetch_user);
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(this, ex.getMessage());
            return "Error: " + ex;
        }
    }
    
    public String updateTutorByAdmin() {
        Connection con = null;
        PreparedStatement pst = null;
        
        try {
            String query = "UPDATE `tutordetails` SET `name`=?,`DOB`=?,`DOJ`=?,`contact`=? ,`password`=? ,`address`=?,postAssigned=?,salary=?,degree=? WHERE username=? ";
            con = DriverManager.getConnection("jdbc:mysql://localhost/multiuserlogin", "root", "");
            pst = con.prepareStatement(query);
            pst.setString(1, this.name);
            pst.setString(2, super.dob);
            pst.setString(3, this.doj);
            pst.setString(4, super.contact);
            pst.setString(5, super.password);
            pst.setString(6, super.address);
            pst.setString(7,this.postAssigned);
            pst.setString(8,this.salary);
            pst.setString(9,this.degree);
            pst.setString(10, super.userName);
            int count ;
            pst.executeUpdate();
            query = "UPDATE `userlogin` SET `password`=? where username=? ";
            pst = con.prepareStatement(query);
            pst.setString(1, super.password);
            pst.setString(2, super.userName);
            count = pst.executeUpdate();
            return "Details has been successfully updated of the username: " + super.userName;
            //JOptionPane.showMessageDialog(this,"Details has been successfully updated of the username: "+fetch_user);
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(this, ex.getMessage());
            return "Error: " + ex;
        }
    }

    public String addTutor() {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost"
                    + "/multiuserlogin", "root", "");
            String query = "INSERT INTO `tutordetails`(`username`, `name`, `DOB`, `DOJ`, `contact`,"
                    + " `degree`, `password`, `postassigned`, `salary`, `address`) VALUE(?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query);
            pst.setString(1, super.userName);
            pst.setString(2, this.name);
            pst.setString(3, super.dob);
            pst.setString(4, this.doj);
            pst.setString(5, super.contact);
            pst.setString(6, this.degree);
            pst.setString(7, super.password);
            pst.setString(8, this.postAssigned);
            pst.setString(9, this.salary);
            pst.setString(10, super.address);
            pst.executeUpdate();

            query = "insert into userlogin value('tutor',?,?)";
            pst = con.prepareStatement(query);
            pst.setString(1, super.userName);
            pst.setString(2, super.password);
            pst.executeUpdate();
            return "Tutor has been Added Successfully.";

            //JOptionPane.showMessageDialog(this,"Tutor has been Added Successfully.");
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(this, ex.getMessage());
            return "Error: " + ex;
        }

    }
    
    public String removeTutor(){
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            //StudentDetails table
            String query = "Delete from tutordetails where username=?";
            con = DriverManager.getConnection("jdbc:mysql://localhost/multiuserlogin", "root", "");
            pst = con.prepareStatement(query);
            pst.setString(1, super.userName);
            int count = pst.executeUpdate();
            //userlogin table
            query = "Delete from userlogin where username=?";
            con = DriverManager.getConnection("jdbc:mysql://localhost/multiuserlogin", "root", "");
            pst = con.prepareStatement(query);
            pst.setString(1, super.userName);
            count = pst.executeUpdate();
            query = "delete from taughtby WHERE `tusername`=?";
            con = DriverManager.getConnection("jdbc:mysql://localhost/multiuserlogin", "root", "");
            pst = con.prepareStatement(query);
            pst.setString(1, super.userName);
            count = pst.executeUpdate();
            return "Details has been successfully deleted of the username: " + super.userName;
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(this, ex.getMessage());
            return "Error: "+ex;
        }
    }
}
