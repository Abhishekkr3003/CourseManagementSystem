/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Course.Managment.System;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author abhishek
 */
public class Course {

    protected String semester;
    private String coursename;
    private String courseID;
    public boolean flag;

    public String getSemester() {
        return semester;
    }

    public String getCoursename() {
        return coursename;
    }

    public String getCourseID() {
        return courseID;
    }
    

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public void insertCourse() {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "insert into coursedetails( `Semester`, `coursename`) value(?,?)";
            con = DriverManager.getConnection("jdbc:mysql://localhost/multiuserlogin", "root", "");
            pst = con.prepareStatement(query);
            pst.setString(1, this.semester);
            pst.setString(2, this.coursename);
//             pst.setString(3,(String)Tutor.getSelectedItem());
            int count;
            count = pst.executeUpdate();
        } catch (Exception ex) {

        }
    }

    public String coursefromSem(String sem) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String kk = "";
            String query = "select * from coursedetails where Semester=?";
            con = DriverManager.getConnection("jdbc:mysql://localhost/multiuserlogin", "root", "");
            pst = con.prepareStatement(query);
            pst.setString(1, sem);
            rs = pst.executeQuery();
            while (rs.next()) {
                kk = kk + " " + rs.getString("coursename") + "\n";
            }
            return kk;

        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(this, ex.getMessage());
            return "Error: "+ex;
        }
    }
    
    public String modifyCourse(){
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try
            {
                String query="SELECT * from coursedetails where coursename=?";
                con=DriverManager.getConnection("jdbc:mysql://localhost/multiuserlogin","root","");    
                pst=con.prepareStatement(query);
                pst.setString(1,this.coursename);
                rs=pst.executeQuery();
                flag=rs.next();
                if(flag)
                {
                    this.coursename=(rs.getString("coursename"));
                    this.semester=(rs.getString("Semester"));
                    this.courseID=(rs.getString("course_id"));
                    query="SELECT tusername from taughtby where course_id=?";
                    pst=con.prepareStatement(query);
                    pst.setString(1,courseID);
                    ResultSet rs1 = null;
                    rs1=pst.executeQuery();
                    String kk="";
                    while(rs1.next())
                    {
                        kk+=rs1.getString("tusername")+",";
                    }
                    return (kk);
                }
                else
                {
                    return "No Data Available.";
                }
            }
        catch(Exception ex)
            {
                //JOptionPane.showMessageDialog(this, ex.getMessage());
                return "Error: "+ex;
            }
    }
    
    public String deleteCourse(){
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try
            {
                
                String query="delete from taughtby where Course_Id=?";
                con=DriverManager.getConnection("jdbc:mysql://localhost/multiuserlogin","root","");
                pst=con.prepareStatement(query);
                 pst.setString(1,courseID);
                 pst.executeUpdate();
                query="Delete from coursedetails where coursename=? and semester=?";
                con=DriverManager.getConnection("jdbc:mysql://localhost/multiuserlogin","root","");    
                pst=con.prepareStatement(query);
                pst.setString(1,this.coursename);
                pst.setString(2,this.semester);
                int count=pst.executeUpdate();
                return "Succesfully Removed.";
                
         
            }
        catch(Exception ex)
            {
                //JOptionPane.showMessageDialog(this, ex.getMessage());
                return "Error: "+ex;
            }
    }
    
    public String studentInCourse(){
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{

            String query="Select u.username from (select semester, coursename from coursedetails "
                    + "where coursename=?) as c inner join (select username, "
                    + "semester from studentdetails) as u on c.semester=u.semester";
            con=DriverManager.getConnection("jdbc:mysql://localhost/multiuserlogin","root","");    
            pst=con.prepareStatement(query);
            pst.setString(1,this.coursename);
            rs=pst.executeQuery();
            String kk="Students Enrolled:\n";
            while(rs.next())
            {
                kk=kk+""+rs.getString(1)+"\n";
            }
            return kk;
            
        }
        catch(Exception ex)
        {
            //JOptionPane.showMessageDialog(this, ex.getMessage());
            return "Error: "+ex;
        }
    }

}
