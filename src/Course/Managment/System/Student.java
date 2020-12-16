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
public class Student extends Person {

    private String FirstName;
    private String LastName;
    private String BloodGroup;
    private String stream;
    private String Semester;

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setBloodGroup(String BloodGroup) {
        this.BloodGroup = BloodGroup;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public void setSemester(String Semester) {
        this.Semester = Semester;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getBloodGroup() {
        return BloodGroup;
    }

    public String getStream() {
        return stream;
    }

    public String getSemester() {
        return Semester;
    }

    void showDetails() {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String query = "SELECT * from studentdetails where username=?";
            con = DriverManager.getConnection("jdbc:mysql://localhost/multiuserlogin", "root", "");
            pst = con.prepareStatement(query);
            pst.setString(1, super.userName);
            rs = pst.executeQuery();
            x = rs.next();
            if (x) {
                super.userName = (rs.getString("username"));
                this.FirstName = (rs.getString("FirstName"));
                this.LastName = (rs.getString("LastName"));
                super.dob = (rs.getString("DOB"));
                super.contact = (rs.getString("contact"));
                this.stream = (rs.getString("stream"));
                this.Semester = (rs.getString("Semester"));
                this.BloodGroup = (rs.getString("BloodGroup"));
                super.address = (rs.getString("address"));
                super.password = (rs.getString("password"));
            }
//            else
//            {
//                JOptionPane.showMessageDialog(this,"No Record found!");
//            }
        } catch (Exception ex) {
            //           JOptionPane.showMessageDialog(this, ex.getMessage());
            //return "Error: "+ex;
        }

    }

    String updateDetails() {
        Connection con = null;
        PreparedStatement pst = null;

        try {
            String query = "UPDATE studentdetails SET FirstName=?,"
                    + " LastName=?,DOB=?,password=?,address=?,"
                    + " Stream=?,BloodGroup=?,Semester=?,"
                    + " contact=? "
                    + "WHERE username=? ";
            con = DriverManager.getConnection("jdbc:mysql://localhost/multiuserlogin", "root", "");
            pst = con.prepareStatement(query);
            pst.setString(1, this.FirstName);
            pst.setString(2, this.LastName);
            pst.setString(3, super.dob);
            pst.setString(4, super.password);
            pst.setString(5, super.address);
            pst.setString(6, this.stream);
            pst.setString(7, this.BloodGroup);
            pst.setString(8, this.Semester);
            pst.setString(9, super.contact);
            pst.setString(10, super.userName);
            int count = pst.executeUpdate();
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

    public String addStudent() {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost"
                    + "/multiuserlogin", "root", "");
            String query = "INSERT INTO `studentdetails`( "
                    + "`FirstName`, `LastName`, `DOB`, `password`, `address`, `Stream`, `BloodGroup`,"
                    + " `Semester`, `contact`,`username`) VALUES (?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query);
            pst.setString(1, this.FirstName);
            pst.setString(2, this.LastName);
            pst.setString(3, super.dob);
            pst.setString(4, super.password);
            pst.setString(5, super.address);
            pst.setString(6, this.stream);
            pst.setString(7, this.BloodGroup);
            pst.setString(8, this.Semester);
            pst.setString(9, super.contact);
            pst.setString(10, super.userName);
            pst.executeUpdate();

            query = "insert into userlogin value('student',?,?)";
            pst = con.prepareStatement(query);
            pst.setString(1, super.userName);
            pst.setString(2, super.password);
            pst.executeUpdate();
            return "Student has been Added Successfully.";
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(this, ex.getMessage());
            return "Error: " + ex;
        }
    }

    public String removeStudent() {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            //StudentDetails table
            String query = "Delete from studentdetails where username=?";
            con = DriverManager.getConnection("jdbc:mysql://localhost/multiuserlogin", "root", "");
            pst = con.prepareStatement(query);
            pst.setString(1, super.userName);
            pst.executeUpdate();
            //userlogin table
            query = "Delete from userlogin where username=?";
            con = DriverManager.getConnection("jdbc:mysql://localhost/multiuserlogin", "root", "");
            pst = con.prepareStatement(query);
            pst.setString(1, super.userName);
            pst.executeUpdate();
            //Marks table
            query = "Delete from marks where studusername=?";
            con = DriverManager.getConnection("jdbc:mysql://localhost/multiuserlogin", "root", "");
            pst = con.prepareStatement(query);
            pst.setString(1, super.userName);
            pst.executeUpdate();
            return "Details has been successfully deleted of the username: " + super.userName;
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(this, ex.getMessage());
            return "Error: " + ex;
        }
    }

}
