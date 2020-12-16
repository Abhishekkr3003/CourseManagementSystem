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
public class Marks extends Course{

    private String marks;
    private String courseName;
    private String studentName;

    public String getMarks() {
        return marks;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void insertMarks() {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        String fetch_user;
        try {

            String query = "insert into marks(coursename,studusername,marks) value(?,?,?)";
            con = DriverManager.getConnection("jdbc:mysql://localhost/multiuserlogin", "root", "");
            pst = con.prepareStatement(query);
            pst.setString(1, this.courseName);
            pst.setString(2, this.studentName);
            pst.setString(3, this.marks);
            int count = pst.executeUpdate();
            //JOptionPane.showMessageDialog(this,"Marks has been successfully updated of the student:"+StudentNameHolder.getSelectedItem());
            //marks.setText("");
            //return "Marks has been successfully updated of the student:" + this.studentName;
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(this, ex.getMessage());
            //return "Error: " + ex;
        }
    }
    
    public String viewMarks(){
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String query="select m.coursename, m.marks from (select coursename from coursedetails where semester=?) as c inner join (select * from marks where studusername=?) as m on c.coursename=m.coursename";
            con=DriverManager.getConnection("jdbc:mysql://localhost/multiuserlogin","root","");    
            pst=con.prepareStatement(query);
            pst.setString(1,super.semester);
                pst.setString(2,this.studentName); 
            rs=pst.executeQuery();
            String coursename="";
            String kk="Result of Semester"+super.semester+":\n";
            while(rs.next())
            {
                coursename=rs.getString("m.coursename");
                 kk+="CourseName="+coursename+"\tMarks=";
                 if(rs.getString("m.marks")!=null)
                 {
                     kk+=rs.getString("m.marks")+"\n";
                 }
                 else
                 {
                     kk+="N.A.\n";
                 }
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
