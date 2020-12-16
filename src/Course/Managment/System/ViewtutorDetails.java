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
import javax.swing.JOptionPane;

/**
 *
 * @author rajas
 */
public class ViewtutorDetails extends javax.swing.JFrame {

    /**
     * Creates new form ViewtutorDetails
     */
   Tutor t = new Tutor();
   String fetch_user = "";
    public ViewtutorDetails() {
        initComponents();
        try {
            AdminPage a=new AdminPage();
            fetch_user=a.getUserNameofStudents();
            t.setUserName(fetch_user);
            t.viewDetails(1);
            if (t.x) {
                usernameholder.setText(t.getUserName());
                NameHolder.setText(t.getName());
                passwordHolder.setText(t.getPassword());
                postassigned.setText(t.getPostAssigned());
                PostHolder4.setText(t.getSalary());
                Addressholder1.setText(t.getAddress());
                DOJ.setText(t.getDoj());
                DOBHolder.setText(t.getDob());
                ContactHolder.setText(t.getContact());
                PostHolder3.setText(t.getDegree());//degree
                CourseNameHolder.setText(t.getCourseName());

            } else {
                JOptionPane.showMessageDialog(this, "No Record found!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Addressholder = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        passwordHolder = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        DOBHolder = new javax.swing.JTextField();
        ContactHolder = new javax.swing.JTextField();
        NameHolder = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        DOJ = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        postassigned = new javax.swing.JLabel();
        usernameholder = new javax.swing.JLabel();
        PostHolder3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        PostHolder4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Addressholder1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        CourseNameHolder = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        jLabel3.setText("Name");

        jButton2.setFont(new java.awt.Font("Viner Hand ITC", 1, 12)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Addressholder.setColumns(20);
        Addressholder.setRows(5);
        jScrollPane2.setViewportView(Addressholder);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tutor Details:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(347, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, -1));

        jLabel2.setText("UserName");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 83, 78, 19));

        jLabel10.setText("PASSWORD");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 82, 70, 20));
        getContentPane().add(passwordHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 83, 119, -1));

        jLabel4.setText("Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 125, 67, -1));

        jLabel5.setText("Date of Birth");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 164, 67, -1));

        jLabel6.setText("Contact");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 236, 67, -1));

        jLabel7.setText("Degree ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 67, -1));

        jLabel8.setText("Courses*");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 67, -1));
        getContentPane().add(DOBHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 161, 125, -1));

        ContactHolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactHolderActionPerformed(evt);
            }
        });
        getContentPane().add(ContactHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 120, -1));
        getContentPane().add(NameHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 122, 125, -1));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 281, 1, -1));

        jButton3.setFont(new java.awt.Font("Viner Hand ITC", 1, 12)); // NOI18N
        jButton3.setText("Back");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 322, 90, 30));

        jButton1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jButton1.setText("Update");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 317, 90, 34));

        jLabel12.setText("Post Assigned");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 125, 81, -1));

        DOJ.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        DOJ.setText("your DOJ");
        getContentPane().add(DOJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 199, 110, 19));

        jLabel11.setText("Current Salary");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 164, 78, -1));

        postassigned.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        postassigned.setText("your post");
        getContentPane().add(postassigned, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 124, 110, 19));

        usernameholder.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        usernameholder.setText("your Username");
        getContentPane().add(usernameholder, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 85, 110, 19));

        PostHolder3.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        PostHolder3.setText("your Degree");
        getContentPane().add(PostHolder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 110, 19));

        jLabel13.setText("Date of JOINING");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 78, -1));

        PostHolder4.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        PostHolder4.setText("your Salary");
        getContentPane().add(PostHolder4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 163, 110, 19));

        jLabel14.setText("Address");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 67, -1));

        Addressholder1.setColumns(20);
        Addressholder1.setRows(5);
        jScrollPane4.setViewportView(Addressholder1);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, -1, 120));

        CourseNameHolder.setColumns(20);
        CourseNameHolder.setRows(5);
        jScrollPane1.setViewportView(CourseNameHolder);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 190, 70));

        jLabel15.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel15.setText("Date Format:yyyy-mm-dd");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 200, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel16.setText("* unupdatable");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        StudentWork a=new StudentWork();
//        a.setVisible(true);
//        this.setVisible(false);///
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//        TutorWork a=new TutorWork();
//        a.setVisible(true);
//        this.setVisible(false);//
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        //Her
        /* Name.setText(rs.getString("username"));
        FirstnameHolder.setText(rs.getString("FirstName"));
        LastNameHolder.setText(rs.getString("LastName"));
        DOBHolder.setText(rs.getString("DOB"));
        ContactHolder.setText(rs.getString("contact"));
        StreamHolder.setText(rs.getString("stream"));
        SemesterHolder.setText(rs.getString("Semester"));
        BloodGroupHolder.setText(rs.getString("BloodGroup"));
        Addressholder.setText(rs.getString("address"));
        passwordHolder.setText(rs.getString("password"));*/
//        try{
//            String query="UPDATE studentdetails SET FirstName=?,"
//            + " LastName=?,DOB=?,password=?,address=?,"
//            + " Stream=?,BloodGroup=?,Semester=?,"
//            + " contact=? "
//            + "WHERE username=? ";
//            con=DriverManager.getConnection("jdbc:mysql://localhost/multiuserlogin","root","");
//            pst=con.prepareStatement(query);
//            pst.setString(1,FirstnameHolder.getText());
//            pst.setString(2,LastNameHolder.getText());
//            pst.setString(3,DOBHolder.getText());
//            pst.setString(4,passwordHolder.getText());
//            pst.setString(5,Addressholder.getText());
//            pst.setString(6,StreamHolder.getText());
//            pst.setString(7,BloodGroupHolder.getText());
//            pst.setString(8,SemesterHolder.getText());
//            pst.setString(9,ContactHolder.getText());
//            pst.setString(10,fetch_user);
//            int count=pst.executeUpdate();
//            query="UPDATE `userlogin` SET `password`=? where username=? ";
//            pst=con.prepareStatement(query);
//            pst.setString(1,passwordHolder.getText());
//            pst.setString(2,fetch_user);
//            count=pst.executeUpdate();
//            JOptionPane.showMessageDialog(this,"Details has been successfully updated of the username: "+fetch_user);
//        }
//        catch(Exception ex){
//            JOptionPane.showMessageDialog(this, ex.getMessage());
//        }
            
                t.setName(NameHolder.getText());
            t.setDob(DOBHolder.getText());
            t.setPassword(passwordHolder.getText());
            t.setDoj(DOJ.getText());
            t.setContact(ContactHolder.getText());
            t.setAddress(Addressholder1.getText());
            t.setUserName(usernameholder.getText());
            String res=t.updateTutor();

            String fetch_user;
            JOptionPane.showMessageDialog(this, res);
           

//                NameHolder.setText(rs.getString("name"));
//                passwordHolder.setText(rs.getString("password"));
//                postassigned.setText(rs.getString("postassigned"));
//                PostHolder4.setText("Rs."+rs.getString("salary"));
//                Addressholder1.setText(rs.getString("address"));
//                DOJ.setText(rs.getString("DOJ"));
//                DOBHolder.setText(rs.getString("DOB"));
//                ContactHolder.setText(rs.getString("contact"));
//                PostHolder3.setText(rs.getString("degree"));//degree
            

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ContactHolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactHolderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContactHolderActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here://here
        TutorWork a=new TutorWork();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewtutorDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewtutorDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewtutorDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewtutorDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewtutorDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Addressholder;
    private javax.swing.JTextArea Addressholder1;
    private javax.swing.JTextField ContactHolder;
    private javax.swing.JTextArea CourseNameHolder;
    private javax.swing.JTextField DOBHolder;
    private javax.swing.JLabel DOJ;
    private javax.swing.JTextField NameHolder;
    private javax.swing.JLabel PostHolder3;
    private javax.swing.JLabel PostHolder4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField passwordHolder;
    private javax.swing.JLabel postassigned;
    private javax.swing.JLabel usernameholder;
    // End of variables declaration//GEN-END:variables
}
